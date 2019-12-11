package com.ipartek.formacion.listener;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.apache.log4j.Logger;

import com.ipartek.formacion.model.pojo.Usuario;

/**
 * Application Lifecycle Listener implementation class ContadorSesionesListener
 *
 */
@WebListener
public class ContadorSesionesListener implements HttpSessionAttributeListener {

	private static final Logger LOG = Logger.getLogger(ContadorSesionesListener.class);

	// private static ArrayList<Usuario> todos = new ArrayList<Usuario>();
	private static Set<Usuario> todos = new HashSet<Usuario>();

	/**
	 * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
	 */
	public void attributeAdded(HttpSessionBindingEvent event) {
		LOG.info("Añadido atributo " + event.getName() + " con valor " + event.getValue());

		if ("usuarioLogeado".equals(event.getName())) {
			ServletContext sc = event.getSession().getServletContext();
			Usuario usuarioLogeado = (Usuario) event.getValue();
			todos.add(usuarioLogeado);
			sc.setAttribute("usuariosConectados", todos);
		}
	}

	/**
	 * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
	 */
	public void attributeRemoved(HttpSessionBindingEvent event) {
		LOG.info("Quitado atributo " + event.getName() + " con valor " + event.getValue());
		if ("usuarioLogeado".equals(event.getName())) {
			ServletContext sc = event.getSession().getServletContext();
			Usuario usuarioLogeado = (Usuario) event.getValue();
			todos.remove(usuarioLogeado);
			sc.setAttribute("usuariosConectados", todos);
		}
	}

	/**
	 * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
	 */
	public void attributeReplaced(HttpSessionBindingEvent event) {
		LOG.info("Reemplazado atributo " + event.getName() + " con valor " + event.getValue());
	}

}
