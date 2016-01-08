package cl.obam.pasteleria.lapalmera.view;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

public class ProgramaProduccionVO implements java.io.Serializable {

	private String codigo;
	private OrdenFabricacionVO ordenFabricacion;
	private LineaProduccionVO lineaProduccion;
	private String fechaprogramaproduccion;
	private ProductoVO producto;
	private int cantidadprogramada;
	private int cantidadfabricada;
	private int saldoporfabricar;
	private byte active;
	
	private List<CapturaProduccionVO> capturaProduccions;

	public ProgramaProduccionVO() {
	}

	public ProgramaProduccionVO(String codigo, OrdenFabricacionVO ordenFabricacion,
			LineaProduccionVO lineaProduccion, String fechaprogramaproduccion,
            ProductoVO producto, int cantidadprogramada, int cantidadfabricada,
            int saldoporfabricar, byte active, List<CapturaProduccionVO> capturaProduccions) {
		this.codigo = codigo;
		this.ordenFabricacion = ordenFabricacion;
		this.lineaProduccion = lineaProduccion;
		this.fechaprogramaproduccion = fechaprogramaproduccion;
		this.producto = producto;
		this.cantidadprogramada = cantidadprogramada;
		this.cantidadfabricada = cantidadfabricada;
		this.saldoporfabricar = saldoporfabricar;
		this.active = active;
		this.capturaProduccions = capturaProduccions;
	}

	public String getCodigo() {
		return codigo;
	}

	public OrdenFabricacionVO getOrdenFabricacion() {
		return ordenFabricacion;
	}

	public LineaProduccionVO getLineaProduccion() {
		return lineaProduccion;
	}

	public String getFechaprogramaproduccion() {
		return fechaprogramaproduccion;
	}

	public ProductoVO getProducto() {
		return producto;
	}

	public int getCantidadprogramada() {
		return cantidadprogramada;
	}

	public int getCantidadfabricada() {
		return cantidadfabricada;
	}

	public int getSaldoporfabricar() {
		return saldoporfabricar;
	}

	public byte getActive() {
		return active;
	}

	public List<CapturaProduccionVO> getCapturaProduccions() {
		return capturaProduccions;
	}

	public void setLineaProduccion(LineaProduccionVO lineaProduccion) {
		this.lineaProduccion = lineaProduccion;
	}
}