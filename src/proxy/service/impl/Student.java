package proxy.service.impl;

import proxy.service.Dinner;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-05-16 20:36
 */
public class Student implements Dinner {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void eat(String foodName) {
        System.out.println(name + "正在食堂吃" + foodName);
    }

    @Override
    public void drink() {
        System.out.println(name + "正在喝可乐");
    }
}
