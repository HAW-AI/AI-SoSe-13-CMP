package haw.ai;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration conf = new Configuration().configure();
	        SchemaExport schema = new SchemaExport(conf);
	        schema.create(false, true);
            return conf.buildSessionFactory();
        } catch (Throwable e) {
            System.err.println("SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
	}
	
	public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
