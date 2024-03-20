package com.csi.service;

import com.csi.model.Employee;
import com.csi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee signUp(Employee employee) {
        return employeeRepository.save(employee);
    }

    public boolean signIn(String email, String password) {
        boolean flag = false;

        Employee employee = employeeRepository.findByEmpEmailIdAndEmpPassword(email, password);

        if (employee != null && employee.getEmpEmailId().equals(email) && employee.getEmpPassword().equals(password)) {
            flag = true;
        }

        return flag;
    }

    public Optional<Employee> findById(int empId) {
        return employeeRepository.findById(empId);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteById(int empId) {
        employeeRepository.deleteById(empId);
    }


}
