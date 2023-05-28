package com.mapping.hibernatemappings.repo;

import com.mapping.hibernatemappings.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepo extends JpaRepository<Phone, Short> {
}
