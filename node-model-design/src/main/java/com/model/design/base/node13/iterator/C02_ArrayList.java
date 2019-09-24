package com.model.design.base.node13.iterator;

import java.util.ArrayList;
import java.util.List;

public class C02_ArrayList {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>() ;
        stringList.add("One") ;
        stringList.add("Two") ;
        stringList.add("Three") ;
        java.util.Iterator<String> itr = stringList.iterator() ;
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
