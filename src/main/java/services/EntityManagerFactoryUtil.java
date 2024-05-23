package services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryUtil {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	
	public EntityManagerFactoryUtil(String server) {
		// TODO Auto-generated constructor stub
		this.entityManagerFactory=Persistence.createEntityManagerFactory(server);
		this.entityManager=entityManagerFactory.createEntityManager();
	}
	
	
	public EntityManager getEntityManager() {
		return entityManager;
	}


	public void closeEnMa() {
		this.entityManager.close();
	}
	
	public void closeEnMaFac() {
		this.entityManagerFactory.close();
	}
}
