package com.xupt.beans;

/**
 *  记录基本信息
 */
public class EssInfor {
    //学号
    private String stuNum;
    //姓名
    private String stuName;
    //姓名拼音
    private String pinyin;
    //曾用名
    private String beforeName;
    //英文姓名
    private String englishName;
    //性别
    private String sex;
    //证件类型
    private String documentType;
    //证件号码
    private String idNum;
    //出生日期
    private String birth;
    //民族
    private String nation;
    //政治面貌
    private String ps;
    //政治面貌加入时间
    private String pTime;
    //入学日期
    private String aTime;
    //籍贯
    private String place;
    //户口所在地
    private String location;
    //生源地
    private String stuSource;
    //出生地
    private String placeofbirth;
    //血型名称
    private String blood;
    //港澳台侨外
    private String HMT;
    //国籍/地区
    private String nationality;
    //学生类型
    private String stuType;
    //照片
    private String img;

    @Override
    public String toString() {
        return "EssInfor{" +
                "stuNum='" + stuNum + '\'' +
                ", stuName='" + stuName + '\'' +
                ", pinyin='" + pinyin + '\'' +
                ", beforeName='" + beforeName + '\'' +
                ", englishName='" + englishName + '\'' +
                ", sex='" + sex + '\'' +
                ", documentType='" + documentType + '\'' +
                ", idNum='" + idNum + '\'' +
                ", birth='" + birth + '\'' +
                ", nation='" + nation + '\'' +
                ", ps='" + ps + '\'' +
                ", pTime='" + pTime + '\'' +
                ", aTime='" + aTime + '\'' +
                ", place='" + place + '\'' +
                ", location='" + location + '\'' +
                ", stuSource='" + stuSource + '\'' +
                ", placeofbirth='" + placeofbirth + '\'' +
                ", blood='" + blood + '\'' +
                ", HMT='" + HMT + '\'' +
                ", nationality='" + nationality + '\'' +
                ", stuType='" + stuType + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
