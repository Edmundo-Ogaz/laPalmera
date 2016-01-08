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
import cl.obam.pasteleria.lapalmera.service.UbicacionService;
import cl.obam.pasteleria.lapalmera.view.BasicResponseVO;
import cl.obam.pasteleria.lapalmera.view.UbicacionVO;

@Controller
@RequestMapping(value="/ubicacion")
public class UbicacionController {
	
	private static final Logger LOG = Logger.getLogger(UbicacionController.class);
	
	@Autowired
	private UbicacionService ubicacionService;
	
	@RequestMapping(value="/getAllEqBy", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  List<UbicacionVO> getAllEqBy(HttpServletRequest request) throws Exception {
		LOG.debug("Ubicacion getAllEqBy");
		
		List<UbicacionVO> resp = null;
		
		try {
			String q = request.getParameter("state");
			ObjectMapper mapper = new ObjectMapper();
			UbicacionVO ubicacionVO = mapper.readValue(q, UbicacionVO.class);
			
			resp = ubicacionService.getAllEqBy(ubicacionVO);
		} catch(Exception e) {
			throw e;
		}
	
		return resp;
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	@ResponseBody
	public UbicacionVO add(@RequestBody final UbicacionVO ubicacionVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("Ubicacion add");
		
		UbicacionVO resp = null;
		
		try {
			resp = ubicacionService.save(ubicacionVO);
		} catch(Exception e) {
			throw e;
		}

		return resp;
	    
	}
	
	@RequestMapping(value="/update", method = RequestMethod.PUT)
	@ResponseBody
	public UbicacionVO update(@RequestBody final UbicacionVO ubicacionVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("Ubicacion update");
		
		UbicacionVO resp = null;
		
		try {
			resp = ubicacionService.update(ubicacionVO);
		} catch(BusinessException e) {
			throw e;
		}
		
		return resp;
	}
	
	@RequestMapping(value="/del", method = RequestMethod.DELETE)
	@ResponseBody
	public UbicacionVO del(@RequestBody final UbicacionVO ubicacionVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("Ubicacion del");
		
		UbicacionVO resp = null;
		
		try {
			resp = ubicacionService.delete(ubicacionVO);
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