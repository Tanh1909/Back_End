package com.example.buoi6.controller;

import com.example.buoi6.DTO.StudentDTO;
import com.example.buoi6.Service.StudentService;
import com.example.buoi6.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/create_new_student")
    public ResponseEntity<?> CreateNewStudent(@RequestBody StudentDTO studentDTO) {
        Student student = new Student(studentDTO);
        return ResponseEntity.ok(studentService.Save(student));
    }

    @PostMapping("/update_student/{id}")
    public ResponseEntity<?> UpdateStudent(@RequestBody StudentDTO studentDTO, @PathVariable Long id) {
        Student student = new Student(studentDTO);
        student.setId(id);
        return ResponseEntity.ok(studentService.Update(student));
    }

    @PostMapping("/delete_student/{id}")
    public ResponseEntity<?> DeleteStudent(@PathVariable Long id) {
        studentService.Remove(id);
        return ResponseEntity.ok("success");
    }

    @GetMapping("/get_all_student")
    public ResponseEntity<?> getAllStudent() {
        return ResponseEntity.ok(studentService.FindAll());
    }
}
