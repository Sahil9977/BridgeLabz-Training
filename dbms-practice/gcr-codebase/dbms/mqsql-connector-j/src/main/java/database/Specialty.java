package database;

public class Specialty {
	
	String name ;

	public Specialty(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Specialty [name=" + name + "]";
	}
	
	
}
