package ent_4_6;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="job_histories")
public class JobHistory implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department;
	@Id
	@ManyToOne
	@JoinColumn(name="employee_id")
	private Employee employee;
	@Id
	@Column(name = "start_date")
	private LocalDate startDate;
	@Column(name = "end_date")
	private LocalDate endDate;
	
	@ManyToOne
	@JoinColumn(name="job_id")
	private Job job;
	
	public JobHistory() {
		// TODO Auto-generated constructor stub
	}
	
	public JobHistory(Department department, Employee employee, LocalDate startDate, LocalDate endDate, Job job) {
		super();
		this.department = department;
		this.employee = employee;
		this.startDate = startDate;
		this.endDate = endDate;
		this.job = job;
	}

	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "JobHistory [startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
	
}
