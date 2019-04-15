package com.xupt.beans;

/**
 *  其他信息
 */
public class OtherInfor {
    //考生号
    private String candidateNum;
    //报到号
    private String reportNum;
    //考生类别
    private String candidateType;
    //考生来源
    private String candidateFrom;
    //是否走读生
    private String formalStu;
    //毕业中学
    private String graduateSchool;
    //学生证号
    private String stuNum;
    //银行名称
    private String bankName;
    //银行卡号
    private String bankNum;
    //身高
    private String height;
    //体重
    private String weight;
    //特长
    private String features;
    //健康状况
    private String health;
    //户籍性质
    private String household ;
    //入学方式
    private String method;
    //入学总分
    private String score;
    //准考证号
    private String number;
    //婚姻状况
    private String marital;
    //导师
    private String tutor;
    //火车票区间站
    private String train;
    //信仰宗教
    private String belief;
    //学习年限
    private String years;
    //备注
    private String remarks;
    //委培单位
    private String unit;
    //委培地区
    private String place;
    //学生标记
    private String mark;

    @Override
    public String toString() {
        return "OtherInfor{" +
                "candidateNum='" + candidateNum + '\'' +
                ", reportNum='" + reportNum + '\'' +
                ", candidateType='" + candidateType + '\'' +
                ", candidateFrom='" + candidateFrom + '\'' +
                ", formalStu='" + formalStu + '\'' +
                ", graduateSchool='" + graduateSchool + '\'' +
                ", stuNum='" + stuNum + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankNum='" + bankNum + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", features='" + features + '\'' +
                ", health='" + health + '\'' +
                ", household='" + household + '\'' +
                ", method='" + method + '\'' +
                ", score='" + score + '\'' +
                ", number='" + number + '\'' +
                ", marital='" + marital + '\'' +
                ", tutor='" + tutor + '\'' +
                ", train='" + train + '\'' +
                ", belief='" + belief + '\'' +
                ", years='" + years + '\'' +
                ", remarks='" + remarks + '\'' +
                ", unit='" + unit + '\'' +
                ", place='" + place + '\'' +
                ", mark='" + mark + '\'' +
                '}';
    }
}
