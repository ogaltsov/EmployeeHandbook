package org.devgroup.handbook.service;

import org.devgroup.handbook.dto.Request.CreateDepartment;
import org.devgroup.handbook.dto.Request.Reassignment;
import org.devgroup.handbook.entity.EmployeeEntity;

import java.util.List;


public interface DepartmentService {

    String closeDepartment(long id);

    String searchListBranches(long id);

    String createDepartment(CreateDepartment createDepartmentRequest);

    String reassignmentDepartment(Reassignment reassignmentRequest);

    List<EmployeeEntity> getListEmployeeOfDepartment(long id);

    //todo: merge other methods from "DBaranov"
}
