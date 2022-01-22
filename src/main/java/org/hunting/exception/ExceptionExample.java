package org.hunting.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLDataException;

public class ExceptionExample {
    public static void main(String[] args) {

        Child child = new Child();


        child.test();
        try {
            child.test1();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class Base {

    public void testMethod1() throws IOException {
        File file = new File("test.txt");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            fileInputStream.read();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                fileInputStream.close();
            }

        }

    }

    public void test() throws IOException {
        System.out.println("test");
    }
    public void test1()throws IOException{
        System.out.println("welcccccccccc");
    }
}

class Child extends Base {
    public void sample() {
        System.out.println("this is sample method from child class");
    }

    public void test() {

        System.out.println("welcome");
        throw new NullPointerException();

    }
    public void test1()throws IOException{
        throw  new IOException();
    }
}