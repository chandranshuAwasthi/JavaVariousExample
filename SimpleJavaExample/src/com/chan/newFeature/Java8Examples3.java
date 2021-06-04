package com.chan.newFeature;
//import com.chan.newFeature.Item;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8Examples3 {

    public static void main(String[] args) {

        //3 apple, 2 banana, others 1
        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orang", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );

        Map<String, Long> counting = items.stream().collect(
                Collectors.groupingBy(Item::getName, Collectors.counting()));

        System.out.println(counting);

        Map<String, Long> countingPrice = items.stream().collect(
                Collectors.groupingBy(Item::getName, Collectors.counting()));


       // List<Item> listOfItem=items.stream().map( x -> x.getQty()+100).collect(Collectors.toList());

       // List<Item> listOfItem = items.stream().forEachOrdered(x->x.getQty());

        items.stream().forEach(f -> f.setQty(f.getQty() +100));
        items.stream().forEachOrdered(f -> f.setQty(f.getQty() +200));
        items.forEach(System.out::println);


        // System.out.println(sum);

    }
}
