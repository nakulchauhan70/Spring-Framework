package com.demo.dao;

import com.demo.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int rowNo) throws SQLException {

        Employee emp = new Employee();
        emp.setEmployeeId(rs.getInt("emp_id"));
        emp.setEmployeeName(rs.getString("emp_name"));
        emp.setSalary(rs.getDouble("salary"));
        emp.setEmail(rs.getString("email"));
        emp.setGender(rs.getString("gender"));

        return emp;
    }


}
