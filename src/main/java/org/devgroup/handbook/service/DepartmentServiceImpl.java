package org.devgroup.handbook.service;

import org.devgroup.handbook.dao.DepartmentDao;
import org.devgroup.handbook.dto.Request.CreateDepartment;
import org.devgroup.handbook.dto.Request.Reassignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao;

    @Autowired
    public DepartmentServiceImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    public String closeDepartment(long id) {
        return "null";  //todo: return answer from org.devgroup.handbook.dao
    }

    @Override
    public String searchListBranches(long id) {
        return null;
    }

    @Override
    public String createDepartment(CreateDepartment createDepartmentRequest) {
        return null;
    }

    @Override
    public String reassignmentDepartment(Reassignment reassignmentRequest) {
        return null;
    }


}
