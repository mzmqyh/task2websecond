package com.jnshu.controller;

import com.jnshu.entity.Student;
import com.jnshu.mapper.SecondStudentMapper;
import com.jnshu.mapper.StudentMapper;
import org.apache.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/springmvc")
public class TestJsonTagLibController {
    org.apache.log4j.Logger logger = LogManager.getLogger(StudentController.class.getName());
    ModelAndView modelAndView = new ModelAndView();
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    SecondStudentMapper secondStudentMapper;

    Student student = new Student();
   // StateMessage stateMessage = new StateMessage();


    @RequestMapping("/login")
    public String index() {
        System.out.println("helloworld");
        return "login";
    }

    //   @ResponseBody//查找全部
    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public ModelAndView findAllJson() {
        if(studentMapper.total()>0){
            List<Student> stulist = studentMapper.findAll();
            modelAndView.addObject("code", 1);
            modelAndView.addObject("message", "findAll success");
            modelAndView.addObject("student", stulist);
            // 指定视图"/WEB-INF/jsp/items/itemsList.jsp"
            modelAndView.setViewName("jsontextall");
        }else{
            modelAndView.addObject("code", -1);
            modelAndView.addObject("message", "findAll failed");
            // 指定视图"/WEB-INF/jsp/items/itemsList.jsp"
            modelAndView.setViewName("jsontextall");
        }
        return modelAndView;
    }

    //查找单个
    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public ModelAndView excuteFind(@PathVariable long id) {
        logger.info("excuteFind==="+id);
        if(id>0){
            Student stulist = studentMapper.find(id);
            modelAndView.addObject("code", 10);
            modelAndView.addObject("message", "find success");
            modelAndView.addObject("student", stulist);
            // 指定视图"/WEB-INF/jsp/items/itemsList.jsp"
            modelAndView.setViewName("findjsontext");
        }else{
            modelAndView.addObject("code", -10);
            modelAndView.addObject("message", "find failed");
            // 指定视图"/WEB-INF/jsp/items/itemsList.jsp"
            modelAndView.setViewName("findjsontext");
        }
        return modelAndView;
    }

    //删除
    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public ModelAndView exquteDelete(@PathVariable long id, ModelAndView modelAndView) {
        logger.info("exquteDeleteId" + id);
        if(student.getId()==id){
            studentMapper.delete(id);
            modelAndView.addObject("code", 20);
            modelAndView.addObject("message", "delete success");
            modelAndView.setViewName("deletejsontext");
        }else{
            modelAndView.addObject("code", -21);
            modelAndView.addObject("message", "这条数据不存在");
            modelAndView.setViewName("deletejsontext");
        }
        return modelAndView;
    }
//修改
    @RequestMapping(value = "/student/{id}", method = RequestMethod.PUT)
    public ModelAndView exquteUpdate(@PathVariable long id, Student student) {
        logger.info("exquteUpdate:  " + student);
        if(student.getId()==id
                &&student.getName()!=null
                ||student.getNumber()!=0
                ||student.getQq()!=0
                || student.getCoachName()!=null
                ||student.getDailyLink()!=null
                ||student.getGradeColleage()!=null){
            if(secondStudentMapper.update(student)){
                student.setUpdate_at(System.currentTimeMillis());
                modelAndView.addObject("code", 30);
                modelAndView.addObject("message", "update success");
                modelAndView.setViewName("updatejsontext");
            }else{
                modelAndView.addObject("code", -30);
                modelAndView.addObject("message", "update failed");
                modelAndView.setViewName("updatejsontext");
            }
        }else{
            modelAndView.addObject("code", -31);
            modelAndView.addObject("message", "至少填写一个字段，不允许输入为空");
            modelAndView.setViewName("updatejsontext");
        }
        return modelAndView;
    }

    //增加数据
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public ModelAndView exquteAdd(Student student) {
        logger.info(student.toString());
        if(student.getName()!=null||student.getNumber()!=0||student.getQq()!=0||student.getCoachName()!=null||student.getDailyLink()!=null||student.getGradeColleage()!=null){
            student.setCreate_at(System.currentTimeMillis());
            student.setUpdate_at(System.currentTimeMillis());
            studentMapper.insert(student);
            modelAndView.addObject("code", 40);
            modelAndView.addObject("message", "insert success");
            modelAndView.setViewName("insertjsontext");
        }else{
            modelAndView.addObject("code", -40);
            modelAndView.addObject("message", "insert failed");
            modelAndView.setViewName("insertjsontext");
        }
        return modelAndView;
    }
}
