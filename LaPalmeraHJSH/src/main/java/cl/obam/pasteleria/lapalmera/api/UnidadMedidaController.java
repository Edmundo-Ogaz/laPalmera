package cl.obam.pasteleria.lapalmera.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.obam.pasteleria.lapalmera.service.UnidadMedidaService;
import cl.obam.pasteleria.lapalmera.view.UnidadMedidaVO;

@Controller
@RequestMapping(value="/unidadMedida")
public class UnidadMedidaController {
	
	private static final Logger LOG = Logger.getLogger(UnidadMedidaController.class);
	
	@Autowired
	private UnidadMedidaService unidadMedidaService;
	
	@RequestMapping(value="/get", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  UnidadMedidaVO get(HttpServletRequest request) throws Exception {
		LOG.debug("get");
		
		String codigoBodega = request.getParameter("codigoBodega");
		return unidadMedidaService.get(codigoBodega);
	}
	
	@RequestMapping(value="/getAll", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  List<UnidadMedidaVO> getAll(HttpServletRequest request) throws Exception {
		LOG.debug("getAll");
		
		List<UnidadMedidaVO> resp = null;
		
		try {		
			resp = unidadMedidaService.getAll();
		} catch(Exception e) {
			throw e;
		}
		
		return resp;
	}
	
	@RequestMapping(value="/getAllEqBy", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  List<UnidadMedidaVO> getAllEqBy(HttpServletRequest request) throws Exception {
		LOG.debug("getAllEqBy");
		
		List<UnidadMedidaVO> resp = null;
		
		try {		
			String q = request.getParameter("q");
			ObjectMapper mapper = new ObjectMapper();
			UnidadMedidaVO unidadMedidaVO = mapper.readValue(q, UnidadMedidaVO.class);
				
			resp = unidadMedidaService.getAllEqBy(unidadMedidaVO);
		} catch(Exception e) {
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