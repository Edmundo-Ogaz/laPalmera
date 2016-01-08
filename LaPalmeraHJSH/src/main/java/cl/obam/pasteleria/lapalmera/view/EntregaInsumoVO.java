package cl.obam.pasteleria.lapalmera.view;

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

public class EntregaInsumoVO implements java.io.Serializable {

	private Integer correlativoEntregaInsumo;
	private OrdenFabricacionVO ordenFabricacion;
	private FuncionarioVO funcionario;
	private Date fechaEntregaInsumo;
	private Date horaEntregaInsumo;
	private String observacion;
	private DetalleEntregaInsumoVO detalleEntregaInsumo;

	public EntregaInsumoVO() {
	}

	public EntregaInsumoVO(Integer correlativoEntregaInsumo,
			OrdenFabricacionVO ordenFabricacion,
			FuncionarioVO funcionario, Date fechaentregainsumo,
			Date horaentregainsumo) {
		this.correlativoEntregaInsumo = correlativoEntregaInsumo;
		this.ordenFabricacion = ordenFabricacion;
		this.funcionario = funcionario;
		this.fechaEntregaInsumo = fechaentregainsumo;
		this.horaEntregaInsumo = horaentregainsumo;
	}

	public EntregaInsumoVO(Integer correlativoEntregaInsumo,
			OrdenFabricacionVO ordenFabricacion,
			FuncionarioVO funcionario, Date fechaentregainsumo,
			Date horaentregainsumo, String observacion,
			DetalleEntregaInsumoVO detalleentregainsumo) {
		this.correlativoEntregaInsumo = correlativoEntregaInsumo;
		this.ordenFabricacion = ordenFabricacion;
		this.funcionario = funcionario;
		this.fechaEntregaInsumo = fechaentregainsumo;
		this.horaEntregaInsumo = horaentregainsumo;
		this.observacion = observacion;
		this.detalleEntregaInsumo = detalleentregainsumo;
	}

	public Integer getCorrelativoEntregaInsumo() {
		return this.correlativoEntregaInsumo;
	}

	public OrdenFabricacionVO getOrdenFabricacion() {
		return this.ordenFabricacion;
	}

	public FuncionarioVO getFuncionario() {
		return this.funcionario;
	}

	public Date getFechaEntregaInsumo() {
		return this.fechaEntregaInsumo;
	}

	public Date getHoraEntregaInsumo() {
		return this.horaEntregaInsumo;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public DetalleEntregaInsumoVO getDetalleEntregaInsumo() {
		return this.detalleEntregaInsumo;
	}
}