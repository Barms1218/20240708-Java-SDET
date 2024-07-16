package com.skillstorm.hello_spring_boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.skillstorm.hello_spring_boot.beans.Car;
import com.skillstorm.hello_spring_boot.beans.ElectricEngine;
import com.skillstorm.hello_spring_boot.beans.Engine;
import com.skillstorm.hello_spring_boot.beans.GasEngine;
import com.skillstorm.hello_spring_boot.beans.Vehicle;

@Configuration
public class CarConfiguration {

    /*
     * where we can configure our car beans. Tells spring boot where to get beans from/how to initialize them
     *  
     * @BEAN
     *  - Used to register the bean inside the BeanFactory
     *  - Use this annotation on each bean. This way spring can provide beans when asked
     * 
     * @SCOPE - Tells spring what kind of bean you want
     *  BEAN SCOPES:
     * Singleton - each bean will be the same (this is the default)
     * Prototype - Each bean will be different 
     * Application - Creates a bean for the lifespan of the entire application
     * Request - Creates a bean for the lifespan of an HTTP request
     * Session - Creates a bean for the lifespan of the user's session
     * WebSocket - Creates a bean for the lifespan of a web socket
     */

    /*
     * There are 2 types of dependency injection
     * 
     * 1. Setter Injection
     * 2. Constructor Injection
     */

    @Bean(name = { "Mustange", "Camaro" })
    @Scope("prototype")
    public Vehicle gasCar() {
        Car car = new Car();
        car.setEngine(getGasEngine()); // Setter injection

        return car;
    }

    @Bean(name = "Tesla")
    //@Scope("singleton") This is the default
    public Vehicle electricCar() {
        Car car = new Car(getElectricEngine()); // Constructor Injection

        return car;
    }

    @Bean
    public Engine getGasEngine() {
        return new GasEngine();
    }

    @Bean
    Engine getElectricEngine() {
        return new ElectricEngine();
    }
}
