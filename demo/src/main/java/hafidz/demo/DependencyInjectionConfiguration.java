package hafidz.demo;

import hafidz.demo.data.Bar;
import hafidz.demo.data.Foo;
import hafidz.demo.data.FooBar;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DependencyInjectionConfiguration {

    @Primary
    @Bean
    public Foo fooFirst(){
        return new Foo();
    }

    @Bean
    public Foo fooSecond(){
        return new Foo();
    }

    @Bean
    public Bar bar(){
        return new Bar();
    }


    // @Qualifier annotation in Spring is used to differentiate
    // a bean among the same type of bean objects.

    // depedency injection di spring itu langsung digituin sama springnya
    @Bean
    public FooBar fooBar(@Qualifier("fooSecond") Foo foo, Bar bar){
        return new FooBar(foo, bar);
    }
}
