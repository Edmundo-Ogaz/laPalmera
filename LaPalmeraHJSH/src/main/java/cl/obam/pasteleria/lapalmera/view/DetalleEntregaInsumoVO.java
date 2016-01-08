package cl.obam.pasteleria.lapalmera.view;

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

public class DetalleEntregaInsumoVO implements java.io.Serializable {

	private EntregaInsumoVO entregaInsumo;
	private ProductoVO insumo;
	private Integer cantidadentregainsumo;
	private UnidadMedidaVO unidadMedida;

	public DetalleEntregaInsumoVO() {
	}

	public DetalleEntregaInsumoVO(EntregaInsumoVO entregaInsumo, ProductoVO insumo,
			Integer cantidadentregainsumo, UnidadMedidaVO codigounidadmedida) {
		this.entregaInsumo = entregaInsumo;
		this.insumo = insumo;
		this.cantidadentregainsumo = cantidadentregainsumo;
		this.unidadMedida = codigounidadmedida;
	}

	public EntregaInsumoVO getEntregaInsumo() {
		return this.entregaInsumo;
	}

	public ProductoVO getInsumo() {
		return this.insumo;
	}

	public Integer getCantidadentregainsumo() {
		return this.cantidadentregainsumo;
	}

	public UnidadMedidaVO getUnidadMedida() {
		return this.unidadMedida;
	}
}