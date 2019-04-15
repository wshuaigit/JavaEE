package com.xupt.serviceImpl;

import com.xupt.beans.EssInfor;
import com.xupt.beans.OtherInfor;
import com.xupt.dao.SelectDao;
import com.xupt.service.SelectService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelectServiceImpl implements SelectService {

    @Autowired
    private SelectDao selectDao;

    public EssInfor selEssInforByStuNum(String stuNum) {
        return selectDao.selectEssinforByStuNum(stuNum);
    }

    @Override
    public OtherInfor selOtherInforByStuNum(String stuNum) {
        return selectDao.selectOtherInforByStuNum(stuNum);
    }


}
