package com.zzm.crud.service;

import com.zzm.crud.bean.Employee;
import com.zzm.crud.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;



    /*
    所有员工查询
    * */
    public List<Employee> getAll() {


        return employeeMapper.selectByExampleWithDept(null);




    }
}
