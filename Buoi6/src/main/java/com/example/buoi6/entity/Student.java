package com.example.buoi6.entity;

import com.example.buoi6.DTO.StudentDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<Subject> subjects;
    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    private Phone phone;
    public Student(StudentDTO studentDTO){
        this.name=studentDTO.getName();
        this.address=studentDTO.getAddress();
    }
}
