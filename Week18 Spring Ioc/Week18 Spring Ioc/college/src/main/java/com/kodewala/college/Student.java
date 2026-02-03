package com.kodewala.college;

public class Student {
   private String studentName;
   private String studentId;
   private String subject;
   
   
   public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return ("studentName "+studentName+" "+"studentId "+studentId+" "+"subject "+subject);
		}
}
