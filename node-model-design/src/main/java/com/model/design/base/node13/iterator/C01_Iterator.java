package com.model.design.base.node13.iterator;

/**
 * 迭代器源码实现
 */
public class C01_Iterator {
    public static void main(String[] args) {
        Object[] objArray = {"one","two","three","four","five"};
        Aggregate aggregate = new ConcreteAggregate(objArray);
        Iterator iterator = aggregate.createIterator();
        while (!iterator.isEnd()){
            System.out.println(iterator.currentItem());
            iterator.next();
        }
    }
}
interface Iterator {
    void first();
    void next();
    boolean isEnd();
    Object currentItem();
}
class ConcreteIterator implements Iterator{
    //持有被迭代的聚合对象
    private ConcreteAggregate agg;
    //记录当前迭代索引位置
    private int index = 0;
    //设置当前聚集对象的大小
    private int size = 0;
    public ConcreteIterator (ConcreteAggregate agg){
        this.agg = agg;
        this.size = agg.getSize();
        index = 0;
    }
    @Override
    public void first() {
        index = 0;
    }
    @Override
    public void next() {
        if (index<size){
            index++;
        }
    }
    @Override
    public boolean isEnd() {
        return (index>=size);
    }
    @Override
    public Object currentItem() {
        return agg.getElement(index);
    }
}

abstract class Aggregate {
    // 创建相应迭代器对象的接口
    public abstract Iterator createIterator();
}
class ConcreteAggregate extends Aggregate{
    private Object[] objArray = null;
    public ConcreteAggregate (Object[] objArray){
        this.objArray = objArray;
    }
    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(this);
    }
    public Object getElement (int index){
        if (index<objArray.length){
            return objArray[index];
        } else {
            return null;
        }
    }
    public int getSize (){
        return objArray.length;
    }
}
