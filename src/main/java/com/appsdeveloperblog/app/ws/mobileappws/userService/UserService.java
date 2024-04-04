package com.appsdeveloperblog.app.ws.mobileappws.userService;

import com.appsdeveloperblog.app.ws.mobileappws.ui.model.request.UpdateUser;
import com.appsdeveloperblog.app.ws.mobileappws.ui.model.requestDto.UserDto;
import com.appsdeveloperblog.app.ws.mobileappws.ui.model.responseEntity.User;

public interface UserService {
    User createUser(UserDto userDto);
    void deleteUser(String id);
    User getUser(String userId);
    User updateUser(String userId, UpdateUser updateUser);

}
