package com.okarin.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;

public class ProjectTest {

    @Test
    public void getProjectSetters(){
        Project project=new Project("Dex");

        Assertions.assertEquals("Dex",project.getName());

        project.setId(1L);
        project.setName("First");

        Assertions.assertEquals(1L,project.getId());
        Assertions.assertEquals("First",project.getName());

    }
    @Test
    public void equalsTest(){
        Project project=new Project("");
        assert project.equals(project);
        Assertions.assertNotEquals(project, new Object());
        Project project1=new Project("");
        Assertions.assertEquals(project, project1);

    }
    @Test
    public void toStringTest(){
        Assertions.assertNotNull(new Project("").toString());
    }
    @Test
    public void cloneDataTest(){
        Project project=new Project("");
        Project project1=new Project("XZ");
        project.cloneData(project1);
        Assertions.assertEquals(project,project1);

        Assertions.assertEquals(project.hashCode(),project1.hashCode());

    }
}
