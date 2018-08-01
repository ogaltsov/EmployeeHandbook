package org.devgroup.handbook.controller;

import org.devgroup.handbook.dto.Request.ChangeEmployee;
import org.devgroup.handbook.dto.Request.CreateEmployee;
import org.devgroup.handbook.dto.Request.TransferEmployee;
import org.devgroup.handbook.dto.Response.Response;
import org.devgroup.handbook.entity.EmployeeEntity;
import org.devgroup.handbook.exception.MyException;
import org.devgroup.handbook.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeControllerImpl implements EmployeeController {

    private EmployeeService employeeService;

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public Response createEmployee(@Valid @RequestBody CreateEmployee createEmployeeRequest) {
        try {
            System.out.println(createEmployeeRequest);/////////
            String answer = employeeService.createEmployee(createEmployeeRequest);
            return Response.builder()
                    .message(answer)
                    .build();
        } catch (MyException e) {
            return Response.builder()
                    .message(e.getResponse().getErrorCode() + e.getResponse().getErrorMessage())
                    .build();
        }

    }

    @RequestMapping(value = "/transferEmployee", method = RequestMethod.PUT)
    public Response transferEmployee(@Valid @RequestBody TransferEmployee transferEmployeeRequest) {
        try {
            String answer = employeeService.transferEmployee(transferEmployeeRequest);
            return Response.builder()
                    .message(answer)
                    .build();
        } catch (MyException e) {
            return Response.builder()
                    .message(e.getResponse().getErrorCode() + e.getResponse().getErrorMessage())
                    .build();
        }

    }

    @RequestMapping(value = "/changeEmployee", method = RequestMethod.PUT)  //method work correct
    public Response changeEmployee(@RequestBody ChangeEmployee changeEmployeeRequest) {
        try {
            if (changeEmployeeRequest.isCorrect()) {
                String answer = employeeService.changeEmployee(changeEmployeeRequest);
                return Response.builder()
                        .message(answer)
                        .build();
            }
            return Response.builder()
                    .message("incorrect response")
                    .build();
        } catch (MyException e) {
            return Response.builder()
                    .message(e.getResponse().getErrorCode() + e.getResponse().getErrorMessage())
                    .build();
        }
    }

    @RequestMapping(value = "/removeEmployee", method = RequestMethod.DELETE)
    public Response removeEmployee(@RequestParam(value = "id") long id) {
        try {
            String answer = employeeService.removeEmployee(id);
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
    public Response getListEmployeeOfDepartment(@RequestParam(value = "id") long id) {
        try {
            List<EmployeeEntity> listEmployeeOfDepartment = employeeService.getListEmployeeOfDepartment(id);
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
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
