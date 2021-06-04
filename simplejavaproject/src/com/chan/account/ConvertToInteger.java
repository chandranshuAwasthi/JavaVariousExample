package com.chan.account;

public class ConvertToInteger {

    public static void main(String[] args) {
        String value="745";
        char[] arrayofValues=value.toCharArray();

        for(char c:arrayofValues){
            int i=c;
            System.out.println(i-48);

        }



    }


}
