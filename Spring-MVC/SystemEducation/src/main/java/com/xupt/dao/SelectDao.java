package com.xupt.dao;

import com.xupt.beans.EssInfor;
import com.xupt.beans.OtherInfor;
import org.apache.ibatis.annotations.Select;

public interface SelectDao {

    /**
     * 根据学号进行基本信息查询
     * @param stuNum
     * @return
     */
    @Select("SELECT * FROM t_essinfor WHERE stuNum = #{0}")
    EssInfor selectEssinforByStuNum(String stuNum);

    /**
     * 根据学号进行进其他信息查询
     * @param stuNum
     * @return
     */
    @Select("SELECT * FROM t_otherinfor WHERE stuNum = #{0}")
    OtherInfor selectOtherInforByStuNum(String stuNum);
}
