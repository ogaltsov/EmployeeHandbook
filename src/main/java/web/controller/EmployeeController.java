package web.controller;

import web.dto.ChangeEmployeeRequest;
import web.dto.CreateEmployeeRequest;
import web.dto.Response;
import web.dto.TransferEmployeeRequest;

public interface EmployeeController {
    Response createEmployee(CreateEmployeeRequest createEmployeeRequest);
    Response transferEmployee(TransferEmployeeRequest transferEmployeeRequest);
    Response changeEmployee(ChangeEmployeeRequest changeEmployeeRequest);
    Response removeEmployee(long id);
}
