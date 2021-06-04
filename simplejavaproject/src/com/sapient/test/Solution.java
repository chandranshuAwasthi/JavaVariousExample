package com.sapient.test;

import javafx.util.converter.IntegerStringConverter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Pangram FInder
 * <p>
 * The sentence "The quick brown fox jumps over the lazy dog" contains
 * every single letter in the alphabet. Such sentences are called pangrams.
 * Write a function findMissingLetters, which takes a String `sentence`,
 * and returns all the letters it is missing
 */
class Solution {

    private static class PanagramDetector {
        private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

        public String findMissingLetters(String sentence) {
            if ("".equalsIgnoreCase(sentence.trim())) {
                return ALPHABET;
            }

            final Map<String, Integer> mapOfCharandNumber = new HashMap<>();
            char[] arrayofalpahabet = ALPHABET.toCharArray();
            for (char c : arrayofalpahabet) {
                mapOfCharandNumber.put(String.valueOf(c), 0);
            }
            String input = sentence.trim();
            char[] arrofOfInput = input.toCharArray();
            for (char c : arrofOfInput) {
                if (mapOfCharandNumber.containsKey(String.valueOf(c))) {
                    Integer i1 = mapOfCharandNumber.get(String.valueOf(c));
                    mapOfCharandNumber.put(String.valueOf(c), i1 + 1);
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            Set<Map.Entry<String, Integer>> mapofvalue = mapOfCharandNumber.entrySet();
            for (Map.Entry<String, Integer> value : mapofvalue) {
                if (value.getValue() == 0) {
                    stringBuilder.append(value.getValue());
                }
            }
            return stringBuilder.toString();
        }

    }


    public static int getValue() {
        try {
            return 10;
        } finally {
            return 20;
        }
    }

  // 65-90 character value CAPITAL LETTER
  // 97-122 character value CAPITAL LETTER
    private static  boolean findMissingLetters(final String value){
        int values[] = new int[26];
        char [] characterArray=value.toCharArray();
        IntStream.range(0,characterArray.length).filter(i->!" ".equalsIgnoreCase(String.valueOf(characterArray[i]))).forEach(i->{
            System.out.println(characterArray[i]);
            System.out.println((int)characterArray[i]);
           if(values[(int)characterArray[i]-97]==0){
               values[(int)characterArray[i]-97] =1;
           }else{
               System.out.println("finding duplicate " +characterArray[i]);
               ++values[(int)characterArray[i]-97];
           }
        });

        System.out.println("After insertion into Arrays");
       /* IntStream.of(values).filter(value1 -> value1>1).forEach(
                char c=
        System.out::println);*/
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<values.length;i++){
            if(values[i]>1){
                System.out.println((char)(97+i)+ " and value is "+ values[i]);
            }else if(values[i]<1){
                //System.out.println((char)(97+i)+ "and value is "+ values[i]);
                stringBuilder.append((char)(97+i));
            }else{

            }
        }
        System.out.println(stringBuilder.toString().length());

        return true;
    }

    public static void main(String[] args) {
      //  System.out.println(getValue());
        PanagramDetector pd = new PanagramDetector();
        boolean success = true;
       // success = success && "".equals(findMissingLetters("The quick brown fox jumps over the lazy dog".toLowerCase()));

        success = success && "".equals(findMissingLetters("chandranshu".toLowerCase()));
        if (success) {
            System.out.println("Pass ");
        } else {
            System.out.println("Failed");
        }

    }
}
