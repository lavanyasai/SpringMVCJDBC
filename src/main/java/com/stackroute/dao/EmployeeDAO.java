package com.stackroute.dao;

import com.stackroute.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(Employee employee){
        String sql="insert into employeetbl(id, name, age, gender) values("+employee.getId() + ",'" +employee.getName()+"',"+employee.getAge()+",'"+employee.getGender()+"')";
        System.out.println(sql);
        return jdbcTemplate.update(sql);
    }

    public int update(Employee employee){
        String sql="update employeetbl set name='"+employee.getName()+ "',age='"+employee.getAge()+"',gender='"+employee.getGender()+"' where id="+employee.getId();
        System.out.println(sql);
        return jdbcTemplate.update(sql);
    }

    public int delete(int id){
        String sql="delete from employeetbl where id="+id+"";
        return jdbcTemplate.update(sql);
    }

    public Employee getEmployeeById(int id){
        String sql="select * from employeetbl where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Employee>(Employee.class));
    }

    public List<Employee> getEmployees(){
        return jdbcTemplate.query("select * from employeetbl",new RowMapper<Employee>(){
            public Employee mapRow(ResultSet rs, int row) throws SQLException {
                Employee e=new Employee();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setAge(rs.getInt(3));
                e.setGender(rs.getString(4));
                return e;
            }
        });
    }
}
