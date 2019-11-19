package com.learning.employee.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.learning.employee.model.Employee;
import com.learning.employee.model.StudentInfo;
import com.learning.employee.service.EmployeeService;
import com.netflix.discovery.EurekaClient;

@RefreshScope
@RestController
public class EmployeeSearchController {
   @Autowired
   EmployeeService employeeSearchService;
   
   @Autowired
   private EurekaClient eurekaClient;
   
   @Autowired
   private RestTemplate restTemplate;
   
   @RequestMapping("/employee/find/{id}")
   public StudentInfo findById(@PathVariable Long id){
	   String url = "http://192.168.0.18:8081" + "/" + "student/find/" + id;
       System.out.println("Student URL--> " + url);
       StudentInfo emp = restTemplate.getForObject(url, StudentInfo.class);

       return emp;
   }
   
   @RequestMapping("/employee/findall")
   public Collection<Employee> findAll(){
      return employeeSearchService.findAll();
   }
}