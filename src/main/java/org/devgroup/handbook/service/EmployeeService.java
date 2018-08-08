package org.devgroup.handbook.service;

import org.devgroup.handbook.dto.Request.ChangeEmployee;
import org.devgroup.handbook.dto.Request.CreateEmployee;
import org.devgroup.handbook.dto.Request.TransferEmployee;

public interface EmployeeService {

    String createEmployee(CreateEmployee createEmployeeRequest);

    String transferEmployee(TransferEmployee transferEmployeeRequest);

    String changeEmployee(ChangeEmployee changeEmployeeRequest);

    String removeEmployee(long id);


}
