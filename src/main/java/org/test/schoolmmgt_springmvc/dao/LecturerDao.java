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
import org.test.schoolmmgt_springmvc.model.Lecturer;
 
public interface LecturerDao {
 
    public void addLecturer(Lecturer lecturer);
 
    public List<Lecturer> getAllLecturer();
 
    public void deleteLecturer(Integer lecturerId);
 
    public Lecturer updateLecturer(Lecturer lecturer);
 
    public Lecturer getLecturer(int lecturerid);
}