package edu.utsa.cs3443.jourdiary.Model;

/**
* Represents a user in the application
* @author Team Skittlez
*/
public class User {
    private String firstName;
    private String lastName;
    private String userName;
    private String passWord;

    /**
    * Constructor for User
    * @param firstName
    * @param lastName
    * @param userName
    * @param passWord
    */
    
    public User(String firstName, String lastName, String userName, String passWord) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.passWord = passWord;
    }

    //Getters and Setters
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    //toString Method
    @Override
    public String toString() {
        return firstName + " " + lastName + " " + userName + " " + passWord;
    }
}
