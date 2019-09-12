package facades;

import dtos.GroupMemberDTO;
import entities.GroupMember;
import org.junit.jupiter.api.*;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupMemberFacadeTest {

    private static EntityManagerFactory emf;
    private static GroupMemberFacade facade;

    public GroupMemberFacadeTest() {
    }

    @BeforeAll
    public static void setUpClassV2() {
        emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.TEST, EMF_Creator.Strategy.DROP_AND_CREATE);
        facade = GroupMemberFacade.getGroupMemberFacade(emf);
    }

    @AfterAll
    public static void tearDownClass() {
        //Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("GroupMember.deleteAllRows").executeUpdate();
            em.persist(new GroupMember("Matias Bue", "Koefoed", "cph-mk567", "Red"));
            em.persist(new GroupMember("Emil", "Gotthelf Tranberg Hansen", "cph-eh130", "Red"));
            em.persist(new GroupMember("Karl Erik Viktor", "Frödin", "cph-kf112", "Red"));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
        //Remove any data after each test was run
    }

    @Test
    void GetAllGroupMembers() {
        List<GroupMemberDTO> gms = facade.getAllGroupMembers();
        assertEquals(3,gms.size());
    }
}
