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

import cl.obam.pasteleria.lapalmera.service.ComunaService;
import cl.obam.pasteleria.lapalmera.view.ComunaVO;

@Controller
@RequestMapping(value="/comuna")
public class ComunaController {
	
	private static final Logger LOG = Logger.getLogger(ComunaController.class);
	
	@Autowired
	private ComunaService comunaService;
	
	@RequestMapping(value="/getAll", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  List<ComunaVO> getAll(HttpServletRequest request) throws Exception {
		LOG.debug("ComunaController getAll");
		
		List<ComunaVO> resp = null;
		
		try {
			resp = comunaService.getAll();
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