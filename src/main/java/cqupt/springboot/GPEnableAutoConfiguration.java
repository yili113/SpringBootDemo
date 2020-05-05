package cqupt.springboot;

import org.springframework.boot.autoconfigure.AutoConfigurationPackage;

import java.lang.annotation.*;

/**
 * @author Liyi
 * @create 2020-04-24 11:00
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@AutoConfigurationPackage
public @interface GPEnableAutoConfiguration {
}
