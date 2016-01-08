package cl.obam.pasteleria.lapalmera.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.obam.pasteleria.lapalmera.service.ProductoService;
import cl.obam.pasteleria.lapalmera.view.ProductoVO;

@Controller
@RequestMapping(value="/producto")
public class ProductoController {
	
	private static final Logger LOG = Logger.getLogger(ProductoController.class);
	
	@Autowired
	private ProductoService productoService;
	
	@RequestMapping(value="/{codigo}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  ProductoVO get(@PathVariable String codigo, HttpServletRequest request) throws Exception {
		LOG.debug("ProductoController get");
		
		ProductoVO resp = null;
		
		try {		
			resp = productoService.get(codigo);
		} catch(Exception e) {
			throw e;
		}
		
		return resp;
	}
	
//	@RequestMapping(value="/get", method = RequestMethod.GET, produces = "application/json")
//	public @ResponseBody  ProductoVO get(HttpServletRequest request) throws Exception {
//		LOG.debug("get");
//		
//		String q = request.getParameter("q");
//		ObjectMapper mapper = new ObjectMapper();
//		ProductoVO producto = mapper.readValue(q, ProductoVO.class);
//		
//		//String codigoProducto = request.getParameter("codigoProducto");
//		return productoService.get(producto.getCodigo());
//	}
	
//	@RequestMapping(value="/getUbicacion", method = RequestMethod.GET, produces = "application/json")
//	public @ResponseBody  ProductoVO getUbicacion(HttpServletRequest request) throws Exception {
//		LOG.debug("getUbicacion");
//		
//		String codigoProducto = request.getParameter("codigoProducto");
//		return productoService.getUbicacion(codigoProducto);
//	}
	
//	@RequestMapping(value="/getStockUbicacion", method = RequestMethod.GET, produces = "application/json")
//	public @ResponseBody  ProductoVO getStockUbicacion(HttpServletRequest request) throws Exception {
//		LOG.debug("getStockUbicacion");
//		
//		String codigoProducto = request.getParameter("codigoProducto");
//		return productoService.getStockUbicacion(codigoProducto);
//	}
	
	@RequestMapping(value="/getAll", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  List<ProductoVO> getAll(HttpServletRequest request) throws Exception {
		LOG.debug("ProductoController getAll");
		
		List<ProductoVO> resp = null;
		
		try {
			resp = productoService.getAll();
		} catch(Exception e) {
			throw e;
		}
	    return resp;
	}
	
//	@RequestMapping(value="/getAllEqBy", method = RequestMethod.GET, produces = "application/json")
//	public @ResponseBody  List<ProductoVO> getAllEqBy(HttpServletRequest request) throws Exception {
//		LOG.debug("getAllEqBy");
//		
//		String q = request.getParameter("q");
//		ObjectMapper mapper = new ObjectMapper();
//		ProductoVO producto = mapper.readValue(q, ProductoVO.class);
//
//		return productoService.getAllEqBy(producto);
//	}
	
	@RequestMapping(value="/getAllNotEqBy", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  List<ProductoVO> getAllNotEqBy(HttpServletRequest request) throws Exception {
		LOG.debug("ProductoController getAllNotEqBy");
		
		List<ProductoVO> resp = null;
		
		try {		
			String q = request.getParameter("q");
			ObjectMapper mapper = new ObjectMapper();
			ProductoVO producto = mapper.readValue(q, ProductoVO.class);
		
			resp = productoService.getAllNotEqBy(producto);
		} catch(Exception e) {
			throw e;
		}
	    return resp;
	}
	
	@RequestMapping(value="/ingreso", method = RequestMethod.POST)
	@ResponseBody
	public ProductoVO ingreso(@RequestBody final ProductoVO ingresoInsumoVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("ProductoController ingreso");
		
		ProductoVO resp = null;
		
		try {
			resp = productoService.ingreso(ingresoInsumoVO);
		} catch(Exception e) {
			throw e;
		}
	    return resp;
	    //return new BasicResponseVO("1", "SUCCESS", productoVO);
	}
	
	@ExceptionHandler(Exception.class)
	public @ResponseBody String handleException(HttpServletRequest request, HttpServletResponse response, Exception e) {
		LOG.error(e.getMessage(), e);		
		response.setStatus(response.SC_INTERNAL_SERVER_ERROR);		
		return e.getMessage();
	}
}