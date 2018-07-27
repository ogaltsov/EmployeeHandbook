package org.devgroup.handbook.service;

import org.devgroup.handbook.dao.DepartmentDao;
import org.devgroup.handbook.dto.Request.CreateDepartment;
import org.devgroup.handbook.dto.Request.Reassignment;
import org.devgroup.handbook.entity.DepartmentEntity;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao;

    @Autowired
    public DepartmentServiceImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    public String closeDepartment(long id) {
        departmentDao.openCurrentSessionWithTransaction();

        {     ///// ОЧЕНЬ СОМНИТЕЛЬНЫЙ КОД **START**
            CriteriaBuilder cBuilder = departmentDao.getCurrentSession().getCriteriaBuilder();
            CriteriaQuery<DepartmentEntity> cQuery = cBuilder.createQuery(DepartmentEntity.class);
            Root<DepartmentEntity> depRoot = cQuery.from(DepartmentEntity.class);
            cQuery.select(depRoot).where(cBuilder.equal(depRoot.get("id"), id));
            Query<DepartmentEntity> query = departmentDao.getCurrentSession().createQuery(cQuery);
            List<DepartmentEntity> list = query.list();
        }    /////// ОЧЕНЬ СОМНИТЕЛЬНЫЙ КОД **END**

        return null;

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
