package cl.obam.pasteleria.lapalmera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.DetalleEntregaInsumoDao;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Detalleentregainsumo;

@Service
public class DetalleEntregaInsumoService {
	
	@Autowired
	private DetalleEntregaInsumoDao dao;
	
	public Detalleentregainsumo get(String codigo) throws DAOException {
		return dao.get(codigo);
	}
	
	public List<Detalleentregainsumo> getAll() throws DAOException {
		return dao.getAll();
	}
	
	public boolean save(Detalleentregainsumo obj) throws DAOException {
		return dao.save(obj);
	}
	
	public boolean update(Detalleentregainsumo obj) throws DAOException {
		return dao.update(obj);
	}
	
	public boolean delete(String codigo) throws DAOException {
		return dao.delete(codigo);
	}
	
	public List<Detalleentregainsumo> getAllEqBy(Detalleentregainsumo detalleEntregaInsumo) throws DAOException {
		return dao.getAllEqBy(detalleEntregaInsumo);
	}
	
	public List<Detalleentregainsumo> getAllNotEqBy(Detalleentregainsumo detalleEntregaInsumo) throws DAOException {
		return dao.getAllNotEqBy(detalleEntregaInsumo);
	}
	
	public List<Detalleentregainsumo> getAllBeginWithBy(Detalleentregainsumo detalleEntregaInsumo) throws DAOException {
		return dao.getAllBeginWithBy(detalleEntregaInsumo);
	}
	
	public List<Detalleentregainsumo> getAllNotBeginWithBy(Detalleentregainsumo detalleEntregaInsumo) throws DAOException {
		return dao.getAllNotBeginWithBy(detalleEntregaInsumo);
	}
	
	public List<Detalleentregainsumo> getAllEndWithBy(Detalleentregainsumo detalleEntregaInsumo) throws DAOException {
		return dao.getAllEndWithBy(detalleEntregaInsumo);
	}
	
	public List<Detalleentregainsumo> getAllNotEndWithBy(Detalleentregainsumo detalleEntregaInsumo) throws DAOException {
		return dao.getAllNotEndWithBy(detalleEntregaInsumo);
	}
	
	public List<Detalleentregainsumo> getAllContainBy(Detalleentregainsumo detalleEntregaInsumo) throws DAOException {
		return dao.getAllContainBy(detalleEntregaInsumo);
	}
	
	public List<Detalleentregainsumo> getAllNotContainBy(Detalleentregainsumo detalleEntregaInsumo) throws DAOException {
		return dao.getAllNotContainBy(detalleEntregaInsumo);
	}
	
	public List<Detalleentregainsumo> getAllIsNullBy(Detalleentregainsumo detalleEntregaInsumo) throws DAOException {
		return dao.getAllIsNullBy(detalleEntregaInsumo);
	}
	
	public List<Detalleentregainsumo> getAllNotIsNullBy(Detalleentregainsumo detalleEntregaInsumo) throws DAOException {
		return dao.getAllNotIsNullBy(detalleEntregaInsumo);
	}
}