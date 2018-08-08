package org.devgroup.handbook.controller;

import org.devgroup.handbook.dto.Request.CreateDepartment;
import org.devgroup.handbook.dto.Request.EntityIdRequestWrapper;
import org.devgroup.handbook.dto.Request.Reassignment;
import org.devgroup.handbook.dto.Response.Response;

public interface DepartmentController {

    Response closeDepartment(EntityIdRequestWrapper entityIdRequestWrapper);

    Response searchListBranches(EntityIdRequestWrapper entityIdRequestWrapper);

    Response createDepartment(CreateDepartment createDepartmentRequest);

    Response reassignmentDepartment(Reassignment reassignmentRequest);

    Response getListEmployeeOfDepartment(EntityIdRequestWrapper entityIdRequestWrapper);

}
