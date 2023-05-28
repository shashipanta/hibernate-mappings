package com.mapping.hibernatemappings.controller;

import com.mapping.hibernatemappings.dto.request.PhoneRequest;
import com.mapping.hibernatemappings.dto.response.PhoneResponse;
import com.mapping.hibernatemappings.service.PhoneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/phone")
public class PhoneController {


    private final PhoneService phoneService;

    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping(value = "/")
    public List<PhoneResponse> getAllPhones(){
        return phoneService.getAllPhones();
    }

    @PostMapping("/")
    public PhoneResponse savePhone(@RequestBody PhoneRequest phoneRequest){
        return phoneService.createPhone(phoneRequest);
    }

    @PutMapping("/{id}")
    public PhoneResponse updatePhone(@PathVariable("id") Short phoneId, @RequestBody PhoneRequest phoneRequest){
        return phoneService.updatePhone(phoneId, phoneRequest);
    }

    @DeleteMapping("/{id}")
    public String deletePhone(@PathVariable("id") Short phoneId){
        phoneService.deletePhone(phoneId);
        return "deletion successful";
    }
}
