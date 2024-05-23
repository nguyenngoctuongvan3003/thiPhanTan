//package services_minhHoa;
//
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
//import dao.StudentDAO;
//import entities.Student;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityTransaction;
//
//public class StudentService implements StudentDAO {
//	private EntityManager entityManager;
//
//	public StudentService(EntityManager entityManager) {
//		// TODO Auto-generated constructor stub
//		this.entityManager = entityManager;
//	}
//
//	@Override
//	public boolean add(Student student) {
//		// TODO Auto-generated method stub
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//
//		try {
//			entityTransaction.begin();
//			entityManager.persist(student);
//			entityTransaction.commit();
//			return true;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			if (entityTransaction.isActive()) {
//				entityTransaction.rollback();
//			}
//			e.printStackTrace();
//		}
//
//		return false;
//	}
//
//	@Override
//	public boolean update(Student student) {
//		// TODO Auto-generated method stub
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//
//		try {
//			entityTransaction.begin();
//			entityManager.merge(student);
//			entityTransaction.commit();
//			return true;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			if (entityTransaction.isActive()) {
//				entityTransaction.rollback();
//			}
//			e.printStackTrace();
//		}
//
//		return false;
//	}
//
//	@Override
//	public boolean remove(String id) {
//		// TODO Auto-generated method stub
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//
//		try {
//			entityTransaction.begin();
//			Student student = entityManager.find(Student.class, id);
//			entityManager.remove(student);
//			entityTransaction.commit();
//			return true;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			if (entityTransaction.isActive()) {
//				entityTransaction.rollback();
//			}
//			e.printStackTrace();
//		}
//
//		return false;
//	}
//
//	@Override
//	public Student findById(String id) {
//		// TODO Auto-generated method stub
//		return entityManager.createQuery("Select s from Student s where s.id=:id",Student.class)
//				.setParameter("id", id)
//				.getSingleResult();
//	}
//
//	@Override
//	public List<Student> findAll() {
//		// TODO Auto-generated method stub
//		return entityManager.createQuery("Select s from Student s",Student.class)
//				.getResultList();
//	}
//	
////	 listSinhvienDiemTB() : Map<Sinhvien, Float> 
//	@Override
//	public Map<Student, Float> listSinhvienDiemTB(){
//		Map<Student, Float> map= new LinkedHashMap<Student, Float>();
//		List<?> list= entityManager.createQuery("select s.id, avg(e.score) as trungBinh from Student s inner join s.enrollments e group by s.id order by trungBinh desc").getResultList();
//		
//		list.stream().map(t -> (Object[]) t).forEach(t -> {
//			String id= (String) t[0];
//			Double avt= (Double) t[1];
//			Float avtF= avt.floatValue();
//			
//			Student student= this.findById(id);
//			map.put(student, avtF);
//		});
//		return map;
//	}
//	
////	+ listSinhvienGioiJava(): List<Sinhvien> 
//	@Override
//	public List<Student> listSinhvienGioiJava(){
//		return entityManager.createQuery("select s from Student s inner join s.enrollments e where e.score in (Select max(e1.score) from Enrollment e1 )", Student.class).getResultList();
//	}
//
//}
