package com.listener;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MySessionListener
 *
 */
@WebListener
public class MySessionListener implements HttpSessionListener {
	private ServletContext context=null;
	
    public void sessionCreated(HttpSessionEvent se)  { 
         HttpSession session = se.getSession();
         context=session.getServletContext();
         
         ArrayList<HttpSession> sessionList = (ArrayList<HttpSession>)context.getAttribute("sessionList");
         if (sessionList == null) {
        	 sessionList = new ArrayList<HttpSession>();
        	 sessionList.add(session);
        	 context.setAttribute("sessionList", sessionList);
         } else {
        	 sessionList.add(session);
         }
         context.log("创建一个会话："+session.getId());       
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
         HttpSession session = se.getSession();
         context = session.getServletContext();
         ArrayList<HttpSession> sessionList = (ArrayList<HttpSession>)context.getAttribute("sessionList");
         sessionList.remove(session);
         context.log("销毁一个会话：" + session.getId());    
    }
	
}
