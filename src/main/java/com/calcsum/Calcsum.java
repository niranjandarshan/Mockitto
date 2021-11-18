package com.calcsum;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Servlet implementation class Calcsum
 */
@WebServlet("/Calcsum")

public class Calcsum extends Mockito {
	private static final long serialVersionUID = 10236548L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calcsum() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	
	Calculator c=null;
	CalculatorService service =mock(CalculatorService.class);
	@Before
	public void setUp(){
		
		c=new Calculator(service);
		
	}
	@Test
    public void testServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    
        
        int i=Integer.parseInt(request.getParameter("num1"));
		int j=Integer.parseInt(request.getParameter("num2"));
		
		int predict=Integer.parseInt(request.getParameter("predict"));
		
		 
		   
		   when(service.add(i, j)).thenReturn(predict);
        doPost(request, response);
        verify(service).add(i, j);
        assertEquals("<script> alert('Enter Reference Type Name!');</script>",predict,c.perform(i,j)
				 
				);
    }

}
