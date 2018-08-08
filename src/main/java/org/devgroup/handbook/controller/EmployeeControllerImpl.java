package org.devgroup.handbook.controller;

import com.fasterxml.jackson.core.JsonParseException;
import org.devgroup.handbook.dto.Request.ChangeEmployee;
import org.devgroup.handbook.dto.Request.CreateEmployee;
import org.devgroup.handbook.dto.Request.EntityIdRequestWrapper;
import org.devgroup.handbook.dto.Request.TransferEmployee;
import org.devgroup.handbook.dto.Response.Response;
import org.devgroup.handbook.exception.EmployeeHandbookException;
import org.devgroup.handbook.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.ValidationException;
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
            String answer = employeeService.createEmployee(createEmployeeRequest);
            return Response.builder()
                    .message(answer)
                    .build();
        } catch (EmployeeHandbookException e) {
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
        } catch (EmployeeHandbookException e) {
            return Response.builder()
                    .message(e.getResponse().getErrorCode() + e.getResponse().getErrorMessage())
                    .build();
        }

    }

    @RequestMapping(value = "/changeEmployee", method = RequestMethod.PUT)  //method work correct
    public Response changeEmployee(@Valid @RequestBody ChangeEmployee changeEmployeeRequest) {
        try {
            if (changeEmployeeRequest.isCorrect()) {
                String answer = employeeService.changeEmployee(changeEmployeeRequest);
                return Response.builder()
                        .message(answer)
                        .build();
            }
            return Response.builder()
                    .message("Incorrect response: fields are empty")
                    .build();
        } catch (EmployeeHandbookException e) {
            return Response.builder()
                    .message(e.getResponse().getErrorCode() + e.getResponse().getErrorMessage())
                    .build();
        }
    }

    @RequestMapping(value = "/removeEmployee", method = RequestMethod.DELETE)
    public Response removeEmployee(@Valid @RequestBody @Positive EntityIdRequestWrapper id) {
        try {
            String answer = employeeService.removeEmployee(id.getId());
            return Response.builder()
                    .message(answer)
                    .build();
        } catch (EmployeeHandbookException e) {
            return Response.builder()
                    .message(e.getResponse().getErrorCode() + e.getResponse().getErrorMessage())
                    .build();
        }

    }

    @ExceptionHandler({MethodArgumentNotValidException.class, NumberFormatException.class,
            JsonParseException.class, ValidationException.class})
    public Response handleNumberFormatExc(Exception e){
        e.printStackTrace();
        return Response.builder()
                .message("Incorrect type/format of incoming data")
                .build();
    }
}
