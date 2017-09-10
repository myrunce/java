package com.teams.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.teams.models.Team;
import com.teams.models.Player;
/**
 * Servlet implementation class addPlayer
 */
@WebServlet("/addPlayer")
public class addPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addPlayer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ArrayList<Team> teams = new ArrayList<Team>();
		teams = (ArrayList<Team>) session.getAttribute("teams");
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("team", teams.get(id));
		request.setAttribute("id", id);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/addPlayer.jsp");
		view.forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Making Player...");
		HttpSession session = request.getSession();
		String firstName = request.getParameter("firstName");
		System.out.println("first name made");
		String lastName = request.getParameter("lastName");
		System.out.println("last name made");
		int age = Integer.parseInt(request.getParameter("age"));
		System.out.println("age made");
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("id made");
		Player newPlayer = new Player(firstName, lastName, age);
		System.out.println("player made");
		System.out.println(newPlayer.getFirst());
		ArrayList<Team> teams = (ArrayList<Team>) session.getAttribute("teams");
		System.out.println("array of teams made");;
		System.out.println(teams.get(id).getName());
		teams.get(id).addPlayer(newPlayer);
		System.out.println("adding player to team");
		session.setAttribute("teams", teams);
		System.out.println("setting attribute");
		System.out.println("redirecting...");
		response.sendRedirect("/Teams");
		
	}

}