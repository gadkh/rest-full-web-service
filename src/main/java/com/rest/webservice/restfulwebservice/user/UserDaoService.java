package com.rest.webservice.restfulwebservice.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {
    // Simulate the array list to DB
    private static List<User> users = new ArrayList<>();

    private static int userCount = 3;

    static {
        users.add(new User(1, "Gad", new Date()));
        users.add(new User(2, "Dan", new Date()));
        users.add(new User(3, "San", new Date()));
    }

    // Return all Users from the DB
    public List<User>findAll(){
        return users;
    }

    // Save user to DB if user id is null calculate new user id
    public User saveUser(User user){
        if (user.getId() == null){
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    // Find user by primary key (id) from DB, if not exist return null
    public User findOne(int id){
        for (User user : users){
            if (user.getId() == id){
                return user;
            }
        }
        return null;
    }


}
