package cl.obam.pasteleria.lapalmera.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

public class ProductoLineaVO implements java.io.Serializable {

	private Integer id;
	private ProductoVO producto;
	private LineaProduccionVO lineaProduccion;
	private int prioridad;

	public ProductoLineaVO() {
	}

	public ProductoLineaVO(Integer id, ProductoVO producto, LineaProduccionVO lineaproduccion,
			int prioridad) {
		this.id = id;
		this.producto = producto;
		this.lineaProduccion = lineaproduccion;
		this.prioridad = prioridad;
	}
	
	public Integer getId() {
		return this.id;
	}

	public ProductoVO getProducto() {
		return this.producto;
	}

	public LineaProduccionVO getLineaProduccion() {
		return this.lineaProduccion;
	}

	public int getPrioridad() {
		return this.prioridad;
	}
}