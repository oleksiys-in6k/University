package university.entity;

import javax.persistence.*;

@Entity
@Table(name = "userRole")
public class UserRole {

    @Id
    @Column(name = "roleId")
    @GeneratedValue
    private Integer roleId;

    @Column(name = "name")
    private String name;

//    public UserRole(String userRoles) {
//        this.role = userRoles;
//    }
//
//    public UserRole() {
//    }

    public String getUserRoles() {
        return name;
    }

    public void setUserRoles(String name) {
        this.name = name;
    }

    public Integer getStudentRoleId() {
        return roleId;
    }

    @Override
    public String toString() {
        return "(" + roleId + " studentRoleId, " + "role= " + name + ')';
    }
}
