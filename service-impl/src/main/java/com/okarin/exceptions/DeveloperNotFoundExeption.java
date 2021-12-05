package com.okarin.exceptions;

import com.okarin.entity.Developer;

public class DeveloperNotFoundExeption extends RuntimeException{
    public DeveloperNotFoundExeption(long developerId){
        super("Developer with id"+developerId+"doesn't exist");
    }

}
