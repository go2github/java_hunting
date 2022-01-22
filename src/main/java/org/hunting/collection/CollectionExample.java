package org.hunting.collection;

import java.util.*;

public class CollectionExample {

    public static void main(String[] args){
        Set<StudentSetPojo> list=new HashSet<>();
        Set<StudentSetPojo> treeSet=new TreeSet<>();

        StudentSetPojo studentSetPojo1=new StudentSetPojo();
        studentSetPojo1.setRollNo(2);
        studentSetPojo1.setName("anand");
        studentSetPojo1.setEmail("test1@gmail.com");
        list.add(studentSetPojo1);

        StudentSetPojo studentSetPojo2=new StudentSetPojo();
        studentSetPojo2.setRollNo(3);
        studentSetPojo2.setName("boobalan");
        studentSetPojo2.setEmail("test13@gmail.com");
        list.add(studentSetPojo2);

        StudentSetPojo studentSetPojo3=new StudentSetPojo();
        studentSetPojo3.setRollNo(1);
        studentSetPojo3.setName("senthil");
        studentSetPojo3.setEmail("test3@gmail.com");
        list.add(studentSetPojo3);

        Map<StudentSetPojo,String> map=new HashMap<>();
        map.put(studentSetPojo1,"first obj");
        map.put(studentSetPojo2,"second obj");
        map.put(studentSetPojo3,"thried obj");

        treeSet.add(studentSetPojo1);
        treeSet.add(studentSetPojo2);
        treeSet.add(studentSetPojo3);

        System.out.println(treeSet.toString());
        System.out.println("map size "+treeSet.size());
    }
}
