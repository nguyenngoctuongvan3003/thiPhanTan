package entities_minhHoa;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="enrollments")
public class Enrollment implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;
	
	@Id
	private String semester;
	@Id
	private int year;
	
	private int score;
	
	public Enrollment() {
		// TODO Auto-generated constructor stub
	}
	public Enrollment(Student student, Course course, String semester, int year, int score) {
		super();
		this.student = student;
		this.course = course;
		this.semester = semester;
		this.year = year;
		this.score = score;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Enrollment [student=" + student + ", course=" + course + ", semester=" + semester + ", year=" + year
				+ ", score=" + score + "]";
	}
	
	
	
}
