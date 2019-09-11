package entities;

import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Main {

    private static EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.DROP_AND_CREATE);
    private static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        GroupMember Matias = new GroupMember("Matias Bue","Koefoed","cph-mk567","Red");
        GroupMember Emil = new GroupMember("Emil","Gotthelf Tranberg Hansen","cph-eh130","Red");
        GroupMember Karl = new GroupMember("Karl Erik Viktor","Frödin","cph-kf112","Red");

        try {
            em.getTransaction().begin();
            em.persist(new CarEntity(1234, "Blart", "Blocus", 12345));
            em.persist(new CarEntity(1423, "Dang", "Mamba", 53454));
            em.persist(new CarEntity(3234, "Dubi", "La", 4534));
            em.persist(Matias);
            em.persist(Emil);
            em.persist(Karl);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

    }

}
