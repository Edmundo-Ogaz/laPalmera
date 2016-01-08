package cl.obam.pasteleria.lapalmera.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.obam.pasteleria.lapalmera.service.DevolucionInsumoService;
import cl.obam.pasteleria.lapalmera.view.BasicResponseVO;
import cl.obam.pasteleria.lapalmera.view.DevolucionInsumoVO;

@Controller
@RequestMapping(value="/devolucionInsumo")
public class DevolucionInsumoController {
	
	private static final Logger LOG = Logger.getLogger(DevolucionInsumoController.class);
	
	@Autowired
	private DevolucionInsumoService devolucionInsumoService;
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	@ResponseBody
	public BasicResponseVO add(@RequestBody final DevolucionInsumoVO devolucionInsumoVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("DevolucionInsumo add");

		DevolucionInsumoVO devolucionInsumoRespVO = devolucionInsumoService.save(devolucionInsumoVO);		
	    return new BasicResponseVO("1", "SUCCESS", devolucionInsumoRespVO);
	}
}