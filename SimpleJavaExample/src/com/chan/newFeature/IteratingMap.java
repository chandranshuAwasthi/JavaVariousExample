package com.chan.newFeature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IteratingMap {


    public static void main(String[] args) {
        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);

        // simple for each

        for (Map.Entry<String, Integer> mapofValues : items.entrySet()) {
            System.out.println("Key is  :" + mapofValues.getKey() + " and value is :" + mapofValues.getValue());
        }

        ///by using lamda

       items.forEach((k, v) -> System.out.println("Key is  :" + k + " and value is :" + v));



        // By using Lamda and some  condition
final Integer i=0;
        items.forEach((k, v) -> {
            System.out.println("Item : " + k + " Count : " + v);
            if ("E".equals(k)) {
                System.out.println("Matched Item : " + k + " Count : " + v);
            }
        });

       //items.forEach(System.out::println);


//Stream and filter
        //Output : B
        List<String> array_items = new ArrayList<>();
        array_items.add("A");
        array_items.add("B");
        array_items.add("C");
        array_items.add("D");
        array_items.add("E");

    //    array_items.forEach(item->System.out.println(item));

       // Stream with filter

        array_items.stream().filter(s -> s.contains("B")).forEach(System.out::println);

        //);



    }

}
