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

import cl.obam.pasteleria.lapalmera.service.BodegaService;
import cl.obam.pasteleria.lapalmera.view.BasicResponseVO;
import cl.obam.pasteleria.lapalmera.view.BodegaVO;

@Controller
@RequestMapping(value="/bodega")
public class BodegaController {
	
	private static final Logger LOG = Logger.getLogger(BodegaController.class);
	
	@Autowired
	private BodegaService bodegaService;
	
	@RequestMapping(value="/get", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  BodegaVO get(HttpServletRequest request) throws Exception {
		LOG.debug("get");
		
		String codigoBodega = request.getParameter("codigoBodega");
		return bodegaService.get(codigoBodega);
	}
	
	@RequestMapping(value="/getAll", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  List<BodegaVO> getAll(HttpServletRequest request) throws Exception {
		LOG.debug("BodegaService getAll");
		
		List<BodegaVO> resp = null;
		
		try {
			resp = bodegaService.getAll();
		} catch (Exception e) {
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