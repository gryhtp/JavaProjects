package com.codes;

import java.util.*;
import java.lang.*;
public class Main {

    public static void main (String[] args) throws java.lang.Exception {

        String a = "labkas_Asjw_aaw_qqsd.gfdsa.asww";
        System.out.println(caesarCipher(a, 6));

    }

    public static String caesarCipher(String s, int k) {
        StringBuilder mystr = new StringBuilder();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        StringBuilder answer = new StringBuilder();
        int temp;
        if (k >= 26){
            temp = k % 26;
        } else {
            temp = k;
        }

        for(int i = 0; i < alphabet.length(); i++){
            if (temp >= alphabet.length()){
                temp = 0;
            }

            mystr.append(alphabet.charAt(temp));
            temp++;
        }

        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < alphabet.length(); i++){
            map.put(alphabet.charAt(i), mystr.toString().charAt(i));
            map.put(alphabet.toUpperCase().charAt(i), mystr.toString().toUpperCase().charAt(i));
        }

        for (int i = 0; i < s.length(); i++){
            if (map.containsValue(s.charAt(i))){
                answer.append(map.get(s.charAt(i)));
            } else {
                answer.append(s.charAt(i));
            }
        }

        return answer.toString();
    }

}