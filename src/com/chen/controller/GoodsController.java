package com.chen.controller;

import com.chen.common.Container;
import com.chen.common.Result;
import com.chen.model.Goods;
import com.chen.service.GoodsService;
import com.chen.serviceimpl.GoodsServiceImpl;

import java.util.List;

public class GoodsController {
    GoodsService goodsService;

    public GoodsController() {
        goodsService = Container.GetInstance(GoodsServiceImpl.class);
    }

    public Result<String> save(String name, float price) {
        goodsService.add(name, price);
        return Result.OK();
    }

    public Result<Goods> findById(String id) {
        Goods goods = goodsService.get(id);
        return Result.OK(goods);
    }

    public Result<List<Goods>> findList() {
        List<Goods> goodsList = goodsService.getList();
        return Result.OK(goodsList);
    }
}
