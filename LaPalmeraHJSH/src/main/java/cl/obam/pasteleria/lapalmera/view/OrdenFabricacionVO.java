package cl.obam.pasteleria.lapalmera.view;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import cl.obam.pasteleria.lapalmera.model.Entregainsumo;
import cl.obam.pasteleria.lapalmera.model.Estadoordenfabricacion;

public class OrdenFabricacionVO implements java.io.Serializable {

	private String codigoOrdenFabricacion;
	private CabezaPedidoVO cabezaPedido;
	private ProductoVO producto;
	private String fechaIngresoOrdenFabricacion;
	private int cantidadProducto;
	private EstadoOrdenFabricacionVO estadoOrdenFabricacion;
	private List<ProgramaProduccionVO> programaProduccions;
	private List<EntregaInsumoVO> entregaInsumos;
	private List<DevolucionInsumoVO> devolucionInsumos;
	//private List<CapturaProduccionVO> capturaProduccions;
	
	private String fechaInicio;
	private String fechaTermino;

	public OrdenFabricacionVO() {
	}
	
	public OrdenFabricacionVO(String codigoOrdenFabricacion) {
		this.codigoOrdenFabricacion = codigoOrdenFabricacion;
	}

	public OrdenFabricacionVO(String codigoOrdenFabricacion, CabezaPedidoVO numerPedido,
			ProductoVO producto, EstadoOrdenFabricacionVO estadoOrdenFabricacion, 
			String fechaingresoordenfabricacion, int cantidadproducto,
			List<ProgramaProduccionVO> programarProduccions) {
		super();
		this.codigoOrdenFabricacion = codigoOrdenFabricacion;
		this.cabezaPedido = numerPedido;
		this.producto = producto;
		this.estadoOrdenFabricacion = estadoOrdenFabricacion;
		this.fechaIngresoOrdenFabricacion = fechaingresoordenfabricacion;
		this.cantidadProducto = cantidadproducto;
		this.programaProduccions = programarProduccions;
	}
	
	public OrdenFabricacionVO(String codigoOrdenFabricacion, CabezaPedidoVO numerPedido,
			ProductoVO producto, EstadoOrdenFabricacionVO estadoOrdenFabricacion, 
			String fechaingresoordenfabricacion, int cantidadproducto,
			List<ProgramaProduccionVO> programarProduccions, List<EntregaInsumoVO> entregaInsumos,
			List<DevolucionInsumoVO> devolucionInsumos) {
		super();
		this.codigoOrdenFabricacion = codigoOrdenFabricacion;
		this.cabezaPedido = numerPedido;
		this.producto = producto;
		this.estadoOrdenFabricacion = estadoOrdenFabricacion;
		this.fechaIngresoOrdenFabricacion = fechaingresoordenfabricacion;
		this.cantidadProducto = cantidadproducto;
		this.programaProduccions = programarProduccions;
		this.entregaInsumos = entregaInsumos;
		this.devolucionInsumos = devolucionInsumos;
		//this.capturaProduccions = capturaProduccions;
	}

	public String getCodigoOrdenFabricacion() {
		return codigoOrdenFabricacion;
	}

	public CabezaPedidoVO getCabezaPedido() {
		return cabezaPedido;
	}

	public ProductoVO getProducto() {
		return producto;
	}

	public EstadoOrdenFabricacionVO getEstadoOrdenFabricacion() {
		return estadoOrdenFabricacion;
	}

	public String getFechaIngresoOrdenFabricacion() {
		return fechaIngresoOrdenFabricacion;
	}

	public int getCantidadProducto() {
		return cantidadProducto;
	}

	public List<ProgramaProduccionVO> getProgramaProduccions() {
		return programaProduccions;
	}

	public List<EntregaInsumoVO> getEntregaInsumos() {
		return entregaInsumos;
	}

	public List<DevolucionInsumoVO> getDevolucionInsumos() {
		return devolucionInsumos;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public String getFechaTermino() {
		return fechaTermino;
	}
}