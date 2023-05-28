package com.mapping.hibernatemappings.service;

import com.mapping.hibernatemappings.dto.request.PhoneRequest;
import com.mapping.hibernatemappings.dto.response.PhoneResponse;

import java.util.List;

public interface PhoneService {

    PhoneResponse createPhone(PhoneRequest phoneRequest);

    PhoneResponse getSinglePhone(Short phoneId);

    List<PhoneResponse> getAllPhones();

    PhoneResponse updatePhone(Short phoneId, PhoneRequest  phoneRequest);

    void deletePhone(Short phoneId);
}
