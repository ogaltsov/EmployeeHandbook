package org.devgroup.handbook.controller;

import org.devgroup.handbook.dto.Request.CreateDepartment;
import org.devgroup.handbook.dto.Request.Reassignment;
import org.devgroup.handbook.dto.Response.Response;

public interface DepartmentController {

    Response closeDepartment(long id);

    Response searchListBranches(long id);

    Response createDepartment(CreateDepartment createDepartmentRequest);

    Response reassignmentDepartment(Reassignment reassignmentRequest);

}
