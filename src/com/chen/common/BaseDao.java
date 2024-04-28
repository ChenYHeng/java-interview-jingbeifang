package com.chen.common;

import javafx.beans.property.Property;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BaseDao<T> {
    protected List<T> data;

    public BaseDao() {
        data = new ArrayList<>();
    }

    public void insert(T info) {
        data.add(info);
    }

    public void update(int index, T info) {
        data.set(index, info);
    }

    public T get(int index) {
        return data.get(index);
    }

    public T getById(String id) {
        try {
//            System.out.println("GetById, " + data.size());
            for (T po : data) {
                Class<?> clz = po.getClass();
                Method method = clz.getMethod("getId");
                String tmpId = (String) method.invoke(po);
//                System.out.println("tmpId = " + tmpId);
                if (tmpId.equals(id)) {
                    return po;
                }
            }

        } catch (Exception e) {
//            System.out.println(e.printStackTrace());
            e.printStackTrace();
        }

        return null;
    }

    public List<T> getList() {
        return data;
    }

    public void remove(int index) {
        data.remove(index);
    }
}
