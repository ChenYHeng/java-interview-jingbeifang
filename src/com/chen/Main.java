package com.chen;

import com.chen.common.Container;
import com.chen.controller.EventController;
import com.chen.controller.GoodsController;
import com.chen.controller.OrderController;
import com.chen.model.Event;
import com.chen.model.Goods;
import com.chen.model.OrderGoodsArrVo;
import com.chen.model.OrderVo;
import com.chen.utils.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        EventController eventController = Container.GetInstance(EventController.class);
        GoodsController goodsController = Container.GetInstance(GoodsController.class);


        // 题目一
        System.out.println("题目一：--------------------------------------------------");
        goodsController.save("苹果", 8);
        goodsController.save("草莓", 13);
        buyFruits();
        System.out.println();

        // 题目二
        System.out.println("题目二：--------------------------------------------------");
        goodsController.save("芒果", 20);
        buyFruits();
        System.out.println();

        // 题目三
        System.out.println("题目三：--------------------------------------------------");
        // 添加草莓八折的促销活动
        for (Goods goods:
             goodsController.findList().getData()) {
            if (goods.getName().equals("草莓")) {
                eventController.addEventDiscount("草莓限时八折", goods.getId(), 0.8f);
            }
        }
        buyFruits();
        System.out.println();

        System.out.println("题目四：--------------------------------------------------");
        eventController.addEventFull("购物满100减10", 100f, 10f);
        buyFruits();
        System.out.println();

    }

    public static void buyFruits() throws Exception {
        GoodsController goodsController = Container.GetInstance(GoodsController.class);
        OrderController orderController = Container.GetInstance(OrderController.class);
        EventController eventController = Container.GetInstance(EventController.class);
        Scanner scanner = new Scanner(System.in);

        // 获取商品列表
        List<Goods> goodsList = goodsController.findList().getData();
        System.out.println("商品列表----");
        for (Goods goods : goodsList) {
            System.out.printf("%-5s %-5s元/斤\n", goods.getName(), StringUtil.formatValue(goods.getPrice()));
        }

        // 获取活动列表
        List<Event> eventList = eventController.findList().getData();
        System.out.println("活动列表----");
        for (int i = 0; i < eventList.size(); i++) {
            Event event = eventList.get(i);
            System.out.printf("%-5d%-5s\n", i + 1, event.getDesc());
        }

        // 准备订单数据
        OrderVo orderVo = new OrderVo();
        orderVo.goodsArr = new ArrayList<>();
        int num = 0;

        // 输入想要买的数量
        for (int i = 0; i < goodsList.size(); i++) {
            Goods goods = goodsList.get(i);
            System.out.printf("请输入%s斤数\n", goods.getName());
            num = scanner.nextInt();
            if (num < 0) {
                throw new Exception("斤数需要大于或等于0");
            }
            orderVo.goodsArr.add(new OrderGoodsArrVo(goods.getId(), num));
        }

        // 计算总价
        float total = orderController.generateOrder(orderVo).getData();
        System.out.printf("总价：%s\n", StringUtil.formatValue(total));
    }
}
