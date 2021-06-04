package com.chan.newFeature;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8Example1 {

    public static void main(String[] args) {
        
        //3 apple, 2 banana, others 1
        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");
        Map<String, Long> result =
                items.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );
        System.out.println(result);
        List<Staff> staffList = Arrays.asList(new Staff("Tom", 21, new BigDecimal(21000)), new Staff("Dick", 31, new BigDecimal(31000)), new Staff("Harry", 42, new BigDecimal(42000)),new Staff("Tom", 21, new BigDecimal(21000)), new Staff("Dick", 31, new BigDecimal(31000)), new Staff("Harry", 42, new BigDecimal(42000)));
        Map<Staff,Long> mapOfSameStaff=staffList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        mapOfSameStaff.forEach((k,v)->{System.out.println(k+"It's counting"+v);});



    }


    static class Staff {

        private String name;

        @Override
        public String toString() {
            return "Staff{" +
                    "name='" + name + '\'' +
                    '}';
        }

        private int age;
        private BigDecimal salary;

        public Staff(String name, int age, BigDecimal salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Staff staff = (Staff) o;
            if (this.age != staff.age) return false;
            if (this.name != null ? !this.name.equals(staff.name) : staff.name != null) return false;
            return salary != null ? salary.equals(staff.salary) : staff.salary == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + age;
            result = 31 * result + (salary != null ? salary.hashCode() : 0);
            return result;
        }
    }
}