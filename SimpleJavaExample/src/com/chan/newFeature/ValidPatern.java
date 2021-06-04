package com.chan.newFeature;

public class ValidPatern {

    public static void main(String[] args) {

    }


    private  boolean getString(final String stringToValidate){
        boolean validString=false;
        int count=0;
        char[] character=stringToValidate.toCharArray();
        for (int i = 0; i < character.length; i++) {
            if ('{'==character[i] || '}'==character[i] || '('==character[i] ||')'==character[i] ) {
                    count++;
            }

        }








        return validString;
    }



}
