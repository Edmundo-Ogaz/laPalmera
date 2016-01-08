package cl.obam.pasteleria.lapalmera.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

public class StockVO implements java.io.Serializable {

	private ProductoVO producto;
	private Float stockDisponible;
	private Float stockComprometido;
	private UnidadMedidaVO unidadMedida;

	public StockVO() {
	}

	public StockVO(ProductoVO producto, Float stockdisponible,
			Float stockcomprometido, UnidadMedidaVO codigounidadmedida) {
		this.producto = producto;
		this.stockDisponible = stockdisponible;
		this.stockComprometido = stockcomprometido;
		this.unidadMedida = codigounidadmedida;
	}

	public ProductoVO getProducto() {
		return this.producto;
	}

	public Float getStockDisponible() {
		return this.stockDisponible;
	}

	public Float getStockComprometido() {
		return this.stockComprometido;
	}

	public UnidadMedidaVO getUnidadMedida() {
		return this.unidadMedida;
	}

	public void setStockDisponible(Float stockDisponible) {
		this.stockDisponible = stockDisponible;
	}

	public void setStockComprometido(Float stockComprometido) {
		this.stockComprometido = stockComprometido;
	}

	public void setUnidadMedida(UnidadMedidaVO unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
}