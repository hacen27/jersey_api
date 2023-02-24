package com.api.dao;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


import java.util.Properties;

import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.api.entity.Employee;
import com.api.entity.Etudiant;
import com.api.entity.Vacations;


public class SessionUtil {
	private static SessionFactory factory;
	
	private SessionUtil() {}
	
	public static SessionFactory getFactory() {
		if(factory == null) {
			Configuration configuration = new Configuration();
			
			Properties settings = new Properties();
			settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
			settings.put(Environment.URL, "jdbc:mysql://localhost:3306/leavemanager_db");
			settings.put(Environment.USER, "root");
			settings.put(Environment.PASS, "c14466");
			
			settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
			settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");

			settings.put(Environment.SHOW_SQL, "false");
			settings.put(Environment.HBM2DDL_AUTO, "update");
			
			configuration.setProperties(settings);
			configuration.addAnnotatedClass(Employee.class);
			configuration.addAnnotatedClass(Vacations.class);
			configuration.addAnnotatedClass(Etudiant.class);
			
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties())
					.build();
			
			factory = configuration.buildSessionFactory(serviceRegistry);
		}
		
		return factory;
	}

}