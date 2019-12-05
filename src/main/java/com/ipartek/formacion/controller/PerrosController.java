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
		perros.add(new Perro(perros.size(), "bubba"));
		perros.add(new Perro(perros.size(), "rataplan"));
		perros.add(new Perro(perros.size(), "mosca"));
		perros.add(new Perro(perros.size(), "txakur"));
		perros.add(new Perro(perros.size(), "lagun"));
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// esto seria para eliminar en post ¿creo?
		// int idToDelete = Integer.parseInt(request.getParameter("eliminar"));
		// int idToUpdate = Integer.parseInt(request.getParameter("modificar"));

		// eliminar o modificar de la lista
		// perros.removeIf(n -> (n.getId() == idToDelete));

		// listar perros
		request.setAttribute("perros", perros);
		request.getRequestDispatcher("perros.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// recibir datos del form

		String nombre = request.getParameter("nombre");

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
