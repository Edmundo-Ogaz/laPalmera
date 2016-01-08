package cl.obam.pasteleria.lapalmera.service;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.OrdenFabricacionDao;
import cl.obam.pasteleria.lapalmera.exception.BusinessException;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Ordenfabricacion;
import cl.obam.pasteleria.lapalmera.model.Pedido;
import cl.obam.pasteleria.lapalmera.model.Producto;
import cl.obam.pasteleria.lapalmera.model.Productolinea;
import cl.obam.pasteleria.lapalmera.util.Mapper;
import cl.obam.pasteleria.lapalmera.view.CabezaPedidoVO;
import cl.obam.pasteleria.lapalmera.view.OrdenFabricacionVO;

@Service
public class OrdenFabricacionService {
	
	private static final Logger LOG = Logger.getLogger(OrdenFabricacionService.class);
	
	@Autowired
	private OrdenFabricacionDao dao;
	
	public OrdenFabricacionVO get(String codigo) throws DAOException {
		OrdenFabricacionVO ordenFabricacionVO = null;
		Ordenfabricacion ordenFabricacion = dao.get(codigo);
		if(ordenFabricacion instanceof Ordenfabricacion) {
			ordenFabricacionVO = Mapper.from(ordenFabricacion);
		}
		
		return ordenFabricacionVO;
	}
	
	public List<Ordenfabricacion> getAll() throws DAOException {
		return dao.getAll();
	}
	
	public boolean create(Ordenfabricacion obj) throws DAOException {
		return dao.create(obj);
	}
	
	public boolean update(Ordenfabricacion obj) throws DAOException {
		return dao.update(obj);
	}
	
	public boolean delete(String codigo) throws DAOException {
		return dao.delete(codigo);
	}
	
	public List<OrdenFabricacionVO> getAllEqBy(OrdenFabricacionVO ordenFabricacionVO) throws ParseException, DAOException {
		
		return dao.getAllEqBy(ordenFabricacionVO);
	}
	
	public List<Ordenfabricacion> getAllNotEqBy(Ordenfabricacion ordenFabricacion) throws DAOException {
		return dao.getAllNotEqBy(ordenFabricacion);
	}
	
	public List<Ordenfabricacion> getAllBeginWithBy(Ordenfabricacion ordenFabricacion) throws DAOException {
		return dao.getAllBeginWithBy(ordenFabricacion);
	}
	
	public List<Ordenfabricacion> getAllNotBeginWithBy(Ordenfabricacion ordenFabricacion) throws DAOException {
		return dao.getAllNotBeginWithBy(ordenFabricacion);
	}
	
	public List<Ordenfabricacion> getAllEndWithBy(Ordenfabricacion ordenFabricacion) throws DAOException {
		return dao.getAllEndWithBy(ordenFabricacion);
	}
	
	public List<Ordenfabricacion> getAllNotEndWithBy(Ordenfabricacion ordenFabricacion) throws DAOException {
		return dao.getAllNotEndWithBy(ordenFabricacion);
	}
	
	public List<Ordenfabricacion> getAllContainBy(Ordenfabricacion ordenFabricacion) throws DAOException {
		return dao.getAllContainBy(ordenFabricacion);
	}
	
	public List<Ordenfabricacion> getAllNotContainBy(Ordenfabricacion ordenFabricacion) throws DAOException {
		return dao.getAllNotContainBy(ordenFabricacion);
	}
	
	public List<Ordenfabricacion> getAllIsNullBy(Ordenfabricacion ordenFabricacion) throws DAOException {
		return dao.getAllIsNullBy(ordenFabricacion);
	}
	
	public List<Ordenfabricacion> getAllNotIsNullBy(Ordenfabricacion ordenFabricacion) throws DAOException {
		return dao.getAllNotIsNullBy(ordenFabricacion);
	}
	
	public OrdenFabricacionVO save(OrdenFabricacionVO ordenFabricacionVO ) throws BusinessException, DAOException, Exception, Throwable {
		
		LOG.debug("OrdenFabricacionService save");
		
		try {			
						
			Ordenfabricacion ordenFabricacion = Mapper.from(ordenFabricacionVO);
			
			dao.save(ordenFabricacion);
			
			ordenFabricacionVO = Mapper.from(ordenFabricacion);
			
		} catch(DAOException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		} catch(Throwable t) {
			throw t;
		}
		
		return ordenFabricacionVO;
	}
}