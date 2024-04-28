package com.chen.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StringUtil {
    public static String formatValue(double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.toString();
    }
}
