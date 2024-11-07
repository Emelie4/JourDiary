package edu.utsa.cs3443.jourdiary.Model;

public class User {
    private String firstName;
    private String lastName;
    private String passWord;





    //Constructor
    public User(String firstName, String lastName, String passWord){
        this.firstName = firstName;
        this.lastName = lastName;
        this.passWord = passWord;
    }

    //Getters and Setters


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(){
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(){
        this.lastName = lastName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(){
        this.passWord = passWord;
    }

    public String toString(){
        return firstName + " " + lastName;
    }
}
