package cl.obam.pasteleria.lapalmera.service;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.UbicacionDao;
import cl.obam.pasteleria.lapalmera.exception.BusinessException;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Ubicacion;
import cl.obam.pasteleria.lapalmera.util.Mapper;
import cl.obam.pasteleria.lapalmera.view.UbicacionVO;

@Service
public class UbicacionService {
	
	@Autowired
	private UbicacionDao dao;
	
	public Ubicacion get(int id) throws DAOException {
		return dao.get(id);
	}
	
	public List<Ubicacion> getAll() throws DAOException {
		return dao.getAll();
	}
	
	public UbicacionVO save(UbicacionVO ubicacionVO) throws ParseException, DAOException {
		Ubicacion ubicacion = Mapper.from(ubicacionVO);
		dao.save(ubicacion);
		return Mapper.from(ubicacion);
	}
	
	public UbicacionVO update(UbicacionVO ubicacionVO) throws BusinessException, ParseException, DAOException {
		if(!dao.update(Mapper.from(ubicacionVO))) {
			throw new BusinessException("No pudo actualizar ubicación");
		}
		return ubicacionVO;
	}
	
	public UbicacionVO delete(UbicacionVO ubicacionVO) throws BusinessException, DAOException {
		if(!dao.delete(ubicacionVO.getId())) {
			throw new BusinessException("No pudo eliminar ubicación");
		}
		return ubicacionVO;
	}
	
	public List<UbicacionVO> getAllEqBy(UbicacionVO ubicacionVO) throws ParseException, DAOException {
		List<UbicacionVO> ubicacionsVO = new LinkedList<UbicacionVO>();
		for(Ubicacion ubicacion : dao.getAllEqBy(Mapper.from(ubicacionVO))) {
			ubicacionsVO.add(Mapper.from(ubicacion));
		}
		return ubicacionsVO;
	}
	
	public List<Ubicacion> getAllNotEqBy(Ubicacion ubicacion) throws DAOException {
		return dao.getAllNotEqBy(ubicacion);
	}
	
	public List<Ubicacion> getAllBeginWithBy(Ubicacion ubicacion) throws DAOException {
		return dao.getAllBeginWithBy(ubicacion);
	}
	
	public List<Ubicacion> getAllNotBeginWithBy(Ubicacion ubicacion) throws DAOException {
		return dao.getAllNotBeginWithBy(ubicacion);
	}
	
	public List<Ubicacion> getAllEndWithBy(Ubicacion ubicacion) throws DAOException {
		return dao.getAllEndWithBy(ubicacion);
	}
	
	public List<Ubicacion> getAllNotEndWithBy(Ubicacion ubicacion) throws DAOException {
		return dao.getAllNotEndWithBy(ubicacion);
	}
	
	public List<Ubicacion> getAllContainBy(Ubicacion ubicacion) throws DAOException {
		return dao.getAllContainBy(ubicacion);
	}
	
	public List<Ubicacion> getAllNotContainBy(Ubicacion ubicacion) throws DAOException {
		return dao.getAllNotContainBy(ubicacion);
	}
	
	public List<Ubicacion> getAllIsNullBy(Ubicacion ubicacion) throws DAOException {
		return dao.getAllIsNullBy(ubicacion);
	}
	
	public List<Ubicacion> getAllNotIsNullBy(Ubicacion ubicacion) throws DAOException {
		return dao.getAllNotIsNullBy(ubicacion);
	}
}