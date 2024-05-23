package test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import entities.DocGia;
import entities.Sach;
import jakarta.persistence.EntityManager;
import services.ChiTietMuonSachServices;
import services.DocGiaServices;
import services.EntityManagerFactoryUtil;
import services.SachService;

public class TestService {
	private static EntityManagerFactoryUtil entityManagerFactoryUtil;
	private static EntityManager entityManager;
	private static ChiTietMuonSachServices chiTietMuonSachServices;
	private static SachService sachService;
	private static DocGiaServices docGiaServices;
	
	@BeforeAll
	static void setup() {
		entityManagerFactoryUtil=new EntityManagerFactoryUtil("sql");
		entityManager= entityManagerFactoryUtil.getEntityManager();
//		chiTietMuonSachServices= new ChiTietMuonSachServices(entityManager);
//		sachService= new SachService(entityManager);
//		docGiaServices=new DocGiaServices(entityManager);
	}
	
	@Test
	void getDSDocGia() {
		List<DocGia> list = docGiaServices.getDSDocGia("Cuoi Ky JAVA PT");	
		list.forEach(t -> System.out.println(t));
	}
//	
	@Test
	void themChiTietMuonSach() {
		DocGia docGia=new DocGia("DG02", null, null, null);
		Sach sach = entityManager.find(Sach.class, "S01");
		chiTietMuonSachServices.themChiTietMuonSach(docGia, sach);
	}
	
	@Test
	void updateSach() {
		Sach sach=new Sach("S02", "cá", "TuongVan", 2003, 80000);
		sachService.updateSach(sach);
	}
	
	@AfterAll
	public static void afterAll() {
		entityManagerFactoryUtil.closeEnMa();
		entityManagerFactoryUtil.closeEnMaFac();
		
	}
}
