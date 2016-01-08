package cl.obam.pasteleria.lapalmera.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Conceptotecnico;
import cl.obam.pasteleria.lapalmera.service.ConceptoTecnicoService;
import cl.obam.pasteleria.lapalmera.view.ConceptoTecnicoVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class ConceptoTecnicoSeviceTest {
	
	@Autowired
	private ConceptoTecnicoService conceptoTecnicoService;
	
	@Test
	//@Ignore
	public void getAll() {
		
		try {
			List<Conceptotecnico> listConceptoTecnico = conceptoTecnicoService.getAll();
			Assert.assertNotNull(listConceptoTecnico);
			List<Object> list = new ArrayList<Object>();
			for (Conceptotecnico conceptoTecnico : listConceptoTecnico) {
				list.add(new ConceptoTecnicoVO(conceptoTecnico.getCodigoconceptotecnico(),
						conceptoTecnico.getNombreconceptotecnico()));
			}
			Assert.assertTrue(list.size() > 1);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	//@Ignore
	public void getAllEqBy() {
		
		try {
			Conceptotecnico area = new Conceptotecnico();
			Assert.assertNotNull(conceptoTecnicoService.getAllEqBy(area));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEqBy() {
		
		try {
			Conceptotecnico area = new Conceptotecnico();
			Assert.assertNotNull(conceptoTecnicoService.getAllNotEqBy(area));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
					
	@Test
	//@Ignore
	public void getAllBeginWithBy() {
		
		try {
			Conceptotecnico area = new Conceptotecnico();
			Assert.assertNotNull(conceptoTecnicoService.getAllBeginWithBy(area));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotBeginWithBy() {
		
		try {
			Conceptotecnico area = new Conceptotecnico();
			Assert.assertNotNull(conceptoTecnicoService.getAllNotBeginWithBy(area));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllEndWithBy() {
		
		try {
			Conceptotecnico area = new Conceptotecnico();
			Assert.assertNotNull(conceptoTecnicoService.getAllEndWithBy(area));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotEndWithBy() {
		
		List<Conceptotecnico> list = null;
		try {
			Conceptotecnico area = new Conceptotecnico();
			Assert.assertNotNull(conceptoTecnicoService.getAllNotEndWithBy(area));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllContainBy() {
		
		try {
			Conceptotecnico area = new Conceptotecnico();
			Assert.assertNotNull(conceptoTecnicoService.getAllContainBy(area));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotContainBy() {
		
		try {
			Conceptotecnico area = new Conceptotecnico();
			Assert.assertNotNull(conceptoTecnicoService.getAllNotContainBy(area));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllIsNullBy() {
		
		try {
			Conceptotecnico area = new Conceptotecnico();
			Assert.assertNotNull(conceptoTecnicoService.getAllIsNullBy(area));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	//@Ignore
	public void getAllNotIsNullBy() {
		
		try {
			Conceptotecnico area = new Conceptotecnico();
			Assert.assertNotNull(conceptoTecnicoService.getAllNotIsNullBy(area));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	
	@Test
	//@Ignore
	public void save() {
		
		try {
			Conceptotecnico area = new Conceptotecnico();
			area.setCodigoconceptotecnico("z");
			area.setNombreconceptotecnico("z");
			Assert.assertEquals(conceptoTecnicoService.save(area), true);
			Assert.assertNotNull(conceptoTecnicoService.get(area.getCodigoconceptotecnico()));
			area.setNombreconceptotecnico("zz");
			Assert.assertEquals(conceptoTecnicoService.update(area), true);			
			Assert.assertEquals(conceptoTecnicoService.delete(area.getCodigoconceptotecnico()), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	@Ignore
	public void update() {
		
		try {
			Conceptotecnico area = new Conceptotecnico();
			area.setCodigoconceptotecnico("z");
			area.setNombreconceptotecnico("zz");
			Assert.assertEquals(conceptoTecnicoService.update(area), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void delete() {
		
		try {
			String id = "z";
			Assert.assertEquals(conceptoTecnicoService.delete(id), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	

}
