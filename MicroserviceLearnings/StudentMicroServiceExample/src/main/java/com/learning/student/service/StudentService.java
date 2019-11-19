package com.learning.student.service;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.learning.student.model.Student;

@Service
public class StudentService {
	private static Map< Long, Student > StudentRepsitory = null;
    static {
        Stream< String > employeeStream = Stream.of("1,Shashmita Student Mitra,Java,Architect", "2,Sohan Student Mitra,C++,Manager",
            "3,Sharma Student Mitra,AI,Sr.Architect");
        StudentRepsitory = employeeStream.map(employeeStr -> {
            String[] info = employeeStr.split(",");
            return createEmployee(new Long(info[0]), info[1], info[2], info[3]);
        }).collect(Collectors.toMap(Student::getStudentId, emp -> emp));
    }
    
    private static Student createEmployee(Long id, String name, String practiceArea, String designation) {
        Student emp = new Student();
        emp.setStudentId(id);
        emp.setName(name);
        emp.setPracticeArea(practiceArea);
        emp.setDesignation(designation);
//        emp.setCompanyInfo("Cognizant");
        return emp;
    }
    
    public Student findById(Long id) {
    	
        return StudentRepsitory.get(id);
    }
    
    public Collection < Student > findAll() {
        return StudentRepsitory.values();
    }
}
