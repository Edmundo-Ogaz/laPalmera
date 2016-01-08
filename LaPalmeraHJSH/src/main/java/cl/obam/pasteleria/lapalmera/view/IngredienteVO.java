package cl.obam.pasteleria.lapalmera.view;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

public class IngredienteVO implements java.io.Serializable {

	private int id;
	private ProductoVO producto;
	private ProductoVO insumo;
	private int carga;
	private float cantidadinsumo;
	private UnidadMedidaVO unidadMedida;

	public IngredienteVO() {
	}

	public IngredienteVO(int id, ProductoVO producto, ProductoVO insumo,
			int carga, float cantidadinsumo, UnidadMedidaVO codigounidadmedida) {
		this.id = id;
		this.producto = producto;
		this.insumo = insumo;
		this.carga = carga;
		this.cantidadinsumo = cantidadinsumo;
		this.unidadMedida = codigounidadmedida;
	}

	public int getId() {
		return id;
	}

	public ProductoVO getProducto() {
		return this.producto;
	}

	public ProductoVO getInsumo() {
		return this.insumo;
	}

	public int getCarga() {
		return this.carga;
	}

	public float getCantidadinsumo() {
		return this.cantidadinsumo;
	}

	public UnidadMedidaVO getUnidadMedida() {
		return this.unidadMedida;
	}
}