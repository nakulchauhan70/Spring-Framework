package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.demo.model.StudentListAccessor;

public class ApplicationContextDemo {

	public static void main(String[] args) {

		ApplicationContext appContext = new FileSystemXmlApplicationContext("/SpringELCollection/src/main/resources/Bean.xml");

		StudentListAccessor studentListAccessor = appContext.getBean("studentListAccessor", StudentListAccessor.class);

		System.out.println(studentListAccessor.getStudentNames()+"\n"+studentListAccessor.getThirdStudent()+"\n"+studentListAccessor.getFailedStudent());
		
		((AbstractApplicationContext) appContext).close();

	}

}
