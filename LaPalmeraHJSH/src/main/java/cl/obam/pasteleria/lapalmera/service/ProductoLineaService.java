package cl.obam.pasteleria.lapalmera.service;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.obam.pasteleria.lapalmera.dao.ProductoLineaDao;
import cl.obam.pasteleria.lapalmera.exception.BusinessException;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Productolinea;
import cl.obam.pasteleria.lapalmera.util.Mapper;
import cl.obam.pasteleria.lapalmera.view.ProductoLineaVO;

@Service
public class ProductoLineaService {
	
	@Autowired
	private ProductoLineaDao dao;
	
	public Productolinea get(String codigo) throws DAOException {
		return dao.get(codigo);
	}
	
	public List<Productolinea> getAll() throws DAOException {
		return dao.getAll();
	}
	
	public Productolinea save(ProductoLineaVO productoLineaVO) throws BusinessException, ParseException, DAOException {

		if(existProductoLinea(productoLineaVO))
			throw new BusinessException("Linea Producción existe");
		
		if(existPrioridad(productoLineaVO))
			throw new BusinessException("Prioridad existe");
		
		Productolinea productoLinea = Mapper.from(productoLineaVO);
		dao.save(productoLinea);
		return productoLinea;
	}
	
	public Productolinea update(ProductoLineaVO productoLineaVO) throws BusinessException, ParseException, DAOException {
		
		if(existProductoLinea(productoLineaVO))
			throw new BusinessException("Linea Producción existe");
		
		if(existPrioridad(productoLineaVO))
			throw new BusinessException("Prioridad existe");
		
		
		Productolinea productoLinea = Mapper.from(productoLineaVO);
		dao.update(productoLinea);
		return productoLinea;
	}
	
	public ProductoLineaVO delete(ProductoLineaVO obj) throws BusinessException, DAOException {
		boolean resp = dao.delete(obj.getId());
		if(!resp) {
			throw new BusinessException("No se pudo eliminar Producto Linea");
		}
		return obj;
	}
	
	public List<ProductoLineaVO> getAllEqBy(ProductoLineaVO productoLineaVO) throws ParseException, DAOException {
		List<ProductoLineaVO> productoLineasVO = new LinkedList<ProductoLineaVO>();
		for (Productolinea productoLinea : dao.getAllEqBy(Mapper.from(productoLineaVO))) {
			productoLineasVO.add(Mapper.from(productoLinea));
		}
		return productoLineasVO;
	}
	
	public List<Productolinea> getAllNotEqBy(Productolinea productoLinea) throws DAOException {
		return dao.getAllNotEqBy(productoLinea);
	}
	
	public List<Productolinea> getAllBeginWithBy(Productolinea productoLinea) throws DAOException {
		return dao.getAllBeginWithBy(productoLinea);
	}
	
	public List<Productolinea> getAllNotBeginWithBy(Productolinea productoLinea) throws DAOException {
		return dao.getAllNotBeginWithBy(productoLinea);
	}
	
	public List<Productolinea> getAllEndWithBy(Productolinea productoLinea) throws DAOException {
		return dao.getAllEndWithBy(productoLinea);
	}
	
	public List<Productolinea> getAllNotEndWithBy(Productolinea productoLinea) throws DAOException {
		return dao.getAllNotEndWithBy(productoLinea);
	}
	
	public List<Productolinea> getAllContainBy(Productolinea productoLinea) throws DAOException {
		return dao.getAllContainBy(productoLinea);
	}
	
	public List<Productolinea> getAllNotContainBy(Productolinea productoLinea) throws DAOException {
		return dao.getAllNotContainBy(productoLinea);
	}
	
	public List<Productolinea> getAllIsNullBy(Productolinea productoLinea) throws DAOException {
		return dao.getAllIsNullBy(productoLinea);
	}
	
	public List<Productolinea> getAllNotIsNullBy(Productolinea productoLinea) throws DAOException {
		return dao.getAllNotIsNullBy(productoLinea);
	}
	
	private boolean existProductoLinea(ProductoLineaVO lineaProduccionVO) throws ParseException, DAOException {
		boolean resp = false;
		
		Productolinea exist = new Productolinea();
		exist.setProducto(Mapper.from(lineaProduccionVO.getProducto())); 
		exist.setLineaproduccion(Mapper.from(lineaProduccionVO.getLineaProduccion()));
		List<Productolinea> productoLineas = dao.getAllEqBy(exist);
		if(productoLineas instanceof List && !productoLineas.isEmpty()) {
			for(Productolinea obj : productoLineas) {
				if(!obj.getId().equals(lineaProduccionVO.getId())) {
					resp = true;
					break;
				}
			}
		}
		
		return resp;	
	}
	
	private boolean existPrioridad(ProductoLineaVO lineaProduccionVO) throws ParseException, DAOException {
		boolean resp = false;
		
		Productolinea exist = new Productolinea();
		exist.setProducto(Mapper.from(lineaProduccionVO.getProducto())); 
		exist.setPrioridad(lineaProduccionVO.getPrioridad());
		List<Productolinea> productoLineas = dao.getAllEqBy(exist);
		if(productoLineas instanceof List && !productoLineas.isEmpty()) {
			for(Productolinea obj : productoLineas) {
				if(!obj.getId().equals(lineaProduccionVO.getId())) {
					resp = true;
					break;
				}
			}
		}
		
		return resp;	
	}
}