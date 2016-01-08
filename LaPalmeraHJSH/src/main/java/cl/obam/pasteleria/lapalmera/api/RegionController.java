package cl.obam.pasteleria.lapalmera.api;

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

import cl.obam.pasteleria.lapalmera.service.RegionService;
import cl.obam.pasteleria.lapalmera.view.BasicResponseVO;
import cl.obam.pasteleria.lapalmera.view.RegionVO;

@Controller
@RequestMapping(value="/region")
public class RegionController {
	
	private static final Logger LOG = Logger.getLogger(RegionController.class);
	
	@Autowired
	private RegionService regionService;
	
	@RequestMapping(value="/getAll", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody  List<RegionVO> getAll(HttpServletRequest request) throws Exception {
		LOG.debug("RegionController getAll");
		
		List<RegionVO> resp = null;

		try {			
			resp = regionService.getAll();
		} catch(Exception e) {
			throw e;
		}		
		return resp;
	}
	
//	@RequestMapping(value="/search", method = RequestMethod.GET, produces = "application/json")
//	public @ResponseBody  JqGrid search(HttpServletRequest request) throws Exception {
//		LOG.debug("RegionController search");
//		
//		List<Region> listRegion = null;
//		
//		LOG.debug(request.getQueryString());
//		
//		boolean _search = Boolean.parseBoolean(request.getParameter("_search"));
//		if (_search) {
//			String field = request.getParameter("searchField");
//			String value = request.getParameter("searchString");
//			String oper = request.getParameter("searchOper");
//			
//			Region region = fillObjectByReflection(field, value);
//			
//			if (OperacionEnum.EQUAL.equals(oper)) {
//				LOG.debug("equals");
//				listRegion = regionService.getAllEqBy(region);
//			} else if (OperacionEnum.NOT_EQUAL.equals(oper)) {
//				LOG.debug("not equals");
//				listRegion = regionService.getAllNotEqBy(region);			
//			} else if (OperacionEnum.BEGINS_WITH.equals(oper)) {
//				LOG.debug("begins with");
//				listRegion = regionService.getAllBeginWithBy(region);	
//			} else if (OperacionEnum.NOT_BEGINS_WITH.equals(oper)) {
//				LOG.debug("not begins with");
//				listRegion = regionService.getAllNotBeginWithBy(region);	
//			} else if (OperacionEnum.END_WITH.equals(oper)) {
//				LOG.debug("end with");
//				listRegion = regionService.getAllEndWithBy(region);	
//			} else if (OperacionEnum.NOT_END_WITH.equals(oper)) {
//				LOG.debug("not end with");
//				listRegion = regionService.getAllNotEndWithBy(region);	
//			} else if (OperacionEnum.CONTAIN.equals(oper)) {
//				LOG.debug("contain");
//				listRegion = regionService.getAllContainBy(region);	
//			} else if (OperacionEnum.NOT_CONTAIN.equals(oper)) {
//				LOG.debug("not contain");
//				listRegion = regionService.getAllNotContainBy(region);	
//			} else if (OperacionEnum.IS_NULL.equals(oper)) {
//				LOG.debug("is null");
//				listRegion = regionService.getAllIsNullBy(region);	
//			} else if (OperacionEnum.NOT_IS_NULL.equals(oper)) {
//				LOG.debug("not is null");
//				listRegion = regionService.getAllNotIsNullBy(region);	
//			}
//		}
//		
//		List<Object> list = new ArrayList<Object>();
//		for (Region region : listRegion) {
//			list.add(new RegionVO(region.getCodigo(), region.getNombre()));
//		}
//	    
//	    JqGrid jqGrid = new JqGrid();
//	    jqGrid.setRows(list);
//	    jqGrid.setRecords(String.valueOf(list.size()));	          
//	    jqGrid.setPage("1");
//	    jqGrid.setTotal("10");
//	    return jqGrid;
//	}
	
	@RequestMapping(value="/add", method = RequestMethod.POST)
	@ResponseBody
	public RegionVO add(@RequestBody final RegionVO regionVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("Region add");

		RegionVO resp = null;
		
		try {	
			resp =  regionService.save(regionVO);
		} catch(Exception e) {
			throw e;			
		}
	    return resp;
	}
	
	@RequestMapping(value="/update", method = RequestMethod.PUT)
	@ResponseBody
	public RegionVO update(@RequestBody final RegionVO regionVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("Region update");

		RegionVO resp = null;
		
		try {		
			resp = regionService.update(regionVO);
		} catch(Exception e) {
			throw e;			
		}	
	    return resp;
	}
	
	@RequestMapping(value="/del", method = RequestMethod.DELETE)
	@ResponseBody
	public RegionVO del(@RequestBody final RegionVO regionVO, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOG.debug("Region del");
		
		RegionVO resp = null;
		
		try {
			resp = regionService.delete(regionVO);
		} catch(Exception e) {
			throw e;			
		}
	    return resp;
	}
	
//	private Region fillObjectByReflection(String field, String value) {
//	
//		Region obj = new Region();	
//		BeanInfo info = null;
//		try {
//			info = Introspector.getBeanInfo(obj.getClass());
//		
//			for (PropertyDescriptor descriptor : info.getPropertyDescriptors()) {
//				String name = descriptor.getName();
//				Method setter = descriptor.getWriteMethod();
//				if (field.equals(name) && setter != null)
//					setter.invoke(obj, value);
//			}
//		} catch (IntrospectionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalArgumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} // varargs  
//		
//		return obj;
//	}
	
	@ExceptionHandler(Exception.class)
	public @ResponseBody String handleException(HttpServletRequest request, HttpServletResponse response, Exception e) {
		LOG.error(e.getMessage(), e);		
		response.setStatus(response.SC_INTERNAL_SERVER_ERROR);		
		return e.getMessage();
	}
}