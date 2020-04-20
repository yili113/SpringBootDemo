package cqupt.springboot.controller;

import cqupt.springboot.dao.DepartmentDao;
import cqupt.springboot.dao.EmployeeDao;
import cqupt.springboot.entities.Department;
import cqupt.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * @author Liyi
 * @create 2020-04-20 10:52
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    // 返回全体员工的信息
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        // 把从dao层拿到的数据放到请求域中
        model.addAttribute("emps", employees);
        // thymeleaf模板引擎会自动拼串，返回到那个页面
        return "emp/list";
    }


    // 添加员工页面
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        // 先查出不同的部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";// 跳转到添加员工页面
    }
    // 添加员工
    // SpringMVC自动将请求参数和入参对象的属性进行一一绑定；要求请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
//        System.out.println(employee);
        // 保存员工数据
        employeeDao.save(employee);

        // 添加完后要跳转到员工列表页面emps
        // redirect重定向
        // forward转发
        return "redirect:/emps";
    }
    // 来到修改页面，查出当前员工，在页面上进行回显
    @GetMapping("/emp/{id}")
    public String editEmp(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);// 将根据id查到的emp放进视图中

        // 页面显示不同的部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";// 跳转到add页面，让add与edit操作用同一个页面
    }
    // 员工修改
    @PutMapping("/emp")
    public String updateEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";// 修改完跳转到员工列表页面
    }
    // 删除员工
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
