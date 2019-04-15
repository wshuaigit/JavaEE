package com.xupt.service;

public interface LoginService {
    String loginService(String stuNum);

    int registerService(String stuNum, String pwdMD5);
}
