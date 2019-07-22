package com.stackroute.controller;

import com.stackroute.dao.EmployeeDAO;
import com.stackroute.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @RequestMapping("/getEmployeeForm")
    public String showform(Model m){
        m.addAttribute("employeea", new Employee());
        return "addNewEmployee";
    }

    @RequestMapping("/viewEmployees")
    public String viewEmployees(Model model) {
        List<Employee> employeeList = employeeDAO.getEmployees();
        model.addAttribute("employeeList", employeeList);
        return "viewEmployees";
    }

    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String save(@ModelAttribute("Employee") Employee employee){
        employeeDAO.save(employee);
        return "redirect:/viewEmployees";
    }

    @RequestMapping(value="/editEmployee/{id}")
    public String edit(@PathVariable int id, Model m){
        Employee employee=employeeDAO.getEmployeeById(id);
        m.addAttribute("employee",employee);
        return "employeeEditForm";
    }

    @RequestMapping(value="/editSave", method = RequestMethod.POST)
    public String editSave(@ModelAttribute("Employee") Employee employee){
        System.out.println(employee);
        employeeDAO.update(employee);
        return "redirect:/viewEmployees";
    }

    @RequestMapping(value="/deleteEmployee/{id}")
    public String delete(@PathVariable int id){
        employeeDAO.delete(id);
        return "redirect:/viewEmployees";
    }
}
