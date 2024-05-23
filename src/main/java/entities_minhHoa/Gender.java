package entities_minhHoa;

public enum Gender {
	MALE("MALE"),
	FEMALE("FEMALE"),
	OTHER("OTHER");
	
	private String name;

	private Gender(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
	
	
	
}
