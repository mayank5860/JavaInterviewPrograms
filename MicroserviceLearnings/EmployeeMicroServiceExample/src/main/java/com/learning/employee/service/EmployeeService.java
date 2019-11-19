package com.learning.employee.service;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.learning.employee.model.Employee;

@Service
public class EmployeeService {
	private static Map< Long, Employee > EmployeeRepsitory = null;
    static {
        Stream< String > employeeStream = Stream.of("1,Employee  Mitra,Java,Architect", "2,Samir Employee Mitra,C++,Manager",
            "3,Swastika  Employee,AI,Sr.Architect");
        EmployeeRepsitory = employeeStream.map(employeeStr -> {
            String[] info = employeeStr.split(",");
            return createEmployee(new Long(info[0]), info[1], info[2], info[3]);
        }).collect(Collectors.toMap(Employee::getEmployeeId, emp -> emp));
    }
    
    private static Employee createEmployee(Long id, String name, String practiceArea, String designation) {
        Employee emp = new Employee();
        emp.setEmployeeId(id);
        emp.setName(name);
        emp.setPracticeArea(practiceArea);
        emp.setDesignation(designation);
        emp.setCompanyInfo("Cognizant");
        return emp;
    }
    
    public Employee findById(Long id) {
    	
        return EmployeeRepsitory.get(id);
    }
    
    public Collection < Employee > findAll() {
        return EmployeeRepsitory.values();
    }
}
