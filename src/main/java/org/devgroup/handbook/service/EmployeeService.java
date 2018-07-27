package org.devgroup.handbook.service;

import org.devgroup.handbook.dto.Request.ChangeEmployeeRequest;
import org.devgroup.handbook.dto.Request.CreateEmployeeRequest;
import org.devgroup.handbook.dto.Request.TransferEmployeeRequest;

public interface EmployeeService {

    String createEmployee(CreateEmployeeRequest createEmployeeRequest);

    String transferEmployee(TransferEmployeeRequest transferEmployeeRequest);

    String changeEmployee(ChangeEmployeeRequest changeEmployeeRequest);

    String removeEmployee(long id);

    String getListEmployeeOfDepartment(long id);

}
