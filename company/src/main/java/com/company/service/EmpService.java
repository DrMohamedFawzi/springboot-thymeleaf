package com.company.service;

import com.company.entity.Employee;
import com.company.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {

    @Autowired
    private EmpRepository empRepository;

    public void addEmp(Employee employee){
        empRepository.save(employee);
    }

    public List<Employee> getAllEmp(){
        return empRepository.findAll();
    }

    public Employee getEmployeeFindById(int id){
        Optional<Employee> employee = empRepository.findById(id);
        if (employee.isPresent()){
            return employee.get();
        }else{
            throw new NullPointerException("Employee not found in this id = " + id + "!");
        }
    }

    public void deleteEmpById(int id){
        empRepository.deleteById(id);
    }

    public List<Employee> getEmployeesByHint(String hint){
        return empRepository.findEmployeeByHint(hint);
    }
}
