package cqupt.springboot.gupaoDemo;

import cqupt.springboot.Application;
import cqupt.springboot.GPEnableAutoConfiguration;
import cqupt.springboot.gupaoDemo1.RedisTemplateService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Liyi
 * @create 2020-04-24 11:05
 */
@GPEnableAutoConfiguration// 自定义自动装配注解
@SpringBootApplication
public class DemoApplication {
    // 模拟自动装配
    public static void main(String[] args) {

        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(Application.class, args);
        // 拿到自定义的自动装配得到的bean对象
        System.out.println(configurableApplicationContext.getBean(RedisTemplateService.class));
    }
}
