package cl.obam.pasteleria.lapalmera.model;

// Generated 07-01-2016 12:33:38 AM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entregainsumo generated by hbm2java
 */
@Entity
@Table(name = "entregainsumo", catalog = "lapalmera")
public class Entregainsumo implements java.io.Serializable {

	private Integer correlativoentregainsumo;
	private Ordenfabricacion ordenfabricacion;
	private Funcionario funcionario;
	private Date fechaentregainsumo;
	private Date horaentregainsumo;
	private String observacion;
	private Detalleentregainsumo detalleentregainsumo;

	public Entregainsumo() {
	}

	public Entregainsumo(Ordenfabricacion ordenfabricacion,
			Funcionario funcionario, Date fechaentregainsumo,
			Date horaentregainsumo) {
		this.ordenfabricacion = ordenfabricacion;
		this.funcionario = funcionario;
		this.fechaentregainsumo = fechaentregainsumo;
		this.horaentregainsumo = horaentregainsumo;
	}

	public Entregainsumo(Ordenfabricacion ordenfabricacion,
			Funcionario funcionario, Date fechaentregainsumo,
			Date horaentregainsumo, String observacion,
			Detalleentregainsumo detalleentregainsumo) {
		this.ordenfabricacion = ordenfabricacion;
		this.funcionario = funcionario;
		this.fechaentregainsumo = fechaentregainsumo;
		this.horaentregainsumo = horaentregainsumo;
		this.observacion = observacion;
		this.detalleentregainsumo = detalleentregainsumo;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CORRELATIVOENTREGAINSUMO", unique = true, nullable = false)
	public Integer getCorrelativoentregainsumo() {
		return this.correlativoentregainsumo;
	}

	public void setCorrelativoentregainsumo(Integer correlativoentregainsumo) {
		this.correlativoentregainsumo = correlativoentregainsumo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODIGOORDENFABRICACION", nullable = false)
	public Ordenfabricacion getOrdenfabricacion() {
		return this.ordenfabricacion;
	}

	public void setOrdenfabricacion(Ordenfabricacion ordenfabricacion) {
		this.ordenfabricacion = ordenfabricacion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RUTFUNCIONARIO", nullable = false)
	public Funcionario getFuncionario() {
		return this.funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHAENTREGAINSUMO", nullable = false, length = 10)
	public Date getFechaentregainsumo() {
		return this.fechaentregainsumo;
	}

	public void setFechaentregainsumo(Date fechaentregainsumo) {
		this.fechaentregainsumo = fechaentregainsumo;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "HORAENTREGAINSUMO", nullable = false, length = 8)
	public Date getHoraentregainsumo() {
		return this.horaentregainsumo;
	}

	public void setHoraentregainsumo(Date horaentregainsumo) {
		this.horaentregainsumo = horaentregainsumo;
	}

	@Column(name = "OBSERVACION", length = 80)
	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "entregainsumo")
	public Detalleentregainsumo getDetalleentregainsumo() {
		return this.detalleentregainsumo;
	}

	public void setDetalleentregainsumo(
			Detalleentregainsumo detalleentregainsumo) {
		this.detalleentregainsumo = detalleentregainsumo;
	}

}