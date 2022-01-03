package com.okarin.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Project() {
    }

    public Project(String name) {
        this.name = name;
    }

    public void cloneData(Project project){
        this.name=project.getName();
    }
}
