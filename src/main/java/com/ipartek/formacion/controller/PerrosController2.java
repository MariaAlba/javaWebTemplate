package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.model.pojo.Perro;

/**
 * Servlet implementation class PerrosController
 */
@WebServlet("/perros2")
public class PerrosController2 extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(PerrosController2.class);

	// lista de perros que imita a una bbdd
	private ArrayList<Perro> perros = new ArrayList<Perro>();

	// para las ids
	private int indice = 0;

	String mensaje = "";

	@Override
	public void init(ServletConfig config) throws ServletException {
		LOG.trace(" se ejecuta la primera vez que se llama a este servlet y nunca mas");

		super.init(config);

		perros.add(new Perro(1, "bubba", "https://images.dog.ceo/breeds/chow/n02112137_9146.jpg"));
		perros.add(new Perro(2, "rataplan", "https://images.dog.ceo/breeds/poodle-toy/n02113624_7996.jpg"));
		perros.add(new Perro(3, "mosca", "https://images.dog.ceo/breeds/elkhound-norwegian/n02091467_3556.jpg"));
		perros.add(new Perro(4, "txakur", "https://images.dog.ceo/breeds/keeshond/n02112350_7141.jpg"));
		perros.add(new Perro(5, "lagun", "https://images.dog.ceo/breeds/retriever-chesapeake/n02099849_4767.jpg"));

		indice = 6;

	}

	@Override
	public void destroy() {
		LOG.trace("se ejecuta solo una vez cuando se para el servidor de aplicacionez");
		super.destroy();
		perros = null;
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOG.trace("se ejecuta antes del doGet o doPost");

		mensaje = "";

		super.service(request, response); // ejecuta doGet o doPost

		LOG.trace("se ejecuta despues del doGet o doPost");

		request.setAttribute("mensaje", mensaje);
		request.setAttribute("perros", perros);
		request.getRequestDispatcher("perros-jstl.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// listar perros
		LOG.trace("doGET");

		int id = (request.getParameter("id") == null) ? 0 : Integer.parseInt(request.getParameter("id"));
		boolean adoptar = (request.getParameter("eliminar") == null) ? false : true;
		boolean editar = (request.getParameter("modificar") == null) ? false : true;

		LOG.debug("id= " + id + " eliminar =  " + adoptar + " modificar = " + editar);

		if (id > 0) {

			// buscar perro en array
			Perro perro = null;
			for (Perro p : perros) {
				if (p.getId() == id) {
					perro = p;
					break;
				}
			}

			if (adoptar) {
				perros.remove(perro);
				mensaje = "Ya has adoptado a " + perro.getNombre() + ", gracias.";
			}

			if (editar) {
				request.setAttribute("perroEditar", perro);
			}

		} else {
			LOG.trace("solo listar perros");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOG.trace("doPost");

		// recibir datos del form
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String foto = request.getParameter("foto");

		// TODO validar parametros

		if (id > 0) {

			LOG.trace("Modificar el perro");
			Perro perro = null;
			for (Perro p : perros) {
				if (p.getId() == id) {
					perro = p;
					break;
				}
			}
			perro.setNombre(nombre);
			perro.setFoto(foto);

			mensaje = "Perro modificado con exito";

		} else {

			LOG.trace("Crear perro nuevo");

			// crear perro
			Perro p = new Perro();
			p.setNombre(nombre);
			p.setFoto(foto);
			p.setId(indice);
			indice++;

			mensaje = "Gracias por dar de alta un nuevo perro";

			// guardar en lista
			perros.add(p);

		}

	}

}
