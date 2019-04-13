package com.wangzhao.ba06;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ClassName:School
 * Package:com.wangzhao.ba03
 * Description:
 *
 * @Date:2019/3/7 15:24
 * @Author:wangzhao
 */

@Component("myXuexiao")
public class School {
    @Value("西安邮电大学")
    private String name;
    @Value("西安长安区")
    private String address;

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
