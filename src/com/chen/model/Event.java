package com.chen.model;

import com.chen.common.BaseModel;

public class Event extends BaseModel {
    private String desc;
    private Integer eventType; // 1商品降价，2满减
    private String goodsId; // 商品ID
    private float discounts; // 打折
    private float total; // 满减
    private float totalReduce; // 满total减totalReduce

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getEventType() {
        return eventType;
    }

    public void setEventType(Integer eventType) {
        this.eventType = eventType;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public float getDiscounts() {
        return discounts;
    }

    public void setDiscounts(float discounts) {
        this.discounts = discounts;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getTotalReduce() {
        return totalReduce;
    }

    public void setTotalReduce(float totalReduce) {
        this.totalReduce = totalReduce;
    }
}
