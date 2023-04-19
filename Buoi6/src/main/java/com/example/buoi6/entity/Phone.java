package com.example.buoi6.entity;

import com.example.buoi6.DTO.PhoneDTO;
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
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "student_id",unique = true)
    private Student student;
    public Phone(PhoneDTO phoneDTO,Student student){
        this.name=phoneDTO.getName();
        this.brand=phoneDTO.getBrand();
        this.student=student;
    }
}
