package facades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class CarFacade {

    private static CarFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private CarFacade() {}
    
    
    /**
     * 
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
    
    public long getCarEntityCount(){
        EntityManager em = emf.createEntityManager();
        try{
            return (long)em.createQuery("SELECT COUNT(c) FROM CarEntity c").getSingleResult();
        }finally{  
            em.close();
        }
        
    }

}
