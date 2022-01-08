package cqupt.springboot.gupaoDemo2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author : liyi14
 * @Description
 * @date Date 2022/01/08
 */
@Configuration
public class ConditionConfig {
    @Bean
    @Conditional(GpConditional.class)
    public Demo2Service demo2Service() {
        return new Demo2Service();
    }
}
