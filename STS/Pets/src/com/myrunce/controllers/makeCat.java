package com.myrunce.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myrunce.models.Cat;

/**
 * Servlet implementation class makeCat
 */
@WebServlet("/makeCat")
public class makeCat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public makeCat() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String breed = request.getParameter("breed");
		int weight = Integer.parseInt(request.getParameter("weight"));
		
		Cat cat = new Cat(name, breed, weight);
		
		request.setAttribute("cat", cat);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/cat.jsp");
		view.forward(request, response);
	}

}
