package services_ck15a;

import java.util.Date;

import dao.ChiTietMuonSachDAO;
import entities_minhHoa.ChiTietMuonSach;
import entities_minhHoa.DocGia;
import entities_minhHoa.Sach;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ChiTietMuonSachServices implements ChiTietMuonSachDAO{
	private EntityManager entityManager;
	
	
	public ChiTietMuonSachServices(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	

	@Override
	public boolean themChiTietMuonSach(DocGia docGia, Sach sach) {
		// TODO Auto-generated method stub
		EntityTransaction entityTransaction=entityManager.getTransaction();
		ChiTietMuonSach chiTietMuonSach=new ChiTietMuonSach(docGia, sach, new Date(), null, 0);
		
		if(sach.getNamXB()>2015) {
			chiTietMuonSach.setTienCoc(sach.getGiaBia());
		}else {
			chiTietMuonSach.setTienCoc((long) (sach.getGiaBia()*0.5));
		}
		
		
		try {
			entityTransaction.begin();
			entityManager.persist(chiTietMuonSach);
			entityTransaction.commit();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if(entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
			e.printStackTrace();
		}
		
		return false;
	}

}
