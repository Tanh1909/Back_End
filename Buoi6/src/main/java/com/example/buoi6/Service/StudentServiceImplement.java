package com.example.buoi6.Service;

import com.example.buoi6.entity.Student;
import com.example.buoi6.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentServiceImplement implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Override
    public Student Save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student Update(Student student) {
       return studentRepository.findById(student.getId()).map(student1 -> {
           student1.setName(student.getName());
           student1.setAddress(student.getAddress());
           return studentRepository.save(student1);
        }).orElseGet(() -> studentRepository.save(student));
    }

    @Override
    public void Remove(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> FindAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> FindByID(Long id) {
        return studentRepository.findById(id);
    }
}
