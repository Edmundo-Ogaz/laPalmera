package cl.obam.pasteleria.lapalmera.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Cabezapedido;
import cl.obam.pasteleria.lapalmera.model.Confirmacionpedido;
import cl.obam.pasteleria.lapalmera.model.Despachopedido;
import cl.obam.pasteleria.lapalmera.model.Detallepedido;
import cl.obam.pasteleria.lapalmera.model.Especificarproduccion;
import cl.obam.pasteleria.lapalmera.model.Estadoordenfabricacion;
import cl.obam.pasteleria.lapalmera.model.Estadopedido;
import cl.obam.pasteleria.lapalmera.model.Lineaproduccion;
import cl.obam.pasteleria.lapalmera.model.Ordenfabricacion;
import cl.obam.pasteleria.lapalmera.model.Producto;
import cl.obam.pasteleria.lapalmera.model.Productolinea;
import cl.obam.pasteleria.lapalmera.model.Programarproduccion;
import cl.obam.pasteleria.lapalmera.service.CabezaPedidoService;
import cl.obam.pasteleria.lapalmera.service.OrdenFabricacionService;
import cl.obam.pasteleria.lapalmera.view.CabezaPedidoVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class CabezaPedidoSeviceTest {
	
	@Autowired
	private CabezaPedidoService cabezaPedidoService;
	@Autowired
	private OrdenFabricacionService ordenFabricacionService;
	
	@Test
	@Ignore
	public void getAll() {
		
		try {
			List<Cabezapedido> listCabezaPedido = cabezaPedidoService.getAll();
			Assert.assertNotNull(listCabezaPedido);
			List<Object> list = new ArrayList<Object>();
			for (Cabezapedido cabezaPedido : listCabezaPedido) {
//				list.add(new CabezaPedidoVO(cabezaPedido.getNumeropedido(), 
//						cabezaPedido.getNombrecliente(), 
//						cabezaPedido.getFechapedido(),
//						cabezaPedido.getHorapedido(), 
//						cabezaPedido.getPreciototalpedido(), 
//						cabezaPedido.getEstadoconfirmacionpedido(), 
//						cabezaPedido.getObservacionpedido()));
			}
			Assert.assertTrue(list.size() > 1);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void getAllEqBy() {
		
		try {
			Cabezapedido cabezaPedido = new Cabezapedido();
			Assert.assertNotNull(cabezaPedidoService.getAllEqBy(cabezaPedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllNotEqBy() {
		
		try {
			Cabezapedido cabezaPedido = new Cabezapedido();
			Assert.assertNotNull(cabezaPedidoService.getAllNotEqBy(cabezaPedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
					
	@Test
	@Ignore
	public void getAllBeginWithBy() {
		
		try {
			Cabezapedido cabezaPedido = new Cabezapedido();
			Assert.assertNotNull(cabezaPedidoService.getAllBeginWithBy(cabezaPedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllNotBeginWithBy() {
		
		try {
			Cabezapedido cabezaPedido = new Cabezapedido();
			Assert.assertNotNull(cabezaPedidoService.getAllNotBeginWithBy(cabezaPedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllEndWithBy() {
		
		try {
			Cabezapedido cabezaPedido = new Cabezapedido();
			Assert.assertNotNull(cabezaPedidoService.getAllEndWithBy(cabezaPedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllNotEndWithBy() {
		
		List<Cabezapedido> list = null;
		try {
			Cabezapedido cabezaPedido = new Cabezapedido();
			Assert.assertNotNull(cabezaPedidoService.getAllNotEndWithBy(cabezaPedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllContainBy() {
		
		try {
			Cabezapedido cabezaPedido = new Cabezapedido();
			Assert.assertNotNull(cabezaPedidoService.getAllContainBy(cabezaPedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllNotContainBy() {
		
		try {
			Cabezapedido cabezaPedido = new Cabezapedido();
			Assert.assertNotNull(cabezaPedidoService.getAllNotContainBy(cabezaPedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllIsNullBy() {
		
		try {
			Cabezapedido cabezaPedido = new Cabezapedido();
			Assert.assertNotNull(cabezaPedidoService.getAllIsNullBy(cabezaPedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllNotIsNullBy() {
		
		try {
			Cabezapedido cabezaPedido = new Cabezapedido();
			Assert.assertNotNull(cabezaPedidoService.getAllNotIsNullBy(cabezaPedido));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	
	@Test
	//@Ignore
	public void save() {
		
		try {
			/***Estadopedido***/
			String codigoestadopedido = "C";		
			Estadopedido estadopedido = new Estadopedido(codigoestadopedido);
			
			/***Producto***/
			String codigoproducto = "I01C01C01";
			Producto producto = new Producto();
			producto.setCodigoproducto(codigoproducto);
			
			/***Detallepedido***/
			Cabezapedido nullcabezaPedido = null;
			//Producto producto = "II";
			Integer precioproducto = 10000;
			Integer cantidadproducto = 2;			
			Detallepedido detallepedido = new Detallepedido(nullcabezaPedido, producto, precioproducto, cantidadproducto);
			
			/***Despachopedido***/
			//Cabezapedido cabezaPedido = null;
			String nombrecliente = "Pasteler�a La Palmera";
			String direcciondespacho = "Venta";
			Date fechaentregadespacho = new Date();
			Date horaentregadespacho = new Date();			
			Despachopedido despachopedido = new Despachopedido(nullcabezaPedido, nombrecliente, direcciondespacho, fechaentregadespacho, horaentregadespacho);
			
			/***Confirmacionpedido***/
			//cabezapedido, 
			//nombrecliente, 
			String apellidocliente = "Pastelera La Palmera";
			String direccioncliente = "Ventas";
			Integer telefonocliente = 268898;			
			Confirmacionpedido confirmacionpedido = new Confirmacionpedido(nullcabezaPedido, nombrecliente, apellidocliente, direccioncliente, telefonocliente);
			
			//estadopedido = 
			//String nombrecliente = "Pasteler�a La Palmera";
			Date fechapedido = new Date();
			Date horapedido = new Date();
			Integer preciototalpedido = 10000; 
			String dedicatoriapedido = "dedicatoria";
			String observacionpedido = "comentario";
			//detallepedido
			//despachopedido, 
			//confirmacionpedido = "C";
			Set<Ordenfabricacion> setordenfabricacions = null;
			Cabezapedido cabezapedido = new Cabezapedido(estadopedido, nombrecliente, fechapedido, horapedido, preciototalpedido, dedicatoriapedido, observacionpedido, detallepedido, despachopedido, confirmacionpedido, setordenfabricacions);
			//detallepedido.setCabezapedido(cabezapedido);
			
			
			
			//new Detallepedido()
			detallepedido.setCabezapedido(cabezapedido);
			Assert.assertEquals(cabezaPedidoService.create(cabezapedido), true);
			
			/*************************************************************************************************************************/
			
			/***Estadoordenfabricacion***/
			String codigoestadoordenfabricacion = "A";			
			Estadoordenfabricacion estadoordenfabricacion = new Estadoordenfabricacion(codigoestadoordenfabricacion);
			
			/***Lineaproduccion***/
			String codigolineaproduccion = "M01"; 
			Lineaproduccion lineaproduccion = new Lineaproduccion(codigolineaproduccion);
			
			/***Programarproduccion***/
			Ordenfabricacion nullordenfabricacion = null;
			Date fechaprogramaproduccion = new Date(); 
			Date horaprogramaproduccion = new Date();
			//String codigoproducto = producto.getCodigoproducto();
			Integer cantidadprogramada = 2;
			Integer cantidadfabricada = 0;
			Integer saldoporfabricar = 2;
			Especificarproduccion nullespecificarproduccion = null;
			Programarproduccion programarproduccion = new Programarproduccion(nullordenfabricacion, estadoordenfabricacion, lineaproduccion, fechaprogramaproduccion, horaprogramaproduccion, codigoproducto, cantidadprogramada, cantidadfabricada, saldoporfabricar, nullespecificarproduccion);
						
			/***Ordenfabricacion***/
			String codigoordenfabricacion = "1-1";
			//cabezapedido, 
			//producto, 
			Date fechaingresoordenfabricacion = new Date();
			Date horaingresoordenfabricacion = new Date();
			//Integer cantidadproducto = 2;
			//Programarproduccion nullprogramarproduccion = null;
			Ordenfabricacion ordenfabricacion = new Ordenfabricacion(codigoordenfabricacion, nullcabezaPedido, producto, fechaingresoordenfabricacion, horaingresoordenfabricacion, cantidadproducto, programarproduccion);
			
			//Assert.assertEquals(ordenFabricacionService.save(ordenfabricacion), true);
			
			//Assert.assertNotNull(cabezaPedidoService.get(Integer.toString(cabezaPedido.getNumeropedido())));
			//cabezaPedido.setNombrecliente("zz");
			//Assert.assertEquals(cabezaPedidoService.update(cabezaPedido), true);			
			//Assert.assertEquals(cabezaPedidoService.delete(Integer.toString(cabezaPedido.getNumeropedido())), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	@Ignore
	public void update() {
		
		try {
			Cabezapedido cabezaPedido = new Cabezapedido();
			cabezaPedido.setNumeropedido(1);
			cabezaPedido.setNombrecliente("zz");
			Assert.assertEquals(cabezaPedidoService.update(cabezaPedido), true);
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
			Assert.assertEquals(cabezaPedidoService.delete(id), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	

}
