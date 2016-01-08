package cl.obam.pasteleria.lapalmera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.EstadoOrdenFabricacionDao;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.view.EstadoOrdenFabricacionVO;

@Service
public class EstadoOrdenFabricacionService {
	
	@Autowired
	private EstadoOrdenFabricacionDao dao;
	
	public List<EstadoOrdenFabricacionVO> getAll() throws DAOException {
		return dao.getAll();
	}

}