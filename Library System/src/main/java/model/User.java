package model;

public class User {
    private int id;       // int for ID
    private String name;
    private String email;

    // Constructor without ID (for insert)
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Constructor with ID (for select/update)
    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters & setters
    public int getId() {
        return id;
    }

    public void setId(int id) {   // must be int
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
