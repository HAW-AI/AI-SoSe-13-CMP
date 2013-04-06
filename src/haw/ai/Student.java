package haw.ai;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Student {
	private long studentId;
	private String name;
	private Notenkonto notenkonto;
	private Set<Kurs> kurse;

	public Student() {
	}

	public Student(String name) {
		this.name = name;
	}

	public static Student find(long studentId) {
		Session session = HibernateUtil.getSession();
		Student student = (Student) session.get(Student.class, studentId);
		session.close();
		return student;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((notenkonto == null) ? 0 : notenkonto.hashCode());
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
		Student other = (Student) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (notenkonto == null) {
			if (other.notenkonto != null)
				return false;
		} else if (!notenkonto.equals(other.notenkonto))
			return false;
		if (studentId != other.studentId)
			return false;
		return true;
	}

	public Notenkonto getNotenkonto() {
		return notenkonto;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNotenkonto(Notenkonto notenkonto) {
		this.notenkonto = notenkonto;
	}

	public void addNotenkonto(Notenkonto notenkonto) {
		if (this.notenkonto == null) {
			this.notenkonto = notenkonto;
			notenkonto.setStudent(this);
		}
	}

	public Set<Kurs> getKurse() {
		return kurse;
	}

	public void setKurse(Set<Kurs> kurse) {
		this.kurse = kurse;
	}

	public void addKurs(Kurs kurs) {
		if (kurs.getStudent() == null) {
			if (this.kurse == null) {
				this.kurse = new HashSet<Kurs>();
			}
			if (this.kurse.add(kurs)) {
				kurs.setStudent(this);
			}
		}
	}

}
