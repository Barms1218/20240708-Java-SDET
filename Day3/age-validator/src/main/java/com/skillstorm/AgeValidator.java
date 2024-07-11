// Source code is decompiled from a .class file using FernFlower decompiler.
package com.skillstorm;

public class AgeValidator {
    public AgeValidator() {
    }

    public boolean oldEnoughToDrive(Person person) {
        if (person.getAge() >= 16) {
            System.out.println(person.getName() + " is old enough to drive.");
            return true;
        } else {
            throw new InvalidAgeException("Must be at least 16 years old to drive!");
        }
    }

    public boolean oldEnoughToVote(Person person) {
        if (person.getAge() >= 18) {
            System.out.println(person.getName() + " is old enough to vote.");
            return true;
        } else {
            throw new InvalidAgeException("Must be at least 18 years old to vote!");
        }
    }

    public boolean oldEnoughToPurchaseAlcohol(Person person) {
        if (person.getAge() >= 21) {
            System.out.println(person.getName() + " is old enough to buy alcohol.");
            return true;
        } else {
            throw new InvalidAgeException("Must be at least 21 years old to buy alcohol!");
        }
    }
}
