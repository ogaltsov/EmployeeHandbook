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
        departmentDao.openSession();
        DepartmentEntity department = departmentDao.getEntityById(createEmployeeRequest.getIdDepartment());

        PositionEntity position = positionDao.getEntityById(createEmployeeRequest.getIdPosition());

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
        employeeDao.closeSession();
        return "successful";  //todo: return answer from dao, handle exc
    }

    @Transactional
    public String transferEmployee(TransferEmployee transferEmployeeRequest) {
        employeeDao.openSession();
        employeeDao.getCurrentSession().beginTransaction();
        EmployeeEntity employee = employeeDao.getEntityById(transferEmployeeRequest.getEmployeeId());

        DepartmentEntity department = departmentDao.getEntityById(transferEmployeeRequest.getDepIdTo());

        employee.setDepartment(department);
        employeeDao.update(employee);
        employeeDao.getCurrentSession().getTransaction().commit();
        employeeDao.closeSession();
        return "successful";  //todo: return answer from dao, exc
    }

    @Transactional
    public String changeEmployee(ChangeEmployee changeEmployeeRequest) {
        employeeDao.openSession();
        employeeDao.getCurrentSession().beginTransaction();
        EmployeeEntity employee = employeeDao.getEntityById(changeEmployeeRequest.getEmployeeId());
        System.out.println(employee.getDepartment().getName());
        if(changeEmployeeRequest.getGrade()!=0)
            employee.setGrade(changeEmployeeRequest.getGrade());
        if(changeEmployeeRequest.getSalary()!=null)
            employee.setSalary(changeEmployeeRequest.getSalary());

        PositionEntity position = positionDao.getEntityById(changeEmployeeRequest.getPositionId());
        if(position!=null)
            employee.setPosition(position);
        System.out.println(position);
        employeeDao.getCurrentSession().saveOrUpdate(employee);
        employeeDao.getCurrentSession().getTransaction().commit();
        employeeDao.closeSession();
        return "success";
    }
    @Transactional
    public String removeEmployee(long id) {
        employeeDao.openSession().beginTransaction();
        employeeDao.delete(id);
        employeeDao.getCurrentSession().getTransaction().commit();
        employeeDao.closeSession();
        return "success";
    }

    @Override
    public List<EmployeeEntity> getListEmployeeOfDepartment(long id) {
        CriteriaBuilder criteriaBuilder = employeeDao.openSession().getCriteriaBuilder();
        CriteriaQuery<EmployeeEntity> criteriaQuery = criteriaBuilder.createQuery(EmployeeEntity.class);
        Root<EmployeeEntity> employeeRoot = criteriaQuery.from(EmployeeEntity.class);
        criteriaQuery.where(criteriaBuilder.equal(employeeRoot.get("department"), id));
        List<EmployeeEntity> listOfEmployee = employeeDao.getWithCriteria(criteriaQuery).list();
        employeeDao.closeSession();
        return listOfEmployee;
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
