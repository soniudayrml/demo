 package com.example.demo.repository;

import com.example.demo.model.Registration;
import com.example.demo.model.RegistrationReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration,Long> {
    List<RegistrationReport> registrationReport();
}
