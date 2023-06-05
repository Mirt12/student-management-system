package web.app.api;

public class Student {
     public int id;
     public String firstName;
     public String lastName;
     public String email;

    public Student(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}