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
import org.devgroup.handbook.exception.MyException;
import org.devgroup.handbook.exception.ResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;
    private DepartmentDao departmentDao; //todo: edit diff dao's as interface
    private PositionDao positionDao;

    @Transactional
    public String createEmployee(CreateEmployee createEmployeeRequest) {
        try {

            DepartmentEntity department = departmentDao.getEntityById(createEmployeeRequest.getIdDepartment());
            PositionEntity position = positionDao.getEntityById(createEmployeeRequest.getIdPosition());

            if(department==null){
                throw new MyException(ResponseException.DEPARTMENT_NOT_EXIST);
            }
            if(position==null){
                throw new MyException(ResponseException.POSITION_NOT_EXIST);
            }


            EmployeeEntity employee = EmployeeEntity.builder()
                    .name(createEmployeeRequest.getName())
                    .surname(createEmployeeRequest.getSurname())
                    .patronymic(createEmployeeRequest.getPatronymic())
                    .gender(createEmployeeRequest.getGender())
                    .birthDate(createEmployeeRequest.getBirthDate())
                    .department(department)
                    .position(position)
                    .grade(createEmployeeRequest.getGrade())
                    .salary(createEmployeeRequest.getSalary())
                    .build();

            employeeDao.create(employee);

            return "Employee was created successfully";
        } catch (IllegalArgumentException e){
            e.printStackTrace();
            ////////////////////// todo: fix exceptions
            throw new MyException(ResponseException.FILE_NOT_FOUND);
        } catch (NullPointerException e){ // if dep or pos not exist in db
            e.printStackTrace();
            ///////////////////  todo: fix exceptions
            throw new MyException(ResponseException.FILE_NOT_FOUND);
        } finally {
        }
    }

    @Transactional
    public String transferEmployee(TransferEmployee transferEmployeeRequest) {
        try {


            EmployeeEntity employee = employeeDao.getEntityById(transferEmployeeRequest.getEmployeeId());
            DepartmentEntity department = departmentDao.getEntityById(transferEmployeeRequest.getDepIdTo());

            if(employee==null)
                throw new MyException(ResponseException.EMPLOYEE_NOT_EXIST);
            if(department==null)
                throw  new MyException(ResponseException.DEPARTMENT_NOT_EXIST);

            employee.setDepartment(department);
            employeeDao.update(employee);
            return "Transfer was complete successful";
        } catch (NullPointerException e){
            e.printStackTrace();
            ////////////////////   todo: fix exceptions
            throw new MyException(ResponseException.FILE_NOT_FOUND);
        }
    }

    @Transactional
    public String changeEmployee(ChangeEmployee changeEmployeeRequest) {


        EmployeeEntity employee = employeeDao.getEntityById(changeEmployeeRequest.getEmployeeId());

        if(employee==null)
            throw new MyException(ResponseException.EMPLOYEE_NOT_EXIST);

        if(changeEmployeeRequest.getGrade()!=null)
            employee.setGrade(changeEmployeeRequest.getGrade());

        if(changeEmployeeRequest.getSalary()!=null)
            employee.setSalary(changeEmployeeRequest.getSalary());

        if(changeEmployeeRequest.getPositionId()!=null) {
            PositionEntity position = positionDao.getEntityById(changeEmployeeRequest.getPositionId());
            if(position==null)
                throw new MyException(ResponseException.POSITION_NOT_EXIST);
            employee.setPosition(position);
        }

        employeeDao.update(employee);

        return "Changes was completed successful";
    }

    @Transactional
    public String removeEmployee(long id) {
        try {
            EmployeeEntity employee = employeeDao.getEntityById(id);

            if (employee == null)
                throw new MyException(ResponseException.EMPLOYEE_NOT_EXIST);

            employeeDao.delete(employee);

            return "Employee was removed successful";
        } catch (NullPointerException e) {
            e.printStackTrace();
            ///////////////// todo fix exc
            throw new MyException(ResponseException.FILE_NOT_FOUND);
        } finally {
            //employeeDao.closeSession();
        }
    }



    @Autowired
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
    @Autowired
    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }
    @Autowired
    public void setPositionDao(PositionDao positionDao) {
        this.positionDao = positionDao;
    }
}
