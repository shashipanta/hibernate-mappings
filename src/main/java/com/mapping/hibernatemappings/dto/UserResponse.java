package com.mapping.hibernatemappings.dto;

import com.mapping.hibernatemappings.entity.Address;
import com.mapping.hibernatemappings.entity.User;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserResponse {

    private String id;
    private String userName;
    private String email;
    private Address address;

//    public UserResponse(User user){
//        this.id = user.getUserId();
//        this.userName = user.getName();
//        this.email = user.getEmail();
////        this.address = user.getAddress();
//    }



}
