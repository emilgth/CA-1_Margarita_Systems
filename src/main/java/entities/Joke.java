package entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author karlito
 */
@Entity
@NamedQuery(name = "Joke.deleteAllRows", query = "DELETE from Joke")
public class Joke implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String theJoke;
    private boolean typeOfJoke;
    private int yearOfJoke;


    public Joke( String theJoke, boolean typeOfJoke, int yearOfJoke ) {
        this.theJoke = theJoke;
        this.typeOfJoke = typeOfJoke;
        this.yearOfJoke = yearOfJoke;

    }

    public Joke() {

    }

    public int getYearOfJoke() {
        return yearOfJoke;
    }

    public void setYearOfJoke(int yearOfJoke) {
        this.yearOfJoke = yearOfJoke;
    }

    public String getTheJoke() {
        return theJoke;
    }

    public void setTheJoke(String theJoke) {
        this.theJoke = theJoke;
    }

    public boolean getTypeOfJoke() {
        return typeOfJoke;
    }

    public void setTypeOfJoke(boolean typeOfJoke) {
        this.typeOfJoke = typeOfJoke;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
