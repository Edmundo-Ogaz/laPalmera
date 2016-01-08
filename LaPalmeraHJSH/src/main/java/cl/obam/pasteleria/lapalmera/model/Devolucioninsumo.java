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
 * Devolucioninsumo generated by hbm2java
 */
@Entity
@Table(name = "devolucioninsumo", catalog = "lapalmera")
public class Devolucioninsumo implements java.io.Serializable {

	private Integer correlativoentregainsumo;
	private Ordenfabricacion ordenfabricacion;
	private Funcionario funcionario;
	private Date fechadevolucioninsumo;
	private Date horadevolucioninsumo;
	private String observacion;
	private Detalledevolucioninsumo detalledevolucioninsumo;

	public Devolucioninsumo() {
	}

	public Devolucioninsumo(Ordenfabricacion ordenfabricacion,
			Funcionario funcionario, Date fechadevolucioninsumo,
			Date horadevolucioninsumo) {
		this.ordenfabricacion = ordenfabricacion;
		this.funcionario = funcionario;
		this.fechadevolucioninsumo = fechadevolucioninsumo;
		this.horadevolucioninsumo = horadevolucioninsumo;
	}

	public Devolucioninsumo(Ordenfabricacion ordenfabricacion,
			Funcionario funcionario, Date fechadevolucioninsumo,
			Date horadevolucioninsumo, String observacion,
			Detalledevolucioninsumo detalledevolucioninsumo) {
		this.ordenfabricacion = ordenfabricacion;
		this.funcionario = funcionario;
		this.fechadevolucioninsumo = fechadevolucioninsumo;
		this.horadevolucioninsumo = horadevolucioninsumo;
		this.observacion = observacion;
		this.detalledevolucioninsumo = detalledevolucioninsumo;
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
	@Column(name = "FECHADEVOLUCIONINSUMO", nullable = false, length = 10)
	public Date getFechadevolucioninsumo() {
		return this.fechadevolucioninsumo;
	}

	public void setFechadevolucioninsumo(Date fechadevolucioninsumo) {
		this.fechadevolucioninsumo = fechadevolucioninsumo;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "HORADEVOLUCIONINSUMO", nullable = false, length = 8)
	public Date getHoradevolucioninsumo() {
		return this.horadevolucioninsumo;
	}

	public void setHoradevolucioninsumo(Date horadevolucioninsumo) {
		this.horadevolucioninsumo = horadevolucioninsumo;
	}

	@Column(name = "OBSERVACION", length = 80)
	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "devolucioninsumo")
	public Detalledevolucioninsumo getDetalledevolucioninsumo() {
		return this.detalledevolucioninsumo;
	}

	public void setDetalledevolucioninsumo(
			Detalledevolucioninsumo detalledevolucioninsumo) {
		this.detalledevolucioninsumo = detalledevolucioninsumo;
	}

}
