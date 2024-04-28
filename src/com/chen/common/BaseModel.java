package com.chen.common;

import java.util.UUID;

public class BaseModel {
    public String id;

    public BaseModel() {
        setId(UUID.randomUUID().toString());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
