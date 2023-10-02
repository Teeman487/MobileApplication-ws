package com.appsdeveloperblog.app.ws.mobileappws.ui.controller;

import com.appsdeveloperblog.app.ws.mobileappws.Exceptions.UserServiceException;
import com.appsdeveloperblog.app.ws.mobileappws.ui.modelresponse.UpdateUserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.mobileappws.ui.modelresponse.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.mobileappws.ui.modelresponse.UserRest;
import com.appsdeveloperblog.app.ws.mobileappws.userService.UserService;
import com.appsdeveloperblog.app.ws.mobileappws.userServiceImpl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.OutputKeys;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users") // http://localhost:8080/users
public class UserController {
    // Store Users Temporary
    Map<String,UserRest> users;  //  Store Users Temporary

    @Autowired
    UserService userService;



    @GetMapping   //  Optional Queries
    public String getUser(@RequestParam(value="page", defaultValue = "1") int page,
                          @RequestParam(value="limit", defaultValue = "50") int limit,
                          @RequestParam(value="sort", defaultValue = "desc", required = false) String sort) {  // int is a primitive data type, hence cant work
       // required = false:In java,if an object-sort has not been initialized, you get Null pointer exception when you want to access it
        //if(sort == null) sort ="desc";
        return "get user was called with page = " + page + " and limit = " + limit + " and sort = " + sort;

    }

    // Returning Object as JSON or XML Representation
     @GetMapping(path="/{userid}", produces = { MediaType.APPLICATION_ATOM_XML_VALUE,
             MediaType.APPLICATION_JSON_VALUE})  // add it dependency - jackson xml
    public ResponseEntity<UserRest> getUser(@PathVariable  String userid) {  // Response Status code
       /* UserRest returnValue = new UserRest();
        returnValue.setEmail("adebusoyeteeman@gmail.com");
        returnValue.setFirstName("Toheeb");
        returnValue.setLastName("Akinade");*/

        //return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);


         //Handle an Exception
         /*String firstName=null;   //

         int firstNameLength=firstName.length();*/
        // Handle an Exception

         if(true) throw new UserServiceException("A user service exeception is thrown");// Throw and Handle your own Custom Exception




         //Store Users Temporary
         if(users.containsKey(userid))
         {
             return  new ResponseEntity<>(users.get(userid), HttpStatus.OK);
         } else {
             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
         }
         //Store Users Temporary

    }

    //Reading HTTP POST Request Body
    @PostMapping(consumes = { MediaType.APPLICATION_ATOM_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE},
            produces = {
            MediaType.APPLICATION_ATOM_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails ) { // Validating HTTP Post RequestBody

       /* UserRest returnValue = new UserRest();
        returnValue.setEmail(userDetails.getEmail());
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());

        //return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);


        // Store Users Temporary
        String userId = UUID.randomUUID().toString();
        returnValue.setUserId(userId);

        if(users ==null) users = new HashMap<>();
        users.put(userId, returnValue);*/

        UserRest returnValue= new UserServiceImpl().createUser(userDetails);                        //Dependency Injection Create & Autowire a Service
        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
        //Store Users Temporary
    }

    // Handle HTTP PUT Request
    @PutMapping(path="/{userId}",consumes = { MediaType.APPLICATION_ATOM_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE},
            produces = {
                    MediaType.APPLICATION_ATOM_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE})
    public UserRest updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailsRequestModel userDetails)
    {
        UserRest storedUserDetails=users.get(userId);
        storedUserDetails.setFirstName(userDetails.getFirstName());
        storedUserDetails.setLastName(userDetails.getLastName());

        users.put(userId,storedUserDetails);
        return storedUserDetails;
    }    // Handle HTTP PUT Request

   /* @PutMapping
    public String updateUser() {
        return "update user was called";
    }*/


    // Handle HTTP Delete Request
    @DeleteMapping(path="/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        users.remove(id);
        return ResponseEntity.noContent().build();
    }

    /*@DeleteMapping
    public String deleteUser() {
        return "delete user was called";
    }*/

}

