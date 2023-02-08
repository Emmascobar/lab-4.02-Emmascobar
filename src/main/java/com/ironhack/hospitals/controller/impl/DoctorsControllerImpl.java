package com.ironhack.hospitals.controller.impl;
import com.ironhack.hospitals.Repository.DoctorsRepository;
import com.ironhack.hospitals.controller.interfaces.DoctorsController;
import com.ironhack.hospitals.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DoctorsControllerImpl implements DoctorsController {

    @Autowired
    private DoctorsRepository doctorsRepository;

    @GetMapping("/doctors")
    public List<Doctor> getAllDoctors() {
        return doctorsRepository.findAll();
    }

    @GetMapping("/doctors/{id}")
    public Doctor getById(@PathVariable(name = "id") Integer Id) {
        return doctorsRepository.findById(Id).get();
    }

    @GetMapping("/doctors/status/{status}")
    public List<Doctor> getByStatus(@PathVariable("status") String status) {
        return doctorsRepository.findByStatus(status);
    }

    @GetMapping("/doctors/departments/{departarment}")
    public List<Doctor> getByDepartment(@PathVariable(name = "department") String department) {
        return doctorsRepository.findByDepartment(department);
    }
//    @PostMapping("/doctors")
//    @ResponseStatus(HttpStatus.CREATED)
//    public doctor(@RequestBody @Valid Doctor doctor) {
//        return doctorsRepository.save(doctor);
//    }

}
