package corejava.hibernate.domain;

public class Uom {
	private int id;
	private String description;
	public Uom(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public boolean equals(Object obj) {
		Uom other = (Uom)obj;
		return (id == other.id);
	}
	@Override
	public int hashCode() {
		return 15*id;
	}
	@Override
	public String toString() {
		return "ID :"+id+" Description :"+description;
	}
	
}
