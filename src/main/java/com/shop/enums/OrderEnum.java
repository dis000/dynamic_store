package com.shop.enums;

public enum OrderEnum {

    asc, desc;

    public static boolean contains(String orderBy) {
        for (OrderEnum c : OrderEnum.values()) {
            if (c.name().equals(orderBy)) {
                return true;
            }
        }
        return false;
    }
}
