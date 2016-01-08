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
 * Tipoproducto generated by hbm2java
 */
@Entity
@Table(name = "tipoproducto", catalog = "lapalmera")
public class Tipoproducto implements java.io.Serializable {

	private String codigo;
	private String nombre;
	private Set<Producto> productos = new HashSet<Producto>(0);

	public Tipoproducto() {
	}

	public Tipoproducto(String codigo) {
		this.codigo = codigo;
	}

	public Tipoproducto(String codigo, String nombre, Set<Producto> productos) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.productos = productos;
	}

	@Id
	@Column(name = "codigo", unique = true, nullable = false, length = 10)
	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Column(name = "nombre", length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoproducto")
	public Set<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

}