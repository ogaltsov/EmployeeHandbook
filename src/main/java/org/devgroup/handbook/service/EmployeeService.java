package org.devgroup.handbook.service;

import org.devgroup.handbook.dto.ChangeEmployeeRequest;
import org.devgroup.handbook.dto.CreateEmployeeRequest;
import org.devgroup.handbook.dto.TransferEmployeeRequest;

public interface EmployeeService {

    String createEmployee(CreateEmployeeRequest createEmployeeRequest);

    String transferEmployee(TransferEmployeeRequest transferEmployeeRequest);

    String changeEmployee(ChangeEmployeeRequest changeEmployeeRequest);

    String removeEmployee(long id);
}
