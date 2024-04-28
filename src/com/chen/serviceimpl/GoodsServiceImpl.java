package com.chen.serviceimpl;

import com.chen.common.Container;
import com.chen.dao.GoodsDao;
import com.chen.model.Goods;
import com.chen.service.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    private GoodsDao dao;

    public GoodsServiceImpl() {
        dao = Container.GetInstance(GoodsDao.class);
    }

    @Override
    public void add(String name, float price) {
        Goods po = new Goods();
        po.setName(name);
        po.setPrice(price);
        dao.insert(po);
    }

    @Override
    public Goods get(String id) {
        return dao.getById(id);
    }

    @Override
    public List<Goods> getList() {
        return dao.getList();
    }
}
