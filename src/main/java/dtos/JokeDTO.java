package dtos;

import entities.Joke;

public class JokeDTO {

    private String theJoke;

    public JokeDTO(Joke joke) {
        this.theJoke = joke.getTheJoke();
    }

    public JokeDTO(String theJoke) {
        this.theJoke = theJoke;
    }

    public String getTheJoke() {
        return theJoke;
    }

    public void setTheJoke(String theJoke) {
        this.theJoke = theJoke;
    }
}
