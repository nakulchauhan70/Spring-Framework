package com.demo.model;

import java.util.List;

public class StudentListAccessor {

	private List<String> studentNames;
	private List<Student> failedStudent;
	private Student thirdStudent;

	public List<String> getStudentNames() {
		return studentNames;
	}

	public void setStudentNames(List<String> studentNames) {
		this.studentNames = studentNames;
	}

	public List<Student> getFailedStudent() {
		return failedStudent;
	}

	public void setFailedStudent(List<Student> failedStudent) {
		this.failedStudent = failedStudent;
	}

	public Student getThirdStudent() {
		return thirdStudent;
	}

	public void setThirdStudent(Student thirdStudent) {
		this.thirdStudent = thirdStudent;
	}

}
