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
import cl.obam.pasteleria.lapalmera.model.Ingrediente;
import cl.obam.pasteleria.lapalmera.service.IngredienteService;
import cl.obam.pasteleria.lapalmera.view.BasicResponseVO;
import cl.obam.pasteleria.lapalmera.view.IngredienteVO;

@Controller
@RequestMapping(value="/ingrediente")
public class IngredienteController {
	
	private static final Logger LOG = Logger.getLogger(IngredienteController.class);
	
	@Autowired
	private IngredienteService ingredienteService;
	
	@RequestMapping(value="/getAllEqBy", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  List<IngredienteVO> getAllBy(HttpServletRequest request) throws Exception {
		LOG.debug("getAllEqBy");
		
		List<IngredienteVO> resp = null;
		
		try {
			String q = request.getParameter("state");
			ObjectMapper mapper = new ObjectMapper();
			IngredienteVO ingrediente = mapper.readValue(q, IngredienteVO.class);
		
			resp = ingredienteService.getAllEqBy(ingrediente);
		} catch(Exception e) {
			throw e;
		}
		
		return resp;
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	@ResponseBody
	public IngredienteVO add(@RequestBody final IngredienteVO ingredienteVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("Ingrediente add");
		
		IngredienteVO resp = null;
		
		try {
			resp = ingredienteService.save(ingredienteVO);			
		} catch(Exception e) {
			throw e;
		}

		return resp;
	    
	}
	
	@RequestMapping(value="/update", method = RequestMethod.PUT)
	@ResponseBody
	public IngredienteVO update(@RequestBody final IngredienteVO ingredienteVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("Ingrediente update");
		
		IngredienteVO resp = null;
		
		try {
			resp = ingredienteService.update(ingredienteVO);
		} catch(Exception e) {
			throw e;
		}
		
		return resp;
	}
	
	@RequestMapping(value="/del", method = RequestMethod.DELETE)
	@ResponseBody
	public IngredienteVO del(@RequestBody final IngredienteVO ingredienteVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("Ingrediente del");
		
		IngredienteVO resp = null;
		
		try {
			resp = ingredienteService.delete(ingredienteVO);			
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