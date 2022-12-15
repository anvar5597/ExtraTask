package onlineTest;

import javax.xml.crypto.Data;

public class User {
    public static Long countObject = 0L;
    private final Long id ;
    private String name;
    private String email;
    private String pasword;
    private String role;

    private Data data;

    public User(String name, String email, String pasword, String role) {
        countObject++;
        this.id = countObject;
        this.name = name;
        this.email = email;
        this.pasword = pasword;
        this.role = role;
    }

    public Long getId() {
        return id;
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

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", pasword='" + pasword + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
