package com.chen.dao;

import com.chen.common.BaseDao;
import com.chen.model.Event;

import java.util.ArrayList;
import java.util.List;

public class EventDao extends BaseDao<Event> {
    public List<Event> getList(int eventType) {
        List<Event> events = new ArrayList<>();
        for (Event event:
             data) {
            if (eventType == event.getEventType()) {
                events.add(event);
            }
        }

        return events;
    }
}
