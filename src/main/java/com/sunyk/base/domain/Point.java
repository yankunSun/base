package com.sunyk.base.domain;

import com.sun.scenario.effect.impl.prism.ps.PPSOneSamplerPeer;

/**
* @Description: 定义泛型类 ， T 任意字母
 *      *     E：元素（Element），多用于java集合框架
 *      *     K：关键字（Key）
 *      *     N：数字（Number）
 *      *     T：类型（Type）
 *      *     V：值（Value）
* @Param:
* @return:
* @Author: sun彦坤
* @Date: 2021/9/8
*/
public class Point<T> {
    private T x;
    private T y;

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }

    public static void main(String[] args) {
        Point<Integer> point = new Point<>();
        point.setX(1);
        //此处会报错，泛型的好处，定义的是宽泛的，编译是严谨的
        //point.setX("");
        System.out.println(point.getX());
        Point<String> stringPoint = new Point<>();
        stringPoint.setX("1");
        System.out.println(stringPoint.getX());
    }
}
