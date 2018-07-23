package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.DepartmentService;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/closeDepartment", method = RequestMethod.DELETE)
    public String closeDepartment(@RequestParam(value = "id") long id) {  //if have no param -> exception
        String answer = departmentService.closeDepartment(id);
        return answer;
    }
}
