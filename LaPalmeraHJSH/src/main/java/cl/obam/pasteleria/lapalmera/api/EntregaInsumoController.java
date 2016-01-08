package cl.obam.pasteleria.lapalmera.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.obam.pasteleria.lapalmera.service.EntregaInsumoService;
import cl.obam.pasteleria.lapalmera.view.BasicResponseVO;
import cl.obam.pasteleria.lapalmera.view.EntregaInsumoVO;

@Controller
@RequestMapping(value="/entregaInsumo")
public class EntregaInsumoController {
	
	private static final Logger LOG = Logger.getLogger(EntregaInsumoController.class);
	
	@Autowired
	private EntregaInsumoService entregaInsumoService;
	
	@RequestMapping(value="/getAllEqBy", method = RequestMethod.GET)
	@ResponseBody
	public List<EntregaInsumoVO> getAllEqBy(HttpServletRequest request) throws Exception {
		LOG.debug("EntregaInsumo getAllEqBy");
		
		String q = request.getParameter("q");
		ObjectMapper mapper = new ObjectMapper();
		EntregaInsumoVO entregaInsumo = mapper.readValue(q, EntregaInsumoVO.class);
	    	
	    return entregaInsumoService.getAllEqBy(entregaInsumo);
	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	@ResponseBody
	public BasicResponseVO add(@RequestBody final EntregaInsumoVO entregaInsumoVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("EntregaInsumo add");

		EntregaInsumoVO entregaInsumoRespVO = entregaInsumoService.save(entregaInsumoVO);		
	    return new BasicResponseVO("1", "SUCCESS", entregaInsumoRespVO);
	}
}