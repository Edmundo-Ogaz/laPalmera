package cl.obam.pasteleria.lapalmera.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.obam.pasteleria.lapalmera.exception.BusinessException;
import cl.obam.pasteleria.lapalmera.service.CabezaPedidoService;
import cl.obam.pasteleria.lapalmera.service.SolicitudProductoService;
import cl.obam.pasteleria.lapalmera.view.BasicResponseVO;
import cl.obam.pasteleria.lapalmera.view.CabezaPedidoVO;
import cl.obam.pasteleria.lapalmera.view.SolicitudProductoVO;

@Controller
@RequestMapping(value="/solicitudProducto")
public class SolicitudProductoController {
	
	private static final Logger LOG = Logger.getLogger(SolicitudProductoController.class);
	
	@Autowired
	private SolicitudProductoService solicitudProductoService;
	
	@Autowired
	private CabezaPedidoService cabezaPedidoService;
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	@ResponseBody
	public CabezaPedidoVO add(@RequestBody final CabezaPedidoVO cabezaPedidoVO, HttpServletRequest request, HttpServletResponse response) throws Throwable {
		LOG.debug("SolicitudProducto add");
		
		CabezaPedidoVO resp = null;
		
		try {
			resp = solicitudProductoService.save(cabezaPedidoVO);
		} catch(Throwable e) {
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