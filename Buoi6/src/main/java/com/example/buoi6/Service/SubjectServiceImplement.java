package com.example.buoi6.Service;

import com.example.buoi6.entity.Subject;
import com.example.buoi6.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImplement implements SubjectService{
    @Autowired
    private SubjectRepository subjectRepository;
    @Override
    public Subject Save(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Subject Update(Subject subject) {
        return subjectRepository.findById(subject.getId()).map(subject1 -> {
            subject1.setName(subject.getName());
            return subjectRepository.save(subject1);
        }).orElseGet(() -> subjectRepository.save(subject));
    }

    @Override
    public void Remove(Long id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public List<Subject> FindAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Optional<Subject> FindByID(Long id) {
        return subjectRepository.findById(id);
    }

    @Override
    public List<Subject> FindByStudentID(Long id) {
        return subjectRepository.findAllByStudent_Id(id);
    }
}
