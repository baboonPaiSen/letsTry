package com.gsk.thought;

import com.gsk.pojo.Class;
import com.gsk.pojo.School;
import com.gsk.pojo.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: TODO
 * @date: 2020/6/4 20:35
 * @author: ShangKun
 * @version: 2.0.0
 */
public class ForOTwice {

    private static School initData(){

        Class aClass = new Class();

        Class bClass = new Class();

        List<Student>  astudents = new ArrayList<>();

        List<Student>  bstudents = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            student.setAge(i);
            student.setStudentName("名字是"+i);

            if (i<5){
                astudents.add(student);
            }else {
                bstudents.add(student);
            }
        }

        aClass.setStudents(astudents);
        bClass.setStudents(bstudents);

        School school = new School();
        school.setClasses(Arrays.asList(aClass,bClass));

        return school;
    }


    public static void main(String[] args) {
        School school = initData();
        List<Class> classes = school.getClasses();

        String a = "电";
        for (int i = 0; i < 50; i++) {
            System.out.print(a);
        }

    }
}
