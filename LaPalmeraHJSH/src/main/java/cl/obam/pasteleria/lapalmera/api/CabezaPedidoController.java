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

import cl.obam.pasteleria.lapalmera.service.CabezaPedidoService;
import cl.obam.pasteleria.lapalmera.view.CabezaPedidoVO;
import cl.obam.pasteleria.lapalmera.view.ProductoVO;

@Controller
@RequestMapping(value="/cabezaPedido")
public class CabezaPedidoController {
	
	private static final Logger LOG = Logger.getLogger(CabezaPedidoController.class);
	
	@Autowired
	private CabezaPedidoService cabezaPedidoService;
	
//	@RequestMapping(value="/{numeroPedido}", method = RequestMethod.GET, produces = "application/json")
//	public @ResponseBody  CabezaPedidoVO get(@PathVariable String numeroPedido, HttpServletRequest request) throws Exception {
//		LOG.debug("CabezaPedidoController get");
//		
//		CabezaPedidoVO resp = null;
//		try {
//			resp =cabezaPedidoService.get(numeroPedido);
//		} catch(Exception e) {
//			throw e;
//		}
//		
//		return resp;
//	}
	
	@ExceptionHandler(Exception.class)
	public @ResponseBody String handleException(HttpServletRequest request, HttpServletResponse response, Exception e) {
		LOG.error(e.getMessage(), e);		
		response.setStatus(response.SC_INTERNAL_SERVER_ERROR);		
		return e.getMessage();
	}
}