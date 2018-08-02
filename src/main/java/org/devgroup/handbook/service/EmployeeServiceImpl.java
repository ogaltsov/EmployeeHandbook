package org.devgroup.handbook.service;

import org.devgroup.handbook.dao.DepartmentHibernateDao;
import org.devgroup.handbook.dao.EmployeeHibernateDao;
import org.devgroup.handbook.dao.PositionHibernateDao;
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

    private EmployeeHibernateDao employeeHibernateDao;
    private DepartmentHibernateDao departmentHibernateDao; //todo: edit diff dao's as interface
    private PositionHibernateDao positionHibernateDao;

    @Transactional
    public String createEmployee(CreateEmployee createEmployeeRequest) {
        try {
            employeeHibernateDao.openSession();

            DepartmentEntity department = departmentHibernateDao.getEntityById(createEmployeeRequest.getIdDepartment());
            PositionEntity position = positionHibernateDao.getEntityById(createEmployeeRequest.getIdPosition());

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

            employeeHibernateDao.create(employee);

            employeeHibernateDao.closeSession();
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
            employeeHibernateDao.closeSession();
        }
    }

    public String transferEmployee(TransferEmployee transferEmployeeRequest) {
        try {
            employeeHibernateDao.openSession();
            employeeHibernateDao.getCurrentSession().beginTransaction();

            EmployeeEntity employee = employeeHibernateDao.getEntityById(transferEmployeeRequest.getEmployeeId());
            DepartmentEntity department = departmentHibernateDao.getEntityById(transferEmployeeRequest.getDepIdTo());

            if(employee==null)
                throw new MyException(ResponseException.EMPLOYEE_NOT_EXIST);
            if(department==null)
                throw  new MyException(ResponseException.DEPARTMENT_NOT_EXIST);

            employee.setDepartment(department);
            employeeHibernateDao.update(employee);
            employeeHibernateDao.getCurrentSession().getTransaction().commit();
            employeeHibernateDao.closeSession();
            return "Transfer was complete successful";
        } catch (NullPointerException e){
            e.printStackTrace();
            ////////////////////   todo: fix exceptions
            throw new MyException(ResponseException.FILE_NOT_FOUND);
        }
    }


    public String changeEmployee(ChangeEmployee changeEmployeeRequest) {
        employeeHibernateDao.openSession();
        employeeHibernateDao.getCurrentSession().beginTransaction();

        EmployeeEntity employee = employeeHibernateDao.getEntityById(changeEmployeeRequest.getEmployeeId());

        if(employee==null)
            throw new MyException(ResponseException.EMPLOYEE_NOT_EXIST);

        if(changeEmployeeRequest.getGrade()!=null)
            employee.setGrade(changeEmployeeRequest.getGrade());

        if(changeEmployeeRequest.getSalary()!=null)
            employee.setSalary(changeEmployeeRequest.getSalary());

        if(changeEmployeeRequest.getPositionId()!=null) {
            PositionEntity position = positionHibernateDao.getEntityById(changeEmployeeRequest.getPositionId());
            if(position==null)
                throw new MyException(ResponseException.POSITION_NOT_EXIST);
            employee.setPosition(position);
        }

        employeeHibernateDao.getCurrentSession().update(employee);
        employeeHibernateDao.getCurrentSession().getTransaction().commit();
        employeeHibernateDao.closeSession();
        return "Changes was completed successful";
    }

    public String removeEmployee(long id) {
        try {
            employeeHibernateDao.openSession().beginTransaction();
            //\\
            System.out.println(id);
            ////
            EmployeeEntity employee = employeeHibernateDao.getEntityById(id);

            if (employee == null)
                throw new MyException(ResponseException.EMPLOYEE_NOT_EXIST);

            employeeHibernateDao.delete(employee);
            employeeHibernateDao.getCurrentSession().getTransaction().commit();
            employeeHibernateDao.closeSession();
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
    public void setEmployeeHibernateDao(EmployeeHibernateDao employeeHibernateDao) {
        this.employeeHibernateDao = employeeHibernateDao;
    }
    @Autowired
    public void setDepartmentHibernateDao(DepartmentHibernateDao departmentHibernateDao) {
        this.departmentHibernateDao = departmentHibernateDao;
    }
    @Autowired
    public void setPositionHibernateDao(PositionHibernateDao positionHibernateDao) {
        this.positionHibernateDao = positionHibernateDao;
    }
}
