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

    
}
