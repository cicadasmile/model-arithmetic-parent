package com.model.principle.node03.depend;

public class C01_FarmFactory {
    public static void main(String[] args) {
        Animal animal = new Dog() ;
        FarmFactory farm = new Farming() ;
        farm.breed(animal) ;
        animal = new Pig() ;
        farm.breed(animal) ;
    }
}
/**
 * 接口声明依赖对象
 */
interface FarmFactory {
    void breed (Animal animal) ;
}
class Farming implements FarmFactory {
    @Override
    public void breed(Animal animal) {
        System.out.println("农场饲养："+animal.getAnimalName());
    }
}
interface Animal {
    String getAnimalName () ;
}
class Dog implements Animal {
    @Override
    public String getAnimalName() {
        return "牧羊犬";
    }
}
class Pig implements Animal {
    @Override
    public String getAnimalName() {
        return "土猪一号";
    }
}