package com.example.buoi6.entity;

import com.example.buoi6.DTO.SubjectDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name="student_id")
    @JsonIgnore
    private Student student;

    public Subject(SubjectDTO subjectDTO,Student student){
        this.name=subjectDTO.getName();
        this.student=student;
    }
}
