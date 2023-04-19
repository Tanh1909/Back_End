package com.example.buoi6.Service;

import com.example.buoi6.entity.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectService {
    Subject Save(Subject subject);
    Subject Update(Subject subject);
    void Remove(Long id);
    List<Subject> FindAll();
    Optional<Subject> FindByID(Long id);
    List<Subject> FindByStudentID(Long id);
}
