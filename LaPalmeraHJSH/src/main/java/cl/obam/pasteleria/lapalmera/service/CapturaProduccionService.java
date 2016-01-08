package cl.obam.pasteleria.lapalmera.service;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.CapturaProduccionDao;
import cl.obam.pasteleria.lapalmera.dao.FuncionarioDao;
import cl.obam.pasteleria.lapalmera.dao.ProductoDao;
import cl.obam.pasteleria.lapalmera.dao.StockDao;
import cl.obam.pasteleria.lapalmera.exception.BusinessException;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Capturaproduccion;
import cl.obam.pasteleria.lapalmera.model.Funcionario;
import cl.obam.pasteleria.lapalmera.model.Producto;
import cl.obam.pasteleria.lapalmera.model.Stock;
import cl.obam.pasteleria.lapalmera.util.Mapper;
import cl.obam.pasteleria.lapalmera.util.UnidadMedidaHelper;
import cl.obam.pasteleria.lapalmera.view.CapturaProduccionVO;
import cl.obam.pasteleria.lapalmera.view.FuncionarioVO;

@Service
public class CapturaProduccionService {
	
	private static final Logger LOG = Logger.getLogger(CapturaProduccionService.class);
	
	@Autowired
	private CapturaProduccionDao dao;
	
	@Autowired
	private FuncionarioDao funcionarioDao;
	
	@Autowired
	private ProductoDao productoDao;
	
	@Autowired
	private StockDao stockDao;
		
	public Capturaproduccion get(CapturaProduccionVO capturaProduccionVO) throws DAOException {		
		return dao.get(capturaProduccionVO.getCorrelativoProduccion());
	}
	
	public List<CapturaProduccionVO> getAll() throws DAOException {
		List<CapturaProduccionVO> capturaProduccionsVO = new LinkedList<CapturaProduccionVO>();
		for(Capturaproduccion capturaProduccion : dao.getAll()) {
			capturaProduccionsVO.add(Mapper.from(capturaProduccion));
		}
		return capturaProduccionsVO;
	}
	
	public boolean save(Capturaproduccion obj) throws DAOException {
		return dao.save(obj);
	}
	
	public boolean update(CapturaProduccionVO capturaProduccionVO) throws ParseException, DAOException {
		return dao.update(Mapper.from(capturaProduccionVO));
	}
	
	public boolean delete(CapturaProduccionVO capturaProduccionVO) throws DAOException {
		return dao.delete(capturaProduccionVO.getCorrelativoProduccion());
	}
	
	public List<CapturaProduccionVO> getAllEqBy(CapturaProduccionVO capturaProduccionVO) throws ParseException, DAOException {
		List<CapturaProduccionVO> capturaProduccionsVO = new LinkedList<CapturaProduccionVO>();		
		for(Capturaproduccion capturaProduccion : dao.getAllEqBy(Mapper.from(capturaProduccionVO))) {
			capturaProduccionsVO.add(Mapper.from(capturaProduccion));
		}		
		return capturaProduccionsVO;
	}
	
	public List<CapturaProduccionVO> getAllNotEqBy(CapturaProduccionVO capturaProduccionVO) throws ParseException, DAOException {
		List<CapturaProduccionVO> capturaProduccionsVO = new LinkedList<CapturaProduccionVO>();		
		for(Capturaproduccion capturaProduccion : dao.getAllNotEqBy(Mapper.from(capturaProduccionVO))) {
			capturaProduccionsVO.add(Mapper.from(capturaProduccion));
		}		
		return capturaProduccionsVO;
	}
	
	public List<CapturaProduccionVO> getAllBeginWithBy(CapturaProduccionVO capturaProduccionVO) throws ParseException, DAOException {
		List<CapturaProduccionVO> capturaProduccionsVO = new LinkedList<CapturaProduccionVO>();		
		for(Capturaproduccion capturaProduccion : dao.getAllBeginWithBy(Mapper.from(capturaProduccionVO))) {
			capturaProduccionsVO.add(Mapper.from(capturaProduccion));
		}		
		return capturaProduccionsVO;
	}
	
	public List<CapturaProduccionVO> getAllNotBeginWithBy(CapturaProduccionVO capturaProduccionVO) throws ParseException, DAOException {
		List<CapturaProduccionVO> capturaProduccionsVO = new LinkedList<CapturaProduccionVO>();		
		for(Capturaproduccion capturaProduccion : dao.getAllNotBeginWithBy(Mapper.from(capturaProduccionVO))) {
			capturaProduccionsVO.add(Mapper.from(capturaProduccion));
		}		
		return capturaProduccionsVO;
	}
	
	public List<CapturaProduccionVO> getAllEndWithBy(CapturaProduccionVO capturaProduccionVO) throws ParseException, DAOException {
		List<CapturaProduccionVO> capturaProduccionsVO = new LinkedList<CapturaProduccionVO>();		
		for(Capturaproduccion capturaProduccion : dao.getAllEndWithBy(Mapper.from(capturaProduccionVO))) {
			capturaProduccionsVO.add(Mapper.from(capturaProduccion));
		}		
		return capturaProduccionsVO;
	}
	
	public List<CapturaProduccionVO> getAllNotEndWithBy(CapturaProduccionVO capturaProduccionVO) throws ParseException, DAOException {
		List<CapturaProduccionVO> capturaProduccionsVO = new LinkedList<CapturaProduccionVO>();		
		for(Capturaproduccion capturaProduccion : dao.getAllNotEndWithBy(Mapper.from(capturaProduccionVO))) {
			capturaProduccionsVO.add(Mapper.from(capturaProduccion));
		}		
		return capturaProduccionsVO;
	}
	
	public List<CapturaProduccionVO> getAllContainBy(CapturaProduccionVO capturaProduccionVO) throws ParseException, DAOException {
		List<CapturaProduccionVO> capturaProduccionsVO = new LinkedList<CapturaProduccionVO>();		
		for(Capturaproduccion capturaProduccion : dao.getAllContainBy(Mapper.from(capturaProduccionVO))) {
			capturaProduccionsVO.add(Mapper.from(capturaProduccion));
		}		
		return capturaProduccionsVO;
	}
	
	public List<CapturaProduccionVO> getAllNotContainBy(CapturaProduccionVO capturaProduccionVO) throws ParseException, DAOException {
		List<CapturaProduccionVO> capturaProduccionsVO = new LinkedList<CapturaProduccionVO>();		
		for(Capturaproduccion capturaProduccion : dao.getAllNotContainBy(Mapper.from(capturaProduccionVO))) {
			capturaProduccionsVO.add(Mapper.from(capturaProduccion));
		}		
		return capturaProduccionsVO;
	}
	
	public List<CapturaProduccionVO> getAllIsNullBy(CapturaProduccionVO capturaProduccionVO) throws ParseException, DAOException {
		List<CapturaProduccionVO> capturaProduccionsVO = new LinkedList<CapturaProduccionVO>();		
		for(Capturaproduccion capturaProduccion : dao.getAllIsNullBy(Mapper.from(capturaProduccionVO))) {
			capturaProduccionsVO.add(Mapper.from(capturaProduccion));
		}		
		return capturaProduccionsVO;
	}
	
	public List<CapturaProduccionVO> getAllNotIsNullBy(CapturaProduccionVO capturaProduccionVO) throws ParseException, DAOException {
		List<CapturaProduccionVO> capturaProduccionsVO = new LinkedList<CapturaProduccionVO>();		
		for(Capturaproduccion capturaProduccion : dao.getAllNotIsNullBy(Mapper.from(capturaProduccionVO))) {
			capturaProduccionsVO.add(Mapper.from(capturaProduccion));
		}		
		return capturaProduccionsVO;
	}
	
	public CapturaProduccionVO save(CapturaProduccionVO capturaProduccionVO ) throws BusinessException, DAOException, Exception {
		
		LOG.debug("CapturaProduccionService save");
		
		try {			
			/***get datos Funcionario***/
			String rutfuncionario = null;
			List<FuncionarioVO> funcionariosVO = new LinkedList<FuncionarioVO>();
			for(FuncionarioVO funcionarioVO : capturaProduccionVO.getFuncionarios()) {
				rutfuncionario = funcionarioVO.getRut();
				Funcionario funcionario = funcionarioDao.get(rutfuncionario);				
				funcionariosVO.add(Mapper.from(funcionario));
			}
			capturaProduccionVO.setFuncionarios(funcionariosVO);
			/***************************/
			
			/***Calcular Stock***/
			Stock stock = stockDao.get(capturaProduccionVO.getProducto().getCodigo());
			if(!(stock instanceof Stock)) {
				Producto producto = productoDao.get(capturaProduccionVO.getProducto().getCodigo());
				stock = new Stock(producto.getUnidadmedida(), producto);
				stockDao.save(stock);				
			}
			Float cantidad = UnidadMedidaHelper.conversion(
													stock.getUnidadmedida().getCodigo(),
													capturaProduccionVO.getUnidadMedida().getCodigo(), 
													capturaProduccionVO.getCantidadProduccion());
			
			float stockDisponible = stock.getStockdisponible() != null ? stock.getStockdisponible() : 0;
			stock.setStockdisponible(stockDisponible + cantidad);
			capturaProduccionVO.getProducto().setStock(Mapper.from(stock));
			/***************************/
			
			Capturaproduccion capturaproduccion = Mapper.from(capturaProduccionVO);
			
			dao.save(capturaproduccion);
			
			capturaProduccionVO = Mapper.from(capturaproduccion);
			
		} catch(DAOException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}
		
		return capturaProduccionVO;
	}
}