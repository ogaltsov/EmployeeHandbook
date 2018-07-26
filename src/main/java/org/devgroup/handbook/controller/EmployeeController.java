package org.devgroup.handbook.controller;

import org.devgroup.handbook.dto.ChangeEmployeeRequest;
import org.devgroup.handbook.dto.CreateEmployeeRequest;
import org.devgroup.handbook.dto.Response;
import org.devgroup.handbook.dto.TransferEmployeeRequest;

public interface EmployeeController {
    Response createEmployee(CreateEmployeeRequest createEmployeeRequest);
    Response transferEmployee(TransferEmployeeRequest transferEmployeeRequest);
    Response changeEmployee(ChangeEmployeeRequest changeEmployeeRequest);
    Response removeEmployee(long id);
}
