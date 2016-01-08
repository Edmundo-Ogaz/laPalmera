package cl.obam.pasteleria.lapalmera.view;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

public class UbicacionVO implements java.io.Serializable {

	private int id;
	private ProductoVO producto;
	private BodegaVO bodega;
	private String fechaIngreso;
	private String fechaVencimiento;	
	private Float cantidad;
	private UnidadMedidaVO unidadMedida;
	private String observacion;

	public UbicacionVO() {
	}

	public UbicacionVO(int id, ProductoVO producto, BodegaVO bodega, String fechaingreso, 
			String fechaVencimiento, Float cantidad, UnidadMedidaVO codigounidadmedida, 
			String observacion) {
		this.id = id;
		this.producto = producto;
		this.bodega = bodega;
		this.fechaIngreso = fechaingreso;
		this.fechaVencimiento = fechaVencimiento;
		this.cantidad = cantidad;
		this.unidadMedida = codigounidadmedida;
		this.observacion = observacion;
	}

	public int getId() {
		return this.id;
	}

	public BodegaVO getBodega() {
		return this.bodega;
	}

	public Float getCantidad() {
		return this.cantidad;
	}

	public UnidadMedidaVO getUnidadMedida() {
		return this.unidadMedida;
	}

	public ProductoVO getProducto() {
		return this.producto;
	}

	public String getFechaIngreso() {
		return this.fechaIngreso;
	}

	public String getFechaVencimiento() {
		return this.fechaVencimiento;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setUnidadMedida(UnidadMedidaVO unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	
	
}