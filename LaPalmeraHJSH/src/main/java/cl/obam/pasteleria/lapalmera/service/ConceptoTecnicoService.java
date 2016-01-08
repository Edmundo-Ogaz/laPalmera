package cl.obam.pasteleria.lapalmera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.ConceptoTecnicoDao;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Conceptotecnico;

@Service
public class ConceptoTecnicoService {
	
	@Autowired
	private ConceptoTecnicoDao dao;
	
	public Conceptotecnico get(String codigo) throws DAOException {
		return dao.get(codigo);
	}
	
	public List<Conceptotecnico> getAll() throws DAOException {
		return dao.getAll();
	}
	
	public boolean save(Conceptotecnico obj) throws DAOException {
		return dao.save(obj);
	}
	
	public boolean update(Conceptotecnico obj) throws DAOException {
		return dao.update(obj);
	}
	
	public boolean delete(String codigo) throws DAOException {
		return dao.delete(codigo);
	}
	
	public List<Conceptotecnico> getAllEqBy(Conceptotecnico conceptoTecnico) throws DAOException {
		return dao.getAllEqBy(conceptoTecnico);
	}
	
	public List<Conceptotecnico> getAllNotEqBy(Conceptotecnico conceptoTecnico) throws DAOException {
		return dao.getAllNotEqBy(conceptoTecnico);
	}
	
	public List<Conceptotecnico> getAllBeginWithBy(Conceptotecnico conceptoTecnico) throws DAOException {
		return dao.getAllBeginWithBy(conceptoTecnico);
	}
	
	public List<Conceptotecnico> getAllNotBeginWithBy(Conceptotecnico conceptoTecnico) throws DAOException {
		return dao.getAllNotBeginWithBy(conceptoTecnico);
	}
	
	public List<Conceptotecnico> getAllEndWithBy(Conceptotecnico conceptoTecnico) throws DAOException {
		return dao.getAllEndWithBy(conceptoTecnico);
	}
	
	public List<Conceptotecnico> getAllNotEndWithBy(Conceptotecnico conceptoTecnico) throws DAOException {
		return dao.getAllNotEndWithBy(conceptoTecnico);
	}
	
	public List<Conceptotecnico> getAllContainBy(Conceptotecnico conceptoTecnico) throws DAOException {
		return dao.getAllContainBy(conceptoTecnico);
	}
	
	public List<Conceptotecnico> getAllNotContainBy(Conceptotecnico conceptoTecnico) throws DAOException {
		return dao.getAllNotContainBy(conceptoTecnico);
	}
	
	public List<Conceptotecnico> getAllIsNullBy(Conceptotecnico conceptoTecnico) throws DAOException {
		return dao.getAllIsNullBy(conceptoTecnico);
	}
	
	public List<Conceptotecnico> getAllNotIsNullBy(Conceptotecnico conceptoTecnico) throws DAOException {
		return dao.getAllNotIsNullBy(conceptoTecnico);
	}
}