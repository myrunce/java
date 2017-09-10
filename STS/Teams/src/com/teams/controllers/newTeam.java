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

/**
 * Servlet implementation class newTeam
 */
@WebServlet("/newTeam")
public class newTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newTeam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("MAKE A TEAM PAGE");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/newTeam.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("MAKING TEAM...");
		HttpSession session = request.getSession();
		String name = request.getParameter("teamName");
		
		Team team = new Team(name);
		
		
		if (session.getAttribute("teams") == null) {
			ArrayList<Team> teams = new ArrayList<Team>();
			teams.add(team);
			session.setAttribute("teams", teams);
		}
		else {
			ArrayList<Team> teams = (ArrayList<Team>) session.getAttribute("teams");
			teams.add(team);
			session.setAttribute("teams", teams);			
		}
		
		response.sendRedirect("/Teams");
	}
}
