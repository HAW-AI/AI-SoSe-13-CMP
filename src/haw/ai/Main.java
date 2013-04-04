package haw.ai;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class Main {

	/**
	 * @param args
	 */
	private static Session session;
	
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        
        session.beginTransaction();
        Notenkonto notenkonto = new Notenkonto(1.0);
        Student student = new Student("Mike Hunt");
        
        student.setNotenkonto(notenkonto);
        notenkonto.setStudent(student);
        session.save(student);
        
        Kurs kurs1 = new Kurs("AI");
        kurs1.setStudent(student);
        Kurs kurs2 = new Kurs("RN");
        kurs2.setStudent(student);
        
        Set<Kurs> kurse = new HashSet<Kurs>();
        kurse.add(kurs1);
        kurse.add(kurs2);
        student.setKurse(kurse);
        
        session.save(kurs2);
        session.save(kurs1);
        session.save(student);
        
        Buch buch1 = new Buch("per anhalter durch die galaxis");
        Buch buch2 = new Buch("Game of Thrones: A Song of Ice and Fire");
        
        
        
        session.getTransaction().commit();

        session.close();
	}

	
	public static Session getSession() {
		return session;
	}
}
