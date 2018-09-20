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
import org.test.schoolmmgt_springmvc.model.Lecturer;
import org.test.schoolmmgt_springmvc.service.LecturerService;
 
@Controller
public class LecturerController {
 
    private static final Logger logger = Logger
            .getLogger(LecturerController.class);
 
    public LecturerController() {
        System.out.println("LecturerController()");
    }
 
    @Autowired
    private LecturerService lecturerService;
 
    @RequestMapping(value = "/")
    public ModelAndView listLecturer(ModelAndView model) throws IOException {
        List<Lecturer> listLecturer = lecturerService.getAllLecturer();
        model.addObject("listLecturer", listLecturer);
        model.setViewName("home");
        return model;
    }
 
    @RequestMapping(value = "/newLecturer", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        Lecturer lecturer = new Lecturer();
        model.addObject("lecturer", lecturer);
        model.setViewName("Lecturer");
        return model;
    }
 
    @RequestMapping(value = "/saveLecturer", method = RequestMethod.POST)
    public ModelAndView saveLecturer(@ModelAttribute Lecturer lecturer) {
        if (lecturer.getLid() == 0) { // if lecturer id is 0 then creating the
            // lecturer other updating the lecturer
            lecturerService.addLecturer(lecturer);
        } else {
            lecturerService.updateLecturer(lecturer);
        }
        return new ModelAndView("redirect:/");
    }
 
    @RequestMapping(value = "/deleteLecturer", method = RequestMethod.GET)
    public ModelAndView deleteLecturer(HttpServletRequest request) {
        int lecturerId = Integer.parseInt(request.getParameter("id"));
        lecturerService.deleteLecturer(lecturerId);
        return new ModelAndView("redirect:/");
    }
 
    @RequestMapping(value = "/editLecturer", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int lecturerId = Integer.parseInt(request.getParameter("id"));
        Lecturer lecturer = lecturerService.getLecturer(lecturerId);
        ModelAndView model = new ModelAndView("Lecturer");
        model.addObject("lecturer", lecturer);
 
        return model;
    }
 
}