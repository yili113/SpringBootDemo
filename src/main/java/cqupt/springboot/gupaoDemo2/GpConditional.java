package cqupt.springboot.gupaoDemo2;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author : liyi14
 * @Description
 * @date Date 2022/01/08
 */
public class GpConditional implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        // 根据返回值判断bean是否被装载
        String osName = conditionContext.getEnvironment().getProperty("os.name");
        if (osName.contains("Mac")) {
            return true;
        }
        return false;
    }
}
