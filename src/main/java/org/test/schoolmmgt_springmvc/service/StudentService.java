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
import org.test.schoolmmgt_springmvc.model.Student;
 
public interface StudentService {
     
    public void addStudent(Student student);
 
    public List<Student> getAllStudent();
 
    public void deleteStudent(Integer studentId);
 
    public Student getStudent(int studentid);
 
    public Student updateStudent(Student student);
    
}
