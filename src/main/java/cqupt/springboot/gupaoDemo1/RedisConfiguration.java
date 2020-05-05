package cqupt.springboot.gupaoDemo1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Liyi
 * @create 2020-04-24 10:58
 * 配置类里面是装配bean的
 */
@Configuration
public class RedisConfiguration {
    @Bean
    public RedisTemplateService redisTemplateService() {
        return new RedisTemplateService();
    }
}
