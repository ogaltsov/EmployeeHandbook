package service;

import dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import web.dto.ChangeEmployeeRequest;
import web.dto.CreateEmployeeRequest;
import web.dto.TransferEmployeeRequest;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao){
        this.employeeDao = employeeDao;
    }

    public String createEmployee(CreateEmployeeRequest createEmployeeRequest){
        return "null";  //todo: return answer from dao
    }

    public String transferEmployee(TransferEmployeeRequest transferEmployeeRequest){
        return "null";  //todo: return answer from dao
    }

    public String changeEmployee(ChangeEmployeeRequest changeEmployeeRequest){
        return "null";  //todo: return answer from dao
    }

    public String removeEmployee(long id){
        return "null";  //todo: return answer from dao
    }
}
