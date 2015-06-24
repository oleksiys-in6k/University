package university.entity;


import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "userId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String login;
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "fk_user", referencedColumnName = "userId")},
            inverseJoinColumns = {@JoinColumn(name = "ifk_role", referencedColumnName = "roleId")})
    private List<UserRole> userRole = new ArrayList<UserRole>();

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String login, String password, UserRole userRoleUser) {
        this.login = login;
        this.password = password;
        this.userRole.add(userRoleUser);
    }

    public List<UserRole> getUserRole() {
        return userRole;
    }

    public void setUserRole(List<UserRole> userRole) {
        this.userRole = userRole;
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

    public int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "(login= " + login + ", password= " + password + ", userRole= " + userRole + ")";
    }
}
