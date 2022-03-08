import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        //This is a min heap
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(25);
        priorityQueue.add(-22);
        priorityQueue.add(1345);
        priorityQueue.add(0);
        priorityQueue.add(429);
        priorityQueue.add(-2323);
        priorityQueue.add(-1);

        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.remove());
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.remove(429));

        Object[] arrayOfPriority = priorityQueue.toArray();

        for (Object o : arrayOfPriority){
            System.out.println(o);
        }
    }
}
