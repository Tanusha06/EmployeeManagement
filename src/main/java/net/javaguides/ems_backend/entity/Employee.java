package net.javaguides.ems_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto generation of id
    private Long id;

    @Column(name="Name", nullable = false, length = 50)
    private String Name;

    @Column(name="Email",nullable = false,unique = true)
    private String email;

    @Column(name="Salary",nullable = false)
    private Double salary;

    @Enumerated(EnumType.STRING)
    @Column(name="Department")
    private Department department;

}
