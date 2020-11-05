package com.huang.controller;

import com.huang.dao.DepartmentDao;
import com.huang.dao.EmployeeDao;
import com.huang.pojo.Department;
import com.huang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddpage(Model model) {
        //查出所有部门信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee, Model model) {
        //添加操作 forward
        System.out.println("emp=>" + employee);
        employeeDao.save(employee);//调用底层方法保存员工信息
        return "redirect:/emps";
    }

    //去员工的修改页面
    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id") Integer id, Model model) {
        //查出原来的数据
        System.out.println(id);
        Employee employeeById = employeeDao.getEmployeeById(id);
        model.addAttribute("emp", employeeById);

        //查出所有部门信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);

        System.out.println(employeeById);
        return "emp/update";
    }

    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee) {
        employeeDao.save(employee);//由于只是案例局限.没有考虑id问题
        return "redirect:/emps";
    }

    //删除员工
    @GetMapping("/delemp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id, Model model) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
