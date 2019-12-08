package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.model.pojo.Perro;

/**
 * Servlet implementation class PerrosController
 */
@WebServlet("/perros")
public class PerrosController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// lista de perros que imita a una bbdd
	private ArrayList<Perro> perros = new ArrayList<Perro>();

	private int indice = perros.size();

	// Esto no entiendo muy bien pero crea un perro que añade a la lista al iniciar
	// el servlet ¿creo?
	public PerrosController() {
		super();
		perros.add(new Perro(perros.size(), "bubba","https://images.dog.ceo/breeds/chow/n02112137_9146.jpg"));
		perros.add(new Perro(perros.size(), "rataplan","https://images.dog.ceo/breeds/poodle-toy/n02113624_7996.jpg"));
		perros.add(new Perro(perros.size(), "mosca","https://images.dog.ceo/breeds/elkhound-norwegian/n02091467_3556.jpg"));
		perros.add(new Perro(perros.size(), "txakur","https://images.dog.ceo/breeds/keeshond/n02112350_7141.jpg"));
		perros.add(new Perro(perros.size(), "lagun","https://images.dog.ceo/breeds/retriever-chesapeake/n02099849_4767.jpg"));
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// esto seria para eliminar en post ¿creo?
		String idToDelete = request.getParameter("eliminar");
		// int idToUpdate = Integer.parseInt(request.getParameter("modificar"));

		// listar perros
		request.setAttribute("perros", perros);

		// eliminar o modificar de la lista
		if (idToDelete != null) {
			perros.removeIf(n -> (n.getId() == Integer.parseInt(idToDelete)));
		}
		
		if(request.getSession().getAttribute("usuarioLogeado")!=null) { 
				request.getRequestDispatcher("perros.jsp").forward(request, response);}
		else {
			response.sendRedirect("index.jsp");
					
				}

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// recibir datos del form

		String nombre = request.getParameter("nombre");
		String foto = request.getParameter("foto");

		// crear perro
		indice = perros.size();
		Perro p = new Perro();
		p.setId(indice);
		p.setNombre(nombre);
	

		// guardar en lista
		perros.add(p);

		// modificar

		// eliminar

		// listar perros
		request.setAttribute("perros", perros);
		request.getRequestDispatcher("perros.jsp").forward(request, response);

	}

}
