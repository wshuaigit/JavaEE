package com.wangzhao.di08;

import java.util.*;

/**
 * ClassName:MyCollections
 * Package:com.wangzhao.di04
 * Description:
 *
 * @Date:2019/3/6 19:20
 * @Author:wangzhao
 */

public class MyCollections {

    private List<Map<String,String>> myListMap;


    private String[] myArray;
    private Set<String> mySet;
    private List<Student> myList;
    private Map<String,Integer> myMap;
    // Properties 也是key-value的结构，key、value都是String类型
    private Properties myProp;

    public void setMyArray(String[] myArray) {
        this.myArray = myArray;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyList(List<Student> myList) {
        this.myList = myList;
    }

    public void setMyMap(Map<String, Integer> myMap) {
        this.myMap = myMap;
    }

    public void setMyProp(Properties myProp) {
        this.myProp = myProp;
    }

    public void setMyListMap(List<Map<String, String>> myListMap) {
        this.myListMap = myListMap;
    }

    @Override
    public String toString() {
        return "MyCollections{" +
                "myArray=" + Arrays.toString(myArray) +
                ", mySet=" + mySet +
                ", myList=" + myList +
                ", myMap=" + myMap +
                ", myProp=" + myProp +
                '}';
    }
}
