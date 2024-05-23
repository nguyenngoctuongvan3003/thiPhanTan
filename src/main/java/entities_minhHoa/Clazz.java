package entities_minhHoa;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="classes")
public class Clazz implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "class_id")
	private String id;
	private String name;
	private int noOfStudents;
	
	@OneToMany(mappedBy = "clazz", fetch = FetchType.LAZY)
	private Set<Student> students;
	public Clazz() {
		// TODO Auto-generated constructor stub
	}
	public Clazz(String id, String name, int noOfStudents) {
		super();
		this.id = id;
		this.name = name;
		this.noOfStudents = noOfStudents;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNoOfStudents() {
		return noOfStudents;
	}
	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}
	@Override
	public String toString() {
		return "Clazz [id=" + id + ", name=" + name + ", noOfStudents=" + noOfStudents + "]";
	}
	
	
	
	
}
