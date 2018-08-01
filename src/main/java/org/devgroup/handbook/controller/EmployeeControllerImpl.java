package org.devgroup.handbook.controller;

import org.devgroup.handbook.dto.Request.ChangeEmployee;
import org.devgroup.handbook.dto.Request.CreateEmployee;
import org.devgroup.handbook.dto.Request.TransferEmployee;
import org.devgroup.handbook.dto.Response.Response;
import org.devgroup.handbook.exception.MyException;
import org.devgroup.handbook.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
public class EmployeeControllerImpl implements EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


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
    public Response removeEmployee(@RequestParam(value = "id") @Positive long id) {
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

    @ExceptionHandler(NumberFormatException.class)
    public Response handleNumberFormatExc(){
        return Response.builder()
                .message("Incorrect type of input")
                .build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public Response handleIllegalArgExc(Exception e){

        return Response.builder()
                .message("Incorrect type of input; ")
                .build();
    }


}
