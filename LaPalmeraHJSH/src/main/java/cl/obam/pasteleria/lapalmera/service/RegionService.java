package cl.obam.pasteleria.lapalmera.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.RegionDao;
import cl.obam.pasteleria.lapalmera.exception.BusinessException;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Region;
import cl.obam.pasteleria.lapalmera.util.Mapper;
import cl.obam.pasteleria.lapalmera.view.RegionVO;

@Service
public class RegionService {
	
	@Autowired
	private RegionDao dao;
	
	public Region get(String codigo) throws DAOException {
		return dao.get(codigo);
	}
	
	public List<RegionVO> getAll() throws DAOException {
		List<RegionVO> regionsVO = new LinkedList<RegionVO>();
		for(Region region : dao.getAll()) {
			regionsVO.add(Mapper.from(region));
		}
		return regionsVO;
	}
	
	public RegionVO save(RegionVO oregionVO) throws BusinessException, DAOException {
		Region region = Mapper.from(oregionVO);
		if(!dao.save(region)) {
			throw new BusinessException("No se grabar región");
		}
		return Mapper.from(region);
	}
	
	public RegionVO update(RegionVO regionVO) throws BusinessException, DAOException {		
		if(!dao.update(Mapper.from(regionVO))) {
			throw new BusinessException("No se actualizo región");
		}
		return regionVO;
	}
	
	public RegionVO delete(RegionVO regionVO) throws BusinessException, DAOException {
		if(!dao.delete(regionVO.getCodigo())) {
			throw new BusinessException("No se eliminar región");
		}
		return regionVO;
	}
	
	public List<Region> getAllEqBy(Region region) throws DAOException {
		return dao.getAllEqBy(region);
	}
	
	public List<Region> getAllNotEqBy(Region region) throws DAOException {
		return dao.getAllNotEqBy(region);
	}
	
	public List<Region> getAllBeginWithBy(Region region) throws DAOException {
		return dao.getAllBeginWithBy(region);
	}
	
	public List<Region> getAllNotBeginWithBy(Region region) throws DAOException {
		return dao.getAllNotBeginWithBy(region);
	}
	
	public List<Region> getAllEndWithBy(Region region) throws DAOException {
		return dao.getAllEndWithBy(region);
	}
	
	public List<Region> getAllNotEndWithBy(Region region) throws DAOException {
		return dao.getAllNotEndWithBy(region);
	}
	
	public List<Region> getAllContainBy(Region region) throws DAOException {
		return dao.getAllContainBy(region);
	}
	
	public List<Region> getAllNotContainBy(Region region) throws DAOException {
		return dao.getAllNotContainBy(region);
	}
	
	public List<Region> getAllIsNullBy(Region region) throws DAOException {
		return dao.getAllIsNullBy(region);
	}
	
	public List<Region> getAllNotIsNullBy(Region region) throws DAOException {
		return dao.getAllNotIsNullBy(region);
	}
}