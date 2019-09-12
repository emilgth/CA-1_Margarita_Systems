/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import javax.persistence.EntityManagerFactory;
import entities.Joke;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;

/**
 *
 * @author karlito
 */
public class JokeFacade {

    private static JokeFacade instance;
    private static EntityManagerFactory emf;

    private JokeFacade() {

    }

    public static JokeFacade getJokeFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new JokeFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public long getJokeCount() {
        EntityManager em = emf.createEntityManager();
        try {
            long jokeCount = (long) em.createQuery("SELECT COUNT(m) FROM Joke m").getSingleResult();
            return jokeCount;
        } finally {
            em.close();
        }
    }

    public List<Joke> getAllJokes() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT j from Joke j", Joke.class).getResultList();
    }

    public Joke getJokeById(long id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Joke.class, id);
    }

    public Joke getRandomJoke(){
        EntityManager em = emf.createEntityManager();
        List<Joke> jokes = em.createQuery("SELECT j from Joke as j order by random()", Joke.class).getResultList();
        int size = jokes.size();
        Random random = new Random();
        int number = random.nextInt(size);
        return jokes.get(number);

    }


}
