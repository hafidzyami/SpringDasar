package hafidz.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "hafidz.demo.materiImport"
})
public class ScanConfiguration {

}
