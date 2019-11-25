package com.model.design.base.node23.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 调查不同人群对电竞的评价
 */
public class C01_InScene {
    public static void main(String[] args) {
        DataSet dataSet = new DataSet() ;
        dataSet.addCrowd(new Youth());
        dataSet.addCrowd(new MiddleAge());
        CrowdView crowdView = new Against() ;
        dataSet.display(crowdView);
        crowdView = new Approve() ;
        dataSet.display(crowdView);
    }
}
/**
 * 双分派,不同人群管理
 */
abstract class Crowd {
    abstract void accept(CrowdView action);
}
class Youth extends Crowd {
    @Override
    public void accept(CrowdView view) {
        view.getYouthView(this);
    }
}
class MiddleAge extends Crowd {
    @Override
    public void accept(CrowdView view) {
        view.getMiddleAgeView (this);
    }
}
/**
 * 不同人群观念的管理
 */
abstract class CrowdView {
    // 青年人观念
    abstract void getYouthView (Youth youth);
    // 中年人观念
    abstract void getMiddleAgeView (MiddleAge middleAge);
}
class Approve extends CrowdView {
    @Override
    public void getYouthView(Youth youth) {
        System.out.println("青年人赞同电竞");
    }
    @Override
    public void getMiddleAgeView(MiddleAge middleAge) {
        System.out.println("中年人赞同电竞");
    }
}
class Against extends CrowdView {
    @Override
    public void getYouthView(Youth youth) {
        System.out.println("青年人反对电竞");
    }
    @Override
    public void getMiddleAgeView(MiddleAge middleAge) {
        System.out.println("中年人反对电竞");
    }
}
/**
 * 提供一个数据集合
 */
class DataSet {
    private List<Crowd> crowdList = new ArrayList<>();
    public void addCrowd (Crowd crowd) {
        crowdList.add(crowd);
    }
    public void display(CrowdView crowdView) {
        for(Crowd crowd : crowdList) {
            crowd.accept(crowdView);
        }
    }
}