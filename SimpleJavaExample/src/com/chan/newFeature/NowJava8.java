package com.chan.newFeature;

import java.util.Arrays;
import java.util.List;

public class NowJava8 {

    public static void main(String[] args) {

        List<Person> persons = Arrays.asList(
                new Person("mkyong", 30),
                new Person("jack", 20),
                new Person("lawrence", 40)
        );

       Person personList=persons.stream().filter(p ->"jack".equals(p.getName()) && 20==p.getAge()).findAny().orElse(null);
        System.out.println("result 1 :" + personList);

        //or like this
        Person result2 = persons.stream()
                .filter(p -> {
                    if ("jack".equals(p.getName()) && 20 == p.getAge()) {
                        return true;
                    }
                    return false;
                }).findAny()
                .orElse(null);

        System.out.println("result 2 :" + result2);

    }


}
