package service;

import web.dto.ChangeEmployeeRequest;
import web.dto.CreateEmployeeRequest;
import web.dto.TransferEmployeeRequest;

public interface EmployeeService {

    String createEmployee(CreateEmployeeRequest createEmployeeRequest);

    String transferEmployee(TransferEmployeeRequest transferEmployeeRequest);

    String changeEmployee(ChangeEmployeeRequest changeEmployeeRequest);

    String removeEmployee(long id);
}
