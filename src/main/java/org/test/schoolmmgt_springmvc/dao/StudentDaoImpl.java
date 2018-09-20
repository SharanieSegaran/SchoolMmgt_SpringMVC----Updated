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
import org.test.schoolmmgt_springmvc.model.Student;
 
@Repository
public class StudentDaoImpl implements StudentDao {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    public void addStudent(Student student) {
        sessionFactory.getCurrentSession().saveOrUpdate(student);
 
    }
 
    @SuppressWarnings("unchecked")
    public List<Student> getAllStudent() {
 
        return sessionFactory.getCurrentSession().createQuery("from Student")
                .list();
    }
 
    @Override
    public void deleteStudent(Integer studentId) {
        Student student = (Student) sessionFactory.getCurrentSession().load(
                Student.class, studentId);
        if (null != student) {
            this.sessionFactory.getCurrentSession().delete(student);
        }
 
    }
 
    public Student getStudent(int sid) {
        return (Student) sessionFactory.getCurrentSession().get(
                Student.class, sid);
    }
 
    @Override
    public Student updateStudent(Student student) {
        sessionFactory.getCurrentSession().update(student);
        return student;
    }
 
}