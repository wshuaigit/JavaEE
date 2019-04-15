package com.xupt.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface LoginDao {

    @Select("SELECT pwd FROM t_login WHERE stuNum = #{0}")
    String loginByStuNum(String stuNum);

    @Insert("INSERT INTO t_login VALUES (#{0},#{1})")
    int registerMember(String stuNum, String pwdMD5);
}
