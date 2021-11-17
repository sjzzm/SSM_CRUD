package com.zzm.crud.controller;


import com.zzm.crud.bean.Department;
import com.zzm.crud.bean.Msg;
import com.zzm.crud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @ResponseBody
    @RequestMapping("/depts")
    public Msg getDepts(){
        List<Department> departments=departmentService.getDepts();
        return Msg.success().add("depts",departments);
    }
}
