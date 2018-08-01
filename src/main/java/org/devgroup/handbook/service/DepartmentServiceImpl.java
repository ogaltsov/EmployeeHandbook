package org.devgroup.handbook.service;

import org.devgroup.handbook.dao.DepartmentDao;
import org.devgroup.handbook.dao.EmployeeDao;
import org.devgroup.handbook.dto.Request.CreateDepartment;
import org.devgroup.handbook.dto.Request.Reassignment;
import org.devgroup.handbook.entity.DepartmentEntity;
import org.devgroup.handbook.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao;
    private EmployeeDao employeeDao;


    @Override
    @Transactional
    public String closeDepartment(long id) {

        Long countOfEmployee;
        Long countOfDep;

        //build CriteriaQuery to check if department have employees, likewise SQL query:
        //select count(*) from employee where department_id = ...
        employeeDao.openSession();
        {
            CriteriaBuilder criteriaBuilder = employeeDao.getCurrentSession().getCriteriaBuilder();
            CriteriaQuery<Long> countEmployeeQuery = criteriaBuilder.createQuery(Long.class);
            Root<EmployeeEntity> employeeRoot = countEmployeeQuery.from(EmployeeEntity.class);
            countEmployeeQuery.select(criteriaBuilder.count(employeeRoot));
            countEmployeeQuery.where(criteriaBuilder.equal(employeeRoot.get("department"), id));
            countOfEmployee = employeeDao.getWithCriteria(countEmployeeQuery).getSingleResult();
        }
        employeeDao.closeSession();

        if(countOfEmployee!=0)
            return "you cannot close dep, cause: it has employees";

        //build CriteriaQuery to check if department have sub-departments, likewise SQL query:
        //select count(*) from department where parent_department = ...
        departmentDao.openSession();
        {
            CriteriaBuilder criteriaBuilder = departmentDao.getCurrentSession().getCriteriaBuilder();
            CriteriaQuery<Long> countDepartmentQuery = criteriaBuilder.createQuery(Long.class);
            Root<DepartmentEntity> depRoot = countDepartmentQuery.from(DepartmentEntity.class);
            countDepartmentQuery.select(criteriaBuilder.count(depRoot));
            countDepartmentQuery.where(criteriaBuilder.equal(depRoot.get("parentDepartment"), id));
            countOfDep = departmentDao.getWithCriteria(countDepartmentQuery).getSingleResult();
        }
        departmentDao.closeSession();

        if(countOfDep!=0)
            return "you cannot close dep, cause: it has subDeps";

        departmentDao.openSession().beginTransaction();
        {
            departmentDao.delete(id);
        }
        departmentDao.getCurrentSession().getTransaction().commit();
        departmentDao.closeSession();

        return "dep was deleted successfully";  //todo: handle exceptions(trans crushes), return request(class)
    }

    @Override
    public String searchListBranches(long id) {
        List<DepartmentEntity> listOfDepartment;

        departmentDao.openSession();
        {
            CriteriaBuilder criteriaBuilder = departmentDao.getCurrentSession().getCriteriaBuilder();
            CriteriaQuery<DepartmentEntity> departmentQuery = criteriaBuilder.createQuery(DepartmentEntity.class);
            Root<DepartmentEntity> depRoot = departmentQuery.from(DepartmentEntity.class);
            departmentQuery.where(criteriaBuilder.equal(depRoot.get("parentDepartment"), id));
            listOfDepartment = departmentDao.getCurrentSession().createQuery(departmentQuery).list();
        }
        departmentDao.closeSession();
        return null; //todo: return list, handle exc
    }

    @Override
    @Transactional
    public String createDepartment(CreateDepartment createDepRequest) {
        departmentDao.openSession();
        DepartmentEntity department = departmentDao.getEntityById(createDepRequest.getParentDepartment());
        departmentDao.closeSession();

        employeeDao.openSession();
        EmployeeEntity employee = employeeDao.getEntityById(createDepRequest.getHeadEmployee());
        employeeDao.closeSession();

        DepartmentEntity newDepartment = DepartmentEntity.builder()
                .parentDepartment(department)
                .headEmployee(employee)
                .name(createDepRequest.getName())
                .build();

        departmentDao.openSession();
        departmentDao.create(newDepartment);
        departmentDao.closeSession();

        return "success";  //todo: handle exception(if transaction crushes, ), return request(class)
    }

    @Override
    @Transactional
    public String reassignmentDepartment(Reassignment reassignmentRequest) {

        departmentDao.openSession();

        DepartmentEntity depToReassign = departmentDao.getEntityById(reassignmentRequest.getIdDepToReassign());
        DepartmentEntity newParentDep = departmentDao.getEntityById(reassignmentRequest.getIdNewParentDep());
        depToReassign.setParentDepartment(newParentDep);
        departmentDao.update(depToReassign);

        departmentDao.closeSession();
        return "success"; //todo: handle exception, return request(class)
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
    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }
    @Autowired
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
