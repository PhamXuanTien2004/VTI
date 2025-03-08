package entity;

public class User {
    private int id;
    private String FullName;
    private String email;
    private String password;

    public User(int id, String fullName, String email) {
        this.id = id;
        this.FullName = fullName;
        this.email = email;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return  "|" +
                "id=" + id +
                "| FullName='" + FullName + '\'' +
                "| email='" + email + '\''+
                "|"
                ;
    }
}
