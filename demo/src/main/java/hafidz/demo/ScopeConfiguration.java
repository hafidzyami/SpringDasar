package hafidz.demo;


import hafidz.demo.data.Bar;
import hafidz.demo.data.Foo;
import hafidz.demo.scope.DoubletonScope;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@Slf4j
public class ScopeConfiguration {

    //scope prototype itu bukan singleton
    @Bean(name = "foo1")
    @Scope("prototype")
    public Foo foo(){
        log.info("Create new foo");
        return new Foo();
    }
    @Bean(name = "foo2")
    @Scope("prototype")
    public Foo foo2(){
        log.info("Create new foo");
        return new Foo();
    }

    // custom scope
    @Bean
    public CustomScopeConfigurer customScopeConfigurer(){
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        configurer.addScope("doubleton", new DoubletonScope());
        return configurer;
    }

    @Bean
    @Scope("doubleton")
    public Bar bar(){
        log.info("Create new Bar");
        return new Bar();
    }




}
