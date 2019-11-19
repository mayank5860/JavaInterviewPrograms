package com.learning.employee.model;

public class StudentInfo {
	   private Long studentId;
	   private String name;
	   private String practiceArea;
	   private String designation;
	   private String companyInfo;
	   public Long getStudentId() {
	      return studentId;
	   }
	   public void setStudentId(Long studentId) {
	      this.studentId = studentId;
	   }
	   public String getName() {
	      return name;
	   }
	   public void setName(String name) {
	      this.name = name;
	   }
	   public String getPracticeArea() {
	      return practiceArea;
	   }
	   public void setPracticeArea(String practiceArea) {
	      this.practiceArea = practiceArea;
	   }
	   public String getDesignation() {
	      return designation;
	   }
	   public void setDesignation(String designation) {
	      this.designation = designation;
	   }
	   public String getCompanyInfo() {
	      return companyInfo;
	   }
	   public void setCompanyInfo(String companyInfo) {
	      this.companyInfo = companyInfo;
	   }
	   @Override
	   public String toString() {
	      return "Employee [employeeId=" + studentId + ", name=" + name + ", practiceArea=" + practiceArea
	              + ", designation=" + designation + ", companyInfo=" + companyInfo + "]";
	   }
	}