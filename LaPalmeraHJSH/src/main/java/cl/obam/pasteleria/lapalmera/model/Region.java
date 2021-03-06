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
 * Region generated by hbm2java
 */
@Entity
@Table(name = "region", catalog = "lapalmera")
public class Region implements java.io.Serializable {

	private String codigo;
	private String nombre;
	private Set<Ciudad> ciudads = new HashSet<Ciudad>(0);

	public Region() {
	}

	public Region(String codigo) {
		this.codigo = codigo;
	}

	public Region(String codigo, String nombre, Set<Ciudad> ciudads) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.ciudads = ciudads;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "region")
	public Set<Ciudad> getCiudads() {
		return this.ciudads;
	}

	public void setCiudads(Set<Ciudad> ciudads) {
		this.ciudads = ciudads;
	}

}
