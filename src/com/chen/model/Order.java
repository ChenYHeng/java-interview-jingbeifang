package com.chen.model;

import com.chen.common.BaseModel;

import java.util.List;

public class Order extends BaseModel {
//    private List<OrderGoodsArr> goodsArr;
    private float total;

//    public List<OrderGoodsArr> getGoodsArr() {
//        return goodsArr;
//    }
//
//    public void setGoodsArr(List<OrderGoodsArr> goodsArr) {
//        this.goodsArr = goodsArr;
//    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
