package models;

public class Subject {

	private int id;

	private String name;

	private String description;

	private int level;
	
	public Subject() {
		// TODO Auto-generated constructor stub
	}

	public Subject(int id, String name, String description, int level2) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.level = level2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", description=" + description + ", level=" + level + "]";
	}
	

}
