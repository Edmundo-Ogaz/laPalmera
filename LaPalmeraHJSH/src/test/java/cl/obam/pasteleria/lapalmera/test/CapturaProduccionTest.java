package cl.obam.pasteleria.lapalmera.test;

import java.util.List;

import junit.framework.Assert;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.service.CapturaProduccionService;
import cl.obam.pasteleria.lapalmera.service.FuncionarioService;
import cl.obam.pasteleria.lapalmera.service.StockService;
import cl.obam.pasteleria.lapalmera.service.UbicacionService;
import cl.obam.pasteleria.lapalmera.util.Mapper;
import cl.obam.pasteleria.lapalmera.view.CapturaProduccionVO;
import cl.obam.pasteleria.lapalmera.view.OrdenFabricacionVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class CapturaProduccionTest {
	
	@Autowired
	private CapturaProduccionService capturaProduccionService;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private StockService stockService;
	
	@Autowired
	private UbicacionService ubicacionService;
	
	@Test
	@Ignore
	public void getAll() {
		
		try {
			List<CapturaProduccionVO> capturaProduccions = capturaProduccionService.getAll();
			Assert.assertNotNull(capturaProduccions);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void getAllEqBy() {
		
		try {
			CapturaProduccionVO capturaProduccionVO = new CapturaProduccionVO();
			capturaProduccionVO.setProgramaProduccion(new OrdenFabricacionVO("9-1"));
			Assert.assertNotNull(capturaProduccionService.getAllEqBy(capturaProduccionVO));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllNotEqBy() {
		
		try {
			CapturaProduccionVO capturaProduccionVO = new CapturaProduccionVO();
			Assert.assertNotNull(capturaProduccionService.getAllNotEqBy(capturaProduccionVO));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
					
	@Test
	@Ignore
	public void getAllBeginWithBy() {
		
		try {
			CapturaProduccionVO capturaProduccionVO = new CapturaProduccionVO();
			Assert.assertNotNull(capturaProduccionService.getAllBeginWithBy(capturaProduccionVO));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllNotBeginWithBy() {
		
		try {
			CapturaProduccionVO capturaProduccionVO = new CapturaProduccionVO();
			Assert.assertNotNull(capturaProduccionService.getAllNotBeginWithBy(capturaProduccionVO));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllEndWithBy() {
		
		try {
			CapturaProduccionVO capturaProduccionVO = new CapturaProduccionVO();
			Assert.assertNotNull(capturaProduccionService.getAllEndWithBy(capturaProduccionVO));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllNotEndWithBy() {
		
		try {
			CapturaProduccionVO capturaProduccionVO = new CapturaProduccionVO();
			Assert.assertNotNull(capturaProduccionService.getAllNotEndWithBy(capturaProduccionVO));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllContainBy() {
		
		try {
			CapturaProduccionVO capturaProduccionVO = new CapturaProduccionVO();
			Assert.assertNotNull(capturaProduccionService.getAllContainBy(capturaProduccionVO));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllNotContainBy() {
		
		try {
			CapturaProduccionVO capturaProduccionVO = new CapturaProduccionVO();
			Assert.assertNotNull(capturaProduccionService.getAllNotContainBy(capturaProduccionVO));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllIsNullBy() {
		
		try {
			CapturaProduccionVO capturaProduccionVO = new CapturaProduccionVO();
			Assert.assertNotNull(capturaProduccionService.getAllIsNullBy(capturaProduccionVO));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllNotIsNullBy() {
		
		try {
			CapturaProduccionVO capturaProduccionVO = new CapturaProduccionVO();
			Assert.assertNotNull(capturaProduccionService.getAllNotIsNullBy(capturaProduccionVO));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	
	@Test
	//@Ignore
	public void crud() {
		
		try {
			
			String q = "{\"ordenFabricacion\": {\"codigoOrdenFabricacion\" : \"9-1\"},"+
						 "\"fechaCapturaProduccion\" : \"15-09-2015 00:00:00\","+
						 "\"horaCapturaProduccion\" : \"15-09-2015 00:00:00\","+
		 				" \"funcionarios\" : [{\"rut\" : \"15331265-6\"}],"+
		 				 "\"producto\" : {\"codigo\" : \"T01E01D01\","+
		 					 		   	 "\"nombre\" : \"Mil Delicias 20 Porciones\","+
			 					 		 "\"ubicacions\" : [{\"producto\" : {\"codigo\" : \"T01E01D01\"},"+
							  	  			  			    "\"bodega\" : {\"codigo\" : \"B01\"},"+
							  	  			  			    "\"fechaIngreso\" :  \"15-09-2015 00:00:00\","+
							  	  			  				"\"horaIngreso\" : \"15-09-2015 00:00:00\","+
							  	  			  			    "\"fechaVencimiento\" : \"15-09-2015 00:00:00\","+
									  			  			"\"cantidad\": \"1\","+
									  			  			"\"unidadMedida\" : {\"codigo\": \"UND\"},"+
									  			  			"\"observacion\" : \"place\""+
									  			  			"}]"+
								  		  "},"+
				  		 "\"cantidadProduccion\": \"1\","+
				  		 "\"unidadMedida\" : {\"codigo\": \"UND\"},"+
				  		 "\"observacion\": \"obs\""+
					    "}";
			
			ObjectMapper mapper = new ObjectMapper();
			CapturaProduccionVO capturaProduccionVO = mapper.readValue(q, CapturaProduccionVO.class);
			
			capturaProduccionVO = capturaProduccionService.save(capturaProduccionVO);
			Assert.assertNotNull(capturaProduccionVO);
			Assert.assertNotNull(capturaProduccionService.get(capturaProduccionVO));
			//funcioanrio capturaProduccionService.getAllEqBy()
			Assert.assertNotNull(stockService.get(capturaProduccionVO.getProducto().getCodigo()));
			Assert.assertNotSame(ubicacionService.getAllEqBy(capturaProduccionVO.getProducto().getUbicacions().get(0)).size(), 0);
			//Assert.assertEquals(capturaProduccionService.update(capturaProduccionVO), true);
			Assert.assertEquals(capturaProduccionService.delete(capturaProduccionVO), true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	@Ignore
	public void update() {

		try {
			CapturaProduccionVO capturaProduccionVO = new CapturaProduccionVO();
			Assert.assertEquals(capturaProduccionService.update(capturaProduccionVO), true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void delete() {
		
		try {
			CapturaProduccionVO capturaProduccionVO = new CapturaProduccionVO();
			Assert.assertEquals(capturaProduccionService.delete(capturaProduccionVO), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	

}
