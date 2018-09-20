/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.test.schoolmmgt_springmvc.dao;

/**
 *
 * @author ASUS
 */
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.test.schoolmmgt_springmvc.model.Lecturer;
 
@Repository
public class LecturerDaoImpl implements LecturerDao {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    public void addLecturer(Lecturer lecturer) {
        sessionFactory.getCurrentSession().saveOrUpdate(lecturer);
 
    }
 
    @SuppressWarnings("unchecked")
    public List<Lecturer> getAllLecturer() {
 
        return sessionFactory.getCurrentSession().createQuery("from Lecturer")
                .list();
    }
 
    @Override
    public void deleteLecturer(Integer lecturerId) {
        Lecturer lecturer = (Lecturer) sessionFactory.getCurrentSession().load(
                Lecturer.class, lecturerId);
        if (null != lecturer) {
            this.sessionFactory.getCurrentSession().delete(lecturer);
        }
 
    }
 
    public Lecturer getLecturer(int lid) {
        return (Lecturer) sessionFactory.getCurrentSession().get(
                Lecturer.class, lid);
    }
 
    @Override
    public Lecturer updateLecturer(Lecturer lecturer) {
        sessionFactory.getCurrentSession().update(lecturer);
        return lecturer;
    }
 
}