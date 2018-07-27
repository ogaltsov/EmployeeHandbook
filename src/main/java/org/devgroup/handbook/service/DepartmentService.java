package org.devgroup.handbook.service;

import org.devgroup.handbook.dto.Request.CreateDepartmentRequest;
import org.devgroup.handbook.dto.Request.ReassignmentRequest;
import org.devgroup.handbook.dto.Response.Response;

public interface DepartmentService {

    String closeDepartment(long id);

    String searchListBranches(long id);

    String createDepartment(CreateDepartmentRequest createDepartmentRequest);

    String reassignmentDepartment(ReassignmentRequest reassignmentRequest);

    //todo: merge other methods from "DBaranov"
}
