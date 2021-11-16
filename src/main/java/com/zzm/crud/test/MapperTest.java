package com.zzm.crud.test;

import com.zzm.crud.bean.Department;
import com.zzm.crud.bean.Employee;
import com.zzm.crud.dao.DepartmentMapper;
import com.zzm.crud.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlSession;

    @Test
    public void test(){
//        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
//        applicationContext.getBean(Department.class);



        //部门插入
   /*     Department department=new Department(1,"开发部");
        Department department1=new Department(2,"测试部");
        departmentMapper.insertSelective(department);
        departmentMapper.insertSelective(department1);*/


        //员工插入

        employeeMapper=sqlSession.getMapper(EmployeeMapper.class);
        //employeeMapper.insertSelective(new Employee(null,"zhiming","M","985153283@qq.com",1));


        for(int i=0;i<1000;i++){
            String uid=UUID.randomUUID().toString().substring(0,5)+i;
            employeeMapper.insertSelective(new Employee(null,uid,"M",uid+"@qq.com",1));

        }
        System.out.println("完成");
        //批量插入 sqlSession 配置一个




    }
}
