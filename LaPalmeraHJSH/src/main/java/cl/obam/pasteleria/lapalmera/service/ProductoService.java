package cl.obam.pasteleria.lapalmera.service;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.ProductoDao;
import cl.obam.pasteleria.lapalmera.dao.StockDao;
import cl.obam.pasteleria.lapalmera.exception.BusinessException;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Producto;
import cl.obam.pasteleria.lapalmera.model.Stock;
import cl.obam.pasteleria.lapalmera.util.Mapper;
import cl.obam.pasteleria.lapalmera.util.UnidadMedidaHelper;
import cl.obam.pasteleria.lapalmera.view.ProductoVO;
import cl.obam.pasteleria.lapalmera.view.UnidadMedidaVO;

@Service
public class ProductoService {
	
	private static final Logger LOG = Logger.getLogger(ProductoService.class);
	
	@Autowired
	private ProductoDao productoDao;
	
	@Autowired
	private StockDao stockDao;
	
	public ProductoVO get(String codigo) throws DAOException {
		return Mapper.from(productoDao.get(codigo));
	}
	
	public ProductoVO getUbicacion(String codigo) throws DAOException {
		Producto producto = productoDao.get(codigo);
		return Mapper.from(producto, producto.getUbicacions());
	}
	
	public ProductoVO getStockUbicacion(String codigo) throws DAOException {
		Producto producto = productoDao.get(codigo);
		return Mapper.from(producto, producto.getStock(), producto.getUbicacions());
	}
	
	public List<ProductoVO> getAll() throws DAOException {
		
		List<ProductoVO> list = new LinkedList<ProductoVO>();
		for (Producto producto : productoDao.getAll()) {
			list.add(Mapper.from(producto));
		}
		return list;
	}
	
	public boolean save(Producto obj) throws DAOException {
		return productoDao.save(obj);
	}
	
	public boolean update(Producto obj) throws DAOException {
		return productoDao.update(obj);
	}
	
	public boolean delete(String codigo) throws DAOException {
		return productoDao.delete(codigo);
	}
	
	public List<ProductoVO> getAllEqBy(ProductoVO productoVO) throws DAOException, ParseException {
		
		List<ProductoVO> productosVO = new LinkedList<ProductoVO>();
		for (Producto producto : productoDao.getAllEqBy(Mapper.from(productoVO))) {
			productosVO.add(Mapper.from(producto));
		}
		
		return productosVO;
	}
	
	public List<ProductoVO> getAllNotEqBy(ProductoVO productoVO) throws DAOException, ParseException {
		List<ProductoVO> productosVO = new LinkedList<ProductoVO>();
		for(Producto producto : productoDao.getAllNotEqBy(Mapper.from(productoVO))) {
			productosVO.add(Mapper.from(producto));
		}
		return productosVO;
	}
	
	public List<Producto> getAllBeginWithBy(Producto producto) throws DAOException {
		return productoDao.getAllBeginWithBy(producto);
	}
	
	public List<Producto> getAllNotBeginWithBy(Producto producto) throws DAOException {
		return productoDao.getAllNotBeginWithBy(producto);
	}
	
	public List<Producto> getAllEndWithBy(Producto producto) throws DAOException {
		return productoDao.getAllEndWithBy(producto);
	}
	
	public List<Producto> getAllNotEndWithBy(Producto producto) throws DAOException {
		return productoDao.getAllNotEndWithBy(producto);
	}
	
	public List<Producto> getAllContainBy(Producto producto) throws DAOException {
		return productoDao.getAllContainBy(producto);
	}
	
	public List<Producto> getAllNotContainBy(Producto producto) throws DAOException {
		return productoDao.getAllNotContainBy(producto);
	}
	
	public List<Producto> getAllIsNullBy(Producto producto) throws DAOException {
		return productoDao.getAllIsNullBy(producto);
	}
	
	public List<Producto> getAllNotIsNullBy(Producto producto) throws DAOException {
		return productoDao.getAllNotIsNullBy(producto);
	}
	
	public ProductoVO ingreso(ProductoVO productoVO ) throws BusinessException, DAOException, Exception {
		
		LOG.debug("ProductoService ingreso");
		
		try {
			/***Stock***/
			float cantidad = 0;
			float stockDisponible = 0;
			float stockComprometido = 0;
			UnidadMedidaVO unidadMedidaVO = null;
			Stock stock = stockDao.get(productoVO.getCodigo());
			if(stock instanceof Stock) {
				cantidad = UnidadMedidaHelper.conversion(stock.getUnidadmedida().getCodigo(),
																productoVO.getUbicacions().get(0).getUnidadMedida().getCodigo(),
																productoVO.getUbicacions().get(0).getCantidad());
				stockDisponible = stock.getStockdisponible() + cantidad;
				stockComprometido = stock.getStockcomprometido();
				unidadMedidaVO = Mapper.from(stock.getUnidadmedida());
			} else {
				Producto producto = productoDao.get(productoVO.getCodigo());
				cantidad = UnidadMedidaHelper.conversion(producto.getUnidadmedida().getCodigo(), 
																productoVO.getUbicacions().get(0).getUnidadMedida().getCodigo(), 
																productoVO.getUbicacions().get(0).getCantidad());
				stockDisponible = cantidad;
				unidadMedidaVO = Mapper.from(producto.getUnidadmedida());
			}
			productoVO.getStock().setStockDisponible(stockDisponible);
			productoVO.getStock().setStockComprometido(stockComprometido);
			productoVO.getStock().setUnidadMedida(unidadMedidaVO);

			productoVO = productoDao.ingreso(productoVO);

		} catch(DAOException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

		return productoVO;
	}
}