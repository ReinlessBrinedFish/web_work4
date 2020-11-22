package com.work4.Controller;

import com.work4.Item.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    // @RequestMapping不包含请求方法无法跳转
    // get直接通过浏览器url访问，post统一为提交表单访问
    // 不改变地址保持数据由服务器转发，改变地址由浏览器重定位
    @GetMapping({"/", "/login"})
    public String login(User user, Model model, HttpServletRequest request){
        Object flag = request.getSession().getAttribute("login");
        // 检查会话中的登录标志，若存在则已经登录，可直接显示列表页面，否则需要表单验证
        if (null == flag){
            flag = model.getAttribute("user");
            if (null == flag){
                model.addAttribute("user", user);
            }
            return "login";
        } else {
            return "redirect:/list";
        }
    }

    // 验证表单
    @PostMapping("/checklogin")
    public String checkLogin(User user, Model model, HttpServletRequest request){
        // 用户名密码正确，设置会话中的登陆标志，并进入联系人表格界面, 否则显示错误
        if (user.getUsername().equals("test1122") && user.getPassword().equals("Nov1140")){
            user.setMessage("您已登录");
            request.getSession().setAttribute("login",1);
            return "redirect:/list";
        }
        else{
            user.setMessage("用户名或密码错误!");
            user.setUsername("");
            user.setPassword("");
            return login(user, model, request);
        }
    }

    // 直接从网址请求checklogin
    @GetMapping("/checklogin")
    public String directCheckLogin(HttpServletRequest request){
        if (null == request.getSession().getAttribute("login")){
            return "redirect:/login";
        } else{
            return "redirect:/list";
        }
    }

    // 登出
    @GetMapping("/exit")
    public String exit(HttpServletRequest request){
        request.getSession().removeAttribute("login");
        return "redirect:/login";
    }
}