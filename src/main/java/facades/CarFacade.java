package facades;

import dtos.CarDTO;
import entities.CarEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

public class CarFacade {

    private static CarFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private CarFacade() {
    }


    /**
     * @param _emf entityManagerFactory
     * @return an instance of this facade class.
     */
    public static CarFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CarFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public long getCarEntityCount() {
        EntityManager em = emf.createEntityManager();
        try {
            return (long) em.createQuery("SELECT COUNT(c) FROM CarEntity c").getSingleResult();
        } finally {
            em.close();
        }

    }

    public List<CarDTO> getAllCars() {
        EntityManager entityManager = emf.createEntityManager();
        try {
            List<CarDTO> carDTOS = new ArrayList<>();
            List<CarEntity> carEntities = entityManager.createQuery("SELECT c from CarEntity c", CarEntity.class).getResultList();
            carEntities.forEach(car -> carDTOS.add(new CarDTO(car)));
            return carDTOS;
        } finally {
            entityManager.close();
        }
    }

}
