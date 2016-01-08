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
 * Lineaproduccion generated by hbm2java
 */
@Entity
@Table(name = "lineaproduccion", catalog = "lapalmera")
public class Lineaproduccion implements java.io.Serializable {

	private String codigolineaproduccion;
	private String nombrelineaproduccion;
	private Set<Productolinea> productolineas = new HashSet<Productolinea>(0);
	private Set<Programaproduccion> programaproduccions = new HashSet<Programaproduccion>(
			0);

	public Lineaproduccion() {
	}

	public Lineaproduccion(String codigolineaproduccion) {
		this.codigolineaproduccion = codigolineaproduccion;
	}

	public Lineaproduccion(String codigolineaproduccion,
			String nombrelineaproduccion, Set<Productolinea> productolineas,
			Set<Programaproduccion> programaproduccions) {
		this.codigolineaproduccion = codigolineaproduccion;
		this.nombrelineaproduccion = nombrelineaproduccion;
		this.productolineas = productolineas;
		this.programaproduccions = programaproduccions;
	}

	@Id
	@Column(name = "CODIGOLINEAPRODUCCION", unique = true, nullable = false, length = 20)
	public String getCodigolineaproduccion() {
		return this.codigolineaproduccion;
	}

	public void setCodigolineaproduccion(String codigolineaproduccion) {
		this.codigolineaproduccion = codigolineaproduccion;
	}

	@Column(name = "NOMBRELINEAPRODUCCION", length = 80)
	public String getNombrelineaproduccion() {
		return this.nombrelineaproduccion;
	}

	public void setNombrelineaproduccion(String nombrelineaproduccion) {
		this.nombrelineaproduccion = nombrelineaproduccion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lineaproduccion")
	public Set<Productolinea> getProductolineas() {
		return this.productolineas;
	}

	public void setProductolineas(Set<Productolinea> productolineas) {
		this.productolineas = productolineas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lineaproduccion")
	public Set<Programaproduccion> getProgramaproduccions() {
		return this.programaproduccions;
	}

	public void setProgramaproduccions(
			Set<Programaproduccion> programaproduccions) {
		this.programaproduccions = programaproduccions;
	}

}
