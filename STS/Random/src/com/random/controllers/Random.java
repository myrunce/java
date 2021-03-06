package com.random.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Random
 */
@WebServlet("/")
public class Random extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Random() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("GET");
		HttpSession session = request.getSession();
		if (session.getAttribute("counter") == null) {
			int counter = 0;
			session.setAttribute("counter", counter);
		}
		if (session.getAttribute("random") == null) {
			String rand = "Click generate to make a new word!";
			session.setAttribute("random", rand);
		}
		if (session.getAttribute("date") == null) {
			Date date = new Date();
			session.setAttribute("date", date);
		}
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/random.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("POST");
		HttpSession session = request.getSession();
		int counter = (int) session.getAttribute("counter");
		counter++;
		session.setAttribute("counter", counter);
		String[] alaphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		ArrayList<String> alphabetList = new ArrayList<String>(Arrays.asList(alaphabet));
		Collections.shuffle(alphabetList);
		String first = alphabetList.get(0);
        String second = alphabetList.get(1);
        String third = alphabetList.get(2);
        String fourth = alphabetList.get(3);
        String fifth = alphabetList.get(4);
        String sixth = alphabetList.get(5);
        String seventh = alphabetList.get(6);
        String eigth = alphabetList.get(7);
        String ninth = alphabetList.get(8);
        String tenth = alphabetList.get(9);
        String rand = first + second + third + fourth + fifth + sixth + seventh + eigth + ninth + tenth;
        session.setAttribute("random", rand);
        Date date = new Date();
        session.setAttribute("date", date);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/random.jsp");
        view.forward(request, response);
	}

}
