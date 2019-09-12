/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import javax.persistence.EntityManagerFactory;

import dtos.JokeDTO;
import entities.Joke;

import java.util.ArrayList;
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

    public List<JokeDTO> getAllJokes() {
        EntityManager em = emf.createEntityManager();
        List<JokeDTO> jokeDTOS = new ArrayList<>();
        try {
            List<Joke> jokes = em.createQuery("SELECT j from Joke j", Joke.class).getResultList();
            jokes.forEach(joke -> jokeDTOS.add(new JokeDTO(joke)));
            return  jokeDTOS;
        } finally {
            em.close();
        }
    }

    public JokeDTO getJokeById(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
            Joke joke = em.find(Joke.class, id);
            if (joke == null){
                return new JokeDTO("Wow bro, there was like no joke to find or whatever");
            } else {
                return new JokeDTO(joke);
            }
        } finally {
            em.close();
        }
    }

    public JokeDTO getRandomJoke(){
        EntityManager em = emf.createEntityManager();
        List<Joke> jokes = em.createQuery("SELECT j from Joke as j", Joke.class).getResultList();
        int size = jokes.size();
        Random random = new Random();
        int number = random.nextInt(size);
        return new JokeDTO(jokes.get(number));

    }


}
