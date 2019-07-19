package com.model.design.spring.node03.factoryMethod;

import java.util.HashMap;
import java.util.Map;

public class ProductCar implements CarFactory {
    private Map<String, CarEntity> carMap = null;
    public ProductCar() {
        carMap = new HashMap<>();
        carMap.put("china", new CarEntity("中国", "黑色","红旗"));
        carMap.put("america", new CarEntity("美国", "白色","雪佛兰"));
    }
    @Override
    public CarEntity getCar(String type) {
        return carMap.get(type);
    }
}
