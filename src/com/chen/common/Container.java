package com.chen.common;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class Container {
    public static Map<String, Object> containerMap = new HashMap<>();

    public static <T> T GetInstance(Class<T> custom) {
        String name = custom.getName();
        if (containerMap.containsKey(name)) {
            return (T)containerMap.get(name);
        }
        Constructor constructor = null;
        try {
            constructor = custom.getConstructor();
            containerMap.put(name, constructor.newInstance());
            return (T)containerMap.get(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
