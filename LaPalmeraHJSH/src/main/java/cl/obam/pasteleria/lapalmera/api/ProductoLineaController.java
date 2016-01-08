package cl.obam.pasteleria.lapalmera.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.obam.pasteleria.lapalmera.exception.BusinessException;
import cl.obam.pasteleria.lapalmera.model.Productolinea;
import cl.obam.pasteleria.lapalmera.service.ProductoLineaService;
import cl.obam.pasteleria.lapalmera.view.BasicResponseVO;
import cl.obam.pasteleria.lapalmera.view.ProductoLineaVO;

@Controller
@RequestMapping(value="/productoLinea")
public class ProductoLineaController {
	
	private static final Logger LOG = Logger.getLogger(ProductoLineaController.class);
	
	@Autowired
	private ProductoLineaService productoLineaService;
	
	@RequestMapping(value="/getAllEqBy", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  List<ProductoLineaVO> getAllBy(HttpServletRequest request) throws Exception {
		LOG.debug("ProductoLineaController getAllEqBy");
		
		List<ProductoLineaVO> resp = null;
		
		try {
			String q = request.getParameter("state");
			ObjectMapper mapper = new ObjectMapper();
			ProductoLineaVO productoLinea = mapper.readValue(q, ProductoLineaVO.class);
		
		    resp = productoLineaService.getAllEqBy(productoLinea);		
		} catch(Exception e) {
			throw e;
		}
		
		return resp;
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	@ResponseBody
	public Productolinea add(@RequestBody final ProductoLineaVO productoLineaVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("ProductoLinea add");
		
		Productolinea resp = null;
		
		try {
			resp = productoLineaService.save(productoLineaVO);
		} catch(BusinessException e) {
			throw e;
		}

		return resp;
	    
	}
	
	@RequestMapping(value="/update", method = RequestMethod.PUT)
	@ResponseBody
	public Productolinea update(@RequestBody final ProductoLineaVO productoLineaVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("ProductoLinea update");
		
		Productolinea resp = null;
		
		try {
			resp = productoLineaService.update(productoLineaVO);
		} catch(BusinessException e) {
			throw e;
		}
		
		return resp;
	}
	
	@RequestMapping(value="/del", method = RequestMethod.DELETE)
	@ResponseBody
	public BasicResponseVO del(@RequestBody final ProductoLineaVO productoLineaVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("ProductoLinea del");
		
		BasicResponseVO resp = null;
		
		try {
			productoLineaService.delete(productoLineaVO);
			resp = new BasicResponseVO("1", "SUCCESS", productoLineaVO);
		} catch(BusinessException e) {
			LOG.error(e.getMessage(), e);
			resp = new BasicResponseVO("0", "ERROR", e.getMessage());
		}
	    	
	    return resp;
	}
	
	@ExceptionHandler(Exception.class)
	public @ResponseBody String handleException(HttpServletRequest request, HttpServletResponse response, Exception e) {
		LOG.error(e.getMessage(), e);
		
		String msj = e.getMessage();
		if(e instanceof NullPointerException) {
			msj = "Objecto null";
		}
		response.setStatus(response.SC_INTERNAL_SERVER_ERROR);		
		return msj;
	}
}