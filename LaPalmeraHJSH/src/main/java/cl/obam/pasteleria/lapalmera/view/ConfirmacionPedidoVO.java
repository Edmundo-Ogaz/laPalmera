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

public class ConfirmacionPedidoVO implements java.io.Serializable {

	private CabezaPedidoVO cabezaPedido;
	private String nombrecliente;
	private String apellidocliente;
	private String direccioncliente;
	private String fecha;

	public ConfirmacionPedidoVO() {
	}

	public ConfirmacionPedidoVO(CabezaPedidoVO cabezaPedido, String nombrecliente,
			String apellidocliente, String direccioncliente, String fecha) {
		this.cabezaPedido = cabezaPedido;
		this.nombrecliente = nombrecliente;
		this.apellidocliente = apellidocliente;
		this.direccioncliente = direccioncliente;
		this.fecha = fecha;
	}

	public CabezaPedidoVO getCabezaPedido() {
		return this.cabezaPedido;
	}

	public String getNombrecliente() {
		return this.nombrecliente;
	}

	public String getApellidocliente() {
		return this.apellidocliente;
	}

	public String getDireccioncliente() {
		return this.direccioncliente;
	}

	public String getFecha() {
		return fecha;
	}
}