package cl.obam.pasteleria.lapalmera.view;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import cl.obam.pasteleria.lapalmera.model.Producto;

public class FamiliaVO implements java.io.Serializable {

	private String codigo;
	private String nombre;

	public FamiliaVO() {
	}

	public FamiliaVO(String codigofamilia) {
		this.codigo = codigofamilia;
	}

	public FamiliaVO(String codigofamilia, String nombrefamilia) {
		this.codigo = codigofamilia;
		this.nombre = nombrefamilia;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public String getNombre() {
		return this.nombre;
	}
}