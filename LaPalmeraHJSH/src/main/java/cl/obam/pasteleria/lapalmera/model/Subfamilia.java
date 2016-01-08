package cl.obam.pasteleria.lapalmera.model;

// Generated 07-01-2016 12:33:38 AM by Hibernate Tools 3.4.0.CR1

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

/**
 * Subfamilia generated by hbm2java
 */
@Entity
@Table(name = "subfamilia", catalog = "lapalmera")
public class Subfamilia implements java.io.Serializable {

	private String codigosubfamilia;
	private Familia familia;
	private String nombresubfamilia;
	private Set<Producto> productos = new HashSet<Producto>(0);

	public Subfamilia() {
	}

	public Subfamilia(String codigosubfamilia) {
		this.codigosubfamilia = codigosubfamilia;
	}

	public Subfamilia(String codigosubfamilia, Familia familia,
			String nombresubfamilia, Set<Producto> productos) {
		this.codigosubfamilia = codigosubfamilia;
		this.familia = familia;
		this.nombresubfamilia = nombresubfamilia;
		this.productos = productos;
	}

	@Id
	@Column(name = "CODIGOSUBFAMILIA", unique = true, nullable = false, length = 20)
	public String getCodigosubfamilia() {
		return this.codigosubfamilia;
	}

	public void setCodigosubfamilia(String codigosubfamilia) {
		this.codigosubfamilia = codigosubfamilia;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODIGOFAMILIA")
	public Familia getFamilia() {
		return this.familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

	@Column(name = "NOMBRESUBFAMILIA", length = 80)
	public String getNombresubfamilia() {
		return this.nombresubfamilia;
	}

	public void setNombresubfamilia(String nombresubfamilia) {
		this.nombresubfamilia = nombresubfamilia;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subfamilia")
	public Set<Producto> getProductos() {
		return this.productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

}