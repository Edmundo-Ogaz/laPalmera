package cl.obam.pasteleria.lapalmera.service;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.IngredienteDao;
import cl.obam.pasteleria.lapalmera.exception.BusinessException;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Ingrediente;
import cl.obam.pasteleria.lapalmera.util.Mapper;
import cl.obam.pasteleria.lapalmera.view.IngredienteVO;

@Service
public class IngredienteService {
	
	@Autowired
	private IngredienteDao dao;
	
	public Ingrediente get(String codigo) throws DAOException {
		return dao.get(codigo);
	}
	
	public List<Ingrediente> getAll() throws DAOException {
		return dao.getAll();
	}
	
	public IngredienteVO save(IngredienteVO ingredienteVO) throws BusinessException, ParseException, DAOException {

		if(existIngrediente(ingredienteVO))
			throw new BusinessException("Ingrediente existe");
		
		Ingrediente ingrediente = Mapper.from(ingredienteVO); 
		dao.save(ingrediente);
		return Mapper.from(ingrediente);
	}
	
	public IngredienteVO update(IngredienteVO ingredienteVO) throws BusinessException, ParseException, DAOException {
		
		if(existIngrediente(ingredienteVO))
			throw new BusinessException("Ingrediente existe");
		
		dao.update(Mapper.from(ingredienteVO));
		return ingredienteVO;
	}
	
	public IngredienteVO delete(IngredienteVO ingredienteVO) throws BusinessException, ParseException, DAOException {
		boolean resp = dao.delete(ingredienteVO.getId());
		if(!resp) {
			throw new BusinessException("No se pudo eliminar ingredinete");
		}
		return ingredienteVO;
	}
	
	public List<Ingrediente> getAllEqBy(Ingrediente ingrediente) throws DAOException {
		return dao.getAllEqBy(ingrediente);
	}
	
	public List<IngredienteVO> getAllEqBy(IngredienteVO ingredienteVO) throws ParseException, DAOException {
		
		List<IngredienteVO> list = new LinkedList<IngredienteVO>();
		for (Ingrediente obj : dao.getAllEqBy(Mapper.from(ingredienteVO))) {
			list.add(Mapper.from(obj));
		}
		
		return list;
	}
	
	public List<Ingrediente> getAllNotEqBy(Ingrediente ingrediente) throws DAOException {
		return dao.getAllNotEqBy(ingrediente);
	}
	
	public List<Ingrediente> getAllBeginWithBy(Ingrediente ingrediente) throws DAOException {
		return dao.getAllBeginWithBy(ingrediente);
	}
	
	public List<Ingrediente> getAllNotBeginWithBy(Ingrediente ingrediente) throws DAOException {
		return dao.getAllNotBeginWithBy(ingrediente);
	}
	
	public List<Ingrediente> getAllEndWithBy(Ingrediente ingrediente) throws DAOException {
		return dao.getAllEndWithBy(ingrediente);
	}
	
	public List<Ingrediente> getAllNotEndWithBy(Ingrediente ingrediente) throws DAOException {
		return dao.getAllNotEndWithBy(ingrediente);
	}
	
	public List<Ingrediente> getAllContainBy(Ingrediente ingrediente) throws DAOException {
		return dao.getAllContainBy(ingrediente);
	}
	
	public List<Ingrediente> getAllNotContainBy(Ingrediente ingrediente) throws DAOException {
		return dao.getAllNotContainBy(ingrediente);
	}
	
	public List<Ingrediente> getAllIsNullBy(Ingrediente ingrediente) throws DAOException {
		return dao.getAllIsNullBy(ingrediente);
	}
	
	public List<Ingrediente> getAllNotIsNullBy(Ingrediente ingrediente) throws DAOException {
		return dao.getAllNotIsNullBy(ingrediente);
	}
	
	private boolean existIngrediente(IngredienteVO ingredienteVO) throws ParseException, DAOException {
		boolean resp = false;
		
		Ingrediente exist = new Ingrediente();
		exist.setProductoByCodigoproducto(Mapper.from(ingredienteVO.getProducto())); 
		exist.setProductoByCodigoinsumo(Mapper.from(ingredienteVO.getInsumo())); 
		exist.setCarga(ingredienteVO.getCarga());
		List<Ingrediente> ingredientes = dao.getAllEqBy(exist);
		if(ingredientes instanceof List && !ingredientes.isEmpty()) {
			for(Ingrediente obj : ingredientes) {
				if(!obj.getId().equals(ingredienteVO.getId())) {
					resp = true;
					break;
				}
			}
		}
		
		return resp;	
	}
}