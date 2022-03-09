package com.codes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static com.codes.Main.EOF;
import static com.codes.ThreadColor.*;

public class Main {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<>(6);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_RED);
        MyConsumer consumer = new MyConsumer(buffer, ThreadColor.ANSI_BLUE);
        MyConsumer consumerTwo = new MyConsumer(buffer, ANSI_GREEN);

        executorService.execute(producer);
        executorService.execute(consumer);
        executorService.execute(consumerTwo);

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ANSI_PURPLE + "I am being printed from the callable class");
                return "This is the callable result";
            }
        });

        try {
            System.out.println(future.get());
        } catch (ExecutionException e) {
            System.out.println("Something went wrong");
        } catch (InterruptedException e) {
            System.out.println("Thread running the task was interrupted");
        }

        executorService.shutdown();

    }
}

class MyProducer implements Runnable {
    private final ArrayBlockingQueue<String> buffer;
    private final String color;

    public MyProducer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] numbers = {"1", "2", "3", "4", "5"};

        for (String num : numbers) {
            try {
                System.out.println(color + "Adding..." + num);
                buffer.put(num);

                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting");
        try {
            buffer.put("EOF");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyConsumer implements Runnable {
    private final ArrayBlockingQueue<String> buffer;
    private final String color;

    public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (buffer){
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }

                    if (buffer.peek().equals(EOF)) {
                        System.out.println(color + "Exiting...");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.take());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
























