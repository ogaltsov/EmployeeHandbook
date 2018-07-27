package org.devgroup.handbook.controller;

import org.devgroup.handbook.dto.Request.CreateDepartmentRequest;
import org.devgroup.handbook.dto.Request.ReassignmentRequest;
import org.devgroup.handbook.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.devgroup.handbook.service.DepartmentService;
import org.devgroup.handbook.dto.Response.Response;

@RestController
public class DepartmentControllerImpl implements DepartmentController{

    private DepartmentService departmentService;

    @Autowired
    public DepartmentControllerImpl(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @RequestMapping(value = "/closeDepartment", method = RequestMethod.DELETE)
    public Response closeDepartment(@RequestParam(value = "id") long id) {  //if have no param -> exception
        try {
            String answer = departmentService.closeDepartment(id);
            return Response.builder()
                    .message(answer)
                    .build();
        } catch (MyException e) {
            return Response.builder()
                    .message(e.getResponse().getErrorCode() + e.getResponse().getErrorMessage())
                    .build();
        }

    }

    @RequestMapping(value = "/searchListBranches", method = RequestMethod.GET)
    public Response searchListBranches(@RequestParam(value = "id") long id) {
        try {
            String answer = departmentService.searchListBranches(id);
            return Response.builder()
                    .message(answer)
                    .build();
        } catch (MyException e) {
            return Response.builder()
                    .message(e.getResponse().getErrorCode() + e.getResponse().getErrorMessage())
                    .build();
        }
    }

    @Override
    public Response createDepartment(@RequestBody CreateDepartmentRequest createDepartmentRequest) {
        return null;
    }

    @RequestMapping(value = "/reassignmentDepartment", method = RequestMethod.PUT)
    public Response reassignmentDepartment(@RequestBody ReassignmentRequest reassignmentRequest) {
        try {
            String answer = departmentService.reassignmentDepartment(reassignmentRequest);
            return Response.builder()
                    .message(answer)
                    .build();
        } catch (MyException e) {
            return Response.builder()
                    .message(e.getResponse().getErrorCode() + e.getResponse().getErrorMessage())
                    .build();
        }
    }

    //todo: merge other methods from "DBaranov"

}
