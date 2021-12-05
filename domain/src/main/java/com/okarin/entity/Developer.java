package com.okarin.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "developers")
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRST_NAME", length = 30)
    private String first_name;

    @Column(name = "LAST_NAME",length = 90)
    private String last_name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    @org.hibernate.annotations.CreationTimestamp
    private Date dateOfBirth;

    @NotNull
    @Column(name = "PROJECT_HOURS", length = 60)
    private int projectHours;

    @OneToMany
    private Set<Project> projects = new HashSet<>();

    public Developer() {
    }
}