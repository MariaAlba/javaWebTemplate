package com.ipartek.formacion.controller.listener;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;



/**
 * Application Lifecycle Listener implementation class AppListener
 *
 */
@WebListener
public class AppListener implements ServletContextListener {


	private final static Logger LOG = Logger.getLogger(AppListener.class);
	

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	LOG.info("La App se ha arrancado");
    	
    	//sc == applicationScope  
    	ServletContext sc =  sce.getServletContext();
    	sc.setAttribute("numeroUsuariosConectados", 0);
    	
    	
    	//deportes
    	HashMap<String,String> hmDeportes = new HashMap<String, String>();
    	hmDeportes.put("1", "Surf");
    	hmDeportes.put("23", "Bodyboard");
    	hmDeportes.put("34", "Quidditch");
    	hmDeportes.put("33", "Jugger");
    	hmDeportes.put("7", "Soffing");
    	sc.setAttribute("deportes", hmDeportes);
    	
    }

	
	
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	LOG.info("La App se ha parado");
    }
	
}
