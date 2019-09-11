package facades;

import entities.GroupMember;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class GroupMemberFacade {

    private static facades.GroupMemberFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private GroupMemberFacade() {
    }


    /**
     * @param _emf
     * @return an instance of this facade class.
     */
    public static facades.GroupMemberFacade getGroupMemberFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new facades.GroupMemberFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        GroupMember Matias = new GroupMember("Matias Bue","Koefoed","cph-mk567","Red");
        GroupMember Emil = new GroupMember("Emil","Gotthelf Tranberg Hansen","cph-eh130","Red");
        GroupMember Karl = new GroupMember("Karl Erik Viktor","Frödin","cph-kf112","Red");

        try {
            em.getTransaction().begin();
            em.persist(Matias);
            em.persist(Emil);
            em.persist(Karl);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

}
