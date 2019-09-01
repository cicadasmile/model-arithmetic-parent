package com.model.design.base.node09.decorator;

/**
 * 孙悟空有七十二般变化，他的每一种变化都给他带来一种附加的本领。
 * 他变成鱼儿时，就可以到水里游泳；他变成鸟儿时，就可以在天上飞行。
 */
public class C01_InScene {
    public static void main(String[] args) {
        TheGreatestSage greatestSage = new Monkey();
        TheGreatestSage fish = new Fish(greatestSage);
        fish.shapeDesc();
        // 这里虽然是鱼形态，但是本体是悟空，所以可以直接变化
        TheGreatestSage bird = new Bird(fish);
        bird.shapeDesc();
    }
}
// 顶级接口
interface TheGreatestSage {
    // 定义一个描述形态的方法
    void shapeDesc ();
}
// 悟空本尊
class Monkey implements TheGreatestSage{
    @Override
    public void shapeDesc() {
        System.out.println("Monkey.move()");
    }
}
// 包装一层变化的描述
class Change implements TheGreatestSage {
    private TheGreatestSage greatestSage;
    Change(TheGreatestSage greatestSage){
        this.greatestSage = greatestSage;
    }
    @Override
    public void shapeDesc() {
        greatestSage.shapeDesc();
    }
}
// 具体的变化形态
class Fish extends Change{
    public Fish(TheGreatestSage greatestSage) {
        super(greatestSage);
    }
    public void shapeDesc(){
        System.out.println("鱼在水中游...");
    }
}
class Bird extends Change{
    public Bird(TheGreatestSage greatestSage) {
        super(greatestSage);
    }
    public void shapeDesc(){
        System.out.println("鸟在空中飞...");
    }
}
