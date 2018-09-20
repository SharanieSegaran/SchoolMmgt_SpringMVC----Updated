/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.test.schoolmmgt_springmvc.controller;

/**
 *
 * @author ASUS
 */
import java.io.IOException;
import java.util.List;
 
import javax.servlet.http.HttpServletRequest;
 
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.test.schoolmmgt_springmvc.model.Student;
import org.test.schoolmmgt_springmvc.service.StudentService;
 
@Controller
public class StudentController {
 
    private static final Logger logger = Logger
            .getLogger(StudentController.class);
 
    public StudentController() {
        System.out.println("StudentController()");
    }
 
    @Autowired
    private StudentService studentService;
 
    @RequestMapping(value = "/")
    public ModelAndView listStudent(ModelAndView model) throws IOException {
        List<Student> listStudent = studentService.getAllStudent();
        model.addObject("listStudent", listStudent);
        model.setViewName("home");
        return model;
    }
 
    @RequestMapping(value = "/newStudent", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        Student student = new Student();
        model.addObject("student", student);
        model.setViewName("Student");
        return model;
    }
 
    @RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
    public ModelAndView saveStudent(@ModelAttribute Student student) {
        if (student.getId() == 0) { // if student id is 0 then creating the
            // student other updating the student
            studentService.addStudent(student);
        } else {
            studentService.updateStudent(student);
        }
        return new ModelAndView("redirect:/");
    }
 
    @RequestMapping(value = "/deleteStudent", method = RequestMethod.GET)
    public ModelAndView deleteStudent(HttpServletRequest request) {
        int studentId = Integer.parseInt(request.getParameter("id"));
        studentService.deleteStudent(studentId);
        return new ModelAndView("redirect:/");
    }
 
    @RequestMapping(value = "/editStudent", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int studentId = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.getStudent(studentId);
        ModelAndView model = new ModelAndView("Student");
        model.addObject("student", student);
 
        return model;
    }
 
}