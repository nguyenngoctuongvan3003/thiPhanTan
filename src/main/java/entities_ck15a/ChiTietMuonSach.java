package entities_ck15a;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class ChiTietMuonSach implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "MaDG")
	private DocGia docGia;
	
	@Id
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "MaSach")
	private Sach sach;
	
	@Id
	@Column(name="NgayMuon", columnDefinition = "datetime")
	private Date ngayMuon;
	
	@Column(name="NgayTra", columnDefinition = "datetime")
	private Date ngayTra;
	
	@Column(name="TienCoc", columnDefinition = "bigint")
	private long tienCoc;
	
	
	
}
