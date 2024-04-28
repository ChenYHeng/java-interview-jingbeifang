package com.chen.controller;

import com.chen.common.Container;
import com.chen.common.Result;
import com.chen.model.Order;
import com.chen.model.OrderVo;
import com.chen.service.OrderService;
import com.chen.serviceimpl.OrderServiceImpl;

import java.util.List;

public class OrderController {
    OrderService orderService;

    public OrderController() {
        orderService = Container.GetInstance(OrderServiceImpl.class);
    }

    public Result<Float> generateOrder(OrderVo vo) {
        float total = orderService.add(vo);
        return Result.OK(total);
    }

    public Result<List<Order>> getList() {
        return Result.OK(orderService.getList());
    }
}
