package cl.obam.pasteleria.lapalmera.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.FuncionarioDao;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Funcionario;
import cl.obam.pasteleria.lapalmera.model.Producto;
import cl.obam.pasteleria.lapalmera.util.Mapper;
import cl.obam.pasteleria.lapalmera.view.FuncionarioVO;
import cl.obam.pasteleria.lapalmera.view.ProductoVO;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioDao dao;
	
	public Funcionario get(String codigo) throws DAOException {
		return dao.get(codigo);
	}
	
	public List<FuncionarioVO> getAll() throws DAOException {
		
		List<FuncionarioVO> list = new LinkedList<FuncionarioVO>();
		for (Funcionario funcionario : dao.getAll()) {
			list.add(Mapper.from(funcionario));
		}
		return list;
	}
	
	public boolean save(Funcionario obj) throws DAOException {
		return dao.save(obj);
	}
	
	public boolean update(Funcionario obj) throws DAOException {
		return dao.update(obj);
	}
	
	public boolean delete(String codigo) throws DAOException {
		return dao.delete(codigo);
	}
	
	public List<Funcionario> getAllEqBy(Funcionario funcionario) throws DAOException {
		return dao.getAllEqBy(funcionario);
	}
	
	public List<Funcionario> getAllNotEqBy(Funcionario funcionario) throws DAOException {
		return dao.getAllNotEqBy(funcionario);
	}
	
	public List<Funcionario> getAllBeginWithBy(Funcionario funcionario) throws DAOException {
		return dao.getAllBeginWithBy(funcionario);
	}
	
	public List<Funcionario> getAllNotBeginWithBy(Funcionario funcionario) throws DAOException {
		return dao.getAllNotBeginWithBy(funcionario);
	}
	
	public List<Funcionario> getAllEndWithBy(Funcionario funcionario) throws DAOException {
		return dao.getAllEndWithBy(funcionario);
	}
	
	public List<Funcionario> getAllNotEndWithBy(Funcionario funcionario) throws DAOException {
		return dao.getAllNotEndWithBy(funcionario);
	}
	
	public List<Funcionario> getAllContainBy(Funcionario funcionario) throws DAOException {
		return dao.getAllContainBy(funcionario);
	}
	
	public List<Funcionario> getAllNotContainBy(Funcionario funcionario) throws DAOException {
		return dao.getAllNotContainBy(funcionario);
	}
	
	public List<Funcionario> getAllIsNullBy(Funcionario funcionario) throws DAOException {
		return dao.getAllIsNullBy(funcionario);
	}
	
	public List<Funcionario> getAllNotIsNullBy(Funcionario funcionario) throws DAOException {
		return dao.getAllNotIsNullBy(funcionario);
	}
}