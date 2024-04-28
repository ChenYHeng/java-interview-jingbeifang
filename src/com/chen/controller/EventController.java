package com.chen.controller;

import com.chen.common.Container;
import com.chen.common.Result;
import com.chen.model.Event;
import com.chen.model.OrderVo;
import com.chen.service.EventService;
import com.chen.serviceimpl.EventServiceImpl;

import java.util.List;

public class EventController {
    EventService eventService;

    public EventController() {
        eventService = Container.GetInstance(EventServiceImpl.class);
    }

    public Result<String> addEventDiscount(String desc, String goodsId, float discount) {
        eventService.addDiscount(desc, goodsId, discount);
        return Result.OK();
    }

    public Result<String> addEventFull(String desc, float total, float totalReduce) {
        eventService.addFull(desc, total, totalReduce);
        return Result.OK();
    }

    public Result<List<Event>> findList() {
        return Result.OK(eventService.getList());
    }
}
