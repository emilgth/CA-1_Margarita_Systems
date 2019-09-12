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
        try {
            return em.createQuery("SELECT j from Joke j", Joke.class).getResultList();
        } finally {
            em.close();

        }
    }

    public Joke getJokeById(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
            Joke joke = em.find(Joke.class, id);
            if (joke == null){
                return  new Joke("Wow bro, there was like no joke to find or whatever", true, 2021);
            } else {
                return joke;
            }
        } finally {
            em.close();
        }
    }

    public Joke getRandomJoke(){
        EntityManager em = emf.createEntityManager();
        List<Joke> jokes = em.createQuery("SELECT j from Joke as j", Joke.class).getResultList();
        int size = jokes.size();
        Random random = new Random();
        int number = random.nextInt(size);
        return jokes.get(number);

    }


}
