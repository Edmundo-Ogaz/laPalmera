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
 * Grupo generated by hbm2java
 */
@Entity
@Table(name = "grupo", catalog = "lapalmera")
public class Grupo implements java.io.Serializable {

	private String codigo;
	private String nombre;
	private Set<Usuario> usuarios = new HashSet<Usuario>(0);

	public Grupo() {
	}

	public Grupo(String codigo) {
		this.codigo = codigo;
	}

	public Grupo(String codigo, String nombre, Set<Usuario> usuarios) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.usuarios = usuarios;
	}

	@Id
	@Column(name = "CODIGO", unique = true, nullable = false, length = 20)
	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Column(name = "NOMBRE", length = 80)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "grupo")
	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
