package cl.obam.pasteleria.lapalmera.view;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

public class EstadoOrdenFabricacionVO implements java.io.Serializable {

	private String codigo;
	private String nombre;

	public EstadoOrdenFabricacionVO() {
	}

	public EstadoOrdenFabricacionVO(String codigo) {
		this.codigo = codigo;
	}

	public EstadoOrdenFabricacionVO(String codigo, String nombre) {
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