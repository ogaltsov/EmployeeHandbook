package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.DepartmentService;
import service.EmployeeService;
import service.EmployeeServiceImpl;
import web.dto.ChangeEmployeeRequest;
import web.dto.CreateEmployeeRequest;
import web.dto.TransferEmployeeRequest;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String createEmployee(@RequestBody CreateEmployeeRequest createEmployeeRequest){
        String answer = employeeService.addEmployee(createEmployeeRequest);
        return answer;
    }

    @RequestMapping(value = "/transferEmployee", method = RequestMethod.PUT)
    public String transferEmployee(@RequestBody TransferEmployeeRequest transferEmployeeRequest) {
        String answer = employeeService.transferEmployee(transferEmployeeRequest);
        return answer;
    }

    @RequestMapping(value = "/changeEmployee", method = RequestMethod.PUT)
    public String changeEmployee(@RequestBody ChangeEmployeeRequest changeEmployeeRequest){
        if(changeEmployeeRequest.isCorrect()){
            String answer = employeeService.changeEmployee(changeEmployeeRequest);
            return answer;
        }
        return "incorrect request";   //edit later
    }

    @RequestMapping(value = "/removeEmployee", method = RequestMethod.DELETE)
    public String removeEmployee(@RequestParam(value = "id") long id){
        String answer = employeeService.removeEmployee(id);
        return answer;
    }
}
