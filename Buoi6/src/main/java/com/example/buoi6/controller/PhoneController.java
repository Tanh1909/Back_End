package com.example.buoi6.controller;

import com.example.buoi6.DTO.PhoneDTO;
import com.example.buoi6.Service.PhoneService;
import com.example.buoi6.Service.StudentService;
import com.example.buoi6.entity.Phone;
import com.example.buoi6.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PhoneController {
    @Autowired
    private PhoneService phoneService;
    @Autowired
    private StudentService studentService;
    @PostMapping("/create_new_phone")
    public ResponseEntity<?> CreateNewPhone(@RequestBody PhoneDTO phoneDTO) {
        Student student = studentService.FindByID(phoneDTO.getStudent_id()).orElseThrow(() -> new RuntimeException());
        Phone phone=new Phone(phoneDTO,student);
        return ResponseEntity.ok(phoneService.Save(phone));
    }
    @PostMapping("/update_phone/{id}")
    public ResponseEntity<?> UpdatePhone(@RequestBody PhoneDTO phoneDTO, @PathVariable Long id) {
        Student student = studentService.FindByID(phoneDTO.getStudent_id()).orElseThrow(() -> new RuntimeException());
        Phone phone=new Phone(phoneDTO,student);
        phone.setId(id);
        return ResponseEntity.ok(phoneService.Update(phone));
    }
    @PostMapping("/delete_phone/{id}")
    public ResponseEntity<?> DeletePhone( @PathVariable Long id) {
        phoneService.Remove(id);
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/get_all_phone")
    public ResponseEntity<?> getAllPhone() {
        return ResponseEntity.ok(phoneService.FindAll());
    }
}
