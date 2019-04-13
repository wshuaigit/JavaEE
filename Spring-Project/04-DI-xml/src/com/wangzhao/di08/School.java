package com.wangzhao.di08;

/**
 * ClassName:School
 * Package:com.wangzhao.di02
 * Description:
 *
 * @Date:2019/3/6 18:04
 * @Author:wangzhao
 */
public class School {

    private String name;
    private String address;

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
