package com.skillstorm.spring_mvc.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.skillstorm.spring_mvc.models.User;

/*
 * @Service is where you will do all the business logic for your controller and
 * repositories
 */
@Service
public class UserService {
    public List<User> findallUsers() {
        List<User> users = new LinkedList<>();

        users.add(new User(0, "Caroline", "Ahumada", "cahumada@skillstorm.com", "password123"));
        users.add(new User(0, "Branden", "Arms", "barms@skillstorm.com", "password123"));
        users.add(new User(0, "Kendall", "Budd", "kbudd@skillstorm.com", "verystrongpassword123"));
        users.add(new User(0, "Caroline", "Ahumada", "cahumada@skillstorm.com", "password123"));
        users.add(new User(0, "Caroline", "Ahumada", "cahumada@skillstorm.com", "password123"));

        return users;
    }

    public List<User> findByFirstName() {
        List<User> users = new LinkedList<>();

        users.add(new User(0, "Caroline", "Ahumada", "cahumada@skillstorm.com", "password123"));
        users.add(new User(0, "Branden", "Arms", "barms@skillstorm.com", "password123"));
        users.add(new User(0, "Kendall", "Budd", "kbudd@skillstorm.com", "verystrongpassword123"));

        return users;
    }

    public User findByID(long id) {
        return new User(0, "Branden", "Arms", "barms@skillstorm.com", "password123");
    }

    public User createUser(User user) {
        user.setId(10);
        return user;
    }
}
