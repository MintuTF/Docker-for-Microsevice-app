package edu.miu.authserver.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class Airport {

    private long id;
    private String name;
}
