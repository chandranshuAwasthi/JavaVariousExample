package com.chan.newFeature;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class JavaMapExample {


    public static void main(String[] args) {
        List<String> listOfValues = Arrays.asList("D", "E", "E", "A", "B", "C");
        listOfValues = listOfValues.stream().map(x -> x.toLowerCase()).collect(Collectors.toList());
        listOfValues.forEach(System.out::println);
        System.out.println("After printing List");
        HashSet setOfValues = listOfValues.stream().collect(Collectors.toCollection(HashSet::new));
        setOfValues.forEach(System.out::println);
        System.out.println("After printing Set");
        LinkedHashSet linksetOfValues = (LinkedHashSet) setOfValues.stream().filter(x -> !x.equals("e")).collect(Collectors.toCollection(LinkedHashSet::new));
        linksetOfValues.forEach(System.out::println);

        List<Staff> staffList = Arrays.asList(new Staff("Tom", 21, new BigDecimal(21000)), new Staff("Dick", 31, new BigDecimal(31000)), new Staff("Harry", 42, new BigDecimal(42000)));
        List<Staffing> staffingList = staffList.stream().map(staff -> {
            return new Staffing(staff.name, staff.age, "chandranshu");


        }).collect(Collectors.toList());
       staffingList.forEach(st->System.out.println(st.extra));
    }




    static class Staff {

        private String name;
        private int age;
        private BigDecimal salary;

        public Staff(String name, int age, BigDecimal salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }
    }


    static class Staffing {


        private String name;
        private int age;
        private String extra;
        //...


        public Staffing(String name, int age, String extra) {
            this.name = name;
            this.age = age;
            this.extra = extra;
        }

    }
}