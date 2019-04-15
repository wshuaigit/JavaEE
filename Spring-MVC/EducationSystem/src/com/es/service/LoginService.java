package com.es.service;

/**
 * ClassName:LoginService
 * Package:com.es.service
 * Description:
 *
 * @Date:2019/3/27 0:14
 * @Author:wangzhao
 */
public interface LoginService {
    String loginService(String stuNum);

    int registerService(String stuNum,String pwd);
}
