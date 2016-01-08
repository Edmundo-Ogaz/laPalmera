package cl.obam.pasteleria.lapalmera.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.obam.pasteleria.lapalmera.service.StockService;
import cl.obam.pasteleria.lapalmera.view.BasicResponseVO;
import cl.obam.pasteleria.lapalmera.view.StockVO;

@Controller
@RequestMapping(value="/stock")
public class StockController {
	
	private static final Logger LOG = Logger.getLogger(StockController.class);
	
	@Autowired
	private StockService stockService;
	
	@RequestMapping(value="/getAllEqBy", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  List<StockVO> getAllEqBy(HttpServletRequest request) throws Exception {
		LOG.debug("Stock getAllEqBy");
		
		List<StockVO> resp = null;
		
		try {
			String q = request.getParameter("state");
			ObjectMapper mapper = new ObjectMapper();
			StockVO stockVO = mapper.readValue(q, StockVO.class);
			
			resp = stockService.getAllEqBy(stockVO);
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