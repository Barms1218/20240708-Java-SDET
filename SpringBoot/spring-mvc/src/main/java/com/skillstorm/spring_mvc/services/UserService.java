package com.skillstorm.spring_mvc.services;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.spring_mvc.dtos.UserDto;
import com.skillstorm.spring_mvc.mapper.UserMapper;
import com.skillstorm.spring_mvc.models.User;

/*
 * @Service is where you will do all the business logic for your controller and
 * repositories
 */
@Service
public class UserService {

    @Autowired
    UserMapper mapper;

    public List<UserDto> findAllUsersDto() {
        List<User> users = new LinkedList<>();

        // Convert List<User> to Stream<User>, then converting Stream<User> to
        // Stream<UserDto>, lastly convert Stream<UserDto> to List<UserDto>
        List<UserDto> userDtos = users.stream().map(mapper::toDto).collect(Collectors.toList());

        return userDtos;
    }

    public List<User> findallUsers() {
        List<User> users = new LinkedList<>();

        users.add(new User(0, "Caroline", "Ahumada", "cahumada@skillstorm.com", "password123"));
        users.add(new User(0, "Branden", "Arms", "barms@skillstorm.com", "password123"));
        users.add(new User(0, "Kendall", "Budd", "kbudd@skillstorm.com", "verystrongpassword123"));
        users.add(new User(0, "Caroline", "Ahumada", "cahumada@skillstorm.com", "password123"));
        users.add(new User(0, "Caroline", "Ahumada", "cahumada@skillstorm.com", "password123"));

        return users;
    }

    public List<User> findByFirstName(String nameString) {
        List<User> users = new LinkedList<>();

        users.add(new User(0, nameString, "Ahumada", "cahumada@skillstorm.com", "password123"));
        users.add(new User(1, nameString, "Arms", "barms@skillstorm.com", "password123"));
        users.add(new User(2, nameString, "Budd", "kbudd@skillstorm.com", "verystrongpassword123"));

        return users;
    }

    public User findByID(long id) {
        return new User(0, "Branden", "Arms", "barms@skillstorm.com", "password123");
    }

    public User createUser(User user) {
        user.setId(10);
        return user;
    }

    public User updateUser(long id, User user) {
        user.setId(id);
        return user;
    }

    public User deleteUser(long id, User user) {
        return user;
    }
}
