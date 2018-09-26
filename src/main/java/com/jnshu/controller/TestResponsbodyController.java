package com.jnshu.controller;

import com.jnshu.entity.MyException;
import com.jnshu.entity.StateMessage;
import com.jnshu.entity.Student;
import com.jnshu.mapper.StudentMapper;
import com.jnshu.mapper.ThirdStudentMapper;
import org.apache.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/responsbodytest")
public class TestResponsbodyController {
    org.apache.log4j.Logger logger = LogManager.getLogger(StudentController.class.getName());

    @Autowired
    StudentMapper studentMapper;
//    @Autowired
//    SecondStudentMapper secondStudentMapper;

    @Autowired
    private ThirdStudentMapper thirdStudentMapper;

    Map<String, String> map = new HashMap<>();

    @ResponseBody//查找全部
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public Map<String, Object> findAllJson() {
        Map<String, Object> map = new HashMap<>();
        if (studentMapper.total() > 0) {
            logger.info("正在查找.......");
            List<Student> stulist = studentMapper.findAll();
            map.put("code", "1");
            map.put("message", "findAll success");
            map.put("student", stulist);
        } else {
            map.put("code", "-1");
            map.put("message", "findAll failed");
        }
        logger.info(map);
        return map;
    }

    @ResponseBody//查找单个
    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public Map excuteFind(@PathVariable long id) {
        logger.info("excuteFind===" + id);
        if (id > 0) {
            Student stulist = studentMapper.find(id);
            map.put("code", "10");
            map.put("message", "find success");
            map.put("student", stulist.toString());
        } else {
            MyException stateMessage = new MyException(StateMessage.FIND_ALL_SUCESS);
            stateMessage.getExceptionEnums().getCode();
            stateMessage.getExceptionEnums().getMessage();

            map.put("code", "-10");
            map.put("message", "find failed");
        }
        return map;
    }

    @ResponseBody//删除
    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public Map exquteDelete(@PathVariable long id, ModelAndView modelAndView) {
        logger.info("exquteDeleteId" + id);
        if (id > 0) {
            studentMapper.delete(id);
            map.put("code", "20");
            map.put("message", "delete success");
        } else {
            map.put("code", "-21");
            map.put("message", "这条数据不存在");
        }
        return map;
    }

    @ResponseBody//修改
    @RequestMapping(value = "/student/{id}", method = RequestMethod.PUT)
    public Map exquteUpdate(@PathVariable long id, Student student) {
        logger.info("exquteUpdate:  " + student);
        if (id > 0 && (student.getName() != null
                || student.getNumber() != 0
                || student.getQq() != 0
                || student.getCoachName() != null
                || student.getDailyLink() != null
                || student.getGradeColleage() != null)) {
            logger.info("exquteUpdate: here=== ");
            Student oldStudent = thirdStudentMapper.getStudentById(id);
            logger.info("oldStudent==="+oldStudent);
            if (oldStudent != null) {
                if (student.getName() != null) {
                    oldStudent.setName(student.getName());
                }
                if (student.getNumber() != 0) {
                    oldStudent.setNumber(student.getNumber());
                }
                if (student.getQq() != 0) {
                    oldStudent.setQq(student.getQq());
                }
                if (student.getCoachName() != null) {
                    oldStudent.setCoachName(student.getCoachName());
                }
                if (student.getDailyLink() != null) {
                    oldStudent.setDailyLink(student.getDailyLink());
                }
                if (student.getGradeColleage() != null) {
                    oldStudent.setGradeColleage(student.getGradeColleage());
                }
                oldStudent.setUpdate_at(System.currentTimeMillis());

                if (thirdStudentMapper.updateStudent(oldStudent)) {
                    map.put("code", "30");
                    map.put("message", "update success");
                } else {
                    map.put("code", "-30");
                    map.put("message", "update failed");
                }
            } else {
                map.put("code", "-10");
                map.put("message", "id wrong");
            }
        } else {
            map.put("code", "-31");
            map.put("message", "至少填写一个字段，不允许输入为空");
        }
        return map;
    }

    @ResponseBody//增加数据
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public Map exquteAdd(Student student) {
        logger.info("exquteAdd==="+student);
        if (student.getName() != null
                || student.getNumber() != 0
                || student.getQq() != 0
                || student.getCoachName() != null
                || student.getDailyLink() != null
                || student.getGradeColleage() != null) {
            studentMapper.insert(student);
            student.setCreate_at(System.currentTimeMillis());
            student.setUpdate_at(System.currentTimeMillis());
            map.put("code", "0");
            map.put("message", "insert success");
        } else {
            map.put("code", "-40");
            map.put("message", "insert failed");
        }
//        student.setCreate_at(System.currentTimeMillis());
//        student.setUpdate_at(System.currentTimeMillis());
//        studentMapper.insert(student);
//        map.put("code", "0");
//        map.put("message", "insert success");
        return map;
    }
}
