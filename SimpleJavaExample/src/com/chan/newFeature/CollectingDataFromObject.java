package com.chan.newFeature;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectingDataFromObject {

    public static void main(String[] args) {

        List<Person> listOfperson = Arrays.asList(new Person("chandranshu", 31)
                , new Person("himanshu", 25), new Person("medha", 29));

        List<String> stringList = listOfperson.stream().filter(p -> p.getAge() >= 29).map(person -> person.getName()).collect(Collectors.toList());

        Set<String> setOfstringList = listOfperson.stream().filter(p -> p.getAge() >= 29).map(person -> person.getName()).collect(Collectors.toCollection(HashSet::new));


        stringList.forEach(System.out::println);

        String stringName = listOfperson.stream().filter(p -> p.getAge() >= 29).map(p ->
            p.getName()
        ).findAny().orElse(" ");

       System.out.println(stringName);

    }
}
