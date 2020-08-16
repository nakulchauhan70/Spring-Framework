package com.demo;

import com.demo.model.Employee;
import com.demo.service.EmployeeService;
import com.demo.service.EmployeeServiceImpl;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.List;

public class AbstractApplicationContextDemo {

    public static void main(String[] args) {

        AbstractApplicationContext appContext = new FileSystemXmlApplicationContext("/SpringWithJdbcDaoSupportUsingXML/src/main/resources/Bean.xml");
        EmployeeService employeeService = appContext.getBean("employeeService", EmployeeServiceImpl.class);

        createEmployee(employeeService);

        getEmployeeById(employeeService);

        getAllEmployees(employeeService);

        updateEmployee(employeeService);

        deleteEmployee(employeeService);

        appContext.close();
    }

    private static void deleteEmployee(EmployeeService employeeService) {
        employeeService.deleteEmployee(1);
    }

    private static void updateEmployee(EmployeeService employeeService) {
        employeeService.updateEmployeeByEmail(1, "nakulc2095@gmail.com");
    }

    private static void getAllEmployees(EmployeeService employeeService) {
        List<Employee> empList = employeeService.getAllEmployeeDetails();
        empList.forEach(System.out::println);
    }

    private static void getEmployeeById(EmployeeService employeeService) {
        Employee emp = employeeService.getEmployee(1);
        System.out.println(emp);
    }

    private static void createEmployee(EmployeeService employeeService) {
        Employee employee = new Employee();
        employee.setEmployeeName("Nakul Chauhan");
        employee.setEmail("nkulic20@gmail.com");
        employee.setGender("male");
        employee.setSalary(10000);
        employeeService.createEmployee(employee);
    }

}
