package cl.obam.pasteleria.lapalmera.view;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

public class EstadoPedidoVO implements java.io.Serializable {

	private String codigo;
	private String nombre;

	public EstadoPedidoVO() {
	}

	public EstadoPedidoVO(String codigo) {
		this.codigo = codigo;
	}

	public EstadoPedidoVO(String codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public String getNombre() {
		return this.nombre;
	}
}