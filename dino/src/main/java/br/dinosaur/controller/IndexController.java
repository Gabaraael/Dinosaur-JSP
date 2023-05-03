package br.dinosaur.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.dinosaur.dao.DinoDAO;
import br.dinosaur.model.Dinosaur;

@WebServlet("/dino")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processaRequisicao(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processaRequisicao(request, response);
	}

	private void processaRequisicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		try {
			switch (acao) {
			case "novo":
				chamarPageNovoDino(request, response);
				break;
				case "inserir":					
					inserirNovoDino(request, response);
					break;				
				}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}	

	private void chamarPageNovoDino(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		System.out.println("cheguei aqui");	
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("dino/CadastraDino.jsp");
		dispatcher.forward(request, response);	
		
	}	
	
	private void inserirNovoDino(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException  {		
	
		String specie = request.getParameter("specie");
		String diet = request.getParameter("diet");		
		String habitat = request.getParameter("habitat");
		String period = request.getParameter("period");
		String description = request.getParameter("description");
		
		Dinosaur dino = new Dinosaur(specie, diet, habitat, period, description);		
				
		DinoDAO dinoDao = new DinoDAO();
		Dinosaur dinosaur =  dinoDao.insertDino(dino);
		System.out.println(dinosaur.toString());


		request.setAttribute("userSubmitForm", true);
//		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
//		rd.forward(request,response);			
		response.sendRedirect("index.jsp");
	}
}