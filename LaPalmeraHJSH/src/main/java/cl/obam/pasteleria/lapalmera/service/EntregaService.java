package cl.obam.pasteleria.lapalmera.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.EntregaDao;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Entrega;
import cl.obam.pasteleria.lapalmera.util.Mapper;
import cl.obam.pasteleria.lapalmera.view.EntregaVO;

@Service
public class EntregaService {
	
	@Autowired
	private EntregaDao dao;
	
	public List<EntregaVO> getAll() throws DAOException {
		List<EntregaVO> entregasVO = new LinkedList<EntregaVO>();
		for(Entrega comuna : dao.getAll()) {
			entregasVO.add(Mapper.from(comuna));
		}
		return entregasVO;
	}
}