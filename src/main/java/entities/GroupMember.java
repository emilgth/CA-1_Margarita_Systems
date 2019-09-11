package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQuery(name = "GroupMember.deleteAllRows", query = "DELETE from GroupMember ")
public class GroupMember implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String studentID;
    private String color;

    public GroupMember() {
    }

    public GroupMember(String firstName, String lastName, String studentID, String color) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
        this.color = color;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
