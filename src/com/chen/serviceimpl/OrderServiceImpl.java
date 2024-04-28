package com.chen.serviceimpl;

import com.chen.common.Container;
import com.chen.constant.EventType;
import com.chen.dao.OrderDao;
import com.chen.dao.OrderGoodsArrDao;
import com.chen.model.*;
import com.chen.service.EventService;
import com.chen.service.GoodsService;
import com.chen.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    OrderDao dao;
    OrderGoodsArrDao goodsArrDao;
    GoodsService goodsService;
    EventService eventService;

    public OrderServiceImpl() {
        dao = Container.GetInstance(OrderDao.class);
        goodsArrDao = Container.GetInstance(OrderGoodsArrDao.class);
        goodsService = Container.GetInstance(GoodsServiceImpl.class);
        eventService = Container.GetInstance(EventServiceImpl.class);
    }


    @Override
    public float add(OrderVo vo) {
        Order po = new Order();
        po.setTotal(0);
        for (int i = 0; i < vo.goodsArr.size(); i++) {
            OrderGoodsArrVo goodsArrVo = vo.goodsArr.get(i);

            // 插入记录
            OrderGoodsArr goodsArrItem = new OrderGoodsArr();
            goodsArrItem.setOrderId(po.getId());
            goodsArrItem.setGoodsId(goodsArrVo.goodsId);
            goodsArrItem.setNum(goodsArrVo.num);
            goodsArrDao.insert(goodsArrItem);

            // 计算总价
            Goods goods = goodsService.get(goodsArrItem.getGoodsId());
            float goodPrice = goods.getPrice() * goodsArrItem.getNum();

            // 查找商品打折活动
            List<Event> events = eventService.getList(EventType.Discount);
            for (Event event : events) {
                if (event.getGoodsId().equals(goods.getId())) {
                    goodPrice *= event.getDiscounts();
                }
            }
            po.setTotal(po.getTotal() + goodPrice);
        }

        // 查找所有的满减活动
        List<Event> events = eventService.getList(EventType.Full);
        for (Event event : events) {
            if (event.getTotal() <= po.getTotal()) {
                po.setTotal(po.getTotal() - event.getTotalReduce());
            }
        }

        dao.insert(po);

        return po.getTotal();
    }

    @Override
    public Order get(String id) {
        return dao.getById(id);
    }

    @Override
    public List<Order> getList() {
        return dao.getList();
    }
}
