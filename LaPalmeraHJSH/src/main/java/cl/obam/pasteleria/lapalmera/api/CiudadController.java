package cl.obam.pasteleria.lapalmera.api;

import java.util.ArrayList;
import java.util.List;

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

import cl.obam.pasteleria.lapalmera.model.Ciudad;
import cl.obam.pasteleria.lapalmera.service.CiudadService;
import cl.obam.pasteleria.lapalmera.view.BasicResponseVO;
import cl.obam.pasteleria.lapalmera.view.CiudadVO;
import cl.obam.pasteleria.lapalmera.view.JqGrid;

@Controller
@RequestMapping(value="/ciudad")
public class CiudadController {
	
	private static final Logger LOG = Logger.getLogger(CiudadController.class);
	
	@Autowired
	private CiudadService ciudadService;
	
	@RequestMapping(value="/getAll", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  List<CiudadVO> getAll(HttpServletRequest request) throws Exception {
		LOG.debug("CiudadController getAll");
		
		List<CiudadVO> resp = null;
		
		try {
			resp = ciudadService.getAll();
		} catch(Exception e) {
			throw e;
		}
	    return resp;
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	@ResponseBody
	public CiudadVO add(@RequestBody final CiudadVO ciudadVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("Ciudad add");
		
		CiudadVO resp = null;
		
		try {
			resp = ciudadService.save(ciudadVO);
		} catch(Exception e) {
			throw e;			
		}
	    return resp;
	}
	
	@RequestMapping(value="/update", method = RequestMethod.PUT)
	@ResponseBody
	public CiudadVO update(@RequestBody final CiudadVO ciudadVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("Ciudad update");
		
		CiudadVO resp = null;
		
		try {
			resp =ciudadService.update(ciudadVO);	    	
		} catch(Exception e) {
			throw e;			
		}
	    return resp;
	}
	
	@RequestMapping(value="/del", method = RequestMethod.DELETE)
	@ResponseBody
	public CiudadVO del(@RequestBody final CiudadVO ciudadVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("Ciudad del");

		CiudadVO resp = null;
		
		try {
			resp = ciudadService.delete(ciudadVO);
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