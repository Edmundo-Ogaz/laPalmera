package cl.obam.pasteleria.lapalmera.model;

// Generated 07-01-2016 12:33:38 AM by Hibernate Tools 3.4.0.CR1

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

/**
 * Funcionario generated by hbm2java
 */
@Entity
@Table(name = "funcionario", catalog = "lapalmera")
public class Funcionario implements java.io.Serializable {

	private String rutfuncionario;
	private Area area;
	private Cargo cargo;
	private String nombre;
	private String apellidopaterno;
	private String apellidomaterno;
	private Set<Usuario> usuarios = new HashSet<Usuario>(0);
	private Set<Devolucioninsumo> devolucioninsumos = new HashSet<Devolucioninsumo>(
			0);
	private Set<Especificarproduccion> especificarproduccions = new HashSet<Especificarproduccion>(
			0);
	private Set<Entregainsumo> entregainsumos = new HashSet<Entregainsumo>(0);
	private Set<Capturaproduccion> capturaproduccions = new HashSet<Capturaproduccion>(
			0);

	public Funcionario() {
	}

	public Funcionario(String rutfuncionario, Area area, Cargo cargo) {
		this.rutfuncionario = rutfuncionario;
		this.area = area;
		this.cargo = cargo;
	}

	public Funcionario(String rutfuncionario, Area area, Cargo cargo,
			String nombre, String apellidopaterno, String apellidomaterno,
			Set<Usuario> usuarios, Set<Devolucioninsumo> devolucioninsumos,
			Set<Especificarproduccion> especificarproduccions,
			Set<Entregainsumo> entregainsumos,
			Set<Capturaproduccion> capturaproduccions) {
		this.rutfuncionario = rutfuncionario;
		this.area = area;
		this.cargo = cargo;
		this.nombre = nombre;
		this.apellidopaterno = apellidopaterno;
		this.apellidomaterno = apellidomaterno;
		this.usuarios = usuarios;
		this.devolucioninsumos = devolucioninsumos;
		this.especificarproduccions = especificarproduccions;
		this.entregainsumos = entregainsumos;
		this.capturaproduccions = capturaproduccions;
	}

	@Id
	@Column(name = "RUTFUNCIONARIO", unique = true, nullable = false, length = 10)
	public String getRutfuncionario() {
		return this.rutfuncionario;
	}

	public void setRutfuncionario(String rutfuncionario) {
		this.rutfuncionario = rutfuncionario;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODIGOAREA", nullable = false)
	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODIGOCARGO", nullable = false)
	public Cargo getCargo() {
		return this.cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	@Column(name = "NOMBRE", length = 80)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "APELLIDOPATERNO", length = 80)
	public String getApellidopaterno() {
		return this.apellidopaterno;
	}

	public void setApellidopaterno(String apellidopaterno) {
		this.apellidopaterno = apellidopaterno;
	}

	@Column(name = "APELLIDOMATERNO", length = 80)
	public String getApellidomaterno() {
		return this.apellidomaterno;
	}

	public void setApellidomaterno(String apellidomaterno) {
		this.apellidomaterno = apellidomaterno;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "funcionario")
	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "funcionario")
	public Set<Devolucioninsumo> getDevolucioninsumos() {
		return this.devolucioninsumos;
	}

	public void setDevolucioninsumos(Set<Devolucioninsumo> devolucioninsumos) {
		this.devolucioninsumos = devolucioninsumos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "funcionario")
	public Set<Especificarproduccion> getEspecificarproduccions() {
		return this.especificarproduccions;
	}

	public void setEspecificarproduccions(
			Set<Especificarproduccion> especificarproduccions) {
		this.especificarproduccions = especificarproduccions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "funcionario")
	public Set<Entregainsumo> getEntregainsumos() {
		return this.entregainsumos;
	}

	public void setEntregainsumos(Set<Entregainsumo> entregainsumos) {
		this.entregainsumos = entregainsumos;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "funcionarios")
	public Set<Capturaproduccion> getCapturaproduccions() {
		return this.capturaproduccions;
	}

	public void setCapturaproduccions(Set<Capturaproduccion> capturaproduccions) {
		this.capturaproduccions = capturaproduccions;
	}

}
