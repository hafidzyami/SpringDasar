package hafidz.demo;

import hafidz.demo.data.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Slf4j
@Configuration
public class BeanConfiguration {
    @Bean // ini singleton
    public Foo foo(){
        Foo foo = new Foo();
        log.info("Create new foo");
        return foo;
    }

}
