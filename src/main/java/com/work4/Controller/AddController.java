package com.work4.Controller;

import com.work4.Item.Person;
import com.work4.Item.Table;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AddController {
    @PostMapping("/add")
    public String add(Person person, Model model, HttpServletRequest request) {
        Object flag = request.getSession().getAttribute("login");
        if (null != flag){
            flag = model.getAttribute("person");
            if (null == flag){
                model.addAttribute("person", person);
            }
            return "add";
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("/checkadd")
    public String checkAdd(Person person, Model model, HttpServletRequest request){
        Object flag = request.getSession().getAttribute("login");
        if (null != flag){
            HttpSession session = request.getSession();
            Table table = (Table)session.getAttribute("table");
            table.addPerson(person);
            session.setAttribute("table", table);
            model.addAttribute("person", person);
            return "redirect:/list";
        } else{
            return "redirect:/login";
        }
    }
}
