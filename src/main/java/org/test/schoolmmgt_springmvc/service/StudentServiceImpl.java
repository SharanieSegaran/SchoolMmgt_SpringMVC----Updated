/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.test.schoolmmgt_springmvc.service;

/**
 *
 * @author ASUS
 */

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.test.schoolmmgt_springmvc.dao.StudentDao;
import org.test.schoolmmgt_springmvc.model.Student;
 
@Service
@Transactional
public abstract class StudentServiceImpl implements StudentService {
 
    @Autowired
    private StudentDao studentDao;
 
    @Override
    @Transactional
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }
 
    @Override
    @Transactional
    public List<Student> getAllStudent() {
        return studentDao.getAllStudent();
    }
 
    @Override
    @Transactional
    public void deleteStudent(Integer studentId) {
        studentDao.deleteStudent(studentId);
    }
 
    public Student getStudent(int sid) {
        return studentDao.getStudent(sid);
    }
 
    public Student updateEmployee(Student employee) {
        // TODO Auto-generated method stub
        return studentDao.updateStudent(employee);
    }
 
    public void setStudentDAO(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

   
 
}