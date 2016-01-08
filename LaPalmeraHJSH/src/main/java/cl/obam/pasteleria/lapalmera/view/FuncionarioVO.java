package cl.obam.pasteleria.lapalmera.view;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

public class FuncionarioVO implements java.io.Serializable {

	private String rut;
	private AreaVO area;
	private CargoVO cargo;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;

	public FuncionarioVO() {
	}

	public FuncionarioVO(String rut, AreaVO area, CargoVO cargo) {
		this.rut = rut;
		this.area = area;
		this.cargo = cargo;
	}

	public FuncionarioVO(String rut, AreaVO area, CargoVO cargo,
			String nombre, String apellidopaterno, String apellidomaterno) {
		this.rut = rut;
		this.area = area;
		this.cargo = cargo;
		this.nombre = nombre;
		this.apellidoPaterno = apellidopaterno;
		this.apellidoMaterno = apellidomaterno;
	}

	public String getRut() {
		return this.rut;
	}

	public AreaVO getArea() {
		return this.area;
	}

	public CargoVO getCargo() {
		return this.cargo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getApellidoPaterno() {
		return this.apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return this.apellidoMaterno;
	}
}