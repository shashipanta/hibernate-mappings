package com.mapping.hibernatemappings.service.serviceImpl;

import com.mapping.hibernatemappings.dto.request.PhoneRequest;
import com.mapping.hibernatemappings.dto.response.PhoneResponse;
import com.mapping.hibernatemappings.entity.Phone;
import com.mapping.hibernatemappings.repo.PhoneRepo;
import com.mapping.hibernatemappings.service.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PhoneServiceImpl implements PhoneService {

    private final PhoneRepo phoneRepo;
    @Override
    public PhoneResponse createPhone(PhoneRequest phoneRequest) {
        Phone phone = phoneRepo.save(PhoneRequest.toPhone(phoneRequest));
        return PhoneResponse.toPhoneResponse(phone);
    }

    @Override
    public PhoneResponse getSinglePhone(Short phoneId) {
        Phone foundPhone =  phoneRepo.findById(phoneId).orElseThrow();
        return PhoneResponse.toPhoneResponse(foundPhone);
    }

    @Override
    public List<PhoneResponse> getAllPhones() {

        List<Phone> phoneList = phoneRepo.findAll();
        return phoneList.stream()
                        .map(PhoneResponse::toPhoneResponse)
                        .collect(Collectors.toList());
    }

    @Override
    public PhoneResponse updatePhone(Short phoneId, PhoneRequest phoneRequest) {

        Phone foundPhone = phoneRepo.findById(phoneId).orElseThrow();

        foundPhone = PhoneRequest.toPhone(foundPhone, phoneRequest);

        foundPhone =  phoneRepo.save(foundPhone);

        return PhoneResponse.toPhoneResponse(foundPhone);
    }

    @Override
    public void deletePhone(Short phoneId) {
        phoneRepo.deleteById(phoneId);
    }
}
