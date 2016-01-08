package cl.obam.pasteleria.lapalmera.view;

import java.util.Date;
import java.util.List;

public class CabezaPedidoVO {

	private Integer numeroPedido;
	private ClienteVO cliente;
	private String fechapedido;
	private int preciototalpedido;
	private EstadoPedidoVO estadoPedido;
	private String observacionpedido;
	private List<DetallePedidoVO> detallePedidos;
	private DespachoPedidoVO despachoPedido;
	private ConfirmacionPedidoVO confirmacionPedido;
	private List<OrdenFabricacionVO> ordenFabricacions;
	
	private String fechaInicio;
	private String fechaTermino;
	
	public CabezaPedidoVO() {
	}
	
	public CabezaPedidoVO(Integer numeroPedido, ClienteVO cliente, String fechapedido, 
			int preciototalpedido,EstadoPedidoVO estadoPedido, String observacionpedido) {
		this.numeroPedido = numeroPedido;
		this.cliente = cliente;
		this.fechapedido = fechapedido;
		this.preciototalpedido = preciototalpedido;
		this.estadoPedido = estadoPedido;
		this.observacionpedido = observacionpedido;
	}

	public CabezaPedidoVO(Integer numeropedido, ClienteVO cliente, String fechapedido, 
			int preciototalpedido,EstadoPedidoVO estadoPedido, 
			String observacionpedido, List<DetallePedidoVO> detallePedidos,
			DespachoPedidoVO despachoPedido, ConfirmacionPedidoVO confirmacionPedido,
			List<OrdenFabricacionVO> ordenFabricacions) {
		this.numeroPedido = numeropedido;
		this.cliente = cliente;
		this.fechapedido = fechapedido;
		this.preciototalpedido = preciototalpedido;
		this.estadoPedido = estadoPedido;
		this.observacionpedido = observacionpedido;		
		this.detallePedidos = detallePedidos;
		this.despachoPedido = despachoPedido;
		this.confirmacionPedido = confirmacionPedido;
		this.ordenFabricacions = ordenFabricacions;
	}

	public Integer getNumeroPedido() {
		return this.numeroPedido;
	}

	public ClienteVO getCliente() {
		return this.cliente;
	}

	public String getFechapedido() {
		return this.fechapedido;
	}

	public int getPreciototalpedido() {
		return this.preciototalpedido;
	}

	public EstadoPedidoVO getEstadoPedido() {
		return this.estadoPedido;
	}

	public String getObservacionpedido() {
		return this.observacionpedido;
	}

	public List<DetallePedidoVO> getDetallePedidos() {
		return detallePedidos;
	}

	public DespachoPedidoVO getDespachoPedido() {
		return despachoPedido;
	}

	public ConfirmacionPedidoVO getConfirmacionPedido() {
		return confirmacionPedido;
	}

	public List<OrdenFabricacionVO> getOrdenFabricacions() {
		return ordenFabricacions;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public String getFechaTermino() {
		return fechaTermino;
	}

	public void setEstadoPedido(EstadoPedidoVO estadoPedido) {
		this.estadoPedido = estadoPedido;
	}

	public void setCliente(ClienteVO cliente) {
		this.cliente = cliente;
	}

	public void setNumeroPedido(Integer numeroPedido) {
		this.numeroPedido = numeroPedido;
	}
	
	
	
	
}