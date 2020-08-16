package com.demo.service;

import com.demo.dao.EmployeeDAO;
import com.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDao;

    public void setEmployeeDao(EmployeeDAO employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeDao.createEmployee(employee);
    }

    @Override
    public Employee getEmployee(int employeeId) {
        return employeeDao.getEmployee(employeeId);
    }

    @Override
    public void deleteEmployee(int employeeId) {
        employeeDao.deleteEmployee(employeeId);
    }

    @Override
    public void updateEmployeeByEmail(int employeeId, String newEmail) {
        employeeDao.updateEmployeeByEmail(employeeId, newEmail);
    }

    @Override
    public List<Employee> getAllEmployeeDetails() {
        return employeeDao.getAllEmployeeDetails();
    }

}
