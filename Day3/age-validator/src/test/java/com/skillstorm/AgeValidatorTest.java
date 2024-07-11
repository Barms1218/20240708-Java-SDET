package com.skillstorm;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * JUNIT - unit testing framework
 * 
 * - unit testing is testing the individual components to ensure they work as
 * intended
 * 
 * JUNIT ANNOTATIONS
 * 
 * BeforeClass - The annotation put on your method if you want it to run before
 * all other methods. Ex: To set up a database connection // Before - Annotation
 * used if you want annotation to run before each test Ex: Load data from the
 * database // Test - Ignore - After - AfterClass
 * 
 * if you have multiple methods of the same annotation type, JUNIT does not
 * guarantee the order that the matching annotations will run
 * 
 */
public class AgeValidatorTest {
    static AgeValidator ageValidator;

    Person personOne;
    Person personTwo;
    Person personThree;
    Person personFour;
    Person personFive;

    /*
     * Before and BeforeClass
     * 
     * Setup methods - used to initialize data you will use within your tests
     * 
     * BeforeClass runs
     */

    @BeforeClass
    public static void setupAgeValidator() {
        ageValidator = new AgeValidator();
    }
}
