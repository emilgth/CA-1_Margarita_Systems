package facades;

import utils.EMF_Creator;
import entities.Joke;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.hasProperty;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class JokeFacadeTest {
    private static EntityManagerFactory emf;
    private static JokeFacade facade;
    private static Joke joke;


    public JokeFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactory(
                "pu",
                "jdbc:mysql://localhost:3307/ca1_test",
                "dev",
                "ax2",
                EMF_Creator.Strategy.DROP_AND_CREATE);
        facade = JokeFacade.getJokeFacade(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Joke.deleteAllRows").executeUpdate();
            joke = new Joke("A mexican magician was doing a magic trick. He said, Uno, Dose, and he disappeared without a trace", true, 1993);
            em.persist(joke);
            em.persist(new Joke("What do you get if you cross a rethoric question with a joke?", false, 2019));
            em.persist(new Joke("There’s nothing wrong with you that an expensive operation can’t prolong.", true, 1974));
            em.persist(new Joke("Why is Juan so happy? He finally figured out himself. Huh, I  guess it takes Juan to know Juan", true, 1982));
            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testJokeCount() {
        assertEquals(4, facade.getJokeCount(), "Expects four rows in the database");
    }

    @Test
    public void testGetAllJokes() {
        List<Joke> jokes = facade.getAllJokes();
        assertEquals(4, jokes.size());
    }

    @Test
    public void testGetRandomJoke() {
        Joke joke = facade.getRandomJoke();
        Joke joke1 = joke;
        while (joke == joke1) {
            joke1 = facade.getRandomJoke();
        }
        assertNotEquals(joke, joke1);
    }

    @Test
    public void testGetJokeByIdSuccess() {
        assertEquals(joke.getTheJoke(), facade.getJokeById(joke.getId()).getTheJoke());
    }

    @Test
    public void testGetJokeByIdFailure() {
        assertEquals("Wow bro, there was like no joke to find or whatever", facade.getJokeById(5000).getTheJoke());
    }
}
