package com.example.buoi6.controller;

import com.example.buoi6.DTO.SubjectDTO;
import com.example.buoi6.Service.StudentService;
import com.example.buoi6.Service.SubjectService;
import com.example.buoi6.entity.Student;
import com.example.buoi6.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private StudentService studentService;

    @PostMapping("/create_new_subject")
    public ResponseEntity<?> CreateNewSubject(@RequestBody SubjectDTO subjectDTO) {
        Student student = studentService.FindByID(subjectDTO.getStudent_id()).orElseThrow(() -> new RuntimeException());
        Subject subject = new Subject(subjectDTO, student);
        return ResponseEntity.ok(subjectService.Save(subject));
    }
    @PostMapping("/update_subject/{id}")
    public ResponseEntity<?> UpdateSubject(@RequestBody SubjectDTO subjectDTO, @PathVariable Long id) {
        Student student = studentService.FindByID(subjectDTO.getStudent_id()).orElseThrow(() -> new RuntimeException());
        Subject subject = new Subject(subjectDTO, student);
        subject.setId(id);
        return ResponseEntity.ok(subjectService.Save(subject));
    }
    @PostMapping("/delete_subject/{id}")
    public ResponseEntity<?> DeleteSubject( @PathVariable Long id) {
      subjectService.Remove(id);
        return ResponseEntity.ok("ok");
    }
    @GetMapping("/get_all_subject")
    public ResponseEntity<?> getAllSubject() {
        return ResponseEntity.ok(subjectService.FindAll());
    }
    @GetMapping("/find_all_by_studentId/{id}")
    public ResponseEntity<?> getAllByStudentId(@PathVariable Long id) {
        return ResponseEntity.ok(subjectService.FindByStudentID(id));
    }
}
