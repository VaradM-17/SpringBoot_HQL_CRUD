package com.jbk.Hibernate_HQL_SB.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.Hibernate_HQL_SB.entity.Employee;

@Repository
public class EmployeeDao {

    @Autowired
    SessionFactory factory;

    public String insertData(Employee e) {
        Session ss = null;
        Transaction tx = null;
        String msg = null;

        try {
            ss = factory.openSession();
            tx = ss.beginTransaction();
            ss.persist(e);
            tx.commit();
            msg = "Data Successfully Inserted...";
        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
            }
            ex.printStackTrace();
        } finally {
            if (ss != null) {
                ss.close();
            }
        }
        return msg;
    }

    public String updateData(Employee e, int eid) {
        Session ss = null;
        Transaction tx = null;
        String msg = null;

        try {
            ss = factory.openSession();
            tx = ss.beginTransaction();
            String hql = "UPDATE Employee SET ename = :ename, eage = :eage, esalary = :esalary WHERE eid = :eid";
            Query<Employee> query = ss.createQuery(hql,Employee.class);
            query.setParameter("ename", e.getEname());
            query.setParameter("eage", e.getEage());
            query.setParameter("esalary", e.getEsalary());
            query.setParameter("eid", eid);
            int result = query.executeUpdate();
            tx.commit();
            if (result > 0) {
                msg = "Data Successfully Updated...";
            } else {
                msg = "No Data Found for Update...";
            }
        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
            }
            ex.printStackTrace();
        } finally {
            if (ss != null) {
                ss.close();
            }
        }
        return msg;
    }

    public String deleteData(int eid) {
        Session ss = null;
        Transaction tx = null;
        String msg = null;

        try {
            ss = factory.openSession();
            tx = ss.beginTransaction();
            String hql = "DELETE FROM Employee WHERE eid = :eid";
            Query<Employee> query = ss.createQuery(hql,Employee.class);
            query.setParameter("eid", eid);
            int result = query.executeUpdate();
            tx.commit();
            if (result > 0) {
                msg = "Data Successfully Deleted...";
            } else {
                msg = "No Data Found to Delete...";
            }
        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
            }
            ex.printStackTrace();
        } finally {
            if (ss != null) {
                ss.close();
            }
        }
        return msg;
    }

    public List<Employee> displayallData() {
        Session ss = null;
        Transaction tx = null;
        List<Employee> list = null;

        try {
            ss = factory.openSession();
            tx = ss.beginTransaction();
            String hqlQuery = "FROM Employee";
            Query<Employee> query = ss.createQuery(hqlQuery, Employee.class);
            list = query.list();
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
            }
            ex.printStackTrace();
        } finally {
            if (ss != null) {
                ss.close();
            }
        }
        return list;
    }

    public Employee fetchsingleData(int eid) {
        Session ss = null;
        Transaction tx = null;
        Employee emp = null;

        try {
            ss = factory.openSession();
            tx = ss.beginTransaction();
            String hqlQuery = "FROM Employee WHERE eid = :myid";
            Query<Employee> query = ss.createQuery(hqlQuery, Employee.class);
            query.setParameter("myid", eid);
            emp = query.uniqueResult();
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
            }
            ex.printStackTrace();
        } finally {
            if (ss != null) {
                ss.close();
            }
        }
        return emp;
    }
}
