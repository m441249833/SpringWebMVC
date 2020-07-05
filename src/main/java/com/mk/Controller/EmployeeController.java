package com.mk.Controller;

import com.mk.Dao.DepartmentRepository;
import com.mk.Dao.EmployeeRepository;
import com.mk.Entity.Employee;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;


    @GetMapping("")
    public String indexPage(){
        return "Employee/index";
    }

    @GetMapping("/all")
    public String getAllEmployee(Model model){
        model.addAttribute("employees",employeeRepository.findAll());
        return "Employee/employee";
    }

    @GetMapping("/id")
    public String getEmployeeById(@RequestParam("employeeId") String employeeId,Model model){
        if (employeeId.trim().length() == 0) {
            model.addAttribute("errorMsg","Please enter an ID.");
            return "Employee/searchError";
        }
        Long employeeId1;
        try {
            employeeId1 = Long.parseLong(employeeId.trim());
        } catch (NumberFormatException e) {
            model.addAttribute("errorMsg","ID format incorrect.");
            return "Employee/searchError";
        }
        Optional<Employee> result = employeeRepository.findById(employeeId1);
        if (result.isEmpty()){
            model.addAttribute("errorMsg","Employee Not Found.");
            return "Employee/searchError";
        }else {
            List<Employee> l = new ArrayList<>();
            l.add(result.get());
            model.addAttribute("employees",l);
        }
        return "Employee/employee";
    }

    @GetMapping("/create")
    public String createEmployeeRender(Model model){
        model.addAttribute("departments",departmentRepository.findAll());
        return "Employee/createEmployee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(Employee employee, Model model){
        try{
            employeeRepository.save(employee);
            model.addAttribute("successMsg","Employee saved!");
        }catch (Exception e){
            model.addAttribute("errorMsg","Failed!");
        }
        return "Employee/createEmployee";
    }

    @GetMapping("/delete")
    public String deleteEmployeeRender(Model model){
        return "Employee/deleteEmployee";
    }

    @PostMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") Long employeeId, Model model){
        Optional<Employee> result = employeeRepository.findById(employeeId);
        if (result.isEmpty()){
            model.addAttribute("errorMsg","No result found.");
        }else {
            employeeRepository.delete(result.get());
            model.addAttribute("successMsg","Deleted.");
        }
        return "Employee/deleteEmployee";
    }

    @GetMapping("/department")
    public String departmentRender(Model model){
        model.addAttribute("departments",departmentRepository.findAll());
        return "Employee/department";
    }

}
