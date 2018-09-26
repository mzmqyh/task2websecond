package com.jnshu.controller;

import com.jnshu.mapper.SecondStudentMapper;
import com.jnshu.mapper.StudentMapper;
import com.jnshu.entity.Student;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

// 在类上添加@Controller注解，把Controller交由Spring管理
@Controller
//添加@RequestMapping注解，里面指定请求的url。
@RequestMapping("/students")
public class StudentController {
    Logger logger = LogManager.getLogger(StudentController.class.getName());
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private SecondStudentMapper secondStudentMapper;

    ModelAndView modelAndView = new ModelAndView();
    int total = 0;

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public ModelAndView getStudent(int page, int size) {
        logger.info("getStudent==page=" + page + "==size==" + size);
        List<Student> studentsList = null;
        if (page > 0 && size > 0) {
        //将需要查找学生信息的参数从page对象中得到，用list()方法执行，调用service查找数据库，查询学生信息
        studentsList = studentMapper.list(page,size);
        total = studentMapper.total();
        //TODO 获取total
    }  // ModelAndView表示向视图封装的数据和路径
        modelAndView.addObject("studentsList", studentsList);
        modelAndView.addObject("total", 100);
        // 指定视图"/WEB-INF/jsp/items/itemsList.jsp"
        modelAndView.setViewName("show");
        return modelAndView;
    }

    // 删除数据
    @RequestMapping(value = "/student/dele/{id}", method = RequestMethod.GET)
    public ModelAndView requesDeletet(@PathVariable long id) {
        logger.info("geId===" + id);
        modelAndView.addObject("id", id);
        modelAndView.setViewName("deletestudents");
        return modelAndView;
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public ModelAndView exquteDelete(@PathVariable long id) {
        logger.info("exquteDeleteId" + id);
        studentMapper.delete(id);
        modelAndView.addObject("code", 10);
        modelAndView.addObject("message", "find success");
        modelAndView.setViewName("show");
        return modelAndView;
    }

    //修改数据
    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public ModelAndView requestUpdate(@PathVariable long id, Student student) {
        logger.info("exquteUpdateId:  " + student.getId());
        //model.addAttribute("student",studentMapper.find(student.getId()) );
        modelAndView.addObject("student", studentMapper.find(student.getId()));
        modelAndView.setViewName("updatestudents");
        return modelAndView;
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.PUT)
    public String exquteUpdate(Student student) {
        logger.info("exquteUpdate:  " + student);
        student.setUpdate_at(System.currentTimeMillis());
        logger.info(secondStudentMapper.update(student));
        //  return "show";
        return "redirect:/students/students";
    }

    //增加数据
//    @RequestMapping(value = "/student", method = RequestMethod.GET)
//    public String requestAddstudent() {
//        return "addstudent";
//    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String exquteAdd(Student student) {
        student.setCreate_at(System.currentTimeMillis());
        student.setUpdate_at(System.currentTimeMillis());
        studentMapper.insert(student);
        logger.info(student.toString());
        return "redirect:/students/students";
    }
}
