package cqupt.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author Liyi
 * @create 2020-04-20 9:27
 */
@Controller
public class LoginController {
    @PostMapping(value = "/user/login")//处理login请求
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session) {
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            // 登录成功
//            return "dashboard";
            session.setAttribute("loginUser", username);// 将用户名存在session中进行登录拦截
            // 防止表单重复提交，利用重定向
            return "redirect:/main.html";
        }else {
            // 登录失败
            map.put("msg","用户名或密码错误");
            return "login";
        }
    }
}
