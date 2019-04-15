package com.xupt.controllers;

import com.xupt.exceptions.SpeedException;
import com.xupt.service.LoginService;
import com.xupt.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *  该控制器负责登录，注册，和删除
 */
@Controller
public class LogAndRegController {

    @Autowired
    private LoginService service;

    //用户进行登录
    @RequestMapping(value = "login")
    public void login(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException, SpeedException {
        response.setContentType("text/html;charset=utf-8");
        String stuNum = request.getParameter("stuNum");
        String pwd = request.getParameter("pwd");
        if("".equals(pwd) || "".equals(stuNum)){
            response.getWriter().write("{'flag':0;'msg':'抱歉，请进行输入'}");
            return;
        }
        //从数据库中获取密码
        String password = service.loginService(stuNum);
        if(password == null){
            response.getWriter().write("{'flag':1;'msg':'抱歉，请先进行注册'}");
            return;
        }else{
            //将用户输入密码和查询到的进行md5加密，与数据库密码比对
            String pwdMd5 = MD5Util.getMD5(pwd);
            if(!password.equals(pwdMd5)){
                response.getWriter().write("{'flag':2;'msg':'抱歉，用户名或密码错误'}");
                return;
            }else {
                //将登录信息保存到Session中
                session.setAttribute("stuNum", stuNum);
                response.getWriter().write("{'flag':3;'msg':'登录成功'}");
            }
        }
    }

    //用户进行退出
    @RequestMapping("exit")
    public void exit(HttpSession session){
        if(session != null){
            //清楚当前session的所有信息
            session.invalidate();
        }
    }

    //进行注册
    @RequestMapping(value = "reg")
    public void register(HttpServletRequest request, HttpServletResponse response) throws IOException, SpeedException {
        response.setContentType("text/html;charset=utf-8");
        String stuNum = request.getParameter("stuNum");
        String pwd = request.getParameter("pwd");
        if("".equals(pwd) || "".equals(stuNum)){
            response.getWriter().write("{'flag':0;'msg':'抱歉，请进行输入'}");
            return;
        }
        String password = service.loginService(stuNum);
        if(password != null){
            response.getWriter().write("{'flag':1;'msg':'抱歉，该用户已注册'}");
        }else {
            String pwdMD5 = MD5Util.getMD5(pwd);
            int result = service.registerService(stuNum, pwdMD5);
            if(result == 0){
                response.getWriter().write("{'flag':2;'msg':'注册失败'}");
            }else{
                response.getWriter().write("{'flag':3;'msg':'注册成功'}");
            }
        }
    }
}
