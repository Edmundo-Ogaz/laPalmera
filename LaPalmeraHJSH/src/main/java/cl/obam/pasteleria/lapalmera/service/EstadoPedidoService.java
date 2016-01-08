package cl.obam.pasteleria.lapalmera.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.EstadoPedidoDao;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Estadopedido;
import cl.obam.pasteleria.lapalmera.util.Mapper;
import cl.obam.pasteleria.lapalmera.view.EstadoPedidoVO;

@Service
public class EstadoPedidoService {
	
	@Autowired
	private EstadoPedidoDao dao;
	
	public List<EstadoPedidoVO> getAll() throws DAOException {		
		List<EstadoPedidoVO> list = new LinkedList<EstadoPedidoVO>();
		for (Estadopedido estadoPedido : dao.getAll()) {
			list.add(Mapper.from(estadoPedido));
		}
		return list;
	}

}