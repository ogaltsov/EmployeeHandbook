package org.devgroup.handbook.controller;

import org.devgroup.handbook.dto.Request.ChangeEmployeeRequest;
import org.devgroup.handbook.dto.Request.CreateEmployeeRequest;
import org.devgroup.handbook.dto.Response.Response;
import org.devgroup.handbook.dto.Request.TransferEmployeeRequest;

public interface EmployeeController {

    Response createEmployee(CreateEmployeeRequest createEmployeeRequest);

    Response transferEmployee(TransferEmployeeRequest transferEmployeeRequest);

    Response changeEmployee(ChangeEmployeeRequest changeEmployeeRequest);

    Response removeEmployee(long id);

    Response getListEmployeeOfDepartment(long id);

}
