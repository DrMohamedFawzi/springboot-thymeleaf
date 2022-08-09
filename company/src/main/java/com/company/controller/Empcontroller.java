package com.company.controller;

import com.company.entity.Employee;
import com.company.entity.util.Hint;
import com.company.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class Empcontroller {
    @Autowired
    private EmpService empService;

    @GetMapping("/")
    public String home(Model model, @ModelAttribute Hint hint){
        List<Employee> employees;
        System.out.println("Hint: " + hint.getHint());
        if (hint.getHint() == null){
            employees = empService.getAllEmp();
        }else{
            System.out.println("Hint isn't null!");
            employees = empService.getEmployeesByHint(hint.getHint());
        }

        model.addAttribute("emps", employees);
        return "index";
    }

    @GetMapping("/addemp")
    public String addEmp(){
        return "add_emp";
    }

    @PostMapping("/register")
    public String empRegister(@ModelAttribute Employee employee, HttpSession session){
        empService.addEmp(employee);

        String successMsg = "Employee Added Successfully!";
        session.setAttribute("msg", successMsg);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editEmp(@PathVariable int id, Model model){
        Employee employee = empService.getEmployeeFindById(id);
        model.addAttribute("emp", employee);

        return "edit";
    }

    @PostMapping("/update")
    public String updateEmp(@ModelAttribute Employee employee, HttpSession session){
        empService.addEmp(employee);
        String successMsg = "Employee updated is Successfully!";

        session.setAttribute("msg", successMsg);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmp(@PathVariable int id, HttpSession session){
        empService.deleteEmpById(id);
        String successMsg = "Employee deleted is Successfully!";

        session.setAttribute("msg", successMsg);
        return "redirect:/";
    }
}
