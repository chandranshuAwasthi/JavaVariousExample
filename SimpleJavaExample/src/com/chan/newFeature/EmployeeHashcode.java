package com.chan.newFeature;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Employee {
    int empID;
    String Name;
    String secondName;

  Employee(int empID,String Name,String secondName){
      this.empID=empID;
      this.Name=Name;
      this.secondName=secondName;


  }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
       Employee employee = (Employee) o;
        if (empID != employee.empID) return false;
        if (Name != null ? !Name.equals(employee.Name) : employee.Name != null) return false;
        return secondName != null ? secondName.equals(employee.secondName) : employee.secondName == null;
    }

    /*@Override
    public int hashCode() {
        int result = empID;
        result = 31 * result + (Name != null ? Name.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        return result;
    }
*/
  /*  @Override
    public String toString() {
        return "Employee{" +
                "empID=" + empID +
                ", Name='" + Name + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }*/
}

public class   EmployeeHashcode{


    public static void main(String[] args) {

   //     Map<Integer,Employee> integerEmployeeMap=new HashMap<Integer,Employee>();

        Employee employee1=new Employee(10,"chandranshu","awasthi");
        Employee employee2=new Employee(10,"chandranshu","awasthi");
        Employee employee3=new Employee(10,"chandranshu","awasthi");
        Set<Employee> hashSet=new HashSet<Employee>();
        hashSet.add(employee1);
        hashSet.add(employee2);
        hashSet.add(employee3);
        System.out.println(hashSet);
        Map<String,Employee> integerEmployeeMap=new HashMap<String,Employee>();
        integerEmployeeMap.put(employee1.toString(),employee1);
        integerEmployeeMap.put(employee2.toString(),employee2);
        integerEmployeeMap.put(employee3.toString(),employee3);
        System.out.println(integerEmployeeMap);
    }
        }
