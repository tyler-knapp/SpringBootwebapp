package com.example.demo;

import com.example.demo.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JDBCEmployeeDAO implements EmployeeDAO {
 private JdbcTemplate jdbcTemplate;

 public JDBCEmployeeDAO(DataSource dataSource){
  this.jdbcTemplate = new JdbcTemplate(dataSource);
 }

 @Override
 public List<Employee> getAllEmployees() {
  String sql = "SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date from employee";
  SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
  List<Employee> employees = new ArrayList<Employee>();
  while(rows.next()){
   Employee employee = mapRowToEmployee(rows);
   employees.add(employee);
  }
  return employees;
 }
 
 private Employee mapRowToEmployee(SqlRowSet row){
  Employee employee = new Employee();

  employee.setId( row.getLong("employee_id"));
  employee.setHireDate( row.getDate("hire_date").toLocalDate());
  employee.setFirstName(row.getString("first_name"));
  employee.setLastName(row.getString("last_name"));
  employee.setBirthDay(row.getDate("birth_date").toLocalDate());

  return employee;
 }

}
