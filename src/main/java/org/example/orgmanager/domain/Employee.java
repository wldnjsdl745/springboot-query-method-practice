package org.example.orgmanager.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String name;
    private int salary;
    private LocalDate hireDate;
    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @PrePersist
    public void prePersist(){
        if (this.hireDate == null){
            this.hireDate = LocalDate.now();
        }
    }

    @Builder
    public Employee(String name, int salary, LocalDate hireDate, Department department){
        this.name = name;
        this.salary = salary;
        this.hireDate = hireDate;
        this.department = department;
    }

}
