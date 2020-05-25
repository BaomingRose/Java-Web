package com.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * Application Lifecycle Listener implementation class MyRequestListener
 *
 */
@WebListener
public class MyRequestListener implements ServletRequestListener {
	private int count=0;
	
	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
    	HttpServletRequest request = (HttpServletRequest)sre.getServletRequest();
    	if (request.getRequestURI().endsWith("onlineCount.jsp")) {
    		count++;
    		sre.getServletContext().setAttribute("count", new Integer(count));
    	}
    }
    
    public void requestDestroyed(ServletRequestEvent sre)  { 
    	
    }	
}
