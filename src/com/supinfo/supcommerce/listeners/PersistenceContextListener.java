package com.supinfo.supcommerce.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;

import com.supinfo.supcommerce.dao.PersistenceManager;

@WebListener
public class PersistenceContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		PersistenceManager.closeEntityManagerFactory();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// NOTHIN' DUDE
	}

}
