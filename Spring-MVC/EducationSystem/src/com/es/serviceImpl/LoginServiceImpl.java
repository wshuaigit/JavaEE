package com.es.serviceImpl;

import com.es.dao.LoginMapper;
import com.es.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName:LoginServiceImpl
 * Package:com.es.serviceImpl
 * Description:
 *
 * @Date:2019/3/27 0:15
 * @Author:wangzhao
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper mapper;

    @Override
    public String loginService(String stuNum) {
        return mapper.loginDao(stuNum);
    }

    @Override
    public int registerService(String stuNum, String pwd) {
        return mapper.registerDao(stuNum, pwd);
    }
}
