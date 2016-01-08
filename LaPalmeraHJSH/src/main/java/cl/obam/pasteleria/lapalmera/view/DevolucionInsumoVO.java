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

public class DevolucionInsumoVO implements java.io.Serializable {

	private Integer correlativoEntregaInsumo;
	private OrdenFabricacionVO ordenFabricacion;
	private FuncionarioVO funcionario;
	private Date fechaDevolucionInsumo;
	private Date horaDevolucionInsumo;
	private String observacion;
	private DetalleDevolucionInsumoVO detalleDevolucionInsumo;

	public DevolucionInsumoVO() {
	}

	public DevolucionInsumoVO(OrdenFabricacionVO ordenFabricacion,
			FuncionarioVO funcionario, Date fechadevolucioninsumo,
			Date horadevolucioninsumo) {
		this.ordenFabricacion = ordenFabricacion;
		this.funcionario = funcionario;
		this.fechaDevolucionInsumo = fechadevolucioninsumo;
		this.horaDevolucionInsumo = horadevolucioninsumo;
	}

	public DevolucionInsumoVO(Integer correlativoentregainsumo, 
			OrdenFabricacionVO ordenFabricacion,
			FuncionarioVO funcionario, Date fechadevolucioninsumo,
			Date horadevolucioninsumo, String observacion,
			DetalleDevolucionInsumoVO detalleDevolucionInsumo) {
		this.correlativoEntregaInsumo = correlativoentregainsumo; 
		this.ordenFabricacion = ordenFabricacion;
		this.funcionario = funcionario;
		this.fechaDevolucionInsumo = fechadevolucioninsumo;
		this.horaDevolucionInsumo = horadevolucioninsumo;
		this.observacion = observacion;
		this.detalleDevolucionInsumo = detalleDevolucionInsumo;
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

	public Date getFechaDevolucionInsumo() {
		return this.fechaDevolucionInsumo;
	}

	public Date getHoraDevolucionInsumo() {
		return this.horaDevolucionInsumo;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public DetalleDevolucionInsumoVO getDetalleDevolucionInsumo() {
		return this.detalleDevolucionInsumo;
	}
}