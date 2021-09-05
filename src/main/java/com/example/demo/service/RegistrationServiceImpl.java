package com.example.demo.service;

import com.example.demo.model.Course;
import com.example.demo.model.Registration;
import com.example.demo.model.RegistrationReport;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    private RegistrationRepository registrationRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Override
    @Transactional
    public Registration addRegistration(Registration registration)
    {
        registration=registrationRepository.save(registration);
//        if (registration.getId()==null) {

            Course course = new Course();
            course.setName("Intro");
            course.setDescription("Every attendee must complete the intro.");
            course.setRegistration(registration);

            courseRepository.save(course);
//        }
        return registration;

    }

    @Override
    public List<Registration> findAll() {
        return registrationRepository.findAll();
    }

    @Override
    public List<RegistrationReport> findAllReports() {
        return registrationRepository.registrationReport();
    }

}
