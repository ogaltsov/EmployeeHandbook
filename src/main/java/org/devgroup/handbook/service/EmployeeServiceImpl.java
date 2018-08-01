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

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;
    private DepartmentDao departmentDao; //todo: edit diff dao's as interface
    private PositionDao positionDao;

    @Transactional
    public String createEmployee(CreateEmployee createEmployeeRequest) {
        try {
            employeeDao.openSession();

            DepartmentEntity department = departmentDao.getEntityById(createEmployeeRequest.getIdDepartment());
            PositionEntity position = positionDao.getEntityById(createEmployeeRequest.getIdPosition());

            if(department==null || position==null){
                throw new NullPointerException();
            }

            EmployeeEntity employee = EmployeeEntity.builder()
                    .name(createEmployeeRequest.getName())
                    .surname(createEmployeeRequest.getSurname())
                    .patronymic(createEmployeeRequest.getPatronymic())
                    .gender(createEmployeeRequest.getGenderName())
                    .birthDate(createEmployeeRequest.getBirthDate())
                    .department(department)
                    .position(position)
                    .grade(createEmployeeRequest.getGrade())
                    .salary(createEmployeeRequest.getSalary())
                    .build();

            employeeDao.create(employee);

            employeeDao.closeSession();
            return "Employee was created successfully";
        } catch (IllegalArgumentException e){
            e.printStackTrace();
            ////////////////////// todo: fix exceptions
            throw new MyException(ResponseException.FILE_NOT_FOUND);
        } catch (NullPointerException e){ // if dep or pos not exist in db
            e.printStackTrace();
            ///////////////////  todo: fix exceptions
            throw new MyException(ResponseException.FILE_NOT_FOUND);
        } catch (Exception e){
            e.printStackTrace();
            /////////////////   todo: fix exceptions
            throw new MyException(ResponseException.FILE_NOT_FOUND);
        } finally {
            employeeDao.closeSession();
        }
    }

    public String transferEmployee(TransferEmployee transferEmployeeRequest) {
        try {
            employeeDao.openSession();
            employeeDao.getCurrentSession().beginTransaction();

            EmployeeEntity employee = employeeDao.getEntityById(transferEmployeeRequest.getEmployeeId());
            DepartmentEntity department = departmentDao.getEntityById(transferEmployeeRequest.getDepIdTo());

            if(employee==null || department==null){
                throw new NullPointerException();
            }

            employee.setDepartment(department);
            employeeDao.update(employee);
            employeeDao.getCurrentSession().getTransaction().commit();
            employeeDao.closeSession();
            return "successful";  //todo: return answer from dao, exc
        } catch (NullPointerException e){
            e.printStackTrace();
            ////////////////////   todo: fix exceptions
            throw new MyException(ResponseException.FILE_NOT_FOUND);
        }
    }


    public String changeEmployee(ChangeEmployee changeEmployeeRequest) {
        employeeDao.openSession();
        employeeDao.getCurrentSession().beginTransaction();

        EmployeeEntity employee = employeeDao.getEntityById(changeEmployeeRequest.getEmployeeId());

        if(changeEmployeeRequest.getGrade()!=null)
            employee.setGrade(changeEmployeeRequest.getGrade());
        if(changeEmployeeRequest.getSalary()!=null)
            employee.setSalary(changeEmployeeRequest.getSalary());

        if(changeEmployeeRequest.getPositionId()!=null) {
            PositionEntity position = positionDao.getEntityById(changeEmployeeRequest.getPositionId());
            employee.setPosition(position);


        }

        employeeDao.getCurrentSession().saveOrUpdate(employee);
        employeeDao.getCurrentSession().getTransaction().commit();
        employeeDao.closeSession();
        return "success";
    }

    public String removeEmployee(long id) {
        employeeDao.openSession().beginTransaction();
        employeeDao.delete(id);
        employeeDao.getCurrentSession().getTransaction().commit();
        employeeDao.closeSession();
        return "success";
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
