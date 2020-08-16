package com.demo.dao;

import com.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

@Repository
public class EmployeeDAOImpl extends JdbcDaoSupport implements EmployeeDAO {

    //We are not allowed to set jdbctemplete because it is already final in JdbcDaoSupport but you can autowire it
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//	
//	//Making call to super class jdbcTemplate
//	@PostConstruct
//	public void init() {
//		setJdbcTemplate(jdbcTemplate);
////		and use jdbcTemplate
//	}


    //Or Inject datasource
    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void init() {
        setDataSource(dataSource);
        //and use getJdbcTemplate()
    }

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

}
