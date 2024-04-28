package com.chen.serviceimpl;

import com.chen.common.Container;
import com.chen.constant.EventType;
import com.chen.dao.EventDao;
import com.chen.model.Event;
import com.chen.service.EventService;

import java.util.List;

public class EventServiceImpl implements EventService {
    private EventDao dao;

    public EventServiceImpl() {
        dao = Container.GetInstance(EventDao.class);
    }

    @Override
    public void addDiscount(String desc, String goodsId, float discount) {
        Event po = new Event();
        po.setDesc(desc);
        po.setEventType(EventType.Discount);
        po.setGoodsId(goodsId);
        po.setDiscounts(discount);
        dao.insert(po);
    }

    @Override
    public void addFull(String desc, float total, float totalReduce) {
        Event po = new Event();
        po.setDesc(desc);
        po.setEventType(EventType.Full);
        po.setTotal(total);
        po.setTotalReduce(totalReduce);
        dao.insert(po);
    }

    @Override
    public Event get(String id) {
        return dao.getById(id);
    }

    @Override
    public List<Event> getList(int eventType) {
        return dao.getList(eventType);
    }

    @Override
    public List<Event> getList() {
        return dao.getList();
    }
}
