package cqupt.springboot.gupaoDemo2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : liyi14
 * @Description
 * @date Date 2022/01/08
 */
public class ConditionMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConditionConfig.class);
        Demo2Service bean = applicationContext.getBean(Demo2Service.class);
        System.out.println(bean);
    }
}
