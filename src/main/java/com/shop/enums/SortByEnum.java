package com.shop.enums;

public enum SortByEnum {
    price, name, rating;

    public static boolean contains(String sort) {
        for (SortByEnum c : SortByEnum.values()) {
            if (c.name().equals(sort)) {
                return true;
            }
        }
        return false;
    }
}
