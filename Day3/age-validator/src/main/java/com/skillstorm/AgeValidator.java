package com.skillstorm;

public class AgeValidator {
    public boolean oldEnoughToDrive(Person person) {
        if (person.getAge() >= 16) {
            System.out.println(person.getName() + " is old enough to drive.");
            return true;
        } else {
            /* 
             * THROWS vs THROW
             * throw - Do the exception immediately
             * throws - Announces that a method could throw that type of exception
             */
            throw new InvalidAgeException(person.getName() + " must be at least 16 years old to drive.");
        }
    }

    public boolean oldEnoughToVote(Person person) {
        if (person.getAge() >= 18) {
            System.out.println(person.getName() + " is old enough to vote.");
            return true;
        } else {
            throw new InvalidAgeException(person.getName() + " must be at least 18 years old to vote.");
        }
    }

    public boolean oldEnoughBuyAlcohol(Person person) {
        if (person.getAge() >= 21) {
            System.out.println(person.getName() + " is old enough to buy alcohol.");
            return true;
        } else {
            throw new InvalidAgeException(person.getName() + " must be at least 21 years old to buy alcohol.");
        }
    }
}
