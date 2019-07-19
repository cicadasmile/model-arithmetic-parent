package com.model.design.spring.node03.factoryMethod;

public class CarEntity {
    private String country ;
    private String color ;
    private String name ;
    public CarEntity(String country, String color, String name) {
        this.country = country;
        this.color = color;
        this.name = name;
    }

    @Override
    public String toString() {
        return "CarEntity{" +
                "country='" + country + '\'' +
                ", color='" + color + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
