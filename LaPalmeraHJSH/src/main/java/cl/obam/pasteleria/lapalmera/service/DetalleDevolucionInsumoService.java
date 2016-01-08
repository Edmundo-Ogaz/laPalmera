package cl.obam.pasteleria.lapalmera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.DetalleDevolucionInsumoDao;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Detalledevolucioninsumo;

@Service
public class DetalleDevolucionInsumoService {
	
	@Autowired
	private DetalleDevolucionInsumoDao dao;
	
	public Detalledevolucioninsumo get(String codigo) throws DAOException {
		return dao.get(codigo);
	}
	
	public List<Detalledevolucioninsumo> getAll() throws DAOException {
		return dao.getAll();
	}
	
	public boolean save(Detalledevolucioninsumo obj) throws DAOException {
		return dao.save(obj);
	}
	
	public boolean update(Detalledevolucioninsumo obj) throws DAOException {
		return dao.update(obj);
	}
	
	public boolean delete(String codigo) throws DAOException {
		return dao.delete(codigo);
	}
	
	public List<Detalledevolucioninsumo> getAllEqBy(Detalledevolucioninsumo detalleDevolucionInsumo) throws DAOException {
		return dao.getAllEqBy(detalleDevolucionInsumo);
	}
	
	public List<Detalledevolucioninsumo> getAllNotEqBy(Detalledevolucioninsumo detalleDevolucionInsumo) throws DAOException {
		return dao.getAllNotEqBy(detalleDevolucionInsumo);
	}
	
	public List<Detalledevolucioninsumo> getAllBeginWithBy(Detalledevolucioninsumo detalleDevolucionInsumo) throws DAOException {
		return dao.getAllBeginWithBy(detalleDevolucionInsumo);
	}
	
	public List<Detalledevolucioninsumo> getAllNotBeginWithBy(Detalledevolucioninsumo detalleDevolucionInsumo) throws DAOException {
		return dao.getAllNotBeginWithBy(detalleDevolucionInsumo);
	}
	
	public List<Detalledevolucioninsumo> getAllEndWithBy(Detalledevolucioninsumo detalleDevolucionInsumo) throws DAOException {
		return dao.getAllEndWithBy(detalleDevolucionInsumo);
	}
	
	public List<Detalledevolucioninsumo> getAllNotEndWithBy(Detalledevolucioninsumo detalleDevolucionInsumo) throws DAOException {
		return dao.getAllNotEndWithBy(detalleDevolucionInsumo);
	}
	
	public List<Detalledevolucioninsumo> getAllContainBy(Detalledevolucioninsumo detalleDevolucionInsumo) throws DAOException {
		return dao.getAllContainBy(detalleDevolucionInsumo);
	}
	
	public List<Detalledevolucioninsumo> getAllNotContainBy(Detalledevolucioninsumo detalleDevolucionInsumo) throws DAOException {
		return dao.getAllNotContainBy(detalleDevolucionInsumo);
	}
	
	public List<Detalledevolucioninsumo> getAllIsNullBy(Detalledevolucioninsumo detalleDevolucionInsumo) throws DAOException {
		return dao.getAllIsNullBy(detalleDevolucionInsumo);
	}
	
	public List<Detalledevolucioninsumo> getAllNotIsNullBy(Detalledevolucioninsumo detalleDevolucionInsumo) throws DAOException {
		return dao.getAllNotIsNullBy(detalleDevolucionInsumo);
	}
}