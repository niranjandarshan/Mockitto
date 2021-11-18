package com.calcsum;

import javax.servlet.http.HttpSession;

public class Calculator {
	HttpSession session;
	//session.getattribute("num1");
	
	String predict=(String)session.getAttribute("predict");
	String sum=(String)session.getAttribute("sum");
	String n1=(String)session.getAttribute("num1");
	String n2=(String)session.getAttribute("num2");
	CalculatorService service;
	
	public Calculator(CalculatorService service){
		this.service=service;
	}
	
	public int perform(int i,int j){
		
		return service.add(i,j);
	}

	

}
