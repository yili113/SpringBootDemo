package cqupt.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Liyi
 * @create 2020-04-05 10:00
 */
@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }


//    // 利用SpringMVC替代下面的方法
//    @RequestMapping({"/", "/index.html"})
//    public String index() {
//        return "index";
//    }
}
