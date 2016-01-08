package cl.obam.pasteleria.lapalmera.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.StockDao;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Stock;
import cl.obam.pasteleria.lapalmera.util.Mapper;
import cl.obam.pasteleria.lapalmera.view.StockVO;

@Service
public class StockService {
	
	@Autowired
	private StockDao dao;
	
	public Stock get(String codigo) throws DAOException {
		return dao.get(codigo);
	}
	
	public List<Stock> getAll() throws DAOException {
		return dao.getAll();
	}
	
	public boolean save(Stock obj) throws DAOException {
		return dao.save(obj);
	}
	
	public boolean update(Stock obj) throws DAOException {
		return dao.update(obj);
	}
	
	public boolean delete(String codigo) throws DAOException {
		return dao.delete(codigo);
	}
	
	public List<StockVO> getAllEqBy(StockVO stockVO) throws DAOException {
		List<StockVO> stocksVO = new LinkedList<StockVO>();
		for(Stock stock : dao.getAllEqBy(Mapper.from(stockVO))) {
			stocksVO.add(Mapper.from(stock));
		}
		return stocksVO;
	}
	
	public List<Stock> getAllNotEqBy(Stock stock) throws DAOException {
		return dao.getAllNotEqBy(stock);
	}
	
	public List<Stock> getAllBeginWithBy(Stock stock) throws DAOException {
		return dao.getAllBeginWithBy(stock);
	}
	
	public List<Stock> getAllNotBeginWithBy(Stock stock) throws DAOException {
		return dao.getAllNotBeginWithBy(stock);
	}
	
	public List<Stock> getAllEndWithBy(Stock stock) throws DAOException {
		return dao.getAllEndWithBy(stock);
	}
	
	public List<Stock> getAllNotEndWithBy(Stock stock) throws DAOException {
		return dao.getAllNotEndWithBy(stock);
	}
	
	public List<Stock> getAllContainBy(Stock stock) throws DAOException {
		return dao.getAllContainBy(stock);
	}
	
	public List<Stock> getAllNotContainBy(Stock stock) throws DAOException {
		return dao.getAllNotContainBy(stock);
	}
	
	public List<Stock> getAllIsNullBy(Stock stock) throws DAOException {
		return dao.getAllIsNullBy(stock);
	}
	
	public List<Stock> getAllNotIsNullBy(Stock stock) throws DAOException {
		return dao.getAllNotIsNullBy(stock);
	}
}