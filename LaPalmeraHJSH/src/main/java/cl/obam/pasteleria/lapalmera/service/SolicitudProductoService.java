package cl.obam.pasteleria.lapalmera.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.ProductoLineaDao;
import cl.obam.pasteleria.lapalmera.dao.SolicitudProductoDao;
import cl.obam.pasteleria.lapalmera.exception.BusinessException;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Pedido;
import cl.obam.pasteleria.lapalmera.model.Producto;
import cl.obam.pasteleria.lapalmera.model.Productolinea;
import cl.obam.pasteleria.lapalmera.util.Mapper;
import cl.obam.pasteleria.lapalmera.view.CabezaPedidoVO;

@Service
public class SolicitudProductoService {
	
	private final static Logger LOG = Logger.getLogger(SolicitudProductoService.class);
	
	@Autowired
	private SolicitudProductoDao dao;
	
	@Autowired
	private ProductoLineaDao productoLineaDao;
	
	public CabezaPedidoVO save(CabezaPedidoVO cabezaPedidoVO ) throws BusinessException, DAOException, Exception, Throwable {
		
		LOG.debug("SolicitudProductoService save");
		
		try {			
			
			if(cabezaPedidoVO.getOrdenFabricacions() instanceof List && cabezaPedidoVO.getOrdenFabricacions().size() > 0) {
				/***Build Lineaproduccion***/
				for(int i = 0; i < cabezaPedidoVO.getDetallePedidos().size(); i++) {
					Producto producto = new Producto();
					producto.setCodigoproducto(cabezaPedidoVO.getDetallePedidos().get(i).getProducto().getCodigo());
					Productolinea productoLinea = new Productolinea();
					productoLinea.setProducto(producto);
					List<Productolinea> productoLineas = productoLineaDao.getAllEqBy(productoLinea);
					if(productoLineas instanceof List && !productoLineas.isEmpty()) {
						//TODO get por prioridad y carga
						for(int j = 0; j < cabezaPedidoVO.getOrdenFabricacions().get(i).getProgramaProduccions().size(); j++) {
							cabezaPedidoVO.getOrdenFabricacions().get(i).getProgramaProduccions().get(j).setLineaProduccion(
								Mapper.from(productoLineas.get(0).getLineaproduccion()));
						}
					} else {
						throw new BusinessException("No se encontraron Lineas de Producción para produco");
					}
				}
			}
			
			Pedido cabezaPedido = Mapper.from(cabezaPedidoVO);
			
			if(cabezaPedido.getNumeropedido() == null) { 
				dao.create(cabezaPedido);
			} else {
				dao.update(cabezaPedido);
			}
			
			cabezaPedidoVO = Mapper.from(cabezaPedido);
			
//		} catch(BusinessException e) {
//			throw e;
		} catch(DAOException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		} catch(Throwable t) {
			throw t;
		}
		
		return cabezaPedidoVO;
	}
}