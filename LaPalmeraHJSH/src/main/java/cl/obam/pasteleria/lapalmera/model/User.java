package cl.obam.pasteleria.lapalmera.model;

// Generated 07-01-2016 12:33:38 AM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "user", catalog = "lapalmera")
public class User implements java.io.Serializable {

	private String username;
	private String email;
	private String password;
	private String salt;
	private Set<Userrole> userroles = new HashSet<Userrole>(0);

	public User() {
	}

	public User(String username) {
		this.username = username;
	}

	public User(String username, String email, String password, String salt,
			Set<Userrole> userroles) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.salt = salt;
		this.userroles = userroles;
	}

	@Id
	@Column(name = "username", unique = true, nullable = false, length = 45)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "email", length = 128)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", length = 128)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "salt", length = 128)
	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Userrole> getUserroles() {
		return this.userroles;
	}

	public void setUserroles(Set<Userrole> userroles) {
		this.userroles = userroles;
	}

}
