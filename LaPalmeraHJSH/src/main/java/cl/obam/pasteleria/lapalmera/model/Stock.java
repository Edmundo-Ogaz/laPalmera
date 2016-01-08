package cl.obam.pasteleria.lapalmera.model;

// Generated 07-01-2016 12:33:38 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Stock generated by hbm2java
 */
@Entity
@Table(name = "stock", catalog = "lapalmera")
public class Stock implements java.io.Serializable {

	private String codigoproducto;
	private Unidadmedida unidadmedida;
	private Producto producto;
	private Float stockdisponible;
	private Float stockcomprometido;

	public Stock() {
	}

	public Stock(Unidadmedida unidadmedida, Producto producto) {
		this.unidadmedida = unidadmedida;
		this.producto = producto;
	}

	public Stock(Unidadmedida unidadmedida, Producto producto,
			Float stockdisponible, Float stockcomprometido) {
		this.unidadmedida = unidadmedida;
		this.producto = producto;
		this.stockdisponible = stockdisponible;
		this.stockcomprometido = stockcomprometido;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "producto"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "CODIGOPRODUCTO", unique = true, nullable = false, length = 20)
	public String getCodigoproducto() {
		return this.codigoproducto;
	}

	public void setCodigoproducto(String codigoproducto) {
		this.codigoproducto = codigoproducto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODIGOUNIDADMEDIDA", nullable = false)
	public Unidadmedida getUnidadmedida() {
		return this.unidadmedida;
	}

	public void setUnidadmedida(Unidadmedida unidadmedida) {
		this.unidadmedida = unidadmedida;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Column(name = "STOCKDISPONIBLE", precision = 11, scale = 0)
	public Float getStockdisponible() {
		return this.stockdisponible;
	}

	public void setStockdisponible(Float stockdisponible) {
		this.stockdisponible = stockdisponible;
	}

	@Column(name = "STOCKCOMPROMETIDO", precision = 11, scale = 0)
	public Float getStockcomprometido() {
		return this.stockcomprometido;
	}

	public void setStockcomprometido(Float stockcomprometido) {
		this.stockcomprometido = stockcomprometido;
	}

}
