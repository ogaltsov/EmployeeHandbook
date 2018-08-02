package org.devgroup.handbook.controller;

import org.devgroup.handbook.dto.Request.CreateDepartment;
import org.devgroup.handbook.dto.Request.EntityIdRequestWrapper;
import org.devgroup.handbook.dto.Request.Reassignment;
import org.devgroup.handbook.dto.Response.Response;
import org.devgroup.handbook.entity.EmployeeEntity;
import org.devgroup.handbook.exception.MyException;
import org.devgroup.handbook.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentControllerImpl implements DepartmentController {

    private DepartmentService departmentService;


    @RequestMapping(value = "/closeDepartment", method = RequestMethod.DELETE)
    public Response closeDepartment(@Valid @RequestBody EntityIdRequestWrapper id) {  //if have no param -> exception
        try {
            String answer = departmentService.closeDepartment(id.getId());
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
    public Response searchListBranches(@Valid @RequestBody EntityIdRequestWrapper id) {
        try {
            String answer = departmentService.searchListBranches(id.getId());
            return Response.builder()
                    .message(answer)
                    .build();
        } catch (MyException e) {
            return Response.builder()
                    .message(e.getResponse().getErrorCode() + e.getResponse().getErrorMessage())
                    .build();
        }
    }

    @Override  //todo: ?????
    public Response createDepartment(@RequestBody CreateDepartment createDepartmentRequest) {
        return null;
    }

    @RequestMapping(value = "/reassignmentDepartment", method = RequestMethod.PUT)
    public Response reassignmentDepartment(@RequestBody Reassignment reassignmentRequest) {
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

    @RequestMapping(value = "/getListEmployeeOfDepartment", method = RequestMethod.GET)
    public Response getListEmployeeOfDepartment(@Valid @RequestBody EntityIdRequestWrapper id) {
        try {
            List<EmployeeEntity> listEmployeeOfDepartment = departmentService.getListEmployeeOfDepartment(id.getId());
            return Response.<EmployeeEntity>builder()
                    .list(listEmployeeOfDepartment)
                    .build();
        } catch (MyException e) {
            return Response.<EmployeeEntity>builder()
                    .message(e.getResponse().getErrorCode() + e.getResponse().getErrorMessage())
                    .build();
        }
    }

    @Autowired
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
}
