package com.xupt.controllers;

import com.xupt.beans.EssInfor;
import com.xupt.beans.OtherInfor;
import com.xupt.service.SelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *  该控制器负责信息查询功能
 */
@Controller
@RequestMapping("select")
public class SelectController {

    @Autowired
    private SelectService service;

    @RequestMapping("/essential")
    public void selectEssInfor(HttpServletResponse response, HttpSession session) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        if(session != null){
            String stuNum = (String)session.getAttribute("stuNum");
            EssInfor infor = service.selEssInforByStuNum(stuNum);
            response.getWriter().write(infor.toString());
        }
    }

    @RequestMapping("/other")
    public void selectOtherInfor(HttpServletResponse response, HttpSession session) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        if(session != null){
            String stuNum = (String)session.getAttribute("stuNum");
            OtherInfor infor = service.selOtherInforByStuNum(stuNum);
            response.getWriter().write(infor.toString());
        }
    }
}
