package org.devgroup.handbook.service;

import org.devgroup.handbook.dto.Request.CreateDepartment;
import org.devgroup.handbook.dto.Request.Reassignment;


public interface DepartmentService {

    String closeDepartment(long id);

    String searchListBranches(long id);

    String createDepartment(CreateDepartment createDepartmentRequest);

    String reassignmentDepartment(Reassignment reassignmentRequest);

    //todo: merge other methods from "DBaranov"
}
