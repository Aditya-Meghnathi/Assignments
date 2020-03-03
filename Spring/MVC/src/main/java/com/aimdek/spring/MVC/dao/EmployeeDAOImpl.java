package com.aimdek.spring.MVC.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
 
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.aimdek.spring.MVC.model.Employee;
public class EmployeeDAOImpl implements EmployeeDAO {
 
    private JdbcTemplate jdbcTemplate;
 
    public EmployeeDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
 
    @Override
    public void saveOrUpdate(Employee employee) {
    	 if (employee.getId() > 0) {
    	        // update
    	        String sql = "UPDATE employee SET name=?, email=?, address=? "
    	                    + " WHERE employee_id=?";
    	        jdbcTemplate.update(sql, employee.getName(), employee.getEmail(),
    	                employee.getAddress(), employee.getId());
    	    } else {
    	        String sql = "INSERT INTO employee (name, email, address)"
    	                    + " VALUES (?, ?, ?)";
    	        jdbcTemplate.update(sql, employee.getName(), employee.getEmail(),
    	                employee.getAddress());
    	    }
    }
 
    @Override
    public void delete(int employeeId) {
    	String sql = "DELETE FROM employee WHERE employee_id=?";
        jdbcTemplate.update(sql, employeeId);
    }
 
    @Override
    public List<Employee> list() {
    	String sql = "SELECT * FROM employeedb.employee";
        List<Employee> listEmployee = jdbcTemplate.query(sql, new RowMapper<Employee>() {
     
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                Employee a = new Employee();
     
                a.setId(rs.getInt("employee_id"));
                a.setName(rs.getString("name"));
                a.setEmail(rs.getString("email"));
                a.setAddress(rs.getString("address"));
     
                return a;
            }
     
        });
     
        return listEmployee;
    }
 
    @Override
    public Employee get(int employeeId) {
    	String sql = "SELECT * FROM employee WHERE employee_id=" + employeeId;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Employee>() {
     
            @Override
            public Employee extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    Employee employee = new Employee();
                    employee.setId(rs.getInt("employee_id"));
                    employee.setName(rs.getString("name"));
                    employee.setEmail(rs.getString("email"));
                    employee.setAddress(rs.getString("address"));
                    return employee;
                }
     
                return null;
            }
     
        });
  }
 
}