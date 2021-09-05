package com.example.demo.controller;

import com.example.demo.model.RegistrationReport;
import com.example.demo.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import  org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.example.demo.model.Registration;
import org.springframework.web.bind.annotation.ResponseBody;
//import javax.servlet.Registration;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
public class RegistrationController {
//    @Autowired
//    private RegistrationService registrationService;
    @Autowired
    private RegistrationService registrationService;

    @GetMapping("registration")
    public String getRegistration(@ModelAttribute ("registration")Registration registration) {
        return "registration";
    }

    @GetMapping("registrations")
    public @ResponseBody
     List<Registration> getRegistrations() {
        List<Registration> registrations=registrationService.findAll();
        return registrations;
    }
    @GetMapping("registration-reports")
    public @ResponseBody
    List<RegistrationReport> getRegistrationReports() {
        List<RegistrationReport> registrationReports=registrationService.findAllReports();
        return registrationReports;
    }

//    @GetMapping("registrations")
//    public @ResponseBody
//    List<Registration>
//    getRegistrations() {
//        List<Registration> registrations = registrationService.findAll();
//        return registrations;
//    }
//    @GetMapping("registration-reports")
//    public @ResponseBody
//    List<RegistrationReport>
//    getRegistrationReports() {
//        List<RegistrationReport> registrationReports = registrationService.findAllReports();
//        return registrationReports;
//    }

    @PostMapping("registration")
    public String addRegistration(@Valid @ModelAttribute ("registration")Registration registration, BindingResult result) {
        if(result.hasErrors())
        {
            System.out.println("There are some errors");
            return "registration";
        }
        else {
            registrationService.addRegistration(registration);
        }
//        else
//        {
//            registrationService.addRegistration(registration);
//        }
        System.out.println("Registration :"+registration.getName());
        return "redirect:registration";
    }
//
//@PostMapping("registration/update")
//public @ResponseBody Registration updateRegistration (@Valid @ModelAttribute("registration")
//                                                              Registration registration,
//                                                      BindingResult result) {
//    return registrationService.addRegistration(registration);
//}
}
