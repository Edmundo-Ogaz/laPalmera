package cl.obam.pasteleria.lapalmera.view;

import java.util.List;

public class CapturaProduccionVO implements java.io.Serializable {

	private Integer correlativoProduccion;
	private ProductoVO producto;
	private ProgramaProduccionVO programaProduccion;
	private String fechaCapturaProduccion;
	private Float cantidadProduccion;
	private UnidadMedidaVO unidadMedida;
	private String observacion;
	private List<FuncionarioVO> funcionarios;

	public CapturaProduccionVO() {
	}

	public CapturaProduccionVO(Integer correlativoproduccion, ProductoVO nombreProducto, 
			ProgramaProduccionVO codigoordenfabricacion, String fechacapturaproduccion, 
			Float cantidadproduccion, UnidadMedidaVO unidadMedida, 
			String observacion, List<FuncionarioVO> funcionarios) {
		this.correlativoProduccion = correlativoproduccion;
		this.producto = nombreProducto;
		this.programaProduccion = codigoordenfabricacion;
		this.fechaCapturaProduccion = fechacapturaproduccion;
		this.cantidadProduccion = cantidadproduccion;
		this.unidadMedida = unidadMedida;
		this.observacion = observacion;
		this.funcionarios = funcionarios;
	}

	public Integer getCorrelativoProduccion() {
		return this.correlativoProduccion;
	}

	public ProductoVO getProducto() {
		return this.producto;
	}

	public ProgramaProduccionVO getProgramaProduccion() {
		return this.programaProduccion;
	}

	public String getFechaCapturaProduccion() {
		return this.fechaCapturaProduccion;
	}

	public Float getCantidadProduccion() {
		return this.cantidadProduccion;
	}

	public UnidadMedidaVO getUnidadMedida() {
		return unidadMedida;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public List<FuncionarioVO> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<FuncionarioVO> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public void setProgramaProduccion(ProgramaProduccionVO ordenFabricacion) {
		this.programaProduccion = ordenFabricacion;
	}
	
	
	
}