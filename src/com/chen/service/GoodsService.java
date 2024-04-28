package com.chen.service;

import com.chen.model.Goods;

import java.util.List;

public interface GoodsService {
    void add(String name, float price);

    Goods get(String id);

    List<Goods> getList();
}
