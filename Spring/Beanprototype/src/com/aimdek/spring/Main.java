package com.aimdek.spring;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
	      @SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	      PrintHi objA = (PrintHi) context.getBean("printhi");
	      objA.setMessage("hiiiiiiiii");
	      objA.getMessage();
	      PrintHi objB = (PrintHi) context.getBean("printhi");
	      objB.getMessage();
	   }
}
