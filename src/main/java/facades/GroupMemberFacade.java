package facades;

import entities.GroupMember;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

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

    public List<GroupMember> getAllGroupMembers(){
        EntityManager em = getEntityManager();

        try {
            return em.createQuery("select gm from GroupMember gm",GroupMember.class).getResultList();
        } finally {
            em.close();
        }
    }

}
