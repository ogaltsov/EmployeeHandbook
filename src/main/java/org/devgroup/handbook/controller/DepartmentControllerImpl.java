package org.devgroup.handbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.devgroup.handbook.service.DepartmentService;
import org.devgroup.handbook.dto.Response;

@RestController
public class DepartmentControllerImpl implements DepartmentController{

    private DepartmentService departmentService;

    @Autowired
    public DepartmentControllerImpl(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @RequestMapping(value = "/closeDepartment", method = RequestMethod.DELETE)
    public Response closeDepartment(@RequestParam(value = "id") long id) {  //if have no param -> exception
        String answer = departmentService.closeDepartment(id);
        return new Response(answer);
    }

    //todo: merge other methods from "DBaranov"

}
