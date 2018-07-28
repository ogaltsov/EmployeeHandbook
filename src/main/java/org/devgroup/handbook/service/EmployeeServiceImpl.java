package org.devgroup.handbook.service;

import org.devgroup.handbook.dao.DepartmentDao;
import org.devgroup.handbook.dao.EmployeeDao;
import org.devgroup.handbook.dao.PositionDao;
import org.devgroup.handbook.dto.Request.ChangeEmployee;
import org.devgroup.handbook.dto.Request.CreateEmployee;
import org.devgroup.handbook.dto.Request.TransferEmployee;
import org.devgroup.handbook.entity.DepartmentEntity;
import org.devgroup.handbook.entity.EmployeeEntity;
import org.devgroup.handbook.entity.PositionEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;
    private DepartmentDao departmentDao; //todo: edit diff dao's as interface
    private PositionDao positionDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public String createEmployee(CreateEmployee createEmployeeRequest) {
        departmentDao.openCurrentSessionWithTransaction();
        DepartmentEntity department = departmentDao.getEntityById(createEmployeeRequest.getIdDepartment());
        departmentDao.closeCurrentSessionWithTransaction();

        positionDao.openCurrentSessionWithTransaction();
        PositionEntity position = positionDao.getEntityById(createEmployeeRequest.getIdPosition());
        positionDao.closeCurrentSessionWithTransaction();

        employeeDao.openCurrentSessionWithTransaction();
        EmployeeEntity employee = EmployeeEntity.builder()
                .name(createEmployeeRequest.getName())
                .surname(createEmployeeRequest.getSurname())
                .patronymic(createEmployeeRequest.getPatronimyc())
                .gender(createEmployeeRequest.getGenderName())      //todo: validate gender
                .birthDate(createEmployeeRequest.getBirthDate())
                .department(department)
                .position(position)
                .grade(createEmployeeRequest.getGrade())
                .salary(createEmployeeRequest.getSalary())
                .build();
        employeeDao.create(employee);
        employeeDao.closeCurrentSessionWithTransaction();
        return "successful";  //todo: return answer from dao, handle exc
    }

    public String transferEmployee(TransferEmployee transferEmployeeRequest) {
        employeeDao.openCurrentSessionWithTransaction();
        EmployeeEntity employee = employeeDao.getEntityById(transferEmployeeRequest.getEmployeeId());

        departmentDao.openCurrentSessionWithTransaction();
        DepartmentEntity department = departmentDao.getEntityById(transferEmployeeRequest.getDepIdTo());
        departmentDao.closeCurrentSessionWithTransaction();

        employee.setDepartment(department);
        employeeDao.closeCurrentSessionWithTransaction();
        return "successful";  //todo: return answer from dao, exc
    }

    public String changeEmployee(ChangeEmployee changeEmployeeRequest) {
        return "null";  //todo: return answer from dao
    }

    public String removeEmployee(long id) {
        return "null";  //todo: return answer from dao
    }

    @Override
    public String getListEmployeeOfDepartment(long id) {
        return null;
    }
}
