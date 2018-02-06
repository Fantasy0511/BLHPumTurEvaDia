package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * 创建hibernateFactory 从中创建sessionFactory
 * 
 * @author wuyue
 *
 */
public class HibernateFactory {
	private static SessionFactory sessionFactory;
	private static Configuration configuration;
	static {
		configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Configuration getConfiguration() {
		return configuration;
	}

}
