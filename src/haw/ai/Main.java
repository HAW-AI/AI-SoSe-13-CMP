package haw.ai;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
        
        student.addNotenkonto(notenkonto);
        session.save(student);
        session.save(notenkonto);
        
        Kurs kurs1 = new Kurs("AI");
        Kurs kurs2 = new Kurs("RN");
        
        student.addKurs(kurs1);
        student.addKurs(kurs2);
        
        session.save(kurs2);
        session.save(kurs1);
        session.save(student);
        
        Buch buch1 = new Buch("per anhalter durch die galaxis");
        Buch buch2 = new Buch("Game of Thrones: A Song of Ice and Fire");
        Buch buch3 = new Buch("The Alchemist");
        
        kurs1.addBuch(buch1);
        kurs1.addBuch(buch2);
        
        kurs2.addBuch(buch2);
        kurs2.addBuch(buch3);

        session.save(buch1);
        session.save(buch2);
        session.save(buch3);
        session.save(kurs1);
        session.save(kurs2);
        
        session.getTransaction().commit();
        
        Student mike = Student.find((long)1);
        System.out.println(mike.getName());
        
        Notenkonto mikesKonto = Notenkonto.find(mike.getStudentId());
        System.out.println(mikesKonto.getGesamtnote());
        System.out.println(mike.getKurse().toString());
        System.out.println(mike.getNotenkonto().toString());
        
        System.out.println(mike.getKurse(). toString());
        for (Kurs kurs : mike.getKurse()) {
			System.out.println(kurs.getTitel());
		}

        System.out.println(mike.getKurse(). toString());
        for (Kurs kurs : mike.getKurse()) {
			System.out.println(kurs.getTitel());
			System.out.println("Buecher des Kurses:");
			for (Buch buch : kurs.getBuecher()) {
				System.out.println("  " + "- " + buch.getTitel());
			}
		}
        session.close();
	}

	
	public static Session getSession() {
		return session;
	}
}
