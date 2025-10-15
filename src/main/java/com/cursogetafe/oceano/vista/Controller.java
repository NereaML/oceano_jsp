package com.cursogetafe.oceano.vista;

import java.io.IOException;
import java.util.Set;


import com.cursogetafe.oceano.modelo.Criatura;
import com.cursogetafe.oceano.negocio.Oceano;
import com.cursogetafe.oceano.negocio.OceanoImpl;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/oceano/*")
public class Controller extends HttpServlet {
	
	private Oceano negOceano;
	private String home;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String path = req.getPathInfo();
		
		HttpSession sesion = req.getSession();
		
		if(sesionIniciada(sesion)) {
			
			Set<Criatura> cria;
			switch (path) {
			
			case "/informacion":
				req.setAttribute("origen", "controlador");
				req.getRequestDispatcher("/WEB-INF/informacion").forward(req, resp);		
				break;

			case "/cerrar_sesion":	
		
			}
				
		}else {
			
			switch (path) {
			case "/login":
				req.getRequestDispatcher("/WEB-INF/vista/login.jsp").forward(req, resp);			
				break;

		
			}
		}
		
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getPathInfo();
		
		HttpSession sesion = req.getSession();
		
		if(sesionIniciada(sesion)) {
			
		}
	}
	
	
	
	public void init() throws ServletException{
		negOceano = new OceanoImpl();
		
		ServletContext app = getServletContext();
		
		home = app.getContextPath() + "/oceano";
		
		app.setAttribute("home", home);
		app.setAttribute("css", app.getContextPath() + "/css");
	}
	
	
	
	private boolean isEmpty(String param){
		return param == null || param.trim().length() == 0;
	}
	
	
	private boolean isDouble(String num) {
		try {
			Double.parseDouble(num);
				return true;
		}catch (NumberFormatException e) {
			return false;
		}
	}
	
	
	
	private boolean isInteger(String num) {
		try {
			Integer.parseInt(num);
				return true;
		}catch (NumberFormatException e) {
			return false;
		}
		
		
	}
	private boolean checkPassword(String pwd) {
		return pwd.trim().length() > 5;
	}
	
	private boolean sesionIniciada(HttpSession sesion) {
		return sesion.getAttribute("usuario") != null;
	}
 
}

	

	
	

