package sk.kasv.huzvar.library.member;

import java.util.Date;

public class Member  {
    private  int id;
    private String firstName;
    private String lastName;
    private Date date;

    public Member(int id ,String firstName, String lastName, Date date) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
    }

    public Member(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", date=" + date +
                '}';
    }


}
