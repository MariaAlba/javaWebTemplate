package com.ipartek.formacion.controller.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

/**
 * Application Lifecycle Listener implementation class ContadorSesionesListener
 *
 */
@WebListener
public class ContadorSesionesListener implements HttpSessionAttributeListener, HttpSessionListener {

   
	private final static Logger LOG = Logger.getLogger(ContadorSesionesListener.class);
	
	
	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
    	
    	LOG.debug("attributeAdded " + event.getName() + " " + event.getValue() );
    	
    	if ( "usuarioLogeado".equals(event.getName()) ) {
    	
    		ServletContext sc = event.getSession().getServletContext();
    		int num = (int)sc.getAttribute("numeroUsuariosConectados");    		
    		sc.setAttribute("numeroUsuariosConectados", ++num );
    		
    	}
    	

    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
    	
    	LOG.debug("attributeRemoved " + event.getName() + " " + event.getValue() );
    	
    	if ( "usuarioLogeado".equals(event.getName()) ) {
        	
    		ServletContext sc = event.getSession().getServletContext();
    		int num = (int)sc.getAttribute("numeroUsuariosConectados");    		
    		sc.setAttribute("numeroUsuariosConectados", --num );
    		
    	}

    	
    	
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  {
    	
    	LOG.debug("attributeReplaced " + event.getName() + " " + event.getValue() );
    	
    }

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		LOG.trace("sessionCreated ");
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		LOG.trace("sessionDestroyed ");
		
	}
	
}
