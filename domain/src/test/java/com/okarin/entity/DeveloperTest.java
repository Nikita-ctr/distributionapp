package com.okarin.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class DeveloperTest {

    @Test
    public void getDeveloperSetters() {

        Developer developer=new Developer("Name","LastName",new Date(),11,new Project());

        Assertions.assertNotNull(developer.getDateOfBirth());
        Assertions.assertEquals("Name",developer.getFirst_name());
        Assertions.assertEquals("LastName",developer.getLast_name());
        Assertions.assertEquals(11,developer.getProjectHours());
        Assertions.assertEquals(new Project(),developer.getProject());

        developer.setId(1L);
        developer.setFirst_name("N");
        developer.setLast_name("L");
        developer.setDateOfBirth(new Date(1));
        developer.setProjectHours(2);

        Assertions.assertEquals(1,developer.getId());
        Assertions.assertEquals("N",developer.getFirst_name());
        Assertions.assertEquals("L",developer.getLast_name());
        Assertions.assertEquals(new Date(1),developer.getDateOfBirth());
        Assertions.assertEquals(2,developer.getProjectHours());



    }
    @Test
    public void equalsTest(){
        Developer developer=new Developer("Name","LastName",new Date(1),11,new Project());
        assert developer.equals(developer);
        Assertions.assertNotEquals(developer, new Object());
        Developer developer1=new Developer("Name","LastName",new Date(1),11,new Project());
        Assertions.assertEquals(developer, developer1);


    }
    @Test
    public void toStringTest(){
        Assertions.assertNotNull(new Developer("Name","LastName",new Date(),11,new Project()).toString());

    }
    @Test
    public void cloneDataTest(){
        Developer developer=new Developer("Name","LastName",new Date(),11,new Project());
        Developer developer1=new Developer("Name","LastName",new Date(),11,new Project());
        developer.cloneData(developer1);
        Assertions.assertEquals(developer,developer1);

        Assertions.assertEquals(developer.hashCode(),developer1.hashCode());
    }
}
