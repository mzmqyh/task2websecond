package com.jnshu.mapper;

import com.jnshu.entity.Student;

public interface ThirdStudentMapper {
    boolean updateStudent(Student student);
    Student getStudentById(Long id);
}
