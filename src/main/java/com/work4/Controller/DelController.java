package com.work4.Controller;

import com.work4.Item.Table;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class DelController {
    @GetMapping("/del")
    public String del(HttpServletRequest request, @ModelAttribute(value="row")Integer index) {
        Object flag = request.getSession().getAttribute("login");
        if (null != flag){
            HttpSession session = request.getSession();
            if (null == session.getAttribute("table")) {
                Table table = new Table();
                session.setAttribute("table", table);
            }
            Table table = (Table)session.getAttribute("table");
            // 只有一个删掉会报错
            if (table.getSize() > 1) {
                table.getTable().remove(index-1);
                session.setAttribute("table", table);
            }
            return "redirect:/list";
        } else {
            return "login";
        }
    }
}
