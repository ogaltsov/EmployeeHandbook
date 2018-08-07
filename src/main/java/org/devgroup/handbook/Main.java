package org.devgroup.handbook;

import org.devgroup.handbook.service.EmployeeServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@EnableJpaRepositories
@SpringBootApplication
@PropertySource({"classpath:application.yml"}) //delete?


        //todo: abstract class for all Respons'es
        //todo: Response segregation
        //todo: id in Response for createMethods
        //todo: 




public class Main {

    @Bean
    public EmployeeServiceImpl getEmployeeService(){
        return new EmployeeServiceImpl();
    }  //todo: delete?

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        return new LocalValidatorFactoryBean();
    }  //todo: delete?

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }  //todo: delete?


    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }
}
