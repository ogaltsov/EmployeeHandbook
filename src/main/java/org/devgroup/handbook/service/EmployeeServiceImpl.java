package org.devgroup.handbook.service;

import org.devgroup.handbook.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.devgroup.handbook.dto.Request.ChangeEmployeeRequest;
import org.devgroup.handbook.dto.Request.CreateEmployeeRequest;
import org.devgroup.handbook.dto.Request.TransferEmployeeRequest;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao){
        this.employeeDao = employeeDao;
    }

    public String createEmployee(CreateEmployeeRequest createEmployeeRequest){
        return "null";  //todo: return answer from org.devgroup.handbook.dao
    }

    public String transferEmployee(TransferEmployeeRequest transferEmployeeRequest){
        return "null";  //todo: return answer from org.devgroup.handbook.dao
    }

    public String changeEmployee(ChangeEmployeeRequest changeEmployeeRequest){
        return "null";  //todo: return answer from org.devgroup.handbook.dao
    }

    public String removeEmployee(long id){
        return "null";  //todo: return answer from org.devgroup.handbook.dao
    }

    @Override
    public String getListEmployeeOfDepartment(long id) {
        return null;
    }
}
