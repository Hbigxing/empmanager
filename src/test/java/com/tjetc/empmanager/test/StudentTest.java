package com.tjetc.empmanager.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.tjetc.empmanager.domain.Student;

public class StudentTest {
    public static void main(String[] args) {
        Student student1=new Student("大白",1001);
        Student student2=new Student("小白",1002);
        student1.setStudent(student2);
        student2.setStudent(student2);
        JSON.DEFAULT_GENERATE_FEATURE|= SerializerFeature.DisableCircularReferenceDetect.getMask();
        String str=JSON.toJSONString(student1,SerializerFeature.PrettyFormat);
        System.out.println(str);
        String str1=JSON.toJSONString(student2,SerializerFeature.PrettyFormat);
        System.out.println(str1);
    }
}
