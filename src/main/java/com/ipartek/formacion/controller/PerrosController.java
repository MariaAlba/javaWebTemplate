package com.ipartek.formacion.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.model.ArrayPerroDao;
import com.ipartek.formacion.model.pojo.Perro;

/**
 * Servlet implementation class PerrosController
 */
@WebServlet("/perros")
public class PerrosController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(PerrosController.class);

	private static ArrayPerroDao dao = ArrayPerroDao.getInstance();

	String mensaje = "";

	@Override
	public void init(ServletConfig config) throws ServletException {
		LOG.trace(" se ejecuta la primera vez que se llama a este servlet y nunca mas");

		super.init(config);

		try {
			dao.create(new Perro("Michi",
					"https://images.squarespace-cdn.com/content/v1/5a8abbee6f4ca301c2d1b962/1527808340868-GRA08XX79G20DUND6H9I/ke17ZwdGBToddI8pDm48kGuaBMmARhKtUmXCE1pY_k1Zw-zPPgdn4jUwVcJE1ZvWQUxwkmyExglNqGp0IvTJZUJFbgE-7XRK3dMEBRBhUpzGBwVodEh3vUCb_FH6fADYhlZwvRiPtE8wFqmckfQo9hcWrJuBgPcO-nCQUzImAEM/Logo+Pipper+RECORTADA.jpg"));
			dao.create(new Perro("Puchi",
					"https://images.squarespace-cdn.com/content/v1/5a8abbee6f4ca301c2d1b962/1527808340868-GRA08XX79G20DUND6H9I/ke17ZwdGBToddI8pDm48kGuaBMmARhKtUmXCE1pY_k1Zw-zPPgdn4jUwVcJE1ZvWQUxwkmyExglNqGp0IvTJZUJFbgE-7XRK3dMEBRBhUpzGBwVodEh3vUCb_FH6fADYhlZwvRiPtE8wFqmckfQo9hcWrJuBgPcO-nCQUzImAEM/Logo+Pipper+RECORTADA.jpg"));
			dao.create(new Perro("Ploffi",
					"https://images.squarespace-cdn.com/content/v1/5a8abbee6f4ca301c2d1b962/1527808340868-GRA08XX79G20DUND6H9I/ke17ZwdGBToddI8pDm48kGuaBMmARhKtUmXCE1pY_k1Zw-zPPgdn4jUwVcJE1ZvWQUxwkmyExglNqGp0IvTJZUJFbgE-7XRK3dMEBRBhUpzGBwVodEh3vUCb_FH6fADYhlZwvRiPtE8wFqmckfQo9hcWrJuBgPcO-nCQUzImAEM/Logo+Pipper+RECORTADA.jpg"));
		} catch (Exception e) {
			LOG.trace("Excepcion al crear");
			e.printStackTrace();
		}

	}

	@Override
	public void destroy() {
		LOG.trace("se ejecuta solo una vez cuando se para el servidor de aplicacionez");
		super.destroy();

	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LOG.trace("se ejecuta antes del doGet o doPost");

		mensaje = "";

		super.service(request, response); // ejecuta doGet o doPost

		LOG.trace("se ejecuta despues del doGet o doPost");

		request.setAttribute("mensaje", mensaje);
		request.setAttribute("perros", dao.getAll());
		request.getRequestDispatcher("perros.jsp").forward(request, response);

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
			for (Perro p : dao.getAll()) {
				if (p.getId() == id) {
					perro = p;
					break;
				}
			}

			if (adoptar) {
				try {
					dao.delete(perro.getId());
				} catch (Exception e) {
					LOG.debug("Excepcion al eliminar");
					e.printStackTrace();
				}
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
			for (Perro p : dao.getAll()) {
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

			mensaje = "Gracias por dar de alta un nuevo perro";

			// guardar en lista
			try {
				dao.create(p);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				LOG.debug("Excepcion al crear" + e);
			}

		}

	}

}
