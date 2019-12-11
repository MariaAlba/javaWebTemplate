package com.ipartek.formacion.listener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;

import com.ipartek.formacion.model.pojo.Usuario;

/**
 * Application Lifecycle Listener implementation class AppListener
 *
 */
@WebListener
public class AppListener implements ServletContextListener {

	private static final Logger LOG = Logger.getLogger(AppListener.class);

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		LOG.info("Se para app");
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		LOG.info("Se arranca app");

		// ServletContext = ApplicationScope
		ServletContext sc = sce.getServletContext();

		Set<String> intentosIndebidos = new HashSet<String>();
		ArrayList<Usuario> usuariosLogeados = new ArrayList<Usuario>();

		sc.setAttribute("numeroUsuariosConectados", 0);
		sc.setAttribute("numeroIntentosIndebidos", 0);

		sc.setAttribute("usuariosConectados", usuariosLogeados);
		sc.setAttribute("intentosIndebidos", intentosIndebidos);
	}

}
