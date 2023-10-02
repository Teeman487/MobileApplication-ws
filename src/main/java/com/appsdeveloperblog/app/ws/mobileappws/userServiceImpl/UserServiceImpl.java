package com.appsdeveloperblog.app.ws.mobileappws.userServiceImpl;

import com.appsdeveloperblog.app.ws.mobileappws.Utils.Utils;
import com.appsdeveloperblog.app.ws.mobileappws.ui.modelresponse.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.mobileappws.ui.modelresponse.UserRest;
import com.appsdeveloperblog.app.ws.mobileappws.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    Map<String, UserRest> users;

    // Constructor Based Dependency Injection

    Utils utils;
    public  UserServiceImpl() {}
    @Autowired
    public UserServiceImpl(Utils utils)
    {
        this.utils = utils;
    } // Constructor Based Dependency Injection
    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {
        UserRest returnValue = new UserRest();   // Run Debug
        returnValue.setEmail(userDetails.getEmail());
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());

        //return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);


        // Store Users Temporary
        String userId = utils.generateUserId(); // Constructor Based Dependency
       // String userId = UUID.randomUUID().toString();
        returnValue.setUserId(userId);

        if(users ==null) users = new HashMap<>();
        users.put(userId, returnValue);
        return returnValue;
    }
}
