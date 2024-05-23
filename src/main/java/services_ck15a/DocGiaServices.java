package services_ck15a;

import java.util.ArrayList;
import java.util.List;

import dao.DocGiaDAO;
import entities_minhHoa.DocGia;
import jakarta.persistence.EntityManager;

public class DocGiaServices implements DocGiaDAO {
	private EntityManager entityManager;

	public DocGiaServices(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	@Override
	public DocGia findById(String id) {
		return entityManager.find(DocGia.class,id);
	}
	
	@Override
	public List<DocGia> getDSDocGia(String tuaSach){
		return entityManager.createQuery("select d from DocGia d inner join d.chiTietMuonSachs c where c.sach.tuaSach=:tuaSach group by d having count(c)>=2",DocGia.class)
				.setParameter("tuaSach", tuaSach)
				.getResultList();
		
	} 
	
	
}
