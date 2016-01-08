package cl.obam.pasteleria.lapalmera.view;

import java.util.List;

public class EntregaInsumoPruebaVO implements java.io.Serializable {

	private String ordenFabricacion;
	private String funcionario;
	private String observacion;
	private DetalleEntregaInsumoVO detalleEntregaInsumo;
	private List<UbicacionVO> ubicacions;
	
	public EntregaInsumoPruebaVO() {
	}

	public EntregaInsumoPruebaVO(String ordenFabricacion, String funcionario,
			String observacion, 
			DetalleEntregaInsumoVO detalleEntregaInsumo,
			List<UbicacionVO> ubicacions) {
		super();
		this.ordenFabricacion = ordenFabricacion;
		this.funcionario = funcionario;
		this.observacion = observacion;
		this.detalleEntregaInsumo = detalleEntregaInsumo;
		this.ubicacions = ubicacions;
	}

	public String getOrdenFabricacion() {
		return ordenFabricacion;
	}

	public String getFuncionario() {
		return funcionario;
	}

	public String getObservacion() {
		return observacion;
	}

	public DetalleEntregaInsumoVO getDetalleEntregaInsumo() {
		return detalleEntregaInsumo;
	}

	public List<UbicacionVO> getUbicacions() {
		return ubicacions;
	}
}