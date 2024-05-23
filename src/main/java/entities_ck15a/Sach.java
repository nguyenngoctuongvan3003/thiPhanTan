package entities_ck15a;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Setter
public class Sach implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MaSach", columnDefinition = "varchar(13)")
	private String maSach;
	
	@Column(name="TuaSach", columnDefinition = "varchar(100)")
	private String tuaSach;
	
	@Column(name="TacGia", columnDefinition = "varchar(100)")
	private String tacGia;
	
	@Column(name="NamXB")
	private int namXB;
	
	@Column(name="GiaBia", columnDefinition = "bigint")
	private long giaBia;
	
	public Sach() {
		// TODO Auto-generated constructor stub
	}

	public Sach(String maSach, String tuaSach, String tacGia, int namXB, long giaBan) {
		super();
		this.maSach = maSach;
		this.tuaSach = tuaSach;
		this.tacGia = tacGia;
		this.namXB = namXB;
		this.giaBia = giaBan;
	}
	
}
