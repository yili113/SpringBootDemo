package cqupt.springboot;

import cqupt.springboot.gupaoDemo1.RedisConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author Liyi
 * @create 2020-04-24 11:08
 */

/** ImportSelector这个接口能实现批量的导入
 * 需要一个组件写一个配置类，再用自动装配类装配就太麻烦了
 */
public class GPAutoImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{RedisConfiguration.class.getName()};
    }
}
