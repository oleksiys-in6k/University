package university.entity;


import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String login;
    private String password;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "userRole")
    private UserRole userRole;

    public User(String login, String password, UserRole userRole) {
        this.login = login;
        this.password = password;
        this.userRole = userRole;
    }

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "(login='" + login + ", password='" + password + ", userRole=" + userRole + ")";
    }
}
