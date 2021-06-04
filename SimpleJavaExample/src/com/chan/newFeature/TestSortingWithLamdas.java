package com.chan.newFeature;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestSortingWithLamdas {

    public static void main(String[] args) {
        {
            List<Developer> listDevs = getDevelopers();
            System.out.println("Before Sort");
            //using lamddas
            listDevs.sort((o1,o2)->o1.getAge()-o2.getAge() );
            //sort by age
           /* for (Developer developer : listDevs) {
                System.out.println(developer);
            }*/
         //  listDevs.forEach(dev->System.out.println(dev));

            listDevs.forEach(System.out::println);


        }
    }

    private static List<Developer> getDevelopers() {

        List<Developer> result = new ArrayList<Developer>();
        result.add(new Developer("mkyong", new BigDecimal("70000"), 33));
        result.add(new Developer("alvin", new BigDecimal("80000"), 20));
        result.add(new Developer("jason", new BigDecimal("100000"), 10));
        result.add(new Developer("iris", new BigDecimal("170000"), 55));
        return result;
    }

}
