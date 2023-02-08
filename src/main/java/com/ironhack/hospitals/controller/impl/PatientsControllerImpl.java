package com.ironhack.hospitals.controller.impl;
import com.ironhack.hospitals.Repository.PatientsRepository;
import com.ironhack.hospitals.controller.interfaces.PatientsController;
import com.ironhack.hospitals.enums.Status;
import com.ironhack.hospitals.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
public class PatientsControllerImpl implements PatientsController {

    @Autowired
    private PatientsRepository patientsRepository;

    @GetMapping("/patients")
    public List<Patient> findAll() {
        return patientsRepository.findAll();
    }

    @GetMapping("/patients/¨{id}")
    public Patient getById(@PathVariable(name = "id") Integer id) {
        return patientsRepository.findById(id).get();
    }

    @GetMapping("/patients/dob")
    public List<Patient> getByDateOfBirthBetween(@RequestParam LocalDate from, @RequestParam LocalDate to) {
        return patientsRepository.findByDateOfBirthBetween(from, to);
    }

    @GetMapping("/patients/admittedByDepartment/{department}")
    public List<Patient> getByAdmittedByDepartment(@PathVariable String department) {
        return patientsRepository.findByDoctorDepartment(department);
    }

    @GetMapping("/patients/AdmittedByStatus/{status}")
    public List<Patient> getByAdmittedByStatus(@PathVariable Status status) {
        return patientsRepository.findByDoctorStatus(status.OFF);
    }


//    @PostMapping("/patients")
//    @ResponseStatus(HttpStatus.CREATED)
//    public  store(@RequestBody @Valid Product product) {
//        return productRepository.save(product);
//    }
//

}
