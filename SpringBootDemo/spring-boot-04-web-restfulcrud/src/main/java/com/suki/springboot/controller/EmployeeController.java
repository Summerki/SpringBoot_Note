package com.suki.springboot.controller;

import com.suki.springboot.dao.DepartmentDao;
import com.suki.springboot.dao.EmployeeDao;
import com.suki.springboot.entities.Department;
import com.suki.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;




    // 查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();

        // 放进请求域中
        model.addAttribute("emps", employees);

        // thymeleaf默认就会拼串
        // classpath:/templates/emp/list.html
        return "emp/list";
    }


    @Autowired
    DepartmentDao departmentDao;

    // 来到添加员工页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        // 查出所有的部门，在页面上显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        // 来到添加页面
        return "emp/add";
    }


    // 员工添加功能
    // springmvc自动将请求参数和入参对象的属性进行一一绑定，要求请求参数的名字和javabean入参对象里面的属性名是一样的
    @PostMapping("/emp")
    public String addEmp(Employee employee){

        System.out.println("保存的员工信息：" + employee);
        // 保存员工
        employeeDao.save(employee);

        // 来到员工列表页面
        // redirect:重定向到一个地址  / 代表当前项目地址
        // forward:转发到一个地址
        return "redirect:/emps";
    }


    // 来到修改页面，查出当前员工，在页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id")Integer id, Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);

        // 查出所有的部门，在页面上显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);

        // 回到修改页面（add是一个修改添加二合一的页面）
        return "emp/add";
    }

    // 员工修改
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        System.out.println("修改的员工数据" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }


    // 员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
