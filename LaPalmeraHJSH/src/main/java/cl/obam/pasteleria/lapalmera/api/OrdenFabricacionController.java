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

import cl.obam.pasteleria.lapalmera.service.OrdenFabricacionService;
import cl.obam.pasteleria.lapalmera.view.CabezaPedidoVO;
import cl.obam.pasteleria.lapalmera.view.OrdenFabricacionVO;
import cl.obam.pasteleria.lapalmera.view.ProductoVO;

@Controller
@RequestMapping(value="/ordenFabricacion")
public class OrdenFabricacionController {
	
	private static final Logger LOG = Logger.getLogger(OrdenFabricacionController.class);
	
	@Autowired
	private OrdenFabricacionService ordenFabricacionService;
	
	@RequestMapping(value="/{codigo}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  OrdenFabricacionVO get(@PathVariable String codigo, HttpServletRequest request) throws Exception {
		LOG.debug("OrdenFabricacionController get");
		
		OrdenFabricacionVO resp = null;
		
		try {
			resp = ordenFabricacionService.get(codigo);
		} catch(Exception e) {
			throw e;
		}
	
		return resp;
		
	}
	
	@RequestMapping(value="/getAllEqBy", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  List<OrdenFabricacionVO> getAllEqBy(HttpServletRequest request) throws Exception {
		LOG.debug("OrdenFabricacionController getAllEqBy");
	
		List<OrdenFabricacionVO> resp = null;
		
		try {
			String q = request.getParameter("q");
			ObjectMapper mapper = new ObjectMapper();
			OrdenFabricacionVO ordenFabricacionVO = mapper.readValue(q, OrdenFabricacionVO.class);
			resp = ordenFabricacionService.getAllEqBy(ordenFabricacionVO);
		} catch(Exception e) {
			throw e;
		}
		return resp;
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	@ResponseBody
	public OrdenFabricacionVO save(@RequestBody final OrdenFabricacionVO ordenFabricacionVO, HttpServletRequest request, HttpServletResponse response) throws Throwable {
		LOG.debug("OrdenFabricacionController save");
		
		OrdenFabricacionVO resp = null;
		
		try {
			resp = ordenFabricacionService.save(ordenFabricacionVO);
		} catch(Throwable e) {
			throw e;
		}
		
		return resp;
	}
	
	@ExceptionHandler(Exception.class)
	public @ResponseBody String handleException(HttpServletRequest request, HttpServletResponse response, Exception e) {
		LOG.error(e.getMessage(), e);		
		response.setStatus(response.SC_INTERNAL_SERVER_ERROR);		
		return e.getMessage();
	}
}