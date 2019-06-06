package com.example.hyperlearner.business;

import com.example.hyperlearner.util.IdUtil;

import javax.persistence.MappedSuperclass;


public class AbstractBusinessObject implements IDEnabled {

    private String id;

    public AbstractBusinessObject() {
        id = IdUtil.generateId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    /*@Override
    public void setId() {

    }

    @Override
    public String getId() {
        return null;
    }*/
}
