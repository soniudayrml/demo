package com.example.demo.service;

import com.example.demo.model.Registration;
import com.example.demo.model.RegistrationReport;

import javax.transaction.Transactional;
import java.util.List;

public interface RegistrationService {
    @Transactional
    Registration addRegistration(Registration registration);

    List<Registration> findAll();

    List<RegistrationReport> findAllReports();
}
