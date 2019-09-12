package dtos;

import entities.GroupMember;

public class GroupMemberDTO {

    private String firstName;
    private String lastName;
    private String studentID;
    private String color;

    public GroupMemberDTO(GroupMember gm) {
        this.firstName = gm.getFirstName();
        this.lastName = gm.getLastName();
        this.studentID = gm.getStudentID();
        this.color = gm.getColor();
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
