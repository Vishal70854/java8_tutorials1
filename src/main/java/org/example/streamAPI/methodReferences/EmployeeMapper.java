package org.example.streamAPI.methodReferences;

public class EmployeeMapper {

    public EmployeeDO convert(Employee employee){
        EmployeeDO employeeDO = new EmployeeDO();
        employeeDO.setId(employee.getId());
        employeeDO.setName(employee.getName());
        employeeDO.setSalary(employee.getSalary());
        return employeeDO;
    }

}
