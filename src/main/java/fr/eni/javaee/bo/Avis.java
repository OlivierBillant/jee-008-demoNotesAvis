package fr.eni.javaee.bo;

public class Avis {
	private int id;	
	private int note;
	private String description;
	
	public Avis(int note, String description) {
		super();
		this.note = note;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Avis [id=" + id + ", note=" + note + ", description=" + description + "]";
	}
	
	
}
