package com.mapping.hibernatemappings.dto;

import com.mapping.hibernatemappings.entity.Address;
import com.mapping.hibernatemappings.entity.User;
import lombok.Builder;

@Builder
public class UserRequest {

    private String userName;
    private String email;
    private String password;
    private Address address;

    public static User prepareUser(UserRequest userRequest){
        User user = new User();

        user.setName(userRequest.userName);
        user.setAddress(userRequest.address);
        user.setPassword(userRequest.password);
        user.setEmail(userRequest.email);

        return user;
    }

}
