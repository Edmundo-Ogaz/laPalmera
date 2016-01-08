package cl.obam.pasteleria.lapalmera.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.obam.pasteleria.lapalmera.service.LineaProduccionService;
import cl.obam.pasteleria.lapalmera.view.LineaProduccionVO;

@Controller
@RequestMapping(value="/lineaProduccion")
public class LineaProduccionController {
	
	private static final Logger LOG = Logger.getLogger(LineaProduccionController.class);
	
	@Autowired
	private LineaProduccionService lineaProduccionService;
	
	@RequestMapping(value="/getAll", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  List<LineaProduccionVO> getAll(HttpServletRequest request) throws Exception {
		LOG.debug("getAll");
		
		List<LineaProduccionVO> resp = null;
		
		try {
			resp = lineaProduccionService.getAll();
		} catch(Exception e) {
			throw e;
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