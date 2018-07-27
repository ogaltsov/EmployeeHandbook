package org.devgroup.handbook.controller;

import org.devgroup.handbook.dto.Request.CreateDepartmentRequest;
import org.devgroup.handbook.dto.Request.ReassignmentRequest;
import org.devgroup.handbook.dto.Response.Response;

public interface DepartmentController {

    Response closeDepartment(long id);

    Response searchListBranches(long id);

    Response createDepartment(CreateDepartmentRequest createDepartmentRequest);

    Response reassignmentDepartment(ReassignmentRequest reassignmentRequest);

}
