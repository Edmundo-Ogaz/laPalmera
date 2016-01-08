package cl.obam.pasteleria.lapalmera.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.CiudadDao;
import cl.obam.pasteleria.lapalmera.exception.BusinessException;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Ciudad;
import cl.obam.pasteleria.lapalmera.util.Mapper;
import cl.obam.pasteleria.lapalmera.view.CiudadVO;

@Service
public class CiudadService {
	
	@Autowired
	private CiudadDao dao;
	
	public Ciudad get(String codigo) throws DAOException {
		return dao.get(codigo);
	}
	
	public List<CiudadVO> getAll() throws DAOException {
		List<CiudadVO> ciudadsVO = new LinkedList<CiudadVO>();
		for(Ciudad ciudad : dao.getAll()) {
			ciudadsVO.add(Mapper.from(ciudad));
		}
		return ciudadsVO;
	}
	
	public CiudadVO save(CiudadVO ciudadVO) throws BusinessException, DAOException {
		if(!dao.save(Mapper.from(ciudadVO))) {
			throw new BusinessException("No se pudo grabar ciudad");
		}
		return ciudadVO;
	}
	
	public CiudadVO update(CiudadVO ciudadVO) throws BusinessException, DAOException {
		if(!dao.update(Mapper.from(ciudadVO))) {
			throw new BusinessException("No se pudo actualizar ciudad");
		}
		return ciudadVO;
	}
	
	public CiudadVO delete(CiudadVO ciudadVO) throws BusinessException, DAOException {
		if(!dao.delete(ciudadVO.getCodigo())) {
			throw new BusinessException("No se pudo eliminar ciudad");
		}
		return ciudadVO;
	}
	
	public List<Ciudad> getAllEqBy(Ciudad ciudad) throws DAOException {
		return dao.getAllEqBy(ciudad);
	}
	
	public List<Ciudad> getAllNotEqBy(Ciudad ciudad) throws DAOException {
		return dao.getAllNotEqBy(ciudad);
	}
	
	public List<Ciudad> getAllBeginWithBy(Ciudad ciudad) throws DAOException {
		return dao.getAllBeginWithBy(ciudad);
	}
	
	public List<Ciudad> getAllNotBeginWithBy(Ciudad ciudad) throws DAOException {
		return dao.getAllNotBeginWithBy(ciudad);
	}
	
	public List<Ciudad> getAllEndWithBy(Ciudad ciudad) throws DAOException {
		return dao.getAllEndWithBy(ciudad);
	}
	
	public List<Ciudad> getAllNotEndWithBy(Ciudad ciudad) throws DAOException {
		return dao.getAllNotEndWithBy(ciudad);
	}
	
	public List<Ciudad> getAllContainBy(Ciudad ciudad) throws DAOException {
		return dao.getAllContainBy(ciudad);
	}
	
	public List<Ciudad> getAllNotContainBy(Ciudad ciudad) throws DAOException {
		return dao.getAllNotContainBy(ciudad);
	}
	
	public List<Ciudad> getAllIsNullBy(Ciudad ciudad) throws DAOException {
		return dao.getAllIsNullBy(ciudad);
	}
	
	public List<Ciudad> getAllNotIsNullBy(Ciudad ciudad) throws DAOException {
		return dao.getAllNotIsNullBy(ciudad);
	}
}