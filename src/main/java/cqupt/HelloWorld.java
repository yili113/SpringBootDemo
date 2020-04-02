package cqupt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Liyi
 * @create 2020-04-02 19:01
 */
@SpringBootApplication// 标识这是个springBoot应用
public class HelloWorld {
    public static void main(String[] args) {
        SpringApplication.run(HelloWorld.class, args);// 启动当前这个springBoot应用
    }
}
