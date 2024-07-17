package com.skillstorm.spring_mvc.controllers;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.spring_mvc.services.UserService;
import com.skillstorm.spring_mvc.models.User;
import org.springframework.web.bind.annotation.PostMapping;

/*
 * 
 * Controller vs RestController
 * 
 * @RestController implicity adds @ResponseBody to every method in the class.
 * 
 * @ResponseBody Will tell the controller that the object returned is serialized
 * into JSON inside the body of the HTTP reponse
 * 
 * 
 * @Controller - You have to include it on every method
 * 
 * @RequestMapping will allow us to map all of our requests to a specific place
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired // will ask spring boot to give us this service
    UserService service;

    /*
     * GET - Retrieves Data
     * POST - Creates Data
     * PUT - Updates Data
     * DELETE - Deletes Data
     */

    // The path for the http request will be /users/helloWorld
    @RequestMapping("/helloWorld")
    public String helloWorld() {
        return "Hello World!";
    }

    /*
     * GetMapping is a HTTP Get Request same as @RequestMapping("path", method=RequestMethod.GET
     */
    @GetMapping
    public List<User> findAllUsers() {
        return service.findallUsers();
    }

    /*
     * @RequestParam finds the data for the parameter in the url path
     * 
     * /users/firstName?first_name=[data]
     */
    @GetMapping("/first_name")
    public List<User> findByFirstName(@RequestParam String firstName) {
        return service.findByFirstName();
    }

    @GetMapping("/user/{id}")
    public User findUserByID(@PathVariable long id) {
        return service.findByID(id);
    }

    /*
     * ResponseEntity - object that gives you more control over your http response, modify headers, status code, etc.
     * 
     * RequestBody looks for the data in the body of the request and deserializes JSON to the Java object
     * 
     * PostMapping is typically used for creating data
     */

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = service.createUser(user);

        return new ResponseEntity<User>(createdUser, HttpStatus.CREATED);
    }
}
