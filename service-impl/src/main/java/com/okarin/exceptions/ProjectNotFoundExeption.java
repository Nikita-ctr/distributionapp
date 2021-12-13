package com.okarin.exceptions;

public class ProjectNotFoundExeption extends RuntimeException{

    public ProjectNotFoundExeption(long projectId){
        super("Project with id"+projectId+"doesn't exist");
    }
}
