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

import cl.obam.pasteleria.lapalmera.service.CabezaPedidoService;
import cl.obam.pasteleria.lapalmera.service.SolicitudProductoService;
import cl.obam.pasteleria.lapalmera.view.CabezaPedidoVO;
import cl.obam.pasteleria.lapalmera.view.ProductoVO;

@Controller
@RequestMapping(value="/pedido")
public class PedidoController {
	
	private static final Logger LOG = Logger.getLogger(PedidoController.class);
	
	@Autowired
	private SolicitudProductoService solicitudProductoService;
	
	@Autowired
	private CabezaPedidoService cabezaPedidoService;
	
	@RequestMapping(value="/{numeroPedido}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  CabezaPedidoVO get(@PathVariable String numeroPedido, HttpServletRequest request) throws Exception {
		LOG.debug("CabezaPedidoController get");
		
		CabezaPedidoVO resp = null;
		try {
			resp = cabezaPedidoService.get(numeroPedido);
		} catch(Exception e) {
			throw e;
		}
		
		return resp;
	}
	
	@RequestMapping(value="/getAll", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  List<CabezaPedidoVO> getAll(HttpServletRequest request) throws Exception {
		LOG.debug("PedidoController getAll");
		
		List<CabezaPedidoVO> resp = null;
		
		try {		
			resp = cabezaPedidoService.getAll();
		} catch(Exception e) {
			throw e;
		}
	    return resp;
	}
	
	@RequestMapping(value="/getAllEqBy", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  List<CabezaPedidoVO> getAllEqBy(HttpServletRequest request) throws Exception {
		LOG.debug("PedidoController getAllEqBy");
		
		List<CabezaPedidoVO> resp = null;
		
		try {		
			String q = request.getParameter("q");
			ObjectMapper mapper = new ObjectMapper();
			CabezaPedidoVO pedido = mapper.readValue(q, CabezaPedidoVO.class);
		
			resp = cabezaPedidoService.getAllEqBy(pedido);
		} catch(Exception e) {
			throw e;
		}
	    return resp;
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	@ResponseBody
	public CabezaPedidoVO add(@RequestBody final CabezaPedidoVO cabezaPedidoVO, HttpServletRequest request, HttpServletResponse response) throws Throwable {
		LOG.debug("PedidoController save");
		
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