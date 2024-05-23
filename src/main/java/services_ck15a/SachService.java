package services_ck15a;

import java.time.LocalDate;
import java.util.Date;

import dao.SachDAO;
import entities_minhHoa.Sach;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class SachService implements SachDAO {
private EntityManager entityManager;
	
	
	public SachService(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}


	@Override
	public boolean updateSach(Sach sach) {
		LocalDate ngayHienTai = LocalDate.now();
		if(ngayHienTai.getYear()>=sach.getNamXB()) {
			//nam trc, gia duuong
			EntityTransaction entityTransaction=entityManager.getTransaction();
			try {
				entityTransaction.begin();
				entityManager.merge(sach);
				entityTransaction.commit();
				System.out.println("Thanh cong");
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				if(entityTransaction.isActive()) {
					entityTransaction.rollback();
				}
				e.printStackTrace();
			}
		}else {
			System.out.println("năm xuất bản phải trước hoặc bằng năm hiện tại");
		}
		return false;
	}
	
}
