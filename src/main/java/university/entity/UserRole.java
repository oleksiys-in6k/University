package university.entity;

import javax.persistence.*;

@Entity
@Table(name = "userRole")
public class UserRole {

	@Id
	@Column(name = "roleId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer studentRoleId;

	@Column(name = "userRole")
	private String userRole;

	public UserRole(String userRoles) {
		this.userRole = userRoles;
	}

	public UserRole() {
	}

	public String getUserRoles() {
		return userRole;
	}

	public void setUserRoles(String userRoles) {
		this.userRole = userRoles;
	}

	public Integer getStudentRoleId() {
		return studentRoleId;
	}
}
