package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.model.pojo.Perro;
import com.ipartek.formacion.model.pojo.Usuario;

/**
 * Servlet implementation class UsuariosController
 */
@WebServlet("/usuarios")
public class UsuariosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private int indice = usuarios.size();
    
	/**
     * @see HttpServlet#HttpServlet()
     */
    public UsuariosController() {
        super();
        usuarios.add(new Usuario(usuarios.size(), "admin", "admin", "https://github.com/mradmin", "https://randomuser.me/api/portraits/thumb/men/48.jpg"));
        usuarios.add(new Usuario(usuarios.size(), "user", "12345", "https://github.com/mrbunny", "https://randomuser.me/api/portraits/thumb/men/48.jpg"));
        usuarios.add(new Usuario(usuarios.size(), "maria", "maria", "https://github.com/MariaAlba", "images/avatar.png"));
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// recibir datos del form

				String nombre = request.getParameter("nombre");
				String password = request.getParameter("password");
				String github = request.getParameter("github");
				String imagen = request.getParameter("imagen");

				// crear perro
				indice = usuarios.size();
				Usuario nuevoUsuario = new Usuario();
				nuevoUsuario.setId(indice);
				nuevoUsuario.setNombre(nombre);
				nuevoUsuario.setPassword(password);
				nuevoUsuario.setGithub(github);
				nuevoUsuario.setImagen(imagen);

				// guardar en lista
				usuarios.add(nuevoUsuario);

				// modificar

				// eliminar

				// listar perros
				request.setAttribute("usuarios", usuarios);
				request.getRequestDispatcher("login.jsp").forward(request, response);

	}

}
