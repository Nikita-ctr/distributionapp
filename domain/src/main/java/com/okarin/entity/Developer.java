package com.okarin.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "developers")
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRST_NAME", length = 30)
    private String first_name;

    @Column(name = "LAST_NAME", length = 90)
    private String last_name;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @NotNull
    @Column(name = "PROJECT_HOURS", length = 60)
    private int projectHours;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Project project;

    public Developer(String first_name, String last_name, Date dateOfBirth, int projectHours, Project project) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.dateOfBirth = dateOfBirth;
        this.projectHours = projectHours;
        this.project = project;
    }

    public void cloneData(Developer developer) {
        this.first_name = developer.getFirst_name();
        this.last_name = developer.getLast_name();
        this.dateOfBirth = developer.getDateOfBirth();
        this.projectHours = developer.getProjectHours();
    }

}