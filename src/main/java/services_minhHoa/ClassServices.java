//package services_minhHoa;
//
//import java.util.ArrayList;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
//import dao.ClassDAO;
//import entities.Clazz;
//import jakarta.persistence.EntityManager;
//
//public class ClassServices implements ClassDAO {
//	private EntityManager entityManager;
//
//	public ClassServices(EntityManager entityManager) {
//		this.entityManager = entityManager;
//	}
//
//	@Override
//	public Map<Clazz, Integer> getSisoByLophoc() {
//		// TODO Auto-generated method stub
//		Map<Clazz, Integer> map = new LinkedHashMap<Clazz, Integer>();
//
//		List<?> list = entityManager.createQuery("Select c.id, count(s) as noOfStudents "
//				+ " from Clazz c inner join c.students s group by c.id order by noOfStudents ").getResultList();
//
//		list.stream().map(t -> (Object[]) t).forEach(t->{
//			String id= (String) t[0];
//			Clazz clazz=entityManager.find(Clazz.class, id);
//			Long countL=(Long) t[1];
//			int count= countL.intValue();
//			map.put(clazz, count);
//		});
//		return map;
//	}
//	
////	listLophocNull() : List<Lophoc> 
//	@Override
//	public List<Clazz> listLophocNull(){
//		return entityManager.createQuery("select c from Clazz c left join c.students s where s is null ", Clazz.class).getResultList();
//	}
//
//}
