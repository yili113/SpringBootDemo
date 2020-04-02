package cqupt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Liyi
 * @create 2020-04-02 19:04
 */
@Controller
public class HelloController {
    @ResponseBody// 返回响应实体
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
