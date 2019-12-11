package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.model.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static Set<Usuario> usuariosSet = new HashSet<Usuario>();
	private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private int indice = usuarios.size();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		usuariosSet.add(new Usuario(usuariosSet.size(), "Admin", "admin", "https://github.com/mradmin",
				"https://randomuser.me/api/portraits/thumb/women/48.jpg"));
		usuariosSet.add(new Usuario(usuariosSet.size(), "User", "12345", "https://github.com/mrbunny",
				"https://randomuser.me/api/portraits/thumb/men/48.jpg"));
		usuariosSet.add(
				new Usuario(usuariosSet.size(), "Maria", "maria", "https://github.com/MariaAlba", "images/avatar.png"));
	}

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
		// recuperar sesion del usuario
		HttpSession session = request.getSession();
		session = request.getSession();
		String vista = "";
		String base = request.getContextPath();

		for (Usuario usuario : usuariosSet) {

			if (usuario.getNombre().equalsIgnoreCase(nombre) && usuario.getPassword().equalsIgnoreCase(contrasena)) {
				session.setAttribute("usuarioLogeado", usuario);
				session.setMaxInactiveInterval(-1); // nunca caduca
				vista = base + "/private/home";
				break;

			} else {
				vista = base + "/login.jsp";
			}
		}

		response.sendRedirect(vista);

	}

	// request.getRequestDispatcher(vista).forward(request, response);

}
