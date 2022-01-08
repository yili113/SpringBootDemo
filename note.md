@Conditional 根据返回值true false 决定bean是否装载</br>
这个注解需要实现该接口（Condition）
</br>

## Spring boot自动装配

> springboot 应用中有 @EnableAutoConfiguration注解，这个注解里面有
>@import 注解，这样来看是可以 导入其他的bean到应用中。例如     @Autowired
private RabbitTemplate rabbitTemplate; 这种导入。前提是这个RabbitTemplate已经
> 作为一个bean在ioc容器中了。 通过@import去导入，就说明在jar包中有这样的一个配置：
> @Configuration RabbitConfiguration{@Bean RabbitTemplate rabbitTemplate(){}}
> 那么，Springboot这个应用是如何知道对应组件的@Configuration在哪里呢？只有知道了才能去
> 扫描。
> 通过 spring.factories文件里面定义的路径 这个文件在 自动装配jar 下的META_INF文件夹下

```java
    protected List<String> getCandidateConfigurations(AnnotationMetadata metadata, AnnotationAttributes attributes) {
        List<String> configurations = SpringFactoriesLoader.loadFactoryNames(this.getSpringFactoriesLoaderFactoryClass(), this.getBeanClassLoader());
        Assert.notEmpty(configurations, "No auto configuration classes found in META-INF/spring.factories. If you are using a custom packaging, make sure that file is correct.");
        return configurations;
    }
```



### 如何模拟一个自动装配
- 定义一个 需要注入的 template 例如RedisTemplateService
- 定义一个 Configuration 将这个 template暴露出来  例如RedisConfiguration
- 定义一个 selector 用于获取对应的template 例如GPAutoImportSelector
实现ImportSelector接口，重写selectImports方法
- 定义一个 EnableAutoConfiguration注解，并且对这个注解使用@import 导入上一步的
selector
- 定义一个 Spring boot应用启动主函数，并且添加 EnableAutoConfiguration注解即可
#### 核心
selector 方法



## 自定义 starter
- 自定义一个组件 例如 test-core ,这时候这个 组件项目就会有 maven坐标，且打一个jar包
  - 这个组件包含： 配置类（例如上述的RedisConfiguration）  和   对应的功能实现（例如上述的
    RedisTemplateService）
- 在Spring boot项目的pom文件中导入 test-core的依赖  引入坐标
- 但是此时 还是不能使用这个组件，因为还没有被扫描到，需要在 test-core中
创建文件 spring.factories ，这是因为Spring boot的约定，