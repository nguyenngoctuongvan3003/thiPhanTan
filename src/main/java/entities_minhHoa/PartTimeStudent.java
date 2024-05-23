package entities_minhHoa;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="part_time_students")
public class PartTimeStudent extends Student implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String supervisor;
	public PartTimeStudent() {
		// TODO Auto-generated constructor stub
	}
	public PartTimeStudent(String id, String name, String email, LocalDate dob, String supervisor) {
		super(id, name, email, dob);
		this.supervisor = supervisor;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	@Override
	public String toString() {
		return "PartTimeStudent [supervisor=" + supervisor + ", toString()=" + super.toString() + "]";
	}
	
	
}
