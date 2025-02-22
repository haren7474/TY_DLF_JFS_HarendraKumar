package edu.jspiders.attribuesproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s5")
public class Servlet5 extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		ServletContext context= getServletContext();
		ArrayList<Character> al= (ArrayList<Character>) context.getAttribute("contextAl");
		
		PrintWriter out = resp.getWriter();
	
		out.print("<html><head></head><body><h1>This is Servlet5 Response</h1>");
		
		for (Character ch : al) 
		{
			out.print("<h2>" + ch + "</h2>");
		}
		out.print("</body></html>");	
	}
}
