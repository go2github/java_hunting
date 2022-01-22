package org.hunting.collection;

import java.util.Comparator;
import java.util.Objects;

public class StudentSetPojo implements Comparable<StudentSetPojo> {
    private int rollNo;
    private String name;
    private String email;

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    @Override
    public boolean equals(Object obj) {
        StudentSetPojo pojo=(StudentSetPojo) obj;
        if(pojo.getEmail().equalsIgnoreCase(email)){
            return true;
        }
        return false;
    }
    @Override
    public int hashCode() {
        int hash=Objects.hash(email);
        return hash;
    }


    @Override
    public String toString() {
        return "StudentSetPojo{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public int compareTo(StudentSetPojo studentSetPojo) {

        if(rollNo>studentSetPojo.getRollNo()){
            return 1;
        }

        return -1;
    }
}
