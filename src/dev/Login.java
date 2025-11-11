package dev;

public class Login {

    private int id;
    private String username;
    private String password;

    public Login(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    //GET METHODS
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    //SET METHODS
    public void setID(int id) {
        this.id = id;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("%-10s | %-10s | %-5d", username, password, id);
    }
}
