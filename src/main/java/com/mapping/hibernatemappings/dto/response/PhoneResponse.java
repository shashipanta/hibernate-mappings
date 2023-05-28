package com.mapping.hibernatemappings.dto.response;

import com.mapping.hibernatemappings.entity.Phone;
import com.mapping.hibernatemappings.entity.Student;

public record PhoneResponse(
        Short id,
        String primary,
        String secondary,
        Student student
) {

    public static PhoneResponse toPhoneResponse(Phone phone) {
        return new PhoneResponse(phone.getId(), phone.getPrimary(), phone.getSecondary(), phone.getStudent());
    }
}
