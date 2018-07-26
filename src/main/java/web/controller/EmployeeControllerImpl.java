package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.EmployeeService;
import web.dto.ChangeEmployeeRequest;
import web.dto.CreateEmployeeRequest;
import web.dto.Response;
import web.dto.TransferEmployeeRequest;

@RestController
public class EmployeeControllerImpl implements EmployeeController{

    private EmployeeService employeeService;

    @Autowired
    public EmployeeControllerImpl(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public Response createEmployee(@RequestBody CreateEmployeeRequest createEmployeeRequest){
        String answer = employeeService.createEmployee(createEmployeeRequest);
        return new Response(answer);
    }

    @RequestMapping(value = "/transferEmployee", method = RequestMethod.PUT)
    public Response transferEmployee(@RequestBody TransferEmployeeRequest transferEmployeeRequest) {
        String answer = employeeService.transferEmployee(transferEmployeeRequest);
        return new Response(answer);
    }

    @RequestMapping(value = "/changeEmployee", method = RequestMethod.PUT)
    public Response changeEmployee(@RequestBody ChangeEmployeeRequest changeEmployeeRequest){
        if(changeEmployeeRequest.isCorrect()){
            String answer = employeeService.changeEmployee(changeEmployeeRequest);
            return new Response(answer);
        }
        return new Response("incorrect response"); 
    }

    @RequestMapping(value = "/removeEmployee", method = RequestMethod.DELETE)
    public Response removeEmployee(@RequestParam(value = "id") long id){
        String answer = employeeService.removeEmployee(id);
        return new Response(answer);
    }
}
