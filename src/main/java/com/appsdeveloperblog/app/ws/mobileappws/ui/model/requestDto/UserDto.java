package com.appsdeveloperblog.app.ws.mobileappws.ui.model.requestDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

// User Details Request Model
public class UserDto {
    @NotNull(message = "first name cannot be null")
    @Size(min=2, message ="First name must not be less than 2 characters")
    private String firstName;
    @NotNull(message = "last name cannot be null")
    @Size(min=2, message ="Last name must not be less than 2 characters")
    private String lastName;
    @NotNull (message = "Email cannot be null")
    @Email
    private String email;
    @NotNull(message = "Password cannot be null")
    @Size(min=8,max = 16, message = "Password must be equal or greater than 8 characters and less than 16 characters")
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
