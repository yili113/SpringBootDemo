package cqupt.springboot;

import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.context.annotation.Import;

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
@Import(GPAutoImportSelector.class)
public @interface GPEnableAutoConfiguration {
}
