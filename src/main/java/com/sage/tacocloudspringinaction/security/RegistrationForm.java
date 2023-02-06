package com.sage.tacocloudspringinaction.security;

import com.sage.tacocloudspringinaction.UserP;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegistrationForm {

    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public UserP toUser(PasswordEncoder passwordEncoder){
        return new UserP(
                username = username,
                password = passwordEncoder.encode(password),
                fullname = fullname,
                street = street,
                city = city,
                state = state,
                zip = zip,
                phone = phone
        );
    }
}
