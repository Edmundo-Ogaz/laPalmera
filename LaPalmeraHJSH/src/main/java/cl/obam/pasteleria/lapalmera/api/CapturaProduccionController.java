package cl.obam.pasteleria.lapalmera.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.obam.pasteleria.lapalmera.exception.BusinessException;
import cl.obam.pasteleria.lapalmera.service.CapturaProduccionService;
import cl.obam.pasteleria.lapalmera.view.BasicResponseVO;
import cl.obam.pasteleria.lapalmera.view.CapturaProduccionVO;

@Controller
@RequestMapping(value="/capturaProduccion")
public class CapturaProduccionController {
	
	private static final Logger LOG = Logger.getLogger(CapturaProduccionController.class);
	
	@Autowired
	private CapturaProduccionService capturaProduccionService;
	
	@RequestMapping(value="/getAllEqBy", method = RequestMethod.GET)
	@ResponseBody
	public BasicResponseVO get(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("CapturaProduccion getAllEqBy");
		
		BasicResponseVO resp = null;
		
		try {
			String q = request.getParameter("q");
			ObjectMapper mapper = new ObjectMapper();
			CapturaProduccionVO capturaProduccionVO = mapper.readValue(q, CapturaProduccionVO.class);
			
			List<CapturaProduccionVO> capturaProduccionRespVO = capturaProduccionService.getAllEqBy(capturaProduccionVO);	
			resp = new BasicResponseVO("1", "SUCCESS", capturaProduccionRespVO);
			
		} catch(JsonParseException e) {
			LOG.error(e.getMessage(), e);
			resp = new BasicResponseVO("-1", "ERROR", e.getMessage());
		} catch(Exception e) {
			LOG.error(e.getMessage(), e);
			resp = new BasicResponseVO("-1", "ERROR", "ERROR Captura Produción");
		}
		
		return resp;		
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	@ResponseBody
	public BasicResponseVO add(@RequestBody final CapturaProduccionVO capturaProduccionVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("CapturaProduccion add");
		
		BasicResponseVO resp = null;
		
		try {
			CapturaProduccionVO capturaProduccionRespVO = capturaProduccionService.save(capturaProduccionVO);	
			resp = new BasicResponseVO("1", "SUCCESS", capturaProduccionRespVO);
		} catch(BusinessException e) {
			LOG.error(e.getMessage(), e);
			resp = new BasicResponseVO("0", "ERROR", e.getMessage());
		} catch(Exception e) {
			LOG.error(e.getMessage(), e);
			resp = new BasicResponseVO("-1", "ERROR", "ERROR Captura Produción");
		}
		
		return resp;		
	}
}