
import com.jnshu.mapper.StudentMapper;
import com.jnshu.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration(locations = "classpath:applicationContext.xml")//加载xml文件
@RunWith(SpringJUnit4ClassRunner.class)
public class Test1 {
    @Autowired
    StudentMapper studentMapper;
    @Test
    public void insertTest(){
        Student student = new Student();
        student.setName("房峰");
        student.setQq(123244354);
        student.setNumber(1234242);
        student.setCoachName("易教练");
        student.setGradeColleage("北京大学");
        student.setDailyLink("http://localhost:8080/student/info");
        student.setCreate_at(System.currentTimeMillis());
        student.setUpdate_at(System.currentTimeMillis());
        for(int i = 0;i<=50;i++){
            studentMapper.insert(student);
        }
        System.out.println(student.getId());
    }
    @Test
    public void deleteTest(){
        boolean flag = studentMapper.delete(34);
        System.out.println(flag);
    }
    @Test
    public void updateTest(){
        Student student = new Student();
        student.setId(2);
        student.setName("马云");
        student.setQq(1379787767);
        student.setNumber(1379767767);
        student.setCoachName("易教练");
        student.setGradeColleage("杭州师范大学");
        student.setDailyLink("http://localhost:8080/student/info");
        student.setUpdate_at(System.currentTimeMillis());
        boolean flag = studentMapper.update(student);
        System.out.println(flag);
    }
    @Test
    public void findTest() {
        Student student = studentMapper.find(2);
        System.out.println(student);
    }
    @Test
    public void findAllTest(){
        List studentList = studentMapper.findAll();
        System.out.println(studentList);
    }

}
