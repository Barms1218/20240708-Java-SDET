// Source code is decompiled from a .class file using FernFlower decompiler.
package com.skillstorm;

public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Person [name=" + this.name + ", age=" + this.age + "]";
    }
}
