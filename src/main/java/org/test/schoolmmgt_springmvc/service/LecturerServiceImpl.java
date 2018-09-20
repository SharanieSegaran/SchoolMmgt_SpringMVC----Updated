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
import org.test.schoolmmgt_springmvc.dao.LecturerDao;
import org.test.schoolmmgt_springmvc.model.Lecturer;
 
@Service
@Transactional
public abstract class LecturerServiceImpl implements LecturerService {
 
    @Autowired
    private LecturerDao lecturerDao;
 
    @Override
    @Transactional
    public void addLecturer(Lecturer lecturer) {
        lecturerDao.addLecturer(lecturer);
    }
 
    @Override
    @Transactional
    public List<Lecturer> getAllLecturer() {
        return lecturerDao.getAllLecturer();
    }
 
    @Override
    @Transactional
    public void deleteLecturer(Integer lecturerId) {
        lecturerDao.deleteLecturer(lecturerId);
    }
 
    public Lecturer getLecturer(int sid) {
        return lecturerDao.getLecturer(sid);
    }
 
    public Lecturer updateEmployee(Lecturer lecturer) {
        // TODO Auto-generated method stub
        return lecturerDao.updateLecturer(lecturer);
    }
 
    public void setLecturerDAO(LecturerDao lecturerDao) {
        this.lecturerDao = lecturerDao;
    }

   
 
}