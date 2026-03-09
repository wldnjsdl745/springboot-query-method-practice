package org.example.orgmanager.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(length = 100)
    private String location;

    @Builder
    public Department(String name, String location){
        this.name = name;
        this.location = location;
    }
}