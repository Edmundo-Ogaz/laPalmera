package cl.obam.pasteleria.lapalmera.view;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

public class DespachoPedidoVO implements java.io.Serializable {

	private CabezaPedidoVO cabezaPedido;
	private String nombrecliente;
	private EntregaVO lugarEntrega;
	private String fechaentregadespacho;

	public DespachoPedidoVO() {
	}

	public DespachoPedidoVO(CabezaPedidoVO cabezaPedido, String nombrecliente,
			EntregaVO entrega, String fechaentregadespacho) {
		this.cabezaPedido = cabezaPedido;
		this.nombrecliente = nombrecliente;
		this.lugarEntrega = entrega;
		this.fechaentregadespacho = fechaentregadespacho;
	}

	public CabezaPedidoVO getCabezaPedido() {
		return this.cabezaPedido;
	}

	public String getNombrecliente() {
		return this.nombrecliente;
	}

	public EntregaVO getLugarEntrega() {
		return this.lugarEntrega;
	}

	public String getFechaentregadespacho() {
		return this.fechaentregadespacho;
	}
}