package hafidz.demo;

import hafidz.demo.data.MultiFoo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {
        "hafidz.demo.service",
        "hafidz.demo.repository",
        "hafidz.demo.configuration"
})
@Import(MultiFoo.class)
public class ComponentConfiguration {
}
