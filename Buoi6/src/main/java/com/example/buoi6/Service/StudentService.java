package com.example.buoi6.Service;

import com.example.buoi6.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StudentService {
    Student Save(Student student);
    Student Update(Student student);
    void Remove(Long id);
    List<Student> FindAll();
    Optional<Student> FindByID(Long id);
}
