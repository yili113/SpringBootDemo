package cqupt.springboot.controller;

import cqupt.springboot.exception.UserNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Liyi
 * @create 2020-04-21 9:40
 */
@ControllerAdvice
public class MyExceptionHandler {
    // 浏览器和客服端都是返回json
    @ResponseBody// 响应json数据
    //这个注解是指当controller中抛出这个指定的异常类的时候，都会转到这个方法中来处理异常
    @ExceptionHandler(UserNotExistException.class)
    //返回的状态码
    @ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)     //服务内部错误
    public Map<String,Object> handleException(Exception e){
        // 给异常响应自己定义的json数据
        Map<String,Object> map = new HashMap<>();
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        return map;
    }

//    @ExceptionHandler(UserNotExistException.class)// 处理UserNotExistException这个异常
//    public String handleException(Exception e, HttpServletRequest request){
//        // 给异常响应自己定义的json数据
//        Map<String,Object> map = new HashMap<>();
//        //传入我们自己的错误状态码  4xx 5xx，否则就不会进入定制错误页面的解析流程
//        /**
//         * Integer statusCode = (Integer) request
//         .getAttribute("javax.servlet.error.status_code");
//         */
//        request.setAttribute("javax.servlet.error.status_code",500);
//        map.put("code","user.notexist");
//        map.put("message",e.getMessage());
//        return "/forward:/error";
//    }
}
