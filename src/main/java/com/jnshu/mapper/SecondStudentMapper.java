package com.jnshu.mapper;

import com.jnshu.entity.Student;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import com.jnshu.StudentDynaSqlProvider;

import java.util.List;

public interface SecondStudentMapper {
    @InsertProvider(type=StudentDynaSqlProvider.class,method="add")
    public int add(Student student);
    @DeleteProvider(type=StudentDynaSqlProvider.class,method="delete")
    public void delete(long id);
    @SelectProvider(type=StudentDynaSqlProvider.class,method="get")
    public Student get(long id);
    @UpdateProvider(type=StudentDynaSqlProvider.class,method="update")
    public boolean update(Student student);
    @SelectProvider(type=StudentDynaSqlProvider.class,method="list")
    public List<Student> list();
}
