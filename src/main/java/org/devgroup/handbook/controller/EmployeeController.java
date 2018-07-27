package org.devgroup.handbook.controller;

import org.devgroup.handbook.dto.Request.ChangeEmployee;
import org.devgroup.handbook.dto.Request.CreateEmployee;
import org.devgroup.handbook.dto.Response.Response;
import org.devgroup.handbook.dto.Request.TransferEmployee;

public interface EmployeeController {

    Response createEmployee(CreateEmployee createEmployeeRequest);

    Response transferEmployee(TransferEmployee transferEmployeeRequest);

    Response changeEmployee(ChangeEmployee changeEmployeeRequest);

    Response removeEmployee(long id);

    Response getListEmployeeOfDepartment(long id);

}
