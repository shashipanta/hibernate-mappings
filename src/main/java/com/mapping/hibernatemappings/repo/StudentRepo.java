package com.mapping.hibernatemappings.repo;

import com.mapping.hibernatemappings.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Short> {
}
