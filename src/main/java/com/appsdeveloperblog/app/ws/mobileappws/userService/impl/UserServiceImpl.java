package com.appsdeveloperblog.app.ws.mobileappws.userService.impl;


import com.appsdeveloperblog.app.ws.mobileappws.shared.Utils;
import com.appsdeveloperblog.app.ws.mobileappws.ui.model.request.UpdateUser;
import com.appsdeveloperblog.app.ws.mobileappws.ui.model.requestDto.UserDto;

import com.appsdeveloperblog.app.ws.mobileappws.ui.model.responseEntity.User;
import com.appsdeveloperblog.app.ws.mobileappws.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    Map<String, User> users;  // serves as Repository


    Utils utils;
    public  UserServiceImpl() {}

    // Constructor Based Dependency Injection
    @Autowired
    public UserServiceImpl(Utils utils)
    {
        this.utils = utils;
    }


    // Constructor Based Dependency Injection
    @Override
    public User createUser(UserDto userDto) {
        User user = new User();   // Run Debug
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());

        String userId = Utils.generateUserId(); // Constructor Based Dependency
       // String userId = UUID.randomUUID().toString();  // Not preferred
        user.setUserId(userId);

        if(users ==null) users = new HashMap<>();
        users.put(userId, user);
        return user;
    }

    @Override
    public void deleteUser(String id){
        users.remove(id);

    }

    @Override
    public User getUser(String userId) {  // Response Status code

    // 1.Temporary DB: create a UserRest (entity) DB
    User user1 = new User();
    user1.setEmail("adebusoyeteeman@gmail.com");
    user1.setFirstName("Toheeb");
    user1.setLastName("Akinade");
    user1.setUserId("Tboy");

 //   return user1;

//        Handle a NullPointerException
//         String firstName=null;
//         int firstNameLength=firstName.length();
//         Custom UserServiceException
//         if(true) throw new UserServiceException("A user service exception is thrown");


//        Store Users Temporary
         if(users.containsKey(userId))
         {
             return  users.get(userId);
         }
         else {
             return null;
         }
    }

    @Override
    public User updateUser(String userId, UpdateUser updateUser)
    {
        User storedUserDetails=users.get(userId);
        storedUserDetails.setFirstName(updateUser.getFirstName());
        storedUserDetails.setLastName(updateUser.getLastName());
        users.put(userId,storedUserDetails);
        return storedUserDetails;
    }

}
