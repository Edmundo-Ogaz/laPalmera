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
 * Tipocliente generated by hbm2java
 */
@Entity
@Table(name = "tipocliente", catalog = "lapalmera")
public class Tipocliente implements java.io.Serializable {

	private String codigo;
	private String nombre;
	private Set<Cliente> clientes = new HashSet<Cliente>(0);

	public Tipocliente() {
	}

	public Tipocliente(String codigo) {
		this.codigo = codigo;
	}

	public Tipocliente(String codigo, String nombre, Set<Cliente> clientes) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.clientes = clientes;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipocliente")
	public Set<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}

}