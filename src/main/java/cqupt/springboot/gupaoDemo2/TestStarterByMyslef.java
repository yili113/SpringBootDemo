package cqupt.springboot.gupaoDemo2;

import liyi.LyTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : liyi14
 * @Description
 * @date Date 2022/01/08
 */

public class TestStarterByMyslef {
    @Autowired
    private LyTemplate lyTemplate;

    public void test() {
        // 直接可以用导入组件的 方法
        lyTemplate.sayHello();
    }
}
