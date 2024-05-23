package entities_minhHoa;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="classe_profile")
public class ClazzProfile implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "profile_id")
	private String id;
	
	private LocalDate createDate;
	private String description;
	
	@OneToOne
	@JoinColumn(name = "class_id")
	private Clazz clazz;
	public ClazzProfile() {
		// TODO Auto-generated constructor stub
	}
//	public ClazzProfile(LocalDate createDate, String description, String id, Clazz clazz) {
//		super();
//		this.createDate = createDate;
//		this.description = description;
//		this.id = id;
//		this.clazz = clazz;
//	}
//	
	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	@Override
	public String toString() {
		return "ClazzProfile [createDate=" + createDate + ", description=" + description + ", id=" + id + ", clazz="
				+ clazz + "]";
	}
	
	
	
	
}
