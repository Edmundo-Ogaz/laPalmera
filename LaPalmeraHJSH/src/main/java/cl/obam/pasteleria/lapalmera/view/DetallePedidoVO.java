package cl.obam.pasteleria.lapalmera.view;

public class DetallePedidoVO implements java.io.Serializable {

	private Integer id;
	private CabezaPedidoVO cabezaPedido;
	private ProductoVO producto;
	private Integer precioproducto;
	private Integer cantidadproducto;
	private String observacion;
	private byte active;

	public DetallePedidoVO() {
	}

	public DetallePedidoVO(Integer id, CabezaPedidoVO cabezaPedido, ProductoVO producto,
			Integer precioproducto, Integer cantidadproducto, String observacion, byte active) {
		this.id = id;
		this.cabezaPedido = cabezaPedido;
		this.producto = producto;
		this.precioproducto = precioproducto;
		this.cantidadproducto = cantidadproducto;
		this.observacion = observacion;
		this.active = active;
	}
	
	public Integer getId() {
		return id;
	}

	public CabezaPedidoVO getCabezaPedido() {
		return cabezaPedido;
	}

	public ProductoVO getProducto() {
		return producto;
	}

	public Integer getPrecioproducto() {
		return precioproducto;
	}

	public Integer getCantidadproducto() {
		return cantidadproducto;
	}

	public String getObservacion() {
		return observacion;
	}

	public byte getActive() {
		return active;
	}
	
	
	
	
}