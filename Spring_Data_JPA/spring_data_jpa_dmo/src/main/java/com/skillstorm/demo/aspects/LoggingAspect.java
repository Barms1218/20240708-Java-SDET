package com.skillstorm.demo.aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger; // Simple logging facade for java - abstraction for logging frameworks
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.skillstorm.demo.models.Director;
import com.skillstorm.demo.models.Movie;

@Component // TODO tell Spring that this is a bean
@Aspect // TODO tells AspectJ that this is an aspect
public class LoggingAspect {

    /*
     * Spring Boot provides logging configuration OTB (out of the box)
     * 
     *  Logging Levels:
     *      fatal -> error -> warn -> info -> debug -> trace
     *      set this in application.properties (or application.yml) using
     * 
     *   logging.level.com.skillstorm.demo=debug
     */

    // TODO Create Logger using LoggerFactory
    Logger logger = LoggerFactory.getLogger(getClass());

    /*
     * ASPECTS 
     *      Join Points - expressiosn that specify when during the execution of the progam advice should be run
     * 
     *      Point Cut - the method invocation or when an exception is thrown during execution
     * 
     *      Advice - code to run along with our code at certain points during execution of the program
     */

    /*
     * options for defining point cut:
     *      within() - specify a package or class
     *      execution() - when a specific method executes
     *      bean() - for a specific bean
     */
    // TODO
    @Pointcut("within(com.skillstorm.demo.controllers.MovieController)") // any method in the MovieController class
    public void checkMovie() {
        /* leave empty - the code inside wont ever run */
    }

    /* 
     TODO Define another pointcut using AspectJ expression notation
    
    
     */
    @Pointcut("exceution(public *save(com.skillstorm.demo.Movie)) & args(movieToBeSaved)")
    public void movieSave(Movie movieToBeSaved) {

    }
    /*
    * Types of Advice
    *      Before - 
    *      After - 
    *      AfterReturning - 
    *      AfterThrowing - 
    *      Around - 
    */

    // Before
    @Before("checkMovie()") // this method gets run before every method in MoviesController
    public void request(JoinPoint joinPoint) {
        logger.debug("A request was made to {} with the arguments: {}", joinPoint.getSignature(),
                Arrays.toString(joinPoint.getArgs()));
    }

    @Before("within(com.skillstorm.demo.models)")
    public void everyMethodInModels() {
        
    }

    // AfterReturning
    public void response(JoinPoint joinPoint, Object returnedDataObject) {
        logger.debug("A request was made to {} with the arguments: {}", joinPoint.getSignature().getName(),
                returnedDataObject.toString());
    }

    // AfterThrowing we are using the RestControllerAdvice to handle
    // see file com.skillstorm.controllers.GlobalExceptionHandler.java

    // Around
    @Around("movieSave(movieToBeSaved)")
    public Movie preventPostDoingUpdate(ProceedingJoinPoint, Movie movieToBeSaved) { //
        /*
         * PROCEEDING JOIN POINT
         *      join point that has an extra method: .proceed()
         * 
         *      aspect is going to interrupt a method and do something - then that method gets executed
         *      with a proceeding join point, it WILL NOT execute that method, until you call .proceed()
         * 
         */
        log.debug("MOVIE: {}", movieToBeSaved);
        Movie savedMovie = null;
        if (Character.isUpperCase(movieToBeSaved.getMovieTitle().charAt(0))) {
            try {
                savedMovie = (Movie)ProceedingJoinPoint.proceed();
            }catch (Throwable e) {
                logger.debug("Method could not be excecuted because {} ", e.getMessage());
            }
        } else {
            logger.debug("NOT SAVING BECAUSE TITLE ISN'T CAPITALIZED");
        }

        logger.debug("DONE");
        return null;
    }

}
}