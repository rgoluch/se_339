package edu.microserviceslab.usagemicroservice.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


//@EnableWebMvc
@Configuration
@EnableSwagger2
public class UsageWebConfig implements WebMvcConfigurer {
}
