package com.appsdeveloperblog.app.ws.mobileappws.ui.controllers;
import com.appsdeveloperblog.app.ws.mobileappws.ui.model.requestDto.UserDto;
import com.appsdeveloperblog.app.ws.mobileappws.ui.model.responseEntity.User;
import com.appsdeveloperblog.app.ws.mobileappws.userService.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/users") // http://localhost:8080/users
public class UserController {
    Map<String, User> users;  //  Store Users Temporary in place of Repository
    UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }



    //2. localhost:8081/users?sort=java&limit=4&page=10 - Optional Queries
    @GetMapping
    public String getUser(@RequestParam(value="page", defaultValue = "1") int page,
                          @RequestParam(value="limit", defaultValue = "50") int limit,
                          @RequestParam(value="sort", defaultValue = "desc", required = false) String sort) {
        return "get user was called with page = " + page + " and limit = " + limit + " and sort = " + sort;
    }

    //1. localhost:8081/users/{userId}
     @GetMapping(path="/{userId}"
             // add it dependency - jackson xml | Returning Object as JSON or XML Representation
//     ,produces =  {
//     MediaType.APPLICATION_XML_VALUE,
//     MediaType.APPLICATION_JSON_VALUE
//     }
     )
    public ResponseEntity<User> getUser(@PathVariable  String userId) {  // Response Status code

    // 1.Temporary DB: create a UserRest (entity) DB
//    User user1 = new User();
//    user1.setEmail("adebusoyeteeman@gmail.com");
//    user1.setFirstName("Toheeb");
//    user1.setLastName("Akinade");
//    user1.setUserId("Tboy");
//   return new ResponseEntity<User>(user1, HttpStatus.OK);

         //Handle a NullPointerException
//         String firstName=null;
//         int firstNameLength=firstName.length();
        // Custom UserServiceException
//         if(true) throw new UserServiceException("A user service exception is thrown");

         //Store Users Temporary
//         if(users.containsKey(userId))
//         {
//             return  new ResponseEntity<>(users.get(userId), HttpStatus.OK);
//         } else {
//             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//         }

         User user = userService.getUser(userId);
         return new ResponseEntity<User>(user, HttpStatus.OK);
    }

//4.    Reading HTTP POST Request Body
    @PostMapping(
//            consumes = { MediaType.APPLICATION_ATOM_XML_VALUE,
//            MediaType.APPLICATION_JSON_VALUE},
//            produces = {
//            MediaType.APPLICATION_ATOM_XML_VALUE,
//            MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDto userDto ) { // Validating HTTP Post RequestBody

        // Temporary DB - posting UserDto to User
//        User user2 = new User();
//        user2.setEmail(userDto.getEmail());
//        user2.setFirstName(userDto.getFirstName());
//        user2.setLastName(userDto.getLastName());
//
//        // Store Users Temporary
//        String userId = UUID.randomUUID().toString();
//        user2.setUserId(userId);
//
//        if(users ==null) users = new HashMap<>();
//        else{
//        users.put(userId, user2);}
//        return new ResponseEntity<User>(user2, HttpStatus.OK); // user2 is the body

         //Dependency Injection Create & Autowire a Service
        User user3 = userService.createUser(userDto);
         // User user3= new UserServiceImpl().createUser(userDto);
         return new ResponseEntity<User>(user3, HttpStatus.OK); // user2 is the body
    }

    // Handle HTTP PUT Request
    @PutMapping(path="/{userId}"
//            ,consumes = { MediaType.APPLICATION_ATOM_XML_VALUE,
//            MediaType.APPLICATION_JSON_VALUE},
//            produces = {
//                    MediaType.APPLICATION_ATOM_XML_VALUE,
//                    MediaType.APPLICATION_JSON_VALUE}
    )

    public User updateUser(@PathVariable String userId, @Valid @RequestBody
    com.appsdeveloperblog.app.ws.mobileappws.ui.model.request.UpdateUser userDetails)
    {
//        User storedUserDetails=users.get(userId);
//        storedUserDetails.setFirstName(userDetails.getFirstName());
//        storedUserDetails.setLastName(userDetails.getLastName());
//
//        users.put(userId,storedUserDetails);
        return  userService.updateUser(userId,userDetails);
    }

//    @PutMapping
//    public String updateUser() {
//        return "update user was called";
//    }

    //3.  Handle HTTP Delete Request
    @DeleteMapping(path="/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
//        users.remove(id);
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();

    }

   }

