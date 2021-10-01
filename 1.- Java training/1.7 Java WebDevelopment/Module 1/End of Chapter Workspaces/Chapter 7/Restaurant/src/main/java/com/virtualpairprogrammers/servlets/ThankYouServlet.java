package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ThankYouServlet extends HttpServlet {

	
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//taking the session (cookie) from the request
		HttpSession session = request.getSession();
		//getAttribute returns an object object type so just cast it to the type you will need
		Double total = (Double) session.getAttribute("total");
		
		if (total == null) { // if an order hanst been created
			response.sendRedirect("/order.html"); // redirect to order
			return;
		}
		
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		out.println("<html><body><h1>Ricky's Restaurant</h1>");
		out.println("<h2>Order your food</h2>");
		
		out.println("Thank you - your order has been received. You need to pay $" + total);
				
		out.println("</body></html>");
		out.close();
		
	}
}
