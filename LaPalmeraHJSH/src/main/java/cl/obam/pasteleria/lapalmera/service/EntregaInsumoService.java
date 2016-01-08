package cl.obam.pasteleria.lapalmera.service;

import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.EntregaInsumoDao;
import cl.obam.pasteleria.lapalmera.dao.FuncionarioDao;
import cl.obam.pasteleria.lapalmera.dao.ProductoDao;
import cl.obam.pasteleria.lapalmera.dao.StockDao;
import cl.obam.pasteleria.lapalmera.dao.UbicacionDao;
import cl.obam.pasteleria.lapalmera.exception.BusinessException;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Detalleentregainsumo;
import cl.obam.pasteleria.lapalmera.model.Entregainsumo;
import cl.obam.pasteleria.lapalmera.model.Funcionario;
import cl.obam.pasteleria.lapalmera.model.Ordenfabricacion;
import cl.obam.pasteleria.lapalmera.model.Producto;
import cl.obam.pasteleria.lapalmera.model.Stock;
import cl.obam.pasteleria.lapalmera.model.Ubicacion;
import cl.obam.pasteleria.lapalmera.model.Unidadmedida;
import cl.obam.pasteleria.lapalmera.util.Mapper;
import cl.obam.pasteleria.lapalmera.util.UnidadMedidaHelper;
import cl.obam.pasteleria.lapalmera.view.EntregaInsumoVO;
import cl.obam.pasteleria.lapalmera.view.UbicacionVO;

@Service
public class EntregaInsumoService {
	
	private static final Logger LOG = Logger.getLogger(EntregaInsumoService.class);
	
	@Autowired
	private EntregaInsumoDao dao;
	
	@Autowired
	private ProductoDao productoDao;
	
	@Autowired
	private UbicacionDao ubicacionDao;
	
	@Autowired
	private StockDao stockDao;
	
	@Autowired
	private FuncionarioDao funcionarioDao;
	
	public Entregainsumo get(String codigo) throws DAOException {
		return dao.get(codigo);
	}
	
	public List<Entregainsumo> getAll() throws DAOException {
		return dao.getAll();
	}
	
	public boolean update(Entregainsumo obj) throws DAOException {
		return dao.update(obj);
	}
	
	public boolean delete(int codigo) throws DAOException {
		return dao.delete(codigo);
	}
	
	public List<EntregaInsumoVO> getAllEqBy(EntregaInsumoVO entregaInsumoVO) throws ParseException, DAOException {
		List<EntregaInsumoVO> entregaInsumosVO = new LinkedList<EntregaInsumoVO>();
		for(Entregainsumo obj : dao.getAllEqBy(Mapper.from(entregaInsumoVO))) {
			entregaInsumosVO.add(Mapper.from(obj));
		}
		return entregaInsumosVO;
	}
	
	public List<Entregainsumo> getAllNotEqBy(Entregainsumo entregaInsumo) throws DAOException {
		return dao.getAllNotEqBy(entregaInsumo);
	}
	
	public List<Entregainsumo> getAllBeginWithBy(Entregainsumo entregaInsumo) throws DAOException {
		return dao.getAllBeginWithBy(entregaInsumo);
	}
	
	public List<Entregainsumo> getAllNotBeginWithBy(Entregainsumo entregaInsumo) throws DAOException {
		return dao.getAllNotBeginWithBy(entregaInsumo);
	}
	
	public List<Entregainsumo> getAllEndWithBy(Entregainsumo entregaInsumo) throws DAOException {
		return dao.getAllEndWithBy(entregaInsumo);
	}
	
	public List<Entregainsumo> getAllNotEndWithBy(Entregainsumo entregaInsumo) throws DAOException {
		return dao.getAllNotEndWithBy(entregaInsumo);
	}
	
	public List<Entregainsumo> getAllContainBy(Entregainsumo entregaInsumo) throws DAOException {
		return dao.getAllContainBy(entregaInsumo);
	}
	
	public List<Entregainsumo> getAllNotContainBy(Entregainsumo entregaInsumo) throws DAOException {
		return dao.getAllNotContainBy(entregaInsumo);
	}
	
	public List<Entregainsumo> getAllIsNullBy(Entregainsumo entregaInsumo) throws DAOException {
		return dao.getAllIsNullBy(entregaInsumo);
	}
	
	public List<Entregainsumo> getAllNotIsNullBy(Entregainsumo entregaInsumo) throws DAOException {
		return dao.getAllNotIsNullBy(entregaInsumo);
	}
	
	public boolean save(Entregainsumo obj) throws DAOException {
		return dao.save(obj);
	}
	
	public EntregaInsumoVO save(EntregaInsumoVO entregaInsumoVO ) throws BusinessException, DAOException {
		
		LOG.debug("EntregaInsumoService save");
		
		try {
			String codigoOrdenFabricacion = entregaInsumoVO.getOrdenFabricacion().getCodigoOrdenFabricacion();
			String rutfuncionario = entregaInsumoVO.getFuncionario().getRut();
			String codigoInsumo = entregaInsumoVO.getDetalleEntregaInsumo().getInsumo().getCodigo();
			int cantidad = entregaInsumoVO.getDetalleEntregaInsumo().getCantidadentregainsumo();
			Float fCantidad = new Float(cantidad);
			String codigoUnidadMedida = entregaInsumoVO.getDetalleEntregaInsumo().getUnidadMedida().getCodigo();
			String observacion = entregaInsumoVO.getObservacion();
			List<UbicacionVO> ubicacionsVO = entregaInsumoVO.getDetalleEntregaInsumo().getInsumo().getUbicacions();
			
			/***Ordenfabricacion***/
			Ordenfabricacion ordenFabricacion = new Ordenfabricacion();
			ordenFabricacion.setCodigoordenfabricacion(codigoOrdenFabricacion);
			
			/***Funcionario***/
			Funcionario funcionario = funcionarioDao.get(rutfuncionario);
									
			/***Entregainsumo***/
			Entregainsumo entregaInsumo = new Entregainsumo(ordenFabricacion, funcionario, new Date(), new Date(), observacion, null);
			
			/***Producto***/
			Producto producto = productoDao.get(codigoInsumo);
			
			/***Ubicacion***/
			Set<Ubicacion> ubicacions = new HashSet<Ubicacion>();
			Ubicacion ubicacion = null;
			for(UbicacionVO ubicacionVO : ubicacionsVO) {
				ubicacion = ubicacionDao.get(ubicacionVO.getId());
				Float cantidadUbicacion = ubicacion.getCantidad();
				if(cantidadUbicacion < fCantidad) {
					throw new BusinessException("Cantidad mayor a ubicación elegida");
				} else {
					fCantidad = UnidadMedidaHelper.conversion(ubicacion.getUnidadmedida().getCodigo(), codigoUnidadMedida, fCantidad);
					
					ubicacion.setCantidad(cantidadUbicacion - fCantidad);
					ubicacions.add(ubicacion);
				}
			}
			producto.setUbicacions(ubicacions);
			
			/***Stock***/
			Stock stock = stockDao.get(codigoInsumo);
			float stockDisponible = stock.getStockdisponible() != null ? stock.getStockdisponible() : 0;
			float stockComprometido = stock.getStockcomprometido() != null ? stock.getStockcomprometido() : 0;
			if(stockDisponible < cantidad) {
				throw new BusinessException("Cantidad mayor a stock disponible");
			} else {
				fCantidad = UnidadMedidaHelper.conversion(stock.getUnidadmedida().getCodigo(), codigoUnidadMedida, fCantidad);
				stock.setStockdisponible(stockDisponible - fCantidad);
				stock.setStockcomprometido(stockComprometido + fCantidad);
			}			
			producto.setStock(stock);
			
			Unidadmedida unidadMedida = new Unidadmedida();
			unidadMedida.setCodigo(codigoUnidadMedida);
			
			/***Detalleentregainsumo***/
			Detalleentregainsumo detalleEntregaInsumo = new Detalleentregainsumo(unidadMedida, entregaInsumo, producto, cantidad);
						
			entregaInsumo.setDetalleentregainsumo(detalleEntregaInsumo);
			
			dao.save(entregaInsumo);
			
			entregaInsumoVO = Mapper.from(entregaInsumo);
			
		} catch(DAOException e) {
			throw e;
		} catch(Exception e) {
			LOG.error(e.getMessage(), e);
		}
		
		return entregaInsumoVO;
	}
}