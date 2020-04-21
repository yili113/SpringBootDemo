package cqupt.springboot.config;

import cqupt.springboot.component.LoginHandlerInterceptor;
import cqupt.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Liyi
 * @create 2020-04-05 15:50
 */
// 使用WebMvcConfigurerAdapter可以扩展springMVC工程
@Configuration
//@EnableWebMvc // 全面接管springmvc
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        super.addViewControllers(registry);
        registry.addViewController("/helloaaa").setViewName("success");
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
                registry.addViewController("/main.html").setViewName("dashboard");
            }
            // 注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
//                super.addInterceptors(registry);
                // 静态资源；  *.css , *.js
                // SpringBoot已经做好了静态资源映射
                // 拦截所有的页面 但是要排除登录请求和index页面

                // 暂时关掉登录拦截器
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                        .excludePathPatterns("/index.html","/","/user/login");
            }
        };
        return adapter;
    }

    /**
     * 1.创建一个springMVC的配置类
     * 2.在配置类里面创建各个方法，每个方法对应创建一个自己的组件
     * 3.通过@Bean将自己的组件添加到容器中
     * @return
     */
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }

}
