package com.example.buoi6.repository;

import com.example.buoi6.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    List<Subject> findAllByStudent_Id(Long id);
}
