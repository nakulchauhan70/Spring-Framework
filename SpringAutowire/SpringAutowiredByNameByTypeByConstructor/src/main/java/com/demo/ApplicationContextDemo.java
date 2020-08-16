package com.demo;

import com.demo.model.Account;
import com.demo.model.Employee;
import com.demo.model.Pancard;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ApplicationContextDemo {

	public static void main(String[] args) {

		ApplicationContext appContext = new FileSystemXmlApplicationContext("/SpringAutowiredByNameByTypeByConstructor/src/main/resources/Bean.xml");

		System.out.println("///////////////////////Autowire by name and by type//////////////////////");
		
		Employee employee = appContext.getBean("employee", Employee.class);
		System.out.println(employee.getClass().getSimpleName()+":\t"+employee.getId()+"\t"+employee.getName()+"\t"+employee.getEmail()+"\t"+employee.getAge()+"\t"+employee.getPancard());
		
		Pancard pancard = employee.getPancard();
		System.out.println(pancard.getClass().getSimpleName()+":\t"+pancard.getPanNo()+"\t"+pancard.getPanName());
		System.out.println("\n");
		
		System.out.println("//////////////////////////Autowire constructor/////////////////////////");
		
		Account account = appContext.getBean("account", Account.class);
		System.out.println(account.getClass().getSimpleName()+":\t"+account.getAccNo()+"\t"+account.getAccHolderName());
		
		Pancard pancard1 = account.getPan();
		System.out.println(pancard1.getClass().getSimpleName()+":\t"+pancard1.getPanNo()+"\t"+pancard1.getPanName());


		((AbstractApplicationContext) appContext).close();
	}

}
