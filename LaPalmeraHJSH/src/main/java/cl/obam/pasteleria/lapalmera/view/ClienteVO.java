package cl.obam.pasteleria.lapalmera.view;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class ClienteVO implements java.io.Serializable {

	private String rut;
	private ComunaVO comuna;
	private TipoClienteVO tipoCliente;
	private String dv;
	private String nombre;
	private String direccion;
	private Date fechanacimiento;
	private Integer telefono;
	private Integer celular;
	private String email;
	private String paginawebcliente;
	private String observacion;

	public ClienteVO() {
	}

	public ClienteVO(String rut, ComunaVO comuna, TipoClienteVO tipoCliente,
			String dv, String nombre, String direccion, Date fechanacimiento,
			Integer telefono, Integer celular, String email,
			String paginawebcliente, String observacion) {
		this.rut = rut;
		this.comuna = comuna;
		this.tipoCliente = tipoCliente;
		this.dv = dv;
		this.nombre = nombre;
		this.direccion = direccion;
		this.fechanacimiento = fechanacimiento;
		this.telefono = telefono;
		this.celular = celular;
		this.email = email;
		this.paginawebcliente = paginawebcliente;
		this.observacion = observacion;
	}

	public String getRut() {
		return this.rut;
	}

	public ComunaVO getComuna() {
		return this.comuna;
	}

	public TipoClienteVO getTipoCliente() {
		return this.tipoCliente;
	}

	public String getDv() {
		return this.dv;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public Date getFechanacimiento() {
		return this.fechanacimiento;
	}

	public Integer getTelefono() {
		return this.telefono;
	}

	public Integer getCelular() {
		return this.celular;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPaginawebcliente() {
		return this.paginawebcliente;
	}

	public String getObservacion() {
		return this.observacion;
	}
}