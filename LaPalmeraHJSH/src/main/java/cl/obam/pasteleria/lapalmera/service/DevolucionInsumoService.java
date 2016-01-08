package cl.obam.pasteleria.lapalmera.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.DevolucionInsumoDao;
import cl.obam.pasteleria.lapalmera.dao.FuncionarioDao;
import cl.obam.pasteleria.lapalmera.dao.ProductoDao;
import cl.obam.pasteleria.lapalmera.dao.StockDao;
import cl.obam.pasteleria.lapalmera.dao.UbicacionDao;
import cl.obam.pasteleria.lapalmera.exception.BusinessException;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Bodega;
import cl.obam.pasteleria.lapalmera.model.Detalledevolucioninsumo;
import cl.obam.pasteleria.lapalmera.model.Devolucioninsumo;
import cl.obam.pasteleria.lapalmera.model.Funcionario;
import cl.obam.pasteleria.lapalmera.model.Ordenfabricacion;
import cl.obam.pasteleria.lapalmera.model.Producto;
import cl.obam.pasteleria.lapalmera.model.Stock;
import cl.obam.pasteleria.lapalmera.model.Ubicacion;
import cl.obam.pasteleria.lapalmera.model.Unidadmedida;
import cl.obam.pasteleria.lapalmera.util.Mapper;
import cl.obam.pasteleria.lapalmera.util.UnidadMedidaHelper;
import cl.obam.pasteleria.lapalmera.view.DevolucionInsumoVO;
import cl.obam.pasteleria.lapalmera.view.UbicacionVO;

@Service
public class DevolucionInsumoService {
	
	private static final Logger LOG = Logger.getLogger(DevolucionInsumoService.class);
	
	@Autowired
	private DevolucionInsumoDao dao;
	
	@Autowired
	private FuncionarioDao funcionarioDao;
	
	@Autowired
	private ProductoDao productoDao;
	
	@Autowired
	private UbicacionDao ubicacionDao;
	
	@Autowired
	private StockDao stockDao;
	
	public Devolucioninsumo get(String codigo) throws DAOException {
		return dao.get(codigo);
	}
	
	public List<Devolucioninsumo> getAll() throws DAOException {
		return dao.getAll();
	}
	
	public boolean save(Devolucioninsumo obj) throws DAOException {
		return dao.save(obj);
	}
	
	public boolean update(Devolucioninsumo obj) throws DAOException {
		return dao.update(obj);
	}
	
	public boolean delete(String codigo) throws DAOException {
		return dao.delete(codigo);
	}
	
	public List<Devolucioninsumo> getAllEqBy(Devolucioninsumo area) throws DAOException {
		return dao.getAllEqBy(area);
	}
	
	public List<Devolucioninsumo> getAllNotEqBy(Devolucioninsumo area) throws DAOException {
		return dao.getAllNotEqBy(area);
	}
	
	public List<Devolucioninsumo> getAllBeginWithBy(Devolucioninsumo area) throws DAOException {
		return dao.getAllBeginWithBy(area);
	}
	
	public List<Devolucioninsumo> getAllNotBeginWithBy(Devolucioninsumo area) throws DAOException {
		return dao.getAllNotBeginWithBy(area);
	}
	
	public List<Devolucioninsumo> getAllEndWithBy(Devolucioninsumo area) throws DAOException {
		return dao.getAllEndWithBy(area);
	}
	
	public List<Devolucioninsumo> getAllNotEndWithBy(Devolucioninsumo area) throws DAOException {
		return dao.getAllNotEndWithBy(area);
	}
	
	public List<Devolucioninsumo> getAllContainBy(Devolucioninsumo area) throws DAOException {
		return dao.getAllContainBy(area);
	}
	
	public List<Devolucioninsumo> getAllNotContainBy(Devolucioninsumo area) throws DAOException {
		return dao.getAllNotContainBy(area);
	}
	
	public List<Devolucioninsumo> getAllIsNullBy(Devolucioninsumo area) throws DAOException {
		return dao.getAllIsNullBy(area);
	}
	
	public List<Devolucioninsumo> getAllNotIsNullBy(Devolucioninsumo area) throws DAOException {
		return dao.getAllNotIsNullBy(area);
	}
	
	public DevolucionInsumoVO save(DevolucionInsumoVO entregaInsumoVO ) throws BusinessException, DAOException {
		
		LOG.debug("DevolucionInsumoService save");
		
		try {
			String codigoOrdenFabricacion = entregaInsumoVO.getOrdenFabricacion().getCodigoOrdenFabricacion();
			String rutfuncionario = entregaInsumoVO.getFuncionario().getRut();
			String codigoInsumo = entregaInsumoVO.getDetalleDevolucionInsumo().getInsumo().getCodigo();
			int cantidad = entregaInsumoVO.getDetalleDevolucionInsumo().getCantidadDevolucionInsumo();
			Float fCantidad = new Float(cantidad);
			String codigoUnidadMedida = entregaInsumoVO.getDetalleDevolucionInsumo().getCodigoUnidadMedida();
			String observacion = entregaInsumoVO.getObservacion();
			Bodega bodega = null;
			Date fechaVencimiento = null;
			List<UbicacionVO> ubicacionsVO = entregaInsumoVO.getDetalleDevolucionInsumo().getInsumo().getUbicacions();
			
			/***Ordenfabricacion***/
			Ordenfabricacion ordenFabricacion = new Ordenfabricacion();
			ordenFabricacion.setCodigoordenfabricacion(codigoOrdenFabricacion);
			
			/***Funcionario***/
			Funcionario funcionario = funcionarioDao.get(rutfuncionario);
//			Funcionario funcionario = new Funcionario();
//			funcionario.setRutfuncionario(rutfuncionario);
									
			/***Entregainsumo***/
			Devolucioninsumo devolucionInsumo = new Devolucioninsumo(ordenFabricacion, funcionario, new Date(), new Date(), observacion, null);
			
			/***Producto***/
			Producto producto = productoDao.get(codigoInsumo);
			
			/***Unidadmedida***/
			Unidadmedida unidadMedida = new Unidadmedida();
			unidadMedida.setCodigo(codigoUnidadMedida);

			
			/***Ubicacion***/
			Set<Ubicacion> ubicacions = new HashSet<Ubicacion>();
			for(UbicacionVO ubicacionVO : ubicacionsVO) {
				bodega = new Bodega(ubicacionVO.getBodega().getCodigo());				
				fechaVencimiento = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(ubicacionVO.getFechaVencimiento());			
				Ubicacion ubicacion = new Ubicacion(unidadMedida, producto, bodega, new Date(), fechaVencimiento, fCantidad, observacion);
				ubicacions.add(ubicacion);
			}
			producto.setUbicacions(ubicacions);
			
			/***Stock***/
			Stock stock = stockDao.get(codigoInsumo);
			if(!(stock instanceof Stock)) {
				stock = new Stock(producto.getUnidadmedida(), producto);
				stockDao.save(stock);				
			}
			fCantidad = UnidadMedidaHelper.conversion(stock.getUnidadmedida().getCodigo(), codigoUnidadMedida, fCantidad);
			
			float stockDisponible = stock.getStockdisponible() != null ? stock.getStockdisponible() : 0;
			stock.setStockdisponible(stockDisponible + fCantidad);					
			float stockComprometido = stock.getStockcomprometido() != null ? stock.getStockcomprometido() : 0;
			stock.setStockcomprometido(stockComprometido + fCantidad);
			producto.setStock(stock);
			
			/***Detalleentregainsumo***/
			Detalledevolucioninsumo detalleDevolucionInsumo = new Detalledevolucioninsumo(devolucionInsumo, producto, cantidad, codigoUnidadMedida);
						
			devolucionInsumo.setDetalledevolucioninsumo(detalleDevolucionInsumo);
			
			dao.save(devolucionInsumo);
			
			entregaInsumoVO = Mapper.from(devolucionInsumo);
			
		} catch(DAOException e) {
			throw e;
		} catch(Exception e) {
			LOG.error(e.getMessage(), e);
		}
		
		return entregaInsumoVO;
	}
}