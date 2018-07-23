package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.DepartmentService;
import service.EmployeeServiceImpl;
import web.dto.ChangeEmployeeRequest;
import web.dto.Employee;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String createEmployee(@RequestBody Employee employee){  //на каком этапе выпадет exeption с null полем при создании объекта
        String answer = employeeService.addEmployee(employee);
        return answer;
    }

    @RequestMapping(value = "/transferEmployee", method = RequestMethod.PUT) ///todo: replace with TransferEmployeeRequest
    public String transferEmployee(@RequestParam(value = "employeeId") long employeeId,
                                   @RequestParam(value = "depIdFrom") long depIdFrom,
                                   @RequestParam(value = "depIdTo") long depIdTo) {   //exception by: required=true, parseLong
        String answer = employeeService.transferEmployee(employeeId, depIdFrom, depIdTo);
        return answer;
    }

    @RequestMapping(value = "/changeEmployee", method = RequestMethod.PUT)
    public String changeEmployee(@RequestBody ChangeEmployeeRequest changeEmployeeRequest){  //exc
        if(changeEmployeeRequest.isCorrect()){
            String answer = employeeService.changeEmployee(changeEmployeeRequest);
            return answer;
        }
        return "incorrect request";   //edit later
    }

    @RequestMapping(value = "/removeEmployee", method = RequestMethod.DELETE)
    public String removeEmployee(@RequestParam(value = "id") long id){   //exc
        String answer = employeeService.remove(id);
        return answer;
    }
}
