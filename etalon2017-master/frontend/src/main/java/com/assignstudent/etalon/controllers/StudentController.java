package com.assignstudent.etalon.controllers;

import com.assignstudent.etalon.beans.StudentViewModel;
import com.assignstudent.etalon.entities.FacultyEntity;
import com.assignstudent.etalon.entities.SpecialtyEntity;
import com.assignstudent.etalon.entities.StudentEntity;
import com.assignstudent.etalon.services.FacultyService;
import com.assignstudent.etalon.services.SpecialtyService;
import com.assignstudent.etalon.services.StudentService;
import com.assignstudent.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping ("/students")
public class StudentController {

    @Autowired
    StudentService studentService;
    @Autowired
    FacultyService facultyService;
    @Autowired
    SpecialtyService specialtyService;

    @Autowired
    private ConversionService conversionService;


    private StudentRepository studentRepository;

    @RequestMapping (value = "/showAll", method = RequestMethod.GET)
    public ModelAndView printAllStudents(){
        ModelAndView studentViewModel=new ModelAndView();
        List<StudentEntity> studentEntityList= studentService.getAllStudents();
        studentViewModel.addObject("students", studentEntityList);
        studentViewModel.setViewName("systemStudentPanelView");
        return studentViewModel;
    }

    @RequestMapping (value = "/show/{id}", method = RequestMethod.GET)
    public ModelAndView printOneStudent(@PathVariable("id")int id){
        ModelAndView studentViewModel=new ModelAndView();
        StudentEntity studentEntity=studentService.getOneStudent(id);
        studentViewModel.addObject("student", studentEntity);
        studentViewModel.setViewName("studentsView");
        return studentViewModel;
    }

    @RequestMapping(value = "/create",produces = "application/json", method = RequestMethod.POST)
    public @ResponseBody  StudentEntity createStudent(@RequestBody StudentViewModel studentViewModel) {
        StudentEntity studentEntity=new StudentEntity();

        studentEntity.setFirstName(studentViewModel.getFirstName());
        studentEntity.setLastName(studentViewModel.getLastName());
        studentEntity.setScore(studentViewModel.getScore());
        studentEntity.setGroup(studentViewModel.getGroup());
        studentEntity.setStatus(studentViewModel.getStatus());
        studentEntity.setIsBudget(studentViewModel.getIsBudget());

        studentEntity.setFacultyId(studentViewModel.getFacultyByFacultyId());
        FacultyEntity facultyEntity=facultyService.findById(studentViewModel.getFacultyByFacultyId());
        studentEntity.setFacultyByFacultyId(facultyEntity);

        studentEntity.setSpecialtyId(studentViewModel.getSpecialtyBySpecialtyId());
        SpecialtyEntity specialtyEntity=specialtyService.findById(studentViewModel.getSpecialtyBySpecialtyId());
        studentEntity.setSpecialtyBySpecialtyId(specialtyEntity);

        studentService.createStudent(studentEntity);
        return studentEntity;
    }
}
