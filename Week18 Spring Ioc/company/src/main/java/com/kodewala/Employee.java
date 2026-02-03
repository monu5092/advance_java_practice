package com.kodewala;

public class Employee {
     private String employeeName;
     private String employeeId;
     private String role;
     private int salary;
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
     
     @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return ("EmployeeName-> "+this.employeeName+"\nEmployeeId-> "+employeeId+"\nRole-> "+role+"\nsalary-> "+salary);
    }
}
