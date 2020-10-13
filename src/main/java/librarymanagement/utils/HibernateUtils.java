/*
 *@author ThomasLe
 *@date Oct 4, 2020
*/
package librarymanagement.utils;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import librarymanagement.entities.Book;

public class HibernateUtils {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration configuration = new Configuration();

			Properties settings = new Properties();
			settings.put(Environment.DRIVER, "org.postgresql.Driver");
			settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
			settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/librarymanagement");
			settings.put(Environment.USER, "postgres");
			settings.put(Environment.PASS, "syntask");
			settings.put(Environment.SHOW_SQL, true);
			settings.put(Environment.HBM2DDL_AUTO, "validate");

			configuration.setProperties(settings);
			configuration.addAnnotatedClass(Book.class);

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}

		return sessionFactory;
	}
}
