package com.chen.service;

import com.chen.model.Goods;
import com.chen.model.Order;
import com.chen.model.OrderGoodsArr;
import com.chen.model.OrderVo;

import java.util.List;

public interface OrderService {
    float add(OrderVo vo);

    Order get(String id);

    List<Order> getList();
}
