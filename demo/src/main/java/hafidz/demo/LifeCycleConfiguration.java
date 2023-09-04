package hafidz.demo;

import hafidz.demo.data.Connection;
import hafidz.demo.data.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LifeCycleConfiguration {

    // ini pakai implements di folder data
    @Bean
    public Connection connection(){
        return new Connection();
    }

    // ini gausah pakai implements
    // @Bean(initMethod = "start", destroyMethod = "stop") ini kalau gapakai anotation di methodnya
    @Bean
    public Server server(){
        return new Server();
    }
}
