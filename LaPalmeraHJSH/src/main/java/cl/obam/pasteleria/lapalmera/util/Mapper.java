package cl.obam.pasteleria.lapalmera.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import cl.obam.pasteleria.lapalmera.model.Area;
import cl.obam.pasteleria.lapalmera.model.Bodega;
import cl.obam.pasteleria.lapalmera.model.Capturaproduccion;
import cl.obam.pasteleria.lapalmera.model.Cargo;
import cl.obam.pasteleria.lapalmera.model.Ciudad;
import cl.obam.pasteleria.lapalmera.model.Cliente;
import cl.obam.pasteleria.lapalmera.model.Comuna;
import cl.obam.pasteleria.lapalmera.model.Confirmacionpedido;
import cl.obam.pasteleria.lapalmera.model.Despachopedido;
import cl.obam.pasteleria.lapalmera.model.Detalledevolucioninsumo;
import cl.obam.pasteleria.lapalmera.model.Detalleentregainsumo;
import cl.obam.pasteleria.lapalmera.model.Detallepedido;
import cl.obam.pasteleria.lapalmera.model.Devolucioninsumo;
import cl.obam.pasteleria.lapalmera.model.Entrega;
import cl.obam.pasteleria.lapalmera.model.Entregainsumo;
import cl.obam.pasteleria.lapalmera.model.Estadoordenfabricacion;
import cl.obam.pasteleria.lapalmera.model.Estadopedido;
import cl.obam.pasteleria.lapalmera.model.Familia;
import cl.obam.pasteleria.lapalmera.model.Funcionario;
import cl.obam.pasteleria.lapalmera.model.Ingrediente;
import cl.obam.pasteleria.lapalmera.model.Lineaproduccion;
import cl.obam.pasteleria.lapalmera.model.Ordenfabricacion;
import cl.obam.pasteleria.lapalmera.model.Otracaracteristica;
import cl.obam.pasteleria.lapalmera.model.Pedido;
import cl.obam.pasteleria.lapalmera.model.Producto;
import cl.obam.pasteleria.lapalmera.model.Productolinea;
import cl.obam.pasteleria.lapalmera.model.Programaproduccion;
import cl.obam.pasteleria.lapalmera.model.Region;
import cl.obam.pasteleria.lapalmera.model.Stock;
import cl.obam.pasteleria.lapalmera.model.Subfamilia;
import cl.obam.pasteleria.lapalmera.model.Tipocliente;
import cl.obam.pasteleria.lapalmera.model.Tipoproducto;
import cl.obam.pasteleria.lapalmera.model.Ubicacion;
import cl.obam.pasteleria.lapalmera.model.Unidadmedida;
import cl.obam.pasteleria.lapalmera.view.AreaVO;
import cl.obam.pasteleria.lapalmera.view.BodegaVO;
import cl.obam.pasteleria.lapalmera.view.CabezaPedidoVO;
import cl.obam.pasteleria.lapalmera.view.CapturaProduccionVO;
import cl.obam.pasteleria.lapalmera.view.CargoVO;
import cl.obam.pasteleria.lapalmera.view.CiudadVO;
import cl.obam.pasteleria.lapalmera.view.ClienteVO;
import cl.obam.pasteleria.lapalmera.view.ComunaVO;
import cl.obam.pasteleria.lapalmera.view.ConfirmacionPedidoVO;
import cl.obam.pasteleria.lapalmera.view.DespachoPedidoVO;
import cl.obam.pasteleria.lapalmera.view.DetalleDevolucionInsumoVO;
import cl.obam.pasteleria.lapalmera.view.DetalleEntregaInsumoVO;
import cl.obam.pasteleria.lapalmera.view.DetallePedidoVO;
import cl.obam.pasteleria.lapalmera.view.DevolucionInsumoVO;
import cl.obam.pasteleria.lapalmera.view.EntregaInsumoVO;
import cl.obam.pasteleria.lapalmera.view.EntregaVO;
import cl.obam.pasteleria.lapalmera.view.EstadoOrdenFabricacionVO;
import cl.obam.pasteleria.lapalmera.view.EstadoPedidoVO;
import cl.obam.pasteleria.lapalmera.view.FamiliaVO;
import cl.obam.pasteleria.lapalmera.view.FuncionarioVO;
import cl.obam.pasteleria.lapalmera.view.IngredienteVO;
import cl.obam.pasteleria.lapalmera.view.LineaProduccionVO;
import cl.obam.pasteleria.lapalmera.view.OrdenFabricacionVO;
import cl.obam.pasteleria.lapalmera.view.OtraCaracteristicaVO;
import cl.obam.pasteleria.lapalmera.view.ProductoLineaVO;
import cl.obam.pasteleria.lapalmera.view.ProductoVO;
import cl.obam.pasteleria.lapalmera.view.ProgramaProduccionVO;
import cl.obam.pasteleria.lapalmera.view.RegionVO;
import cl.obam.pasteleria.lapalmera.view.StockVO;
import cl.obam.pasteleria.lapalmera.view.SubFamiliaVO;
import cl.obam.pasteleria.lapalmera.view.TipoClienteVO;
import cl.obam.pasteleria.lapalmera.view.TipoProductoVO;
import cl.obam.pasteleria.lapalmera.view.UbicacionVO;
import cl.obam.pasteleria.lapalmera.view.UnidadMedidaVO;

public final class Mapper {
	
	private static DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/***** PRODUCTO *****/
	
	public static Producto from(ProductoVO productoVO) {
		Producto producto = null;
		if(productoVO instanceof ProductoVO) {
			producto = new Producto(
								   productoVO.getCodigo(),
								   Mapper.from(productoVO.getUnidadMedida()),
								   Mapper.from(productoVO.getTipoProducto()),
								   Mapper.from(productoVO.getOtraCaracteristica()),
								   Mapper.from(productoVO.getFamilia()),
								   Mapper.from(productoVO.getSubFamilia()),
								   productoVO.getNombre(),
								   productoVO.getStockcriticoproducto(),
								   productoVO.getValorcosto(),
								   productoVO.getValorventa(),
								   productoVO.getPreparacion(),				   
								   productoVO.getFotoproducto(),
								   productoVO.getObservacion(),
								   null, null,null,null,null,null,null,null,null,null,null,null);
		}
		return producto;
	}
	
	public static ProductoVO from(Producto producto) {
		ProductoVO productoVO = null;
		if(producto instanceof Producto) {
			productoVO = new ProductoVO(
									   producto.getCodigoproducto(),
									   Mapper.from(producto.getUnidadmedida()),
									   Mapper.from(producto.getOtracaracteristica()),
									   Mapper.from(producto.getFamilia()),
									   Mapper.from(producto.getSubfamilia()),
									   producto.getNombreproducto(),
									   producto.getStockcriticoproducto(),
									   producto.getValorcosto(),
									   producto.getValorventa(),
									   producto.getPreparacion(),
									   Mapper.from(producto.getTipoproducto()),
									   producto.getFotoproducto(),
									   producto.getObservacion());
			
			productoVO.setStock(Mapper.from(producto.getStock()));
			productoVO.setUbicacions(Mapper.fromUbicacions(producto, producto.getUbicacions()));
		}
		return productoVO;
	}
	
	public static ProductoVO from(Detallepedido detallePedido, Producto producto) {
		ProductoVO productoVO = null;
		if(producto instanceof Producto) {
			productoVO = new ProductoVO(
									   producto.getCodigoproducto(),
									   Mapper.from(producto.getUnidadmedida()),
									   Mapper.from(producto.getOtracaracteristica()),
									   Mapper.from(producto.getFamilia()),
									   Mapper.from(producto.getSubfamilia()),
									   producto.getNombreproducto(),
									   producto.getStockcriticoproducto(),
									   producto.getValorcosto(),
									   producto.getValorventa(),
									   producto.getPreparacion(),
									   Mapper.from(producto.getTipoproducto()),
									   producto.getFotoproducto(),
									   producto.getObservacion());
		}
		return productoVO;
	}
	
	public static ProductoVO from(Ordenfabricacion ordenFabricacion, Producto producto) {
		ProductoVO productoVO = null;
		if(producto instanceof Producto) {
			productoVO = new ProductoVO(
									   producto.getCodigoproducto(),
									   Mapper.from(producto.getUnidadmedida()),
									   Mapper.from(producto.getOtracaracteristica()),
									   Mapper.from(producto.getFamilia()),
									   Mapper.from(producto.getSubfamilia()),
									   producto.getNombreproducto(),
									   producto.getStockcriticoproducto(),
									   producto.getValorcosto(),
									   producto.getValorventa(),
									   producto.getPreparacion(),
									   Mapper.from(producto.getTipoproducto()),
									   producto.getFotoproducto(),
									   producto.getObservacion());
		}
		return productoVO;
	}
	
	public static ProductoVO from(Programaproduccion programarProduccion, Producto producto) {
		ProductoVO productoVO = null;
		if(producto instanceof Producto) {
			productoVO = new ProductoVO(
									   producto.getCodigoproducto(),
									   Mapper.from(producto.getUnidadmedida()),
									   Mapper.from(producto.getOtracaracteristica()),
									   Mapper.from(producto.getFamilia()),
									   Mapper.from(producto.getSubfamilia()),
									   producto.getNombreproducto(),
									   producto.getStockcriticoproducto(),
									   producto.getValorcosto(),
									   producto.getValorventa(),
									   producto.getPreparacion(),
									   Mapper.from(producto.getTipoproducto()),
									   producto.getFotoproducto(),
									   producto.getObservacion());
		}
		return productoVO;
	}
	
	public static ProductoVO from(Ingrediente ingrediendte, Producto producto) {
		ProductoVO productoVO = null;
		if(producto instanceof Producto) {
			productoVO = new ProductoVO(
									   producto.getCodigoproducto(),
									   Mapper.from(producto.getUnidadmedida()),
									   Mapper.from(producto.getOtracaracteristica()),
									   Mapper.from(producto.getFamilia()),
									   Mapper.from(producto.getSubfamilia()),
									   producto.getNombreproducto(),
									   producto.getStockcriticoproducto(),
									   producto.getValorcosto(),
									   producto.getValorventa(),
									   producto.getPreparacion(),
									   Mapper.from(producto.getTipoproducto()),
									   producto.getFotoproducto(),
									   producto.getObservacion());
		}
		return productoVO;
	}
	
	public static ProductoVO from(Ubicacion ubicacion, Producto producto) {
		ProductoVO productoVO = null;
		if(producto instanceof Producto) {
			productoVO = new ProductoVO(
									   producto.getCodigoproducto(),
									   Mapper.from(producto.getUnidadmedida()),
									   Mapper.from(producto.getOtracaracteristica()),
									   Mapper.from(producto.getFamilia()),
									   Mapper.from(producto.getSubfamilia()),
									   producto.getNombreproducto(),
									   producto.getStockcriticoproducto(),
									   producto.getValorcosto(),
									   producto.getValorventa(),
									   producto.getPreparacion(),
									   Mapper.from(producto.getTipoproducto()),
									   producto.getFotoproducto(),
									   producto.getObservacion());
			productoVO.setUbicacions(null);
		}
		return productoVO;
	}
	
	
	
	public static ProductoVO from(Producto producto, Stock stock) {
		   return new ProductoVO(
							   producto.getCodigoproducto(),
							   Mapper.from(producto.getUnidadmedida()),
							   Mapper.from(producto.getOtracaracteristica()),
							   Mapper.from(producto.getFamilia()),
							   Mapper.from(producto.getSubfamilia()),
							   producto.getNombreproducto(),
							   producto.getStockcriticoproducto(),
							   producto.getValorcosto(),
							   producto.getValorventa(),
							   producto.getPreparacion(),
							   Mapper.from(producto.getTipoproducto()),
							   producto.getFotoproducto(),
							   producto.getObservacion(),
							   Mapper.from(stock));
	   }
	
	public static Producto from(ProductoVO productoVO, StockVO stockVO) {
		Producto producto = null;   
		producto = new Producto(
							   productoVO.getCodigo(),
							   Mapper.from(productoVO.getUnidadMedida()),
							   Mapper.from(productoVO.getTipoProducto()),
							   Mapper.from(productoVO.getOtraCaracteristica()),
							   Mapper.from(productoVO.getFamilia()),
							   Mapper.from(productoVO.getSubFamilia()),
							   productoVO.getNombre(),
							   productoVO.getStockcriticoproducto(),
							   productoVO.getValorcosto(),
							   productoVO.getValorventa(),
							   productoVO.getPreparacion(),							   
							   productoVO.getFotoproducto(),
							   productoVO.getObservacion(),
							   null, null,null,null,null,null,null,null,null,null,null,null);
		producto.setStock(Mapper.from(stockVO));
		return producto;
	}
	
	public static ProductoVO from(Producto producto, Set<Ubicacion> ubicacions) {
		ProductoVO productoVO = null;
		if(producto instanceof Producto) {
			productoVO = new ProductoVO(
										producto.getCodigoproducto(),
										Mapper.from(producto.getUnidadmedida()),
										Mapper.from(producto.getOtracaracteristica()),
										Mapper.from(producto.getFamilia()),
										Mapper.from(producto.getSubfamilia()),
										producto.getNombreproducto(),
										producto.getStockcriticoproducto(),
										producto.getValorcosto(),
										producto.getValorventa(),
										producto.getPreparacion(),
										Mapper.from(producto.getTipoproducto()),
										producto.getFotoproducto(),
										producto.getObservacion(),
										Mapper.fromUbicacions(ubicacions));
		}
		return productoVO;
	}
	
	public static ProductoVO from(Producto producto, Stock stock, Set<Ubicacion> ubicacions) {
		ProductoVO productoVO = null;  
		if(producto instanceof Producto) {
//			productoVO = Mapper.from(producto);
//			productoVO.setStock(Mapper.from(stock));
//			productoVO.setUbicacions(Mapper.fromUbicacions(ubicacions));
		   	productoVO = new ProductoVO(
				   					producto.getCodigoproducto(),
				   					Mapper.from(producto.getUnidadmedida()),
				   					Mapper.from(producto.getOtracaracteristica()),
				   					Mapper.from(producto.getFamilia()),
				   					Mapper.from(producto.getSubfamilia()),
				   					producto.getNombreproducto(),
				   					producto.getStockcriticoproducto(),
				   					producto.getValorcosto(),
				   					producto.getValorventa(),
							   		producto.getPreparacion(),
							   		Mapper.from(producto.getTipoproducto()),
							   		producto.getFotoproducto(),
							   		producto.getObservacion(),
							   		Mapper.from(stock),
							   		Mapper.fromUbicacions(ubicacions));
		}
		return productoVO;
	}
	
	public static Producto from(ProductoVO productoVO, StockVO stockVO, List<UbicacionVO> ubicacionsVO) throws ParseException {
		Producto producto = null;  
		if(productoVO instanceof ProductoVO) {
			producto = Mapper.from(productoVO);
			producto.setStock(Mapper.from(stockVO));
			producto.setUbicacions(Mapper.fromUbicacions(ubicacionsVO));
		}
		return producto;
	}
	
	/***** STOCK *****/
	public static StockVO from(Stock stock) {
		StockVO stockVO = null;
		if(stock instanceof Stock) {
			stockVO = new StockVO(
						   	new ProductoVO(stock.getProducto().getCodigoproducto()),
			      		  	stock.getStockdisponible(),	
			      		  	stock.getStockcomprometido(),
			      		  	Mapper.from(stock.getUnidadmedida())
	      		  );
		}
		return stockVO;
	}
	
	public static Stock from(StockVO stockVO) {
		Stock stock = null;
		if(stockVO instanceof StockVO) {
			stock = new Stock(
				   			Mapper.from(stockVO.getUnidadMedida()),
						   	Mapper.from(stockVO.getProducto()),
			      		  	stockVO.getStockDisponible(),
			      		  	stockVO.getStockComprometido());
			stock.setCodigoproducto(stockVO.getProducto() != null ? stockVO.getProducto().getCodigo() : null);
		}
		return stock;
	}
	
	/***** INGREDIENTE *****/
	public static IngredienteVO from(Ingrediente ingrediente) {
		return new IngredienteVO(
								ingrediente.getId(),
								Mapper.from(ingrediente, ingrediente.getProductoByCodigoproducto()),
								Mapper.from(ingrediente.getProductoByCodigoinsumo(), 
											ingrediente.getProductoByCodigoinsumo().getStock()),
								ingrediente.getCarga(),
								ingrediente.getCantidadinsumo(),
								Mapper.from(ingrediente.getUnidadmedida()));
	}
	
	public static Ingrediente from(IngredienteVO ingredienteVO)  throws ParseException {
		
		Ingrediente ingrediente = new Ingrediente(
												Mapper.from(ingredienteVO.getUnidadMedida()),
												Mapper.from(ingredienteVO.getProducto()),
												Mapper.from(ingredienteVO.getInsumo()),
												ingredienteVO.getCarga(),
												ingredienteVO.getCantidadinsumo());
		ingrediente.setId(ingredienteVO.getId());
	
		return ingrediente;
	}
	
   
   public static List<IngredienteVO> fromIngredientes(Set<Ingrediente> ingredientes) {
	   List<IngredienteVO> ingredientesVO = new LinkedList<IngredienteVO>();
	   IngredienteVO ingredienteVO = null;
	   for(Ingrediente ingrediente : ingredientes) {
		   ingredienteVO = new IngredienteVO(
				   							ingrediente.getId(),
				   							Mapper.from(ingrediente.getProductoByCodigoproducto()),
				   							Mapper.from(ingrediente.getProductoByCodigoinsumo(), 
				   									    ingrediente.getProductoByCodigoinsumo().getStock()),
				   							ingrediente.getCarga(),
				   							ingrediente.getCantidadinsumo(),
				   							Mapper.from(ingrediente.getUnidadmedida()));
		   ingredientesVO.add(ingredienteVO);		   
	   }
	   
	   return ingredientesVO;
   }
   
   public static CabezaPedidoVO from(Pedido cabezaPedido) {
	   CabezaPedidoVO cabezaPedidoVO = null;
	   if(cabezaPedido instanceof Pedido) {
		   cabezaPedidoVO = new CabezaPedidoVO(
											   cabezaPedido.getNumeropedido(),
											   Mapper.from(cabezaPedido.getCliente()),
											   cabezaPedido.getFechapedido() != null ? sdf.format(cabezaPedido.getFechapedido()) : null,
											   cabezaPedido.getPreciototalpedido(), 
											   Mapper.from(cabezaPedido.getEstadopedido()),
											   cabezaPedido.getObservacionpedido(),
											   Mapper.fromDetallePedidos(cabezaPedido, cabezaPedido.getDetallepedidos()),
											   Mapper.from(cabezaPedido, cabezaPedido.getDespachopedido()),
											   Mapper.from(cabezaPedido, cabezaPedido.getConfirmacionpedido()),
											   Mapper.fromOrdenFabricacions(cabezaPedido, cabezaPedido.getOrdenfabricacions()));
	   }
	   return cabezaPedidoVO;
   }
   
   public static CabezaPedidoVO from(Ordenfabricacion ordenFabricacions, Pedido cabezaPedido) {
	   CabezaPedidoVO cabezaPedidoVO = null;
	   if(cabezaPedido instanceof Pedido) {
		   cabezaPedidoVO = new CabezaPedidoVO(
											   cabezaPedido.getNumeropedido(),
											   Mapper.from(cabezaPedido.getCliente()),
											   cabezaPedido.getFechapedido() != null ? sdf.format(cabezaPedido.getFechapedido()) : null,
											   cabezaPedido.getPreciototalpedido(), 
											   Mapper.from(cabezaPedido.getEstadopedido()),
											   cabezaPedido.getObservacionpedido(),
											   Mapper.fromDetallePedidos(cabezaPedido, cabezaPedido.getDetallepedidos()),
											   Mapper.from(cabezaPedido, cabezaPedido.getDespachopedido()),
											   Mapper.from(cabezaPedido, cabezaPedido.getConfirmacionpedido()),
											   null);
	   }
	   return cabezaPedidoVO;
   }
   
   public static Pedido from(CabezaPedidoVO cabezaPedidoVO) throws ParseException {
	   Pedido cabezaPedido = null;
	   if(cabezaPedidoVO instanceof CabezaPedidoVO) {
		   cabezaPedido = new Pedido(
				   					Mapper.from(cabezaPedidoVO.getCliente()),
		   							Mapper.from(cabezaPedidoVO.getEstadoPedido()),		   							
		   							cabezaPedidoVO.getFechapedido() != null ? sdf.parse(cabezaPedidoVO.getFechapedido()) : null,
		   							cabezaPedidoVO.getPreciototalpedido(),
		   							cabezaPedidoVO.getObservacionpedido(),
		   							Mapper.fromOrdenFabricacions(cabezaPedidoVO.getOrdenFabricacions()),
		   							Mapper.from(cabezaPedidoVO.getDespachoPedido()),
		   							Mapper.from(cabezaPedidoVO.getConfirmacionPedido()),
		   							Mapper.fromDetallePedidos(cabezaPedidoVO.getDetallePedidos()));
		   
		   cabezaPedido.setNumeropedido(cabezaPedidoVO.getNumeroPedido());
	   }
	   return cabezaPedido;
   }
   
//   public static DetallePedidoVO from(Detallepedido detallePedido) {
//	   
//	   return new DetallePedidoVO(
//			   						Mapper.from(detallePedido.getCabezapedido()),
//			   						Mapper.from(detallePedido.getProducto()),
//			   						detallePedido.getPrecioproducto(),
//			   						detallePedido.getCantidadproducto());
//   }
   
   public static DetallePedidoVO from(Pedido cabezaPedido, Detallepedido detallePedido) {
	   
	   return new DetallePedidoVO(
			   						detallePedido.getCorrelativo(),
			   						null,
			   						Mapper.from(detallePedido.getProducto()),
			   						detallePedido.getPrecioproducto(),
			   						detallePedido.getCantidadproducto(),
			   						detallePedido.getObservacion(),
			   						detallePedido.getActive());
   }
   
   public static Detallepedido from(DetallePedidoVO detallePedidoVO) throws ParseException {
	   Detallepedido detallePedido = null;
	   if(detallePedidoVO instanceof DetallePedidoVO) {
		   detallePedido = new Detallepedido(
			   					Mapper.from(detallePedidoVO.getCabezaPedido()),
								Mapper.from(detallePedidoVO.getProducto()),
								detallePedidoVO.getPrecioproducto(),
								detallePedidoVO.getCantidadproducto(),
								detallePedidoVO.getObservacion(),
								detallePedidoVO.getActive());
	   }
	   
	   return detallePedido;
   }
   
//   public static DespachoPedidoVO from(Despachopedido despachoPedido) {
//	   
//	   return new DespachoPedidoVO(
//			   						Mapper.from(despachoPedido.getCabezapedido()),
//								    despachoPedido.getNombrecliente(),
//								    despachoPedido.getDirecciondespacho(),
//								    despachoPedido.getFechaentregadespacho() != null ? sdf.format(despachoPedido.getFechaentregadespacho()) : null,
//								    despachoPedido.getHoraentregadespacho() != null ? sdf.format(despachoPedido.getHoraentregadespacho()) : null);
//   }
   
   public static List<DetallePedidoVO> fromDetallePedidos(Pedido cabezaPedido, Set<Detallepedido> detallePedidos) {
	   List<DetallePedidoVO> detallePedidosVO = null;
	   if(detallePedidos instanceof Set) {
		   detallePedidosVO = new LinkedList<DetallePedidoVO>();
		   DetallePedidoVO detallePedidoVO = null;
		   for(Detallepedido detallePedido : detallePedidos) {
			   detallePedidoVO = new DetallePedidoVO(
					   								detallePedido.getCorrelativo(),
							   						null,
							   						Mapper.from(detallePedido, detallePedido.getProducto()),
							   						detallePedido.getPrecioproducto(),
							   						detallePedido.getCantidadproducto(),
							   						detallePedido.getObservacion(),
							   						detallePedido.getActive());
			   detallePedidosVO.add(detallePedidoVO);
		   }
	   }
	   
	   return detallePedidosVO;
   }
   
   public static Set<Detallepedido> fromDetallePedidos(List<DetallePedidoVO> detallePedidosVO) {
	   Set<Detallepedido> detallePedidos = null;
	   if(detallePedidosVO instanceof List) {
		   detallePedidos = new HashSet<Detallepedido>();
		   Detallepedido detallePedido = null;
		   for(DetallePedidoVO detallePedidoVO : detallePedidosVO) {
			   detallePedido = new Detallepedido(
						   						null,
						   						Mapper.from(detallePedidoVO.getProducto()),
						   						detallePedidoVO.getPrecioproducto(),
						   						detallePedidoVO.getCantidadproducto(),
						   						detallePedidoVO.getObservacion(),
						   						detallePedidoVO.getActive());
			   detallePedido.setCorrelativo(detallePedidoVO.getId());
			   detallePedidos.add(detallePedido);
		   }
	   }
	   
	   return detallePedidos;
   }
   
   public static DespachoPedidoVO from(Pedido cabezaPedido, Despachopedido despachoPedido) {
	   DespachoPedidoVO despachoPedidoVO = null;
	   if(despachoPedido instanceof Despachopedido) {
		   despachoPedidoVO = new DespachoPedidoVO(
			   						null,
								    despachoPedido.getNombrecliente(),
								    Mapper.from(despachoPedido.getEntrega()),
								    despachoPedido.getFechaentregadespacho() != null ? sdf.format(despachoPedido.getFechaentregadespacho()) : null);
	   }
	   
	   return despachoPedidoVO;	   
   }
   
   public static Despachopedido from(DespachoPedidoVO despachoPedidoVO) throws ParseException {
	   Despachopedido despachoPedido = null;
	   if(despachoPedidoVO instanceof DespachoPedidoVO) {
		   despachoPedido = new Despachopedido(
								   Mapper.from(despachoPedidoVO.getCabezaPedido()),
								   Mapper.from(despachoPedidoVO.getLugarEntrega()),
								   despachoPedidoVO.getNombrecliente(),								   
								   despachoPedidoVO.getFechaentregadespacho() != null ? sdf.parse(despachoPedidoVO.getFechaentregadespacho()) : null);
//		   despachoPedido.setNumeropedido(cabezaPedidoVO.getNumeroPedido());
	   }
	   
	   return despachoPedido;
   }
   
//   public static ConfirmacionPedidoVO from(Confirmacionpedido confirmacionPedido) {
//	   
//	   return new ConfirmacionPedidoVO(
//									   Mapper.from(confirmacionPedido.getCabezapedido()),
//									   confirmacionPedido.getNombrecliente(),
//									   confirmacionPedido.getApellidocliente(),
//									   confirmacionPedido.getDireccioncliente(),
//									   confirmacionPedido.getTelefonocliente());
//   }
   
   public static ConfirmacionPedidoVO from(Pedido cabezaPedido, Confirmacionpedido confirmacionPedido) {
	   ConfirmacionPedidoVO confirmacionPedidoVO = null;
	   if(confirmacionPedido instanceof Confirmacionpedido) {
		   confirmacionPedidoVO = new ConfirmacionPedidoVO(
									   null,
									   confirmacionPedido.getNombrecliente(),
									   confirmacionPedido.getApellidocliente(),
									   confirmacionPedido.getDireccioncliente(),
									   confirmacionPedido.getFecha() != null ? sdf.format(confirmacionPedido.getFecha()) : null);
	   }
	   
	   return confirmacionPedidoVO;
   }
   
   public static Confirmacionpedido from(ConfirmacionPedidoVO confirmacionPedidoVO) throws ParseException {
	   Confirmacionpedido confirmacionPedido = null;
	   if(confirmacionPedidoVO instanceof ConfirmacionPedidoVO) {
		   confirmacionPedido = new Confirmacionpedido(
								   						Mapper.from(confirmacionPedidoVO.getCabezaPedido()),
														confirmacionPedidoVO.getNombrecliente(),
														confirmacionPedidoVO.getApellidocliente(),
														confirmacionPedidoVO.getDireccioncliente(),
														confirmacionPedidoVO.getFecha() != null ? sdf.parse(confirmacionPedidoVO.getFecha()) : null);
	   }
	   
	   return confirmacionPedido;
   }
   
   public static OrdenFabricacionVO from(Ordenfabricacion ordenFabricacion) {
	   OrdenFabricacionVO ordenFabricacionVO = null;
	   if(ordenFabricacion instanceof Ordenfabricacion) {
		   ordenFabricacionVO =  new OrdenFabricacionVO(
			   						ordenFabricacion.getCodigoordenfabricacion(),
								    Mapper.from(ordenFabricacion, ordenFabricacion.getPedido()), 
									Mapper.from(ordenFabricacion.getProducto()),
									Mapper.from(ordenFabricacion.getEstadoordenfabricacion()),
									ordenFabricacion.getFechaingresoordenfabricacion() != null ? sdf.format(ordenFabricacion.getFechaingresoordenfabricacion()) : null,
									ordenFabricacion.getCantidadproducto(),
									Mapper.from(ordenFabricacion, ordenFabricacion.getProgramaproduccions()),
									Mapper.fromEntregainsumos(ordenFabricacion.getEntregainsumos()),
									Mapper.fromDevolucioninsumos(ordenFabricacion.getDevolucioninsumos()));
	   }
	   return ordenFabricacionVO;
   }
   
   public static OrdenFabricacionVO from(Programaproduccion programaProduccion, Ordenfabricacion ordenFabricacion) {
	   OrdenFabricacionVO ordenFabricacionVO = null;
	   if(ordenFabricacion instanceof Ordenfabricacion) {
		   ordenFabricacionVO =  new OrdenFabricacionVO(
								   						ordenFabricacion.getCodigoordenfabricacion(),
													    Mapper.from(ordenFabricacion, ordenFabricacion.getPedido()), 
														Mapper.from(ordenFabricacion.getProducto()),
														Mapper.from(ordenFabricacion.getEstadoordenfabricacion()),
														ordenFabricacion.getFechaingresoordenfabricacion() != null ? sdf.format(ordenFabricacion.getFechaingresoordenfabricacion()) : null,
														ordenFabricacion.getCantidadproducto(),
														null,
														Mapper.fromEntregainsumos(ordenFabricacion.getEntregainsumos()),
														Mapper.fromDevolucioninsumos(ordenFabricacion.getDevolucioninsumos()));
	   }
	   return ordenFabricacionVO;
   }
   
   public static Ordenfabricacion from(OrdenFabricacionVO ordenFabricacionVO)  throws ParseException {
	   Ordenfabricacion ordenFabricacion = null;
	   if(ordenFabricacionVO instanceof OrdenFabricacionVO) {
		   ordenFabricacion = new Ordenfabricacion(
									   	ordenFabricacionVO.getCodigoOrdenFabricacion(),
									    Mapper.from(ordenFabricacionVO.getCabezaPedido()), 
										Mapper.from(ordenFabricacionVO.getProducto()),
										Mapper.from(ordenFabricacionVO.getEstadoOrdenFabricacion()),
										ordenFabricacionVO.getFechaIngresoOrdenFabricacion() != null ? sdf.parse(ordenFabricacionVO.getFechaIngresoOrdenFabricacion()) : null,
										ordenFabricacionVO.getCantidadProducto(),
										Mapper.fromEntregaInsumos(ordenFabricacionVO.getEntregaInsumos()),
//										Mapper.fromCapturaProduccions(ordenFabricacionVO.getCapturaProduccions()),
										Mapper.from(ordenFabricacionVO, ordenFabricacionVO.getProgramaProduccions()),										
										Mapper.fromDevolucioninsumos(ordenFabricacionVO.getDevolucionInsumos()));
	   }
	   return ordenFabricacion;
   }
   
//   public static List<OrdenFabricacionVO> fromOrdenFabricacions(Set<Ordenfabricacion> ordenFabricacions) {
//	   List<OrdenFabricacionVO> ordenFabricacionsVO = new LinkedList<OrdenFabricacionVO>();
//	   OrdenFabricacionVO ordenFabricacionVO = null;
//	   for(Ordenfabricacion ordenFabricacion : ordenFabricacions) {
//		   ordenFabricacionVO = new OrdenFabricacionVO(ordenFabricacion.getCodigoordenfabricacion(),
//				   							Mapper.from(ordenFabricacion.getCabezapedido()), 
//				   							Mapper.from(ordenFabricacion.getProducto()),
//				   							ordenFabricacion.getFechaingresoordenfabricacion() != null ? sdf.format(ordenFabricacion.getFechaingresoordenfabricacion()) : null,
//				   							ordenFabricacion.getHoraingresoordenfabricacion() != null ? sdf.format(ordenFabricacion.getHoraingresoordenfabricacion()) : null,
//				   							ordenFabricacion.getCantidadproducto(),
//				   							Mapper.from(ordenFabricacion.getProgramarproduccion()));
//		   ordenFabricacionsVO.add(ordenFabricacionVO);		   
//	   }
//	   
//	   return ordenFabricacionsVO;
//   }
   
   public static List<OrdenFabricacionVO> fromOrdenFabricacions(Pedido cabezaPedido, Set<Ordenfabricacion> ordenFabricacions) {
	   List<OrdenFabricacionVO> ordenFabricacionsVO = new LinkedList<OrdenFabricacionVO>();
	   if(ordenFabricacions instanceof Set) {
		   OrdenFabricacionVO ordenFabricacionVO = null;
		   for(Ordenfabricacion ordenFabricacion : ordenFabricacions) {
			   ordenFabricacionVO = new OrdenFabricacionVO(
								   							ordenFabricacion.getCodigoordenfabricacion(),
								   							null, 
								   							Mapper.from(ordenFabricacion, ordenFabricacion.getProducto()),
								   							Mapper.from(ordenFabricacion.getEstadoordenfabricacion()),
								   							ordenFabricacion.getFechaingresoordenfabricacion() != null ? sdf.format(ordenFabricacion.getFechaingresoordenfabricacion()) : null,
								   							ordenFabricacion.getCantidadproducto(),
								   							Mapper.from(ordenFabricacion, ordenFabricacion.getProgramaproduccions()));
			   ordenFabricacionsVO.add(ordenFabricacionVO);		   
		   }
	   }
	   
	   return ordenFabricacionsVO;
   }
   
   public static Set<Ordenfabricacion> fromOrdenFabricacions(List<OrdenFabricacionVO> ordenFabricacionsVO) throws ParseException {
	   Set<Ordenfabricacion> ordenFabricacions = null;
	   if(ordenFabricacionsVO instanceof List) {
//		   Ordenfabricacion ordenFabricacion = null;
		   ordenFabricacions = new HashSet<Ordenfabricacion>();
		   for(OrdenFabricacionVO ordenFabricacionVO : ordenFabricacionsVO) {
			   ordenFabricacions.add(from(ordenFabricacionVO));
//			   ordenFabricacion = new Ordenfabricacion(
//					   									ordenFabricacionVO.getCodigoOrdenFabricacion(),
//							   							Mapper.from(ordenFabricacionVO.getCabezaPedido()), 
//							   							Mapper.from(ordenFabricacionVO.getProducto()),
//							   							ordenFabricacionVO.getFechaIngresoOrdenFabricacion() != null ? sdf.parse(ordenFabricacionVO.getFechaIngresoOrdenFabricacion()) : null,
//							   							ordenFabricacionVO.getCantidadProducto(),
//							   							Mapper.fromEntregaInsumos(ordenFabricacionVO.getEntregaInsumos()),
//							   							Mapper.from(ordenFabricacionVO.getProgramarProduccions()),
//							   							Mapper.fromCapturaProduccions(ordenFabricacionVO.getCapturaProduccions()),
//							   							Mapper.fromDevolucioninsumos(ordenFabricacionVO.getDevolucionInsumos()));

//			   ordenFabricacions.add(ordenFabricacion);
		   }
	   }
	   
	   return ordenFabricacions;
   }
   
//   public static ProgramarProduccionVO from(Programarproduccion programarProduccion) {
//	   ProgramarProduccionVO programarProduccionVO = null;
//	   if(programarProduccion instanceof Programarproduccion) {
//		   programarProduccionVO =  new ProgramarProduccionVO(
//				   												Mapper.from(programarProduccion.getOrdenfabricacion()),
//				   												Mapper.from(programarProduccion.getLineaproduccion()),
//				   												programarProduccion.getFechaprogramaproduccion() != null ? sdf.format(programarProduccion.getFechaprogramaproduccion()) : null,
//				   												programarProduccion.getHoraprogramaproduccion() != null ? sdf.format(programarProduccion.getHoraprogramaproduccion()) : null,
//				   												Mapper.from(programarProduccion.getProducto()),
//				   												programarProduccion.getCantidadprogramada(),
//				   												programarProduccion.getCantidadfabricada(),
//				   												programarProduccion.getSaldoporfabricar(),
//				   												Mapper.from(programarProduccion.getEstadoordenfabricacion()));
//	   }
//	   return programarProduccionVO;
//   }
   
   public static ProgramaProduccionVO from(Programaproduccion programarProduccion) {
	   ProgramaProduccionVO programarProduccionVO = null;
	   if(programarProduccion instanceof Programaproduccion) {
		   programarProduccionVO =  new ProgramaProduccionVO(
														programarProduccion.getCodigo(),
														Mapper.from(programarProduccion, programarProduccion.getOrdenfabricacion()),
														Mapper.from(programarProduccion.getLineaproduccion()),
														programarProduccion.getFechaprogramaproduccion() != null ? sdf.format(programarProduccion.getFechaprogramaproduccion()) : null,
														Mapper.from(programarProduccion, programarProduccion.getProducto()),
														programarProduccion.getCantidadprogramada(),
														programarProduccion.getCantidadfabricada(),
														programarProduccion.getSaldoporfabricar(),
														programarProduccion.getActive(),
														Mapper.from(programarProduccion, programarProduccion.getCapturaproduccions()));
	   }
	   
	   return programarProduccionVO;
   }
   
   public static ProgramaProduccionVO from(Capturaproduccion capturaProduccion, Programaproduccion programarProduccion) {
	   ProgramaProduccionVO programarProduccionVO = null;
	   if(programarProduccion instanceof Programaproduccion) {
		   programarProduccionVO =  new ProgramaProduccionVO(
														programarProduccion.getCodigo(),
														Mapper.from(programarProduccion, programarProduccion.getOrdenfabricacion()),
														Mapper.from(programarProduccion.getLineaproduccion()),
														programarProduccion.getFechaprogramaproduccion() != null ? sdf.format(programarProduccion.getFechaprogramaproduccion()) : null,
														Mapper.from(programarProduccion, programarProduccion.getProducto()),
														programarProduccion.getCantidadprogramada(),
														programarProduccion.getCantidadfabricada(),
														programarProduccion.getSaldoporfabricar(),
														programarProduccion.getActive(),
														null);
	   }
	   
	   return programarProduccionVO;
   }
   
   public static ProgramaProduccionVO from(Ordenfabricacion ordenFabricacion, Programaproduccion programarProduccion) {
	   ProgramaProduccionVO programarProduccionVO = null;
	   if(programarProduccion instanceof Programaproduccion) {
		   programarProduccionVO =  new ProgramaProduccionVO(
														programarProduccion.getCodigo(),
														null,
														Mapper.from(programarProduccion.getLineaproduccion()),
														programarProduccion.getFechaprogramaproduccion() != null ? sdf.format(programarProduccion.getFechaprogramaproduccion()) : null,
														Mapper.from(programarProduccion, programarProduccion.getProducto()),
														programarProduccion.getCantidadprogramada(),
														programarProduccion.getCantidadfabricada(),
														programarProduccion.getSaldoporfabricar(),
														programarProduccion.getActive(),
														Mapper.from(programarProduccion, programarProduccion.getCapturaproduccions()));
	   }
	   
	   return programarProduccionVO;
   }
		   
   
   public static List<ProgramaProduccionVO> from(Ordenfabricacion ordenFabricacion, Set<Programaproduccion> programarProduccions) {
	   List<ProgramaProduccionVO> programarProduccionsVO = new LinkedList<ProgramaProduccionVO>();
	   if(programarProduccions instanceof Set) {
		   for(Programaproduccion programarProduccion : programarProduccions) {
			   programarProduccionsVO.add(from(ordenFabricacion, programarProduccion));
		   }
//		   programarProduccionVO =  new ProgramarProduccionVO(
//				   												programarProduccion.getCodigo(),
//				   												null,
//				   												Mapper.from(programarProduccion.getLineaproduccion()),
//				   												programarProduccion.getFechaprogramaproduccion() != null ? sdf.format(programarProduccion.getFechaprogramaproduccion()) : null,
//				   												Mapper.from(programarProduccion, programarProduccion.getProducto()),
//				   												programarProduccion.getCantidadprogramada(),
//				   												programarProduccion.getCantidadfabricada(),
//				   												programarProduccion.getSaldoporfabricar(),
//				   												programarProduccion.getActive());
	   }
	   return programarProduccionsVO;
   }
   
   public static Programaproduccion from(ProgramaProduccionVO programarProduccionVO)  throws ParseException {
	   Programaproduccion programarProduccion = null;
	   if(programarProduccionVO instanceof ProgramaProduccionVO) {
		   programarProduccion =  new Programaproduccion(
				   											programarProduccionVO.getCodigo(),
				   											Mapper.from(programarProduccionVO.getProducto()),
														    Mapper.from(programarProduccionVO.getOrdenFabricacion()),
														    Mapper.from(programarProduccionVO.getLineaProduccion()),
														    programarProduccionVO.getFechaprogramaproduccion() != null ? sdf.parse(programarProduccionVO.getFechaprogramaproduccion()) : null,														   
														    programarProduccionVO.getCantidadprogramada(),
														    programarProduccionVO.getCantidadfabricada(),
														    programarProduccionVO.getSaldoporfabricar(),
														    programarProduccionVO.getActive());
	   }
	   return programarProduccion;
   }
   
   public static Set<Programaproduccion> from(List<ProgramaProduccionVO> programarProduccionsVO)  throws ParseException {
	   Set<Programaproduccion> programarProduccions = new HashSet<Programaproduccion>();
	   if(programarProduccionsVO instanceof List) {
		   for(ProgramaProduccionVO programarProduccionVO : programarProduccionsVO) {
			   programarProduccions.add(from(programarProduccionVO));
		   }
	   }
	   return programarProduccions;
   }
   
   public static Programaproduccion from(OrdenFabricacionVO ordenFabricacion, ProgramaProduccionVO programarProduccionVO)  throws ParseException {
	   Programaproduccion programarProduccion = null;
	   if(programarProduccionVO instanceof ProgramaProduccionVO) {
		   programarProduccion =  new Programaproduccion(
				   											programarProduccionVO.getCodigo(),
				   											Mapper.from(programarProduccionVO.getProducto()),
														    null,
														    Mapper.from(programarProduccionVO.getLineaProduccion()),
														    programarProduccionVO.getFechaprogramaproduccion() != null ? sdf.parse(programarProduccionVO.getFechaprogramaproduccion()) : null,														   
														    programarProduccionVO.getCantidadprogramada(),
														    programarProduccionVO.getCantidadfabricada(),
														    programarProduccionVO.getSaldoporfabricar(),
														    programarProduccionVO.getActive());
	   }
	   return programarProduccion;
   }
   
   public static Set<Programaproduccion> from(OrdenFabricacionVO ordenFabricacion, List<ProgramaProduccionVO> programarProduccionsVO) throws ParseException {
	   Set<Programaproduccion> programarProduccions = new HashSet<Programaproduccion>();
	   if(programarProduccionsVO instanceof List) {
		   for(ProgramaProduccionVO programarProduccionVO : programarProduccionsVO) {
			   programarProduccions.add(from(ordenFabricacion, programarProduccionVO));
		   }
	   }
	   return programarProduccions;
   }
   
   public static EntregaInsumoVO from(Entregainsumo entregaInsumo) {

	   return new EntregaInsumoVO(entregaInsumo.getCorrelativoentregainsumo(),
			   					Mapper.from(entregaInsumo.getOrdenfabricacion()),
	   							Mapper.from(entregaInsumo.getFuncionario()),
	   							entregaInsumo.getFechaentregainsumo(),
	   							entregaInsumo.getHoraentregainsumo(),
	   							entregaInsumo.getObservacion(),
	   							Mapper.from(entregaInsumo.getDetalleentregainsumo()));
   }
   
   public static Entregainsumo from(EntregaInsumoVO entregaInsumoVO)  throws ParseException {

	   return new Entregainsumo(
			   					Mapper.from(entregaInsumoVO.getOrdenFabricacion()),
	   							Mapper.from(entregaInsumoVO.getFuncionario()),
	   							entregaInsumoVO.getFechaEntregaInsumo(),
	   							entregaInsumoVO.getHoraEntregaInsumo(),
	   							entregaInsumoVO.getObservacion(),
	   							Mapper.from(entregaInsumoVO.getDetalleEntregaInsumo()));
   }
   
   public static List<EntregaInsumoVO> fromEntregainsumos(Set<Entregainsumo> entregaInsumos) {
	   List<EntregaInsumoVO> entregaInsumosVO = new LinkedList<EntregaInsumoVO>();
	   EntregaInsumoVO entregaInsumoVO = null;
	   for(Entregainsumo entregaInsumo : entregaInsumos) {
		   entregaInsumoVO = new EntregaInsumoVO(entregaInsumo.getCorrelativoentregainsumo(),
				   							null,
				   							Mapper.from(entregaInsumo.getFuncionario()),
				   							entregaInsumo.getFechaentregainsumo(),
				   							entregaInsumo.getHoraentregainsumo(),
				   							entregaInsumo.getObservacion(),
				   							Mapper.from(entregaInsumo.getDetalleentregainsumo()));
		   entregaInsumosVO.add(entregaInsumoVO);		   
	   }
	   
	   return entregaInsumosVO;
   }
   
   public static Set<Entregainsumo> fromEntregaInsumos(List<EntregaInsumoVO> entregaInsumosVO)  throws ParseException {
	   Set<Entregainsumo> entregaInsumos = new HashSet<Entregainsumo>();
	   if(entregaInsumosVO instanceof List) {
		   Entregainsumo entregaInsumo = null;
		   for(EntregaInsumoVO entregaInsumoVO : entregaInsumosVO) {
			   entregaInsumo = new Entregainsumo(
					   							null,
					   							Mapper.from(entregaInsumoVO.getFuncionario()),
					   							entregaInsumoVO.getFechaEntregaInsumo(),
					   							entregaInsumoVO.getHoraEntregaInsumo(),
					   							entregaInsumoVO.getObservacion(),
					   							Mapper.from(entregaInsumoVO.getDetalleEntregaInsumo()));
			   entregaInsumos.add(entregaInsumo);		   
		   }
	   }	   
	   return entregaInsumos;
   }
   
   public static DevolucionInsumoVO from(Devolucioninsumo devolucionInsumo) {
	   
	   return new DevolucionInsumoVO(devolucionInsumo.getCorrelativoentregainsumo(),
		   							null,
		   							Mapper.from(devolucionInsumo.getFuncionario()),
		   							devolucionInsumo.getFechadevolucioninsumo(),
		   							devolucionInsumo.getHoradevolucioninsumo(),
		   							devolucionInsumo.getObservacion(),
		   							Mapper.from(devolucionInsumo.getDetalledevolucioninsumo()));
   }
   
   public static List<DevolucionInsumoVO> fromDevolucioninsumos(Set<Devolucioninsumo> devolucionInsumos) {
	   List<DevolucionInsumoVO> devolucionInsumosVO = new LinkedList<DevolucionInsumoVO>();
	   DevolucionInsumoVO devolucionInsumoVO = null;
	   for(Devolucioninsumo devolucionInsumo : devolucionInsumos) {
		   devolucionInsumoVO = new DevolucionInsumoVO(devolucionInsumo.getCorrelativoentregainsumo(),
							   							null,
							   							Mapper.from(devolucionInsumo.getFuncionario()),
							   							devolucionInsumo.getFechadevolucioninsumo(),
							   							devolucionInsumo.getHoradevolucioninsumo(),
							   							devolucionInsumo.getObservacion(),
							   							Mapper.from(devolucionInsumo.getDetalledevolucioninsumo()));
		   devolucionInsumosVO.add(devolucionInsumoVO);		   
	   }
	   
	   return devolucionInsumosVO;
   }
   
   public static Set<Devolucioninsumo> fromDevolucioninsumos(List<DevolucionInsumoVO> devolucionInsumosVO)  throws ParseException {
	   Set<Devolucioninsumo> devolucionInsumos = new HashSet<Devolucioninsumo>();
	   if(devolucionInsumosVO instanceof List) {
		   Devolucioninsumo devolucionInsumo = null;
		   for(DevolucionInsumoVO devolucionInsumoVO : devolucionInsumosVO) {
			   devolucionInsumo = new Devolucioninsumo(
							   							null,
							   							Mapper.from(devolucionInsumoVO.getFuncionario()),
							   							devolucionInsumoVO.getFechaDevolucionInsumo(),
							   							devolucionInsumoVO.getHoraDevolucionInsumo(),
							   							devolucionInsumoVO.getObservacion(),
							   							Mapper.from(devolucionInsumoVO.getDetalleDevolucionInsumo()));
			   devolucionInsumos.add(devolucionInsumo);		   
		   }
	   }	   
	   return devolucionInsumos;
   }
   
   public static FuncionarioVO from(Funcionario funcionario) {
	   return new FuncionarioVO(
			   					funcionario.getRutfuncionario(),
								Mapper.from(funcionario.getArea()),
								Mapper.from(funcionario.getCargo()),
								funcionario.getNombre(),
								funcionario.getApellidopaterno(),
								funcionario.getApellidomaterno());
   }
   
   public static Funcionario from(FuncionarioVO funcionarioVO) {
	   return new Funcionario(
							   funcionarioVO.getRut(),
							   Mapper.from(funcionarioVO.getArea()),
							   Mapper.from(funcionarioVO.getCargo()),
							   funcionarioVO.getNombre(),
							   funcionarioVO.getApellidoPaterno(),
							   funcionarioVO.getApellidoMaterno(),
							   null,  null,  null,  null,  null);
   }
   
   public static List<FuncionarioVO> fromFuncionarios(Set<Funcionario> funcionarios) {
	   List<FuncionarioVO> funcionariosVO = new LinkedList<FuncionarioVO>();
	   FuncionarioVO funcionarioVO = null;
	   if(funcionarios instanceof Set) {
		   for(Funcionario funcionario : funcionarios) {
			   funcionarioVO = new FuncionarioVO(funcionario.getRutfuncionario(),
											   Mapper.from(funcionario.getArea()),
											   Mapper.from(funcionario.getCargo()),
											   funcionario.getNombre(),
											   funcionario.getApellidopaterno(),
											   funcionario.getApellidomaterno());
			   funcionariosVO.add(funcionarioVO);		   
		   }
	   }
	   
	   return funcionariosVO;
   }
   
   public static Set<Funcionario> fromFuncionarios(List<FuncionarioVO> funcionariosVO) {
	   Set<Funcionario> funcionarios = new  HashSet<Funcionario>();
	   Funcionario funcionario = null;
	   if(funcionariosVO instanceof List) { 
		   for(FuncionarioVO funcionarioVO : funcionariosVO) {
			   funcionario = new Funcionario(
					   						funcionarioVO.getRut(),
											Mapper.from(funcionarioVO.getArea()),
											Mapper.from(funcionarioVO.getCargo()),
											funcionarioVO.getNombre(),
											funcionarioVO.getApellidoPaterno(),
											funcionarioVO.getApellidoMaterno(),
											null, null, null, null, null);
			   funcionarios.add(funcionario);		   
		   }
	   }
	   
	   return funcionarios;
   }
   
   public static AreaVO from(Area area) {
	   AreaVO areaVO = null;
	   if(area instanceof Area) {
		   areaVO = new AreaVO(area.getCodigo(),
				   area.getNombre());
	   }
	   return areaVO;
   }
   
   public static Area from(AreaVO areaVO) {
	   Area area = null;
	   if(areaVO instanceof AreaVO) {
		   area = new Area(
						   areaVO.getCodigo(),
						   areaVO.getNombre(),
						   null);
	   }
	   return area;
   }
   
   public static CargoVO from(Cargo cargo) {
	   CargoVO cargoVO = null;
	   if(cargo instanceof Cargo) {
		   cargoVO = new CargoVO(cargo.getCodigo(),
				   	cargo.getNombre());
	   }
	   return cargoVO;
   }
   
   public static Cargo from(CargoVO cargoVO) {
	   Cargo cargo = null;
	   if(cargoVO instanceof CargoVO) {
		   cargo = new Cargo(
				   			cargoVO.getCodigo(),
				   			cargoVO.getNombre(),
				   			null);
	   }
	   return cargo;
   }
   
   public static DetalleEntregaInsumoVO from(Detalleentregainsumo detalleEntregaInsumo) {
	   return new DetalleEntregaInsumoVO(
			   							null,
			   							Mapper.from(detalleEntregaInsumo.getProducto()),
			   							detalleEntregaInsumo.getCantidadentregainsumo(),
			   							Mapper.from(detalleEntregaInsumo.getUnidadmedida()));
   }
   
   public static Detalleentregainsumo from(DetalleEntregaInsumoVO detalleEntregaInsumoVO)  throws ParseException {
	   return new Detalleentregainsumo(
			   							Mapper.from(detalleEntregaInsumoVO.getUnidadMedida()),
			   							Mapper.from(detalleEntregaInsumoVO.getEntregaInsumo()),
			   							Mapper.from(detalleEntregaInsumoVO.getInsumo()),
			   							detalleEntregaInsumoVO.getCantidadentregainsumo()
			   							);
   }
   
   public static DetalleDevolucionInsumoVO from(Detalledevolucioninsumo detalleDevolucionInsumo) {
	   return new DetalleDevolucionInsumoVO(detalleDevolucionInsumo.getCorrelativodevolucioninsumo(),
										   Mapper.from(detalleDevolucionInsumo.getProducto()),
										   detalleDevolucionInsumo.getCantidaddevolucioninsumo(),
										   detalleDevolucionInsumo.getCodigounidadmedida());
   }
   
   public static Detalledevolucioninsumo from(DetalleDevolucionInsumoVO detalleDevolucionInsumoVO)  throws ParseException {
	   return new Detalledevolucioninsumo(
			   							null,
			   							Mapper.from(detalleDevolucionInsumoVO.getInsumo()),
										detalleDevolucionInsumoVO.getCantidadDevolucionInsumo(),
										detalleDevolucionInsumoVO.getCodigoUnidadMedida());
   }
   
   public static LineaProduccionVO from(Lineaproduccion lineaProduccion) {
	   LineaProduccionVO lineaProduccionVO = null;
	   if(lineaProduccion instanceof Lineaproduccion) {
		   lineaProduccionVO = new LineaProduccionVO(
												   lineaProduccion.getCodigolineaproduccion(),
												   lineaProduccion.getNombrelineaproduccion());
	   }
	   return lineaProduccionVO;
   }
   
   public static Lineaproduccion from(LineaProduccionVO lineaProduccionVO) {
	   Lineaproduccion lineaproduccion = null;
	   if(lineaProduccionVO instanceof LineaProduccionVO) {
		   lineaproduccion = new Lineaproduccion(
				   					lineaProduccionVO.getCodigo(),
				   					lineaProduccionVO.getNombre(),
				   					null, null);
	   }
	   return lineaproduccion;
   }
   
   public static EstadoOrdenFabricacionVO from(Estadoordenfabricacion estadoOrdenFabricacion) {
	   return new EstadoOrdenFabricacionVO(estadoOrdenFabricacion.getCodigo(),
			   estadoOrdenFabricacion.getNombre());
   }
   
   public static Estadoordenfabricacion from(EstadoOrdenFabricacionVO estadoOrdenFabricacionVO) {
	   Estadoordenfabricacion estadoOrdenFabricacion = null;
	   if(estadoOrdenFabricacionVO instanceof EstadoOrdenFabricacionVO) {
		   estadoOrdenFabricacion = new Estadoordenfabricacion(
															   estadoOrdenFabricacionVO.getCodigo(),
															   estadoOrdenFabricacionVO.getNombre(),
															   null);
	   }
	   return estadoOrdenFabricacion;
	   
   }
   
   public static BodegaVO from(Bodega bodega) {
	   return new BodegaVO(bodega.getCodigo(),
			   bodega.getNombre());
   }
   
   public static Bodega from(BodegaVO bodegaVO) {
	   Bodega bodega = null;
	   if(bodegaVO instanceof BodegaVO) {
		   bodega = new Bodega(
						   bodegaVO.getCodigo(),
						   bodegaVO.getNombre(),
						   null);
	   }
	   return bodega;
		   
   }
   
   public static FamiliaVO from(Familia familia) {
	   FamiliaVO familiaVO = null;
	   if(familia instanceof Familia) {
		   familiaVO = new FamiliaVO(familia.getCodigofamilia(),
				   					familia.getNombrefamilia());
	   }
	   return familiaVO;
   }
   
   public static Familia from(FamiliaVO familiaVO) {
	   Familia familia = null;
	   if(familiaVO instanceof FamiliaVO) {
		   familia = new Familia(familiaVO.getCodigo(),
				   				familiaVO.getNombre(),
				   				null,
				   				null,
				   				null);
	   }
	   return familia;
   }
   
   public static SubFamiliaVO from(Subfamilia subFamilia) {
	   SubFamiliaVO subFamiliaVO = null;
	   if(subFamilia instanceof Subfamilia) {
		   subFamiliaVO = new SubFamiliaVO(subFamilia.getCodigosubfamilia(),
				   							Mapper.from(subFamilia.getFamilia()),
				   							subFamilia.getNombresubfamilia());
	   }
	   return subFamiliaVO;
   }
   
   public static Subfamilia from(SubFamiliaVO subFamiliaVO) {
	   Subfamilia subFamilia = null;
	   if(subFamiliaVO instanceof SubFamiliaVO) {
		   subFamilia = new Subfamilia(
				   						subFamiliaVO.getCodigo(),
				   						Mapper.from(subFamiliaVO.getFamilia()),
				   						subFamiliaVO.getNombre(),
				   						null);
	   }
	   return subFamilia;
   }
   
   public static OtraCaracteristicaVO from(Otracaracteristica otraCaracteristica) {
	   OtraCaracteristicaVO otraCaracteristicaVO = null;
	   if(otraCaracteristica instanceof Otracaracteristica) {
		   otraCaracteristicaVO = new OtraCaracteristicaVO(otraCaracteristica.getCodigootracaracteristica(),
				   											otraCaracteristica.getNombreotracaracteristica());
	   }
	   return otraCaracteristicaVO;
   }
   
   public static Otracaracteristica from(OtraCaracteristicaVO otraCaracteristicaVO) {
	   Otracaracteristica otraCaracteristica = null;
	   if(otraCaracteristicaVO instanceof OtraCaracteristicaVO) {
		   otraCaracteristica = new Otracaracteristica(otraCaracteristicaVO.getCodigootracaracteristica(),
				   										otraCaracteristicaVO.getNombreotracaracteristica(),
				   										null);
	   }
	   return otraCaracteristica;
   }
   
   public static UnidadMedidaVO from(Unidadmedida unidadMedida) {
	   UnidadMedidaVO unidadMedidaVO = null;
	   if(unidadMedida instanceof Unidadmedida) {
		   unidadMedidaVO = new UnidadMedidaVO(unidadMedida.getCodigo(),
				   								unidadMedida.getNombre(),
				   								Mapper.from(unidadMedida.getFamilia()));
	   }
	   return unidadMedidaVO;
   }
   
   public static Unidadmedida from(UnidadMedidaVO unidadMedidaVO) {
	   Unidadmedida unidadMedida = null;
	   if(unidadMedidaVO instanceof UnidadMedidaVO) {
		   unidadMedida = new Unidadmedida(
				   							unidadMedidaVO.getCodigo(),
				   							Mapper.from(unidadMedidaVO.getFamilia()),
				   							unidadMedidaVO.getNombre(),
				   							null, null, null, null, null, null);
	   }
	   return unidadMedida;
   }
   
   public static TipoProductoVO from(Tipoproducto tipoProducto) {
	   TipoProductoVO tipoProductoVO = null;
	   if(tipoProducto instanceof Tipoproducto) {
		   tipoProductoVO = new TipoProductoVO(tipoProducto.getCodigo(),
				   					tipoProducto.getNombre());
	   }
	   return tipoProductoVO;
   }
   
   public static Tipoproducto from(TipoProductoVO tipoProductoVO) {
	   Tipoproducto tipoProducto = null;
	   if(tipoProductoVO instanceof TipoProductoVO) {
		   tipoProducto = new Tipoproducto(tipoProductoVO.getCodigo(),
				   							tipoProductoVO.getNombre(),
				   							null);
	   }
	   return tipoProducto;
   }
   
   public static UbicacionVO from(Ubicacion ubicacion) {
	   return new UbicacionVO(
							   ubicacion.getId(), 
							   Mapper.from(ubicacion, ubicacion.getProducto()), 
							   Mapper.from(ubicacion.getBodega()),
							   ubicacion.getFechaingreso() != null ? sdf.format(ubicacion.getFechaingreso()) : null,
							   ubicacion.getFechavencimiento() != null ? sdf.format(ubicacion.getFechavencimiento()) : null,
							   ubicacion.getCantidad(), 
							   Mapper.from(ubicacion.getUnidadmedida()),
							   ubicacion.getObservacionubicacion());
   }
   
   public static Ubicacion from(UbicacionVO ubicacionVO) throws ParseException {
	   Ubicacion ubicacion = null;
	   ubicacion = new Ubicacion(
			   			   Mapper.from(ubicacionVO.getUnidadMedida()),
						   Mapper.from(ubicacionVO.getProducto()), 
						   Mapper.from(ubicacionVO.getBodega()),
						   ubicacionVO.getFechaIngreso() != null ? sdf.parse(ubicacionVO.getFechaIngreso()) : null,
						   ubicacionVO.getFechaVencimiento() != null ? sdf.parse(ubicacionVO.getFechaVencimiento()) : null,
						   ubicacionVO.getCantidad(),						   
						   ubicacionVO.getObservacion());
	   ubicacion.setId(ubicacionVO.getId());
	   return ubicacion;
   }
   
   public static List<UbicacionVO> fromUbicacions(Set<Ubicacion> ubicacions) {
	   List<UbicacionVO> ubicacionsVO = new LinkedList<UbicacionVO>();
	   if(ubicacions instanceof Set) {
		   UbicacionVO ubicacionVO = null;
		   for(Ubicacion ubicacion : ubicacions) {
			   ubicacionVO = new UbicacionVO(
										   ubicacion.getId(), 
										   Mapper.from(ubicacion.getProducto()), 
										   Mapper.from(ubicacion.getBodega()),
										   ubicacion.getFechaingreso() != null ? sdf.format(ubicacion.getFechaingreso()) : null,
										   ubicacion.getFechavencimiento() != null ? sdf.format(ubicacion.getFechavencimiento()) : null,
										   ubicacion.getCantidad(), 
										   Mapper.from(ubicacion.getUnidadmedida()),
										   ubicacion.getObservacionubicacion());
			   ubicacionsVO.add(ubicacionVO);
		   }
	   }	   
	   return ubicacionsVO;
   }
   
   public static List<UbicacionVO> fromUbicacions(Producto producto, Set<Ubicacion> ubicacions) {
	   List<UbicacionVO> ubicacionsVO = new LinkedList<UbicacionVO>();
	   if(ubicacions instanceof Set) {
		   UbicacionVO ubicacionVO = null;
		   for(Ubicacion ubicacion : ubicacions) {
			   ubicacionVO = new UbicacionVO(
										   ubicacion.getId(), 
										   null, 
										   Mapper.from(ubicacion.getBodega()),
										   ubicacion.getFechaingreso() != null ? sdf.format(ubicacion.getFechaingreso()) : null, 
										   ubicacion.getFechavencimiento() != null ? sdf.format(ubicacion.getFechavencimiento()) : null,
										   ubicacion.getCantidad(), 
										   Mapper.from(ubicacion.getUnidadmedida()),
										   ubicacion.getObservacionubicacion());
			   ubicacionsVO.add(ubicacionVO);
		   }
	   }
	   
	   return ubicacionsVO;
   }
   
   public static Set<Ubicacion> fromUbicacions(List<UbicacionVO> ubicacionsVO) throws ParseException {
	   Set<Ubicacion> ubicacions = new HashSet<Ubicacion>();
	   Ubicacion ubicacion = null;
	   for(UbicacionVO ubicacionVO : ubicacionsVO) {
		   ubicacion = new Ubicacion(
								   Mapper.from(ubicacionVO.getUnidadMedida()),
								   Mapper.from(ubicacionVO.getProducto()),
								   Mapper.from(ubicacionVO.getBodega()),
								   ubicacionVO.getFechaIngreso() != null ? sdf.parse(ubicacionVO.getFechaIngreso()) : null,
								   ubicacionVO.getFechaVencimiento() != null ?  sdf.parse(ubicacionVO.getFechaVencimiento()) : null,
								   ubicacionVO.getCantidad(),
								   ubicacionVO.getObservacion());
		   ubicacion.setId(ubicacionVO.getId()); 
		   ubicacions.add(ubicacion);
	   }
	   
	   return ubicacions;
   }
   
   public static CapturaProduccionVO from(Capturaproduccion capturaProduccion) {
	   return new CapturaProduccionVO(
			   							capturaProduccion.getCorrelativoproduccion(), 
			   							Mapper.from(capturaProduccion.getProducto(), 
			   									capturaProduccion.getProducto().getStock(), 
			   									capturaProduccion.getProducto().getUbicacions()), 
									    Mapper.from(capturaProduccion, capturaProduccion.getProgramaproduccion()),
									    capturaProduccion.getFechacapturaproduccion() != null ? sdf.format(capturaProduccion.getFechacapturaproduccion()) : null,
									    capturaProduccion.getCantidadproduccion(), 
									    Mapper.from(capturaProduccion.getUnidadmedida()),
									    capturaProduccion.getObservacion(),
									    Mapper.fromFuncionarios(capturaProduccion.getFuncionarios()));
   }
   
   public static Capturaproduccion from(CapturaProduccionVO capturaProduccionVO)  throws ParseException {
	   Capturaproduccion capturaProduccion = null;
	   if(capturaProduccionVO instanceof CapturaProduccionVO) {
			   capturaProduccion = new Capturaproduccion(
					   									Mapper.from(capturaProduccionVO.getUnidadMedida()),
					   									Mapper.from(capturaProduccionVO.getProducto(), 
					   											capturaProduccionVO.getProducto() != null ? capturaProduccionVO.getProducto().getStock() : null, 
					   											capturaProduccionVO.getProducto() != null ? capturaProduccionVO.getProducto().getUbicacions() : null),
					   									Mapper.from(capturaProduccionVO.getProgramaProduccion()),
					   									capturaProduccionVO.getFechaCapturaProduccion() != null ? sdf.parse(capturaProduccionVO.getFechaCapturaProduccion()) : null,
														capturaProduccionVO.getCantidadProduccion(),
														capturaProduccionVO.getObservacion(),
													    Mapper.fromFuncionarios(capturaProduccionVO.getFuncionarios()));
	   }   
	   return capturaProduccion;
   }
   
   public static List<CapturaProduccionVO> fromCapturaProduccions(Set<Capturaproduccion> capturaProduccions) {
	   List<CapturaProduccionVO> capturaProduccionsVO = new LinkedList<CapturaProduccionVO>();
	   CapturaProduccionVO capturaProduccionVO = null;
	   for(Capturaproduccion capturaProduccion : capturaProduccions) {
		   capturaProduccionVO = new CapturaProduccionVO(
				   										capturaProduccion.getCorrelativoproduccion(), 
														Mapper.from(capturaProduccion.getProducto()), 
														Mapper.from(capturaProduccion, capturaProduccion.getProgramaproduccion()),
													    capturaProduccion.getFechacapturaproduccion() != null ? sdf.format(capturaProduccion.getFechacapturaproduccion()) : null,
													    capturaProduccion.getCantidadproduccion(), 
													    Mapper.from(capturaProduccion.getUnidadmedida()),
													    capturaProduccion.getObservacion(),
													    Mapper.fromFuncionarios(capturaProduccion.getFuncionarios()));
		   capturaProduccionsVO.add(capturaProduccionVO);
	   }
	   
	   return capturaProduccionsVO;
   }
   
   public static List<CapturaProduccionVO> from(Programaproduccion programaProduccion, Set<Capturaproduccion> capturaProduccions) {
	   List<CapturaProduccionVO> capturaProduccionsVO = new LinkedList<CapturaProduccionVO>();
	   CapturaProduccionVO capturaProduccionVO = null;
	   for(Capturaproduccion capturaProduccion : capturaProduccions) {
		   capturaProduccionVO = new CapturaProduccionVO(
				   										capturaProduccion.getCorrelativoproduccion(), 
														Mapper.from(capturaProduccion.getProducto()), 
													    null,
													    capturaProduccion.getFechacapturaproduccion() != null ? sdf.format(capturaProduccion.getFechacapturaproduccion()) : null,
													    capturaProduccion.getCantidadproduccion(), 
													    Mapper.from(capturaProduccion.getUnidadmedida()),
													    capturaProduccion.getObservacion(),
													    Mapper.fromFuncionarios(capturaProduccion.getFuncionarios()));
		   capturaProduccionsVO.add(capturaProduccionVO);
	   }
	   
	   return capturaProduccionsVO;
   }
   
   public static Set<Capturaproduccion> fromCapturaProduccions(List<CapturaProduccionVO> capturaProduccionsVO)  throws ParseException {
	   Set<Capturaproduccion> capturaProduccions = new HashSet<Capturaproduccion>();
	   if(capturaProduccionsVO instanceof List) {
		   Capturaproduccion capturaProduccion = null;
		   for(CapturaProduccionVO capturaProduccionVO : capturaProduccionsVO) {
			   capturaProduccion = new Capturaproduccion(
					   									Mapper.from(capturaProduccionVO.getUnidadMedida()),
					   									Mapper.from(capturaProduccionVO.getProducto()),
					   									null,
					   									capturaProduccionVO.getFechaCapturaProduccion() != null ? sdf.parse(capturaProduccionVO.getFechaCapturaProduccion()) : null,
														capturaProduccionVO.getCantidadProduccion(),
														capturaProduccionVO.getObservacion(),
													    Mapper.fromFuncionarios(capturaProduccionVO.getFuncionarios()));
			   capturaProduccions.add(capturaProduccion);
		   }
	   }	   
	   return capturaProduccions;
   }
   
   public static EstadoPedidoVO from(Estadopedido estadoPedido) {
	   return new EstadoPedidoVO(
			   					estadoPedido.getCodigo(), 
			   					estadoPedido.getNombre());
   }
   
   public static Estadopedido from(EstadoPedidoVO estadoPedidoVO) {
	   Estadopedido estadoPedido = null;
	   if(estadoPedidoVO instanceof EstadoPedidoVO) {
		   estadoPedido = new Estadopedido(
				   					estadoPedidoVO.getCodigo(), 
				   					estadoPedidoVO.getNombre(),
				   					null);
	   }
	   return estadoPedido;
   }
   
   public static Productolinea from(ProductoLineaVO productoLineaVO)  throws ParseException {
	   Productolinea productoLinea = new Productolinea(
													   Mapper.from(productoLineaVO.getProducto()),
													   Mapper.from(productoLineaVO.getLineaProduccion()),
													   productoLineaVO.getPrioridad());
	   productoLinea.setId(productoLineaVO.getId());
	   return productoLinea;
	   
   }
   
   public static ProductoLineaVO from(Productolinea productoLinea) {
	   ProductoLineaVO productoLineaVO = new ProductoLineaVO(
			   											productoLinea.getId(),
			   											Mapper.from(productoLinea.getProducto()),
			   											Mapper.from(productoLinea.getLineaproduccion()),
			   											productoLinea.getPrioridad());
	   return productoLineaVO;
	   
   }
   
   public static RegionVO from(Region region) {
	   RegionVO regionVO = new RegionVO(
										region.getCodigo(),
										region.getNombre());
	   return regionVO;
	   
   }
   
   public static Region from(RegionVO regionVO) {
	   Region region = new Region(
								regionVO.getCodigo(),
								regionVO.getNombre(),
								null);
	   return region;
	   
   }
   
   public static CiudadVO from(Ciudad ciudad) {
	   CiudadVO ciudadVO = null;
	   if(ciudad instanceof Ciudad) {
		   ciudadVO = new CiudadVO(
									ciudad.getCodigo(),
									ciudad.getNombre(),
									Mapper.from(ciudad.getRegion()));
	   }
	   return ciudadVO;
	   
   }
   
   public static Ciudad from(CiudadVO ciudadVO) {
	   Ciudad ciudad = null;
	   if(ciudadVO instanceof CiudadVO) {
		   ciudad = new Ciudad(
								ciudadVO.getCodigo(),
								Mapper.from(ciudadVO.getRegion()),
								ciudadVO.getNombre(),
								null);
	   }
	   return ciudad;
	   
   }
   
   public static ComunaVO from(Comuna comuna) {
	   ComunaVO comunaVO = null;
	   if(comuna instanceof Comuna) {
		   comunaVO = new ComunaVO(
				   					comuna.getCodigo(), 
									comuna.getNombre(), 
								    Mapper.from(comuna.getCiudad()));
	   }
	   
	   return comunaVO;
   }
   
   public static Comuna from(ComunaVO comunaVO) {
	   Comuna comuna = null;
	   if(comunaVO instanceof ComunaVO) {
		   comuna = new Comuna(
			   					comunaVO.getCodigo(), 
			   					Mapper.from(comunaVO.getCiudad()),
			   					comunaVO.getNombre(),
			   					null);
	   }
	   
	   return comuna;
   }
   
   public static Tipocliente from(TipoClienteVO tipoClienteVO) {
	   Tipocliente tipoCliente = null;
	   if(tipoClienteVO instanceof TipoClienteVO) {
		   tipoCliente = new Tipocliente(
				   						tipoClienteVO.getCodigo(), 
				   						tipoClienteVO.getNombre(),
				   						null);
	   }
	   
	   return tipoCliente;
   }
   
   public static TipoClienteVO from(Tipocliente tipoCliente) {
	   TipoClienteVO tipoClienteVO = null;
	   if(tipoCliente instanceof Tipocliente) {
		   tipoClienteVO = new TipoClienteVO(
				   							tipoCliente.getCodigo(), 
				   							tipoCliente.getNombre());
	   }
	   
	   return tipoClienteVO;
   }
   
   public static Cliente from(ClienteVO clienteVO) {
	   Cliente cliente = null;
	   if(clienteVO instanceof ClienteVO) {
		   cliente = new Cliente(
							   clienteVO.getRut(), 
							   Mapper.from(clienteVO.getComuna()), 
							   Mapper.from(clienteVO.getTipoCliente()),
							   clienteVO.getDv(),
							   clienteVO.getNombre(), 
							   clienteVO.getDireccion(), 
							   clienteVO.getFechanacimiento(),
							   clienteVO.getTelefono(), 
							   clienteVO.getCelular(), 
							   clienteVO.getEmail(),
							   clienteVO.getPaginawebcliente(), 
							   clienteVO.getObservacion(),
							   null);
	   }
	   
	   return cliente;
   }
   
   public static ClienteVO from(Cliente cliente) {
	   ClienteVO clienteVO = null;
	   if(cliente instanceof Cliente) {
		   clienteVO = new ClienteVO(
							   cliente.getRut(), 
							   Mapper.from(cliente.getComuna()), 
							   Mapper.from(cliente.getTipocliente()),
							   cliente.getDv(),
							   cliente.getNombre(), 
							   cliente.getDireccion(), 
							   cliente.getFechanacimiento(),
							   cliente.getTelefono(), 
							   cliente.getCelular(), 
							   cliente.getEmail(),
							   cliente.getPaginawebcliente(), 
							   cliente.getObservacion());
	   }
	   
	   return clienteVO;
   }
   
   public static EntregaVO from(Entrega entrega) {
	   EntregaVO entregaVO = null;
	   if(entrega instanceof Entrega) {
		   entregaVO = new EntregaVO(
							   entrega.getCodigo(),
							   entrega.getDescripcion());
	   }
	   
	   return entregaVO;
   }
   
   public static Entrega from(EntregaVO entregaVO) {
	   Entrega entrega = null;
	   if(entregaVO instanceof EntregaVO) {
		   entrega = new Entrega(
							   entregaVO.getCodigo(),
							   entregaVO.getDescripcion());
	   }
	   
	   return entrega;
   }
}