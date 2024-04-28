package com.chen.model;

import com.chen.common.BaseModel;

public class Goods extends BaseModel {
    private String name; // 名称
    private float price; // 单价，X元/斤

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
