package cl.obam.pasteleria.lapalmera.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.obam.pasteleria.lapalmera.service.ClienteService;
import cl.obam.pasteleria.lapalmera.view.ClienteVO;

@Controller
@RequestMapping(value="/cliente")
public class ClienteController {
	
	private static final Logger LOG = Logger.getLogger(ClienteController.class);
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value="/{rut}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ClienteVO get(@PathVariable String rut, HttpServletRequest request) throws Exception {
		LOG.debug("ClienteController get");
		
		ClienteVO resp = null;
		try {
			resp = clienteService.get(rut);
		} catch(Exception e) {
			throw e;
		}
		
		return resp;
	}
	
	@ExceptionHandler(Throwable.class)
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