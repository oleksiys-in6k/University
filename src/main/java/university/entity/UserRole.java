package university.entity;

import javax.persistence.*;

@Entity
@Table(name = "userRole")
public class UserRole {

    @Id
    @Column(name = "roleId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentRoleId;

    @Column(name = "userRole")
    private String role;

    public UserRole(String userRoles) {
        this.role = userRoles;
    }

    public UserRole() {
    }

    public String getUserRoles() {
        return role;
    }

    public void setUserRoles(String userRoles) {
        this.role = userRoles;
    }

    public Integer getStudentRoleId() {
        return studentRoleId;
    }

    @Override
    public String toString() {
        return "(" + studentRoleId + " studentRoleId, " + "role= " + role + ')';
    }
}
