package org.devgroup.handbook;

import org.devgroup.handbook.service.EmployeeServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
@PropertySource({"classpath:application.yml"})
public class Main {

    @Bean
    public EmployeeServiceImpl getEmployeeService(){
        return new EmployeeServiceImpl();
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
//        EmployeeControllerImpl employeeController = new EmployeeControllerImpl();
//
//        CreateEmployee createEmployee = CreateEmployee.builder()
//                .name("Name1")
//                .surname("Sur1")
//                .genderName("M")
//                .birthDate(new Date())
//                .idDepartment(1L)
//                .idPosition(1L)
//                .salary(new BigDecimal(3456.45))
//                .grade(5L)
//                .build();
//        employeeController.createEmployee(createEmployee);
    }
}
