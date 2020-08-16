package com.demo.dao;

import com.demo.model.Employee;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class EmployeeDAOImpl extends JdbcDaoSupport implements EmployeeDAO {

    @Override
    public void createEmployee(Employee employee) {

        int update = getJdbcTemplate().update("INSERT INTO `management`.`employee` (`emp_name`, `salary`, `email`, `gender`) VALUES (?, ?, ?, ?)", employee.getEmployeeName(), employee.getSalary(), employee.getEmail(), employee.getGender());

        if (update > 0) {
            System.out.println("Employee created successfully.");
        } else {
            System.out.println("Employee is unable to create");
        }

    }

    @Override
    public Employee getEmployee(int employeeId) {
        String sql = "SELECT * FROM `management`.`employee` WHERE emp_id = ?";
        Employee emp = getJdbcTemplate().queryForObject(sql, new EmployeeRowMapper(), employeeId);
        return emp;
    }

    @Override
    public void deleteEmployee(int employeeId) {
        String sql = "DELETE FROM `management`.`employee` WHERE emp_id = ?";
        int delete = getJdbcTemplate().update(sql, employeeId);

        if (delete > 0) {
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee is unable to delete");
        }
    }

    @Override
    public void updateEmployeeByEmail(int employeeId, String newEmail) {
        String sql = "UPDATE `management`.`employee` SET email = ? WHERE emp_id = ?";
        int update = getJdbcTemplate().update(sql, newEmail, employeeId);

        if (update > 0) {
            System.out.println("Employee updated successfully.");
        } else {
            System.out.println("Employee is unable to update");
        }

    }

    @Override
    public List<Employee> getAllEmployeeDetails() {
        String sql = "SELECT * FROM `management`.`employee`";
        List<Employee> empList = getJdbcTemplate().query(sql, new EmployeeRowMapper());
        return empList;

    }


//	@Override
//	public void createEmployee(Employee employee) {
//		Connection connection = null;
//		PreparedStatement ps = null;
//		try {
//			connection = dataSource.getConnection();
//			
//			String sql = "INSERT INTO `management`.`employee` (`emp_name`, `salary`, `email`, `gender`) VALUES (?, ?, ?, ?)";
//			ps = connection.prepareStatement(sql);
//			
//			ps.setString(1, employee.getEmployeeName());
//			ps.setDouble(2, employee.getSalary());
//			ps.setString(3, employee.getEmail());
//			ps.setString(4, employee.getGender());
//		
//			int executeUpdate = ps.executeUpdate();
//			
//			if(executeUpdate>0) {
//				System.out.println("Employee created successfully.");
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if(connection != null) {
//				try {
//					connection.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//
//	}


}
