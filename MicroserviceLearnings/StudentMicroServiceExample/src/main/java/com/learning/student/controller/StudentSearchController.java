package com.learning.student.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.learning.student.model.Employee;
import com.learning.student.model.Student;
import com.learning.student.service.StudentService;

@RefreshScope
@RestController
public class StudentSearchController {
   @Autowired
   StudentService studentSearchService;
   
   @Autowired
   private RestTemplate restTemplate;
   
   @RequestMapping("/student/find/{id}")
   public Student findById(@PathVariable Long id){
      return studentSearchService.findById(id);
   }
   
   @RequestMapping("/student/findall")
   public Collection<Employee> findAll(){
	   String url = "http://192.168.0.18:8080/employee/findall";
       System.out.println("Employee URL" + url);
       Collection<Employee> emp = restTemplate.getForObject(url, Collection.class);

       return emp;
   }
}