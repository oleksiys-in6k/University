package university.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_roles")
public class UserRole {

	@Id
	@Column(name = "roleId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer studentRoleId;

//	@JoinColumn(name = "studentId", nullable = false)
	@ManyToMany(mappedBy = "userRoles")
	private Set<Student> student = new HashSet<>();

	@Enumerated(EnumType.STRING)
	private ListRole listRole;

	public UserRole() {
	}

	public UserRole(Integer studentRoleId) {
		this.studentRoleId = studentRoleId;
	}

	public Set<Student> getStudent() {
		return student;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}

	public ListRole getListRole() {
		return listRole;
	}

	public void setListRole(ListRole listRole) {
		this.listRole = listRole;
	}

	public Integer getStudentRoleId() {
		return this.studentRoleId;
	}

}
