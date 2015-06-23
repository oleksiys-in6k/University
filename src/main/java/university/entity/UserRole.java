package university.entity;

import javax.persistence.*;

@Entity
@Table(name = "userRole")
public class UserRole {

    @Id
    @Column(name = "roleId")
    @GeneratedValue
    private Integer roleId;

    @Column(name = "userRole")
    private String role;

//    public UserRole(String userRoles) {
//        this.role = userRoles;
//    }
//
//    public UserRole() {
//    }

    public String getUserRoles() {
        return role;
    }

    public void setUserRoles(String userRoles) {
        this.role = userRoles;
    }

    public Integer getStudentRoleId() {
        return roleId;
    }

    @Override
    public String toString() {
        return "(" + roleId + " studentRoleId, " + "role= " + role + ')';
    }
}
