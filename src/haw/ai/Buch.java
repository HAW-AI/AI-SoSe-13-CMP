package haw.ai;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;


public class Buch {
	private long buchId;
	private String titel;
	private Set<Kurs> kurse;
	
	public Buch() {}
	
	public Buch(String titel) {
		this.titel = titel;
	}
	
	public static Buch find(long buchId) {
	    Session session = HibernateUtil.getSession();
	    Buch buch = (Buch) session.get(Buch.class, buchId);
	    session.close();
	    return buch;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (buchId ^ (buchId >>> 32));
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
		Buch other = (Buch) obj;
		if (buchId != other.buchId)
			return false;
		if (titel == null) {
			if (other.titel != null)
				return false;
		} else if (!titel.equals(other.titel))
			return false;
		return true;
	}

	public long getBuchId() {
		return buchId;
	}
	public void setBuchId(long buchId) {
		this.buchId = buchId;
	}
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public Set<Kurs> getKurse() {
		return kurse;
	}
	public void setKurse(Set<Kurs> kurse) {
		this.kurse = kurse;
	}
	
	public void addKurs(Kurs kurs) {
		if (this.kurse == null) {
			this.kurse = new HashSet<Kurs>();
		}
		if(this.kurse.add(kurs)) {
			kurs.addBuch(this);
		}
	}

	public void removeKurs(Kurs kurs) {
		if (this.kurse != null) {
			if (this.kurse.remove(kurs)) {
				kurs.removeBuch(this);
			}
		}
	}
}
