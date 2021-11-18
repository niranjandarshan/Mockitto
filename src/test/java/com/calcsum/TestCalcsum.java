package com.calcsum;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.junit.Before;
import org.junit.Test;


public class TestCalcsum {
	HttpSession session;
	//session.getattribute("num1");

	
	//String sum=(String)session.getAttribute("sum");
	
	Calculator c=null;
	
//	CalculatorService service=new CalculatorService(){
//
//		public int add(int i, int j) {
//			// TODO Auto-generated method stub
//			return 0;
//		}
//		
//	};
	
	CalculatorService service =mock(CalculatorService.class);
	@Before
	public void setUp(){
		
		c=new Calculator(service);
		
	}
	@Test
	public void testadd(int i,int j,int predict){
		
		when(service.add(i, j)).thenReturn(predict);
		assertEquals("<script> alert('Enter Reference Type Name!');</script>",predict,c.perform(i, j)
				 
				);
	
		verify(service).add(i, j);
	}

}
