package cl.obam.pasteleria.lapalmera.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cl.obam.pasteleria.lapalmera.service.FuncionarioService;
import cl.obam.pasteleria.lapalmera.view.FuncionarioVO;

@Controller
@RequestMapping(value="/funcionario")
public class FuncionarioController {
	
	private static final Logger LOG = Logger.getLogger(FuncionarioController.class);
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@RequestMapping(value="/getAll", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  List<FuncionarioVO> getAll(HttpServletRequest request) throws Exception {
		LOG.debug("getAll");
		
		return funcionarioService.getAll();
	}
}