package cqupt.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Liyi
 * @create 2020-04-05 15:50
 */
// 使用WebMvcConfigurerAdapter可以扩展springMVC工程
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        super.addViewControllers(registry);
        registry.addViewController("/hello").setViewName("success");
        // 浏览器发送hello请求，springmvc给转到success页面
    }

    // 所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean// 将组件注册到容器
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
//                super.addViewControllers(registry);
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
//                registry.addViewController("/").setViewName("login");
            }
        };
        return adapter;
    }
}
