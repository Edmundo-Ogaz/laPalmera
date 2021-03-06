package cl.obam.pasteleria.lapalmera.model;

// Generated 07-01-2016 12:33:38 AM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Programaproduccion generated by hbm2java
 */
@Entity
@Table(name = "programaproduccion", catalog = "lapalmera")
public class Programaproduccion implements java.io.Serializable {

	private String codigo;
	private Producto producto;
	private Ordenfabricacion ordenfabricacion;
	private Lineaproduccion lineaproduccion;
	private Date fechaprogramaproduccion;
	private int cantidadprogramada;
	private int cantidadfabricada;
	private int saldoporfabricar;
	private byte active;
	private Set<Capturaproduccion> capturaproduccions = new HashSet<Capturaproduccion>(
			0);

	public Programaproduccion() {
	}

	public Programaproduccion(String codigo, Producto producto,
			Ordenfabricacion ordenfabricacion, Lineaproduccion lineaproduccion,
			Date fechaprogramaproduccion, int cantidadprogramada,
			int cantidadfabricada, int saldoporfabricar, byte active) {
		this.codigo = codigo;
		this.producto = producto;
		this.ordenfabricacion = ordenfabricacion;
		this.lineaproduccion = lineaproduccion;
		this.fechaprogramaproduccion = fechaprogramaproduccion;
		this.cantidadprogramada = cantidadprogramada;
		this.cantidadfabricada = cantidadfabricada;
		this.saldoporfabricar = saldoporfabricar;
		this.active = active;
	}

	public Programaproduccion(String codigo, Producto producto,
			Ordenfabricacion ordenfabricacion, Lineaproduccion lineaproduccion,
			Date fechaprogramaproduccion, int cantidadprogramada,
			int cantidadfabricada, int saldoporfabricar, byte active,
			Set<Capturaproduccion> capturaproduccions) {
		this.codigo = codigo;
		this.producto = producto;
		this.ordenfabricacion = ordenfabricacion;
		this.lineaproduccion = lineaproduccion;
		this.fechaprogramaproduccion = fechaprogramaproduccion;
		this.cantidadprogramada = cantidadprogramada;
		this.cantidadfabricada = cantidadfabricada;
		this.saldoporfabricar = saldoporfabricar;
		this.active = active;
		this.capturaproduccions = capturaproduccions;
	}

	@Id
	@Column(name = "CODIGO", unique = true, nullable = false, length = 20)
	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODIGOPRODUCTO", nullable = false)
	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODIGOORDENFABRICACION", nullable = false)
	public Ordenfabricacion getOrdenfabricacion() {
		return this.ordenfabricacion;
	}

	public void setOrdenfabricacion(Ordenfabricacion ordenfabricacion) {
		this.ordenfabricacion = ordenfabricacion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODIGOLINEAPRODUCCION", nullable = false)
	public Lineaproduccion getLineaproduccion() {
		return this.lineaproduccion;
	}

	public void setLineaproduccion(Lineaproduccion lineaproduccion) {
		this.lineaproduccion = lineaproduccion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHAPROGRAMAPRODUCCION", nullable = false, length = 19)
	public Date getFechaprogramaproduccion() {
		return this.fechaprogramaproduccion;
	}

	public void setFechaprogramaproduccion(Date fechaprogramaproduccion) {
		this.fechaprogramaproduccion = fechaprogramaproduccion;
	}

	@Column(name = "CANTIDADPROGRAMADA", nullable = false)
	public int getCantidadprogramada() {
		return this.cantidadprogramada;
	}

	public void setCantidadprogramada(int cantidadprogramada) {
		this.cantidadprogramada = cantidadprogramada;
	}

	@Column(name = "CANTIDADFABRICADA", nullable = false)
	public int getCantidadfabricada() {
		return this.cantidadfabricada;
	}

	public void setCantidadfabricada(int cantidadfabricada) {
		this.cantidadfabricada = cantidadfabricada;
	}

	@Column(name = "SALDOPORFABRICAR", nullable = false)
	public int getSaldoporfabricar() {
		return this.saldoporfabricar;
	}

	public void setSaldoporfabricar(int saldoporfabricar) {
		this.saldoporfabricar = saldoporfabricar;
	}

	@Column(name = "ACTIVE", nullable = false)
	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "programaproduccion")
	public Set<Capturaproduccion> getCapturaproduccions() {
		return this.capturaproduccions;
	}

	public void setCapturaproduccions(Set<Capturaproduccion> capturaproduccions) {
		this.capturaproduccions = capturaproduccions;
	}

}
