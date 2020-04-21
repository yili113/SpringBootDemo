package cqupt.springboot.controller;

import com.fasterxml.jackson.annotation.JsonView;
import cqupt.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Liyi
 * @create 2020-04-05 10:00
 */
@Controller
public class HelloController {
//    @ResponseBody
//    @RequestMapping("/hello")
    @GetMapping("/hello/{user}")
    public String hello(@PathVariable("user") String user) {
        if (user.equals("aaa"))
            throw new UserNotExistException();
        return "hello";
    }

//    @GetMapping("/user/{id:\\d+}")
//    //@RequestMapping(value="/user/{id:\\d+}",method=RequestMethod.GET)
//    @JsonView(User.DetailJsonView.class)
//    public User get(@PathVariable String id) {
//        throw new UserNotExistException(id);
//    }



//    // 利用SpringMVC替代下面的方法
//    @RequestMapping({"/", "/index.html"})
//    public String index() {
//        return "index";
//    }


//    @RequestMapping("/success")
//    public String success() {
//        return "success";
//    }
}
