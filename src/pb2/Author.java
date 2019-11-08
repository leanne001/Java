package pb2;

public class Author extends Person{
	private String career;
	
	public Author(String name, Gender gender, String career) {
		super(name, gender);
		this.career = career;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}
}
