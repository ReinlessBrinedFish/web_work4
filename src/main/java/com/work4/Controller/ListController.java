package com.work4.Controller;

import com.work4.Item.Table;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ListController {
    // 直接进入联系人列表
    @GetMapping("/list")
    public String showMain(Model model, HttpServletRequest request){
        Object flag = request.getSession().getAttribute("login");
        if (null != flag){
            HttpSession session = request.getSession();
            Table table = (Table) session.getAttribute("table");
            // 列表为空，就先创建
            if (null == table){
                Table t = new Table();
                table = t;
            }
            session.setAttribute("table", table);
            return "list";
        }
        else {
            return "redirect:/login";
        }
    }
}

