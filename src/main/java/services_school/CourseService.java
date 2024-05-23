package services_school;

import java.util.List;

import dao.CourseDAO;
import entities_minhHoa.Course;
import entities_minhHoa.OnsiteCourse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

public class CourseService implements CourseDAO {

	private EntityManager entityManager;

	public CourseService(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public boolean addCourse(Course course) {
		EntityTransaction trans = entityManager.getTransaction();
		try {
			trans.begin();
			entityManager.persist(course);
			trans.commit();
			return true;
		} catch (Exception e) {
			if (trans.isActive()) {
				trans.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateCourse(Course course) {
		EntityTransaction trans = entityManager.getTransaction();
		try {
			trans.begin();
			entityManager.merge(course);
			trans.commit();
			return true;
		} catch (Exception e) {
			if (trans.isActive()) {
				trans.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteCourse(int id) {
		EntityTransaction trans = entityManager.getTransaction();
		try {
			trans.begin();
			Course course = entityManager.find(Course.class, id);
			entityManager.remove(course);
			trans.commit();
			return true;
		} catch (Exception e) {
			if (trans.isActive()) {
				trans.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Course findCourseByID(int id) {
		return entityManager.find(Course.class, id);
	}
//	// JPQL
//	@NamedQueries({
//			@NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
//			@NamedQuery(name = "Course.findByTitleLike", query = "SELECT c FROM Course c WHERE c.title LIKE :title"),
//			@NamedQuery(name = "Course.existsById", query = "SELECT (count(c) > 0) FROM Course c WHERE c.id = :id"),
//			@NamedQuery(name = "Course.findCoursesWithMaxCredits", query = "SELECT c FROM Course c WHERE c.credits = (SELECT max(credits) FROM Course)"),
//			@NamedQuery(name = "Course.findOnsiteCourses", query = "SELECT c FROM OnsiteCourse c") })
//
//	// SQL
//	@NamedNativeQueries({
//		@NamedNativeQuery(name = "Course.findAllNative", query = "SELECT * FROM course"),
//	})
	@Override
	public Course findCourseByTitle(String title) {
		return entityManager.createQuery("SELECT c FROM Course c WHERE c.title = :title", Course.class)
				.setParameter("title", title)
				.getSingleResult();
		
//		return entityManager.createQuery("SELECT c FROM Course c WHERE c.title = :title", Course.class)
//				.setParameter("title", title)
//				.getResultList()
//				.stream()
//				.findFirst()
//				.orElse(null);
	}

	@Override
	public List<Course> findCourseByTitleLike(String title) {
		return entityManager.createNamedQuery("Course.findByTitleLike", Course.class)
				.setParameter("title", "%" + title + "%")
				.getResultList();
	}

	@Override
	public List<Course> findAll() {
		return entityManager.createNamedQuery("Course.findAll", Course.class).getResultList();
	}

	@Override
	public List<OnsiteCourse> findAllOnsiteCourses() {
		return entityManager.createNamedQuery("Course.findOnsiteCourses", OnsiteCourse.class).getResultList();
	}

}
