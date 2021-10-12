package com.shop.service;

import com.shop.entity.ValueProductFeature;

import java.util.List;

public interface IValueProductFeatureService {
    public List<ValueProductFeature> get(String name);
}
