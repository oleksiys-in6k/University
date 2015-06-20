package university.entity;

import javax.persistence.*;

@Entity
@Table(name = "student_roles",
		uniqueConstraints = @UniqueConstraint(
				columnNames = { "role", "studentId" }))
public class UserRole {

	@Id
	@Column(name = "studentRoleId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer studentRoleId;

	@ManyToOne
	@JoinColumn(name = "studentId", nullable = false)
	private Student student;
	private String role;

	public UserRole() {
	}

	public UserRole(Student student, String role) {
		this.student = student;
		this.role = role;
	}

	public Integer getStudentRoleId() {
		return this.studentRoleId;
	}

	public void setStudentRoleId(Integer studentRoleId) {
		this.studentRoleId = studentRoleId;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
