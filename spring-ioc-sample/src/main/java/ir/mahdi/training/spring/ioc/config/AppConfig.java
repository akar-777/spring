package ir.mahdi.training.spring.ioc.config;

import ir.mahdi.training.spring.ioc.HelloWorld;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public HelloWorld helloWorld() {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setMsg("Hello World! :))");
        return helloWorld;
    }
}
