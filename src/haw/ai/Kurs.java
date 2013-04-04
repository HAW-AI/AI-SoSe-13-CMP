package haw.ai;
import java.util.List;
import java.util.Set;


public class Kurs {
	private long kursId;
	private String titel;
	private Student student;
	private Set<Buch> buecher;
	
	public Kurs() {}
	
	public Kurs(String titel) {
		this.titel = titel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (kursId ^ (kursId >>> 32));
		result = prime * result + ((student == null) ? 0 : student.hashCode());
		result = prime * result + ((titel == null) ? 0 : titel.hashCode());
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
		Kurs other = (Kurs) obj;
		if (kursId != other.kursId)
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		if (titel == null) {
			if (other.titel != null)
				return false;
		} else if (!titel.equals(other.titel))
			return false;
		return true;
	}

	public Set<Buch> getBuecher() {
		return buecher;
	}

	public void setBuecher(Set<Buch> buecher) {
		this.buecher = buecher;
	}

	public long getKursId() {
		return kursId;
	}

	public void setKursId(long kursId) {
		this.kursId = kursId;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}