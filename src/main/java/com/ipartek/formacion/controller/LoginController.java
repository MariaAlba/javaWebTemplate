package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String USER = "admin";
	private static final String PASS = "admin";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. recibir parametros del formulario siempre en formato String
		String nombre = request.getParameter("user");
		String contrasena = request.getParameter("pass");

		// 2. logica
		String vista = "";
		if (USER.equalsIgnoreCase(nombre) && PASS.equalsIgnoreCase(contrasena)) {

			// recuperar sesion del usuario
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogeado", nombre);
			session.setMaxInactiveInterval(-1); // nunca caduca
			vista ="perros";
		} else {

			vista = "index.jsp";
		}
		
		response.sendRedirect(vista);
		
		//request.getRequestDispatcher(vista).forward(request, response);

	}

}
