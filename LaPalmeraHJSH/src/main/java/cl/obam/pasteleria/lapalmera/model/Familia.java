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
 * Familia generated by hbm2java
 */
@Entity
@Table(name = "familia", catalog = "lapalmera")
public class Familia implements java.io.Serializable {

	private String codigofamilia;
	private String nombrefamilia;
	private Set<Subfamilia> subfamilias = new HashSet<Subfamilia>(0);
	private Set<Producto> productos = new HashSet<Producto>(0);
	private Set<Unidadmedida> unidadmedidas = new HashSet<Unidadmedida>(0);

	public Familia() {
	}

	public Familia(String codigofamilia) {
		this.codigofamilia = codigofamilia;
	}

	public Familia(String codigofamilia, String nombrefamilia,
			Set<Subfamilia> subfamilias, Set<Producto> productos,
			Set<Unidadmedida> unidadmedidas) {
		this.codigofamilia = codigofamilia;
		this.nombrefamilia = nombrefamilia;
		this.subfamilias = subfamilias;
		this.productos = productos;
		this.unidadmedidas = unidadmedidas;
	}

	@Id
	@Column(name = "CODIGOFAMILIA", unique = true, nullable = false, length = 20)
	public String getCodigofamilia() {
		return this.codigofamilia;
	}

	public void setCodigofamilia(String codigofamilia) {
		this.codigofamilia = codigofamilia;
	}

	@Column(name = "NOMBREFAMILIA", length = 80)
	public String getNombrefamilia() {
		return this.nombrefamilia;
	}

	public void setNombrefamilia(String nombrefamilia) {
		this.nombrefamilia = nombrefamilia;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "familia")
	public Set<Subfamilia> getSubfamilias() {
		return this.subfamilias;
	}

	public void setSubfamilias(Set<Subfamilia> subfamilias) {
		this.subfamilias = subfamilias;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "familia")
	public Set<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "familia")
	public Set<Unidadmedida> getUnidadmedidas() {
		return this.unidadmedidas;
	}

	public void setUnidadmedidas(Set<Unidadmedida> unidadmedidas) {
		this.unidadmedidas = unidadmedidas;
	}

}
