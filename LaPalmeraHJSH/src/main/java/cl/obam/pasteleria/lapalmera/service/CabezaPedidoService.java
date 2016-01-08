package cl.obam.pasteleria.lapalmera.service;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.CabezaPedidoDao;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Pedido;
import cl.obam.pasteleria.lapalmera.util.Mapper;
import cl.obam.pasteleria.lapalmera.view.CabezaPedidoVO;

@Service
public class CabezaPedidoService {
	
	@Autowired
	private CabezaPedidoDao dao;
	
	public CabezaPedidoVO get(String codigo) throws DAOException {	
		return Mapper.from(dao.get(codigo));
	}
				
				
	public List<CabezaPedidoVO> getAll() throws DAOException {
		List<CabezaPedidoVO> pedidosVO = new LinkedList<CabezaPedidoVO>();
		for(Pedido pedido : dao.getAll()) {
			pedidosVO.add(Mapper.from(pedido)); 
		}
		return pedidosVO;
	}
	
	public boolean save(Pedido obj) throws DAOException {
		return dao.save(obj);
	}
	
	public boolean update(Pedido obj) throws DAOException {
		return dao.update(obj);
	}
	
	public boolean delete(String codigo) throws DAOException {
		return dao.delete(codigo);
	}
	
//	public List<CabezaPedidoVO> getAllEqBy(CabezaPedidoVO cabezaPedido) throws DAOException, ParseException {
//		List<CabezaPedidoVO> pedidosVO = new LinkedList<CabezaPedidoVO>();
//		for(Pedido pedido : dao.getAllEqBy(Mapper.from(cabezaPedido))) {
//			pedidosVO.add(Mapper.from(pedido)); 
//		}
//		return pedidosVO;
//	}
	
	public List<CabezaPedidoVO> getAllEqBy(CabezaPedidoVO cabezaPedido) throws DAOException, ParseException {
		return dao.getAllEqBy(cabezaPedido);
	}
	
	public List<Pedido> getAllNotEqBy(Pedido cabezaPedido) throws DAOException {
		return dao.getAllNotEqBy(cabezaPedido);
	}
	
	public List<Pedido> getAllBeginWithBy(Pedido cabezaPedido) throws DAOException {
		return dao.getAllBeginWithBy(cabezaPedido);
	}
	
	public List<Pedido> getAllNotBeginWithBy(Pedido cabezaPedido) throws DAOException {
		return dao.getAllNotBeginWithBy(cabezaPedido);
	}
	
	public List<Pedido> getAllEndWithBy(Pedido cabezaPedido) throws DAOException {
		return dao.getAllEndWithBy(cabezaPedido);
	}
	
	public List<Pedido> getAllNotEndWithBy(Pedido cabezaPedido) throws DAOException {
		return dao.getAllNotEndWithBy(cabezaPedido);
	}
	
	public List<Pedido> getAllContainBy(Pedido cabezaPedido) throws DAOException {
		return dao.getAllContainBy(cabezaPedido);
	}
	
	public List<Pedido> getAllNotContainBy(Pedido cabezaPedido) throws DAOException {
		return dao.getAllNotContainBy(cabezaPedido);
	}
	
	public List<Pedido> getAllIsNullBy(Pedido cabezaPedido) throws DAOException {
		return dao.getAllIsNullBy(cabezaPedido);
	}
	
	public List<Pedido> getAllNotIsNullBy(Pedido cabezaPedido) throws DAOException {
		return dao.getAllNotIsNullBy(cabezaPedido);
	}
}