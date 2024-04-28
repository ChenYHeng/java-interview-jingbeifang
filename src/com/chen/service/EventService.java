package com.chen.service;

import com.chen.model.Event;

import java.util.List;

public interface EventService {
    void addDiscount(String desc, String goodsId, float discount);

    void addFull(String desc, float total, float totalReduce);

    Event get(String id);

    List<Event> getList(int eventType);

    List<Event> getList();
}
