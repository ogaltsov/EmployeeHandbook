package org.devgroup.handbook.service;

import org.devgroup.handbook.dao.DepartmentDao;
import org.devgroup.handbook.dto.Request.CreateDepartmentRequest;
import org.devgroup.handbook.dto.Request.ReassignmentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao;

    @Autowired
    public DepartmentServiceImpl(DepartmentDao departmentDao){
        this.departmentDao = departmentDao;
    }

    public String closeDepartment(long id){
        return "null";  //todo: return answer from org.devgroup.handbook.dao
    }

    @Override
    public String searchListBranches(long id) {
        return null;
    }

    @Override
    public String createDepartment(CreateDepartmentRequest createDepartmentRequest) {
        return null;
    }

    @Override
    public String reassignmentDepartment(ReassignmentRequest reassignmentRequest) {
        return null;
    }


}
