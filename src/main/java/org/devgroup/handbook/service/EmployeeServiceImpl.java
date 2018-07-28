package org.devgroup.handbook.service;

import org.devgroup.handbook.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.devgroup.handbook.dto.Request.ChangeEmployee;
import org.devgroup.handbook.dto.Request.CreateEmployee;
import org.devgroup.handbook.dto.Request.TransferEmployee;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public String createEmployee(CreateEmployee createEmployeeRequest) {
        return "null";  //todo: return answer from dao
    }

    public String transferEmployee(TransferEmployee transferEmployeeRequest) {
        return "null";  //todo: return answer from dao
    }

    public String changeEmployee(ChangeEmployee changeEmployeeRequest) {
        return "null";  //todo: return answer from dao
    }

    public String removeEmployee(long id) {
        return "null";  //todo: return answer from dao
    }

    @Override
    public String getListEmployeeOfDepartment(long id) {
        return null;
    }
}
