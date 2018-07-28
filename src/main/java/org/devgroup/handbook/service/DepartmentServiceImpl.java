package org.devgroup.handbook.service;

import org.devgroup.handbook.dao.DepartmentDao;
import org.devgroup.handbook.dao.EmployeeDao;
import org.devgroup.handbook.dto.Request.CreateDepartment;
import org.devgroup.handbook.dto.Request.Reassignment;
import org.devgroup.handbook.entity.DepartmentEntity;
import org.devgroup.handbook.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao;
    private EmployeeDao employeeDao;

    @Override
    public String closeDepartment(long id) {

        Long countOfEmployee;
        Long countOfDep;

        //build CriteriaQuery to check if department have employees, likewise SQL query:
        //select count(*) from employee where department_id = ...
        employeeDao.openCurrentSessionWithTransaction();
        {
            CriteriaBuilder criteriaBuilder = employeeDao.getCurrentSession().getCriteriaBuilder();
            CriteriaQuery<Long> countEmployeeQuery = criteriaBuilder.createQuery(Long.class);
            Root<EmployeeEntity> employeeRoot = countEmployeeQuery.from(EmployeeEntity.class);
            countEmployeeQuery.select(criteriaBuilder.count(employeeRoot));
            countEmployeeQuery.where(criteriaBuilder.equal(employeeRoot.get("department"), id));
            countOfEmployee = employeeDao.getCurrentSession().createQuery(countEmployeeQuery).getSingleResult();
        }
        employeeDao.closeCurrentSessionWithTransaction();

        if(countOfEmployee==0)
            return "you cannot close dep, cause: it has employees";

        //build CriteriaQuery to check if department have sub-departments, likewise SQL query:
        //select count(*) from department where parent_department = ...
        departmentDao.openCurrentSessionWithTransaction();
        {
            CriteriaBuilder criteriaBuilder = departmentDao.getCurrentSession().getCriteriaBuilder();
            CriteriaQuery<Long> countDepartmentQuery = criteriaBuilder.createQuery(Long.class);
            Root<DepartmentEntity> depRoot = countDepartmentQuery.from(DepartmentEntity.class);
            countDepartmentQuery.select(criteriaBuilder.count(depRoot));
            countDepartmentQuery.where(criteriaBuilder.equal(depRoot.get("parentDepartment"), id));
            countOfDep = departmentDao.getCurrentSession().createQuery(countDepartmentQuery).getSingleResult();
        }
        departmentDao.closeCurrentSessionWithTransaction();

        if(countOfDep==0)
            return "you cannot close dep, cause: it has subDeps";

        departmentDao.openCurrentSessionWithTransaction();
        {
            departmentDao.delete(id);
        }
        departmentDao.closeCurrentSessionWithTransaction();

        return "dep was deleted successfully";
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




    @Autowired
    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }
    @Autowired
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
