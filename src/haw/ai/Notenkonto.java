package haw.ai;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Notenkonto {
	private double gesamtnote;
	private long studentId;
	private Student student;

	public Notenkonto() {

	}

	public Notenkonto(double gesamtnote) {
		this.gesamtnote = gesamtnote;
	}
	
	public static Notenkonto find(long studentId) {
		Session session = HibernateUtil.getSession();
		Notenkonto notenkonto = (Notenkonto) session.get(Notenkonto.class, studentId);
		session.close();
		return notenkonto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(gesamtnote);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (studentId ^ (studentId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notenkonto other = (Notenkonto) obj;
		if (Double.doubleToLongBits(gesamtnote) != Double
				.doubleToLongBits(other.gesamtnote))
			return false;
		if (studentId != other.studentId)
			return false;
		return true;
	}

	public double getGesamtnote() {
		return gesamtnote;
	}

	public void setGesamtnote(double gesamtnote) {
		this.gesamtnote = gesamtnote;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void addStudent(Student student) {
		if (this.student == null) {
			this.student = student;
			student.setNotenkonto(this);
		}
	}
}
