package com.appsdeveloperblog.app.ws.mobileappws.userService;

import com.appsdeveloperblog.app.ws.mobileappws.ui.modelresponse.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.mobileappws.ui.modelresponse.UserRest;

public interface UserService {
    UserRest createUser(UserDetailsRequestModel userDetails);

}
