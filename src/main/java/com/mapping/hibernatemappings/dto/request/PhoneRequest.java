package com.mapping.hibernatemappings.dto.request;

import com.mapping.hibernatemappings.entity.Phone;
import com.mapping.hibernatemappings.entity.Student;

public record PhoneRequest(
        Short id,
        String primary,
        String secondary,
        Student student
) {

    // to persist into database
    public static Phone toPhone(PhoneRequest phoneRequest){
        Phone phone = new Phone();
        phone.setPrimary(phoneRequest.primary());
        phone.setSecondary(phoneRequest.secondary());
        phone.setStudent(phoneRequest.student());
        return phone;
    }

    // prepare phone to update
    public static Phone toPhone(Phone phone, PhoneRequest phoneRequest){

        if(phoneRequest.id() != null) phone.setId(phoneRequest.id());
        if(phoneRequest.primary() != null) phone.setPrimary(phoneRequest.primary());
        if(phoneRequest.secondary() != null) phone.setSecondary(phoneRequest.secondary());
        if(phoneRequest.student() != null) phone.setStudent(phoneRequest.student());

        return phone;
    }

}
