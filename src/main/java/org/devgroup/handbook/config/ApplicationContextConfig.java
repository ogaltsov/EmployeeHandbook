package org.devgroup.handbook.config;

import org.devgroup.handbook.dao.DepartmentDao;
import org.devgroup.handbook.dao.EmployeeDao;
import org.devgroup.handbook.dao.PositionDao;
import org.devgroup.handbook.service.EmployeeService;
import org.devgroup.handbook.service.EmployeeServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationContextConfig {

    @Bean
    public EmployeeDao getEmployeeDao(){
        return new EmployeeDao();
    }

    @Bean
    public DepartmentDao getDepartmentDao(){
        return new DepartmentDao();
    }

    @Bean
    public PositionDao getPositionDao(){
        return new PositionDao();
    }

    @Bean
    public EmployeeService getEmployeeService(){
        return new EmployeeServiceImpl();
    }


}
