package com.xupt.serviceImpl;

import com.xupt.dao.LoginDao;
import com.xupt.service.LoginService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    @Override
    public String loginService(String stuNum) {
        return loginDao.loginByStuNum(stuNum);
    }

    @Override
    public int registerService(String stuNum, String pwdMD5) {
        return loginDao.registerMember(stuNum,pwdMD5);
    }

    @Test
    public void test(){
        System.out.println(loginDao);
    }
}
