package com.shop.service;

import com.shop.entity.ValueProductFeature;
import com.shop.repository.ValueProductFeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValueProductFeatureService implements IValueProductFeatureService{


    ValueProductFeatureRepository valueProductFeatureRepo;

    @Autowired
    public ValueProductFeatureService(ValueProductFeatureRepository valueProductFeatureRepo) {
        this.valueProductFeatureRepo = valueProductFeatureRepo;
    }

    @Override
    public List<ValueProductFeature> get(String name) {
        System.out.println(valueProductFeatureRepo.findAllByProductFeature1(name));
        return null;
    }
}
