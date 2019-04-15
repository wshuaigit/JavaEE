package com.es.controllers;

import com.es.exceptions.SpeedException;
import com.es.service.LoginService;
import com.es.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * ClassName:MyController
 * Package:com.es.controllers
 * Description:
 *
 * @Date:2019/3/27 0:17
 * @Author:wangzhao
 */
@Controller
public class MyController {

    private static Map<String,String> map = new Hashtable<>();

    /**
     *  阻止多人登录
     */
    public static void isExist(String stuNum, HttpSession session){
        //说明已经登录过，更新信息
        if(map.containsKey(stuNum)){
            Set<Map.Entry<String, String>> entries = map.entrySet();
            for(Map.Entry<String, String> entry: entries){
                //将从前value的sessionID替换

                if (stuNum.equals(entry.getKey())) {
                    map.put(stuNum, session.getId());
                    return;
                }

            }
        }
        //如果没有进行过登录的话
        map.put(stuNum,session.getId());
    }

    /**
     *  当有用户进行退出时，删除该用户的信息
     */
    public static void destory(String stuNum){
        if(map.containsKey(stuNum)) {
            map.remove(stuNum);
        }
    }

    /**
     *  如果在容器中没有发现该用户的SessionID，让该用户强制下线
     */
    public static boolean offLine(HttpSession session){
        if(map.containsValue(session.getId()))
            return true;
        return false;
    }



    @Autowired
    private LoginService service;


    @RequestMapping(value = "login")
    public void login(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
        String stuNum = (String) session.getAttribute("stuNum");
        System.out.println(stuNum);
        //没有该用户的SessionID
        if (!offLine(session)) {
            //由于第一次登录，session中并没有保存stuNum，所以为null
            if (stuNum != null) {
                //每个客户端可以10秒发送一个请求，判断是否多人登录一个账号，强制下线
                response.getWriter().write("{'flag':1;'msg':'你的账号已在别处登录'}");
                return ;
            }
        }

        stuNum = request.getParameter("stuNum");

        String pwd = request.getParameter("pwd");

        String password = service.loginService(stuNum);
        if(password==null){
            response.getWriter().write("{'flag':1;'msg':'抱歉，不存在该用户'}");
        }else{
            try {
                String pwdMd5 = MD5Util.getMD5(pwd);
                if(!password.equals(pwdMd5)){
                    response.getWriter().write("{'flag':2;'msg':'抱歉，用户名或密码错误'}");
                }else{
                    session = request.getSession();
                    //将登录信息保存到Session中
                    session.setAttribute("stuNum",stuNum);
                    //将已登录的用户保存到容器中
                    isExist(stuNum, session);
                    response.getWriter().write("{'flag':3;'msg':'登录成功'}");
                }
            } catch (SpeedException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping(value = "register")
    public void register(HttpServletRequest request,HttpServletResponse response) throws IOException, SpeedException {
        String stuNum = request.getParameter("stuNum");
        String pwd = request.getParameter("pwd");
        String password = service.loginService(stuNum);
        if(password != null){
            response.getWriter().write("{'flag':1;'msg':'抱歉，该用户已注册'}");
        }else {
            String pwdMD5 = MD5Util.getMD5(password);
            int result = service.registerService(stuNum, pwdMD5);
            if(result > 0){
                response.getWriter().write("{'flag':3;'msg':'注册成功'}");
            }else{
                response.getWriter().write("{'flag':2;'msg':'注册失败'}");
            }
        }
    }


    @RequestMapping(value = "destory")
    public void destory(HttpSession session){
        destory((String)session.getAttribute("stuNum"));
    }
}
