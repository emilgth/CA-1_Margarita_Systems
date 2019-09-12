package facades;

import dtos.GroupMemberDTO;
import entities.GroupMember;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
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

    public List<GroupMemberDTO> getAllGroupMembers(){
        EntityManager em = getEntityManager();

        try {
            List<GroupMember> query = em.createQuery("select gm from GroupMember gm",GroupMember.class).getResultList();
            List<GroupMemberDTO> gmDTOs = new ArrayList<>();
            query.forEach(groupMember -> gmDTOs.add(new GroupMemberDTO(groupMember)));
            return gmDTOs;
        } finally {
            em.close();
        }
    }

}
