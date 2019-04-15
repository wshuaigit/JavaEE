package com.xupt.service;

import com.xupt.beans.EssInfor;
import com.xupt.beans.OtherInfor;

public interface SelectService {

    EssInfor selEssInforByStuNum(String stuNum);

    OtherInfor selOtherInforByStuNum(String stuNum);
}
