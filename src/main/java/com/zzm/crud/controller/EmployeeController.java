package com.zzm.crud.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzm.crud.bean.Employee;
import com.zzm.crud.bean.Msg;
import com.zzm.crud.dao.EmployeeMapper;
import com.zzm.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @ResponseBody
    @RequestMapping("/emps")
    public Msg getEmpWithjson(@RequestParam(value = "pn",defaultValue = "5")Integer pn, Model model){

        PageHelper.startPage(pn,5);

        List<Employee> emps=employeeService.getAll();

        PageInfo pageInfo=new PageInfo(emps,5);

        return  Msg.success().add("pageInfo",pageInfo);

    }

    //@RequestMapping("/emps")
    public String getEmps(@RequestParam(value = "pn",defaultValue = "5")Integer pn, Model model){

        //分页查询调用
        PageHelper.startPage(pn,5);

        List<Employee> emps=employeeService.getAll();

        PageInfo pageInfo=new PageInfo(emps,5);


        model.addAttribute("pageInfo",pageInfo);


        return "list";
    }
}
