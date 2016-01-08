package cl.obam.pasteleria.lapalmera.test;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cl.obam.pasteleria.lapalmera.exception.BusinessException;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.service.SolicitudProductoService;
import cl.obam.pasteleria.lapalmera.view.SolicitudProductoVOString;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class SolicitudProductoSeviceTest {
	
	@Autowired
	private SolicitudProductoService solicitudProductoService;
	    	
	@Test
	//@Ignore
	public void save() {
		
//		String codigoestadopedido = "C";
		
//		String codigoproducto = "I01C01C01";
//		Integer cantidadproducto = 2;
//		Integer precioproducto = 10000;
//		Integer preciototalpedido = 10000; 
//		String dedicatoriapedido = "dedicatoria";
//		String observacionpedido = "comentario";
//		
//		Date fechaentregadespacho = new Date();
//		Date horaentregadespacho = new Date();
		
//		Date fechapedido = new Date();
//		Date horapedido = new Date();
//				
//		String nombrecliente = "Pasteler�a La Palmera";
//		String apellidocliente = "Pastelera La Palmera";
//		String direccioncliente = "Ventas";
//		Integer telefonocliente = 268898;
//		
//		String direcciondespacho = "Venta";
//		
//		String codigoestadoordenfabricacion = "A";
//		String codigolineaproduccion = "M01";
//		
//		Date fechaingresoordenfabricacion = new Date();
//		Date horaingresoordenfabricacion = new Date();
//		
//		Date fechaprogramaproduccion = new Date(); 
//		Date horaprogramaproduccion = new Date();
//		
//		Integer cantidadprogramada = cantidadproducto;
//		Integer cantidadfabricada = 0;
//		Integer saldoporfabricar = cantidadprogramada - cantidadfabricada;
//		
		try {
//			
//			/***Producto***/
//			Producto producto = new Producto(codigoproducto);
//			
//			/***Estadopedido***/		
//			Estadopedido estadopedido = new Estadopedido(codigoestadopedido);
//			
//			/***Cabezapedido***/
//			Cabezapedido cabezapedido = new Cabezapedido(estadopedido, nombrecliente, fechapedido, horapedido, preciototalpedido, dedicatoriapedido, observacionpedido, null, null, null, null);
//			
//			/***Detallepedido***/
//			Detallepedido detallepedido = new Detallepedido(cabezapedido, producto, precioproducto, cantidadproducto);
//			
//			/***Despachopedido***/			
//			Despachopedido despachopedido = new Despachopedido(cabezapedido, nombrecliente, direcciondespacho, fechaentregadespacho, horaentregadespacho);
//			
//			/***Confirmacionpedido***/		
//			Confirmacionpedido confirmacionpedido = new Confirmacionpedido(cabezapedido, nombrecliente, apellidocliente, direccioncliente, telefonocliente);
//			
//			/*************************************************************************************************************************/
//			
//			/***Ordenfabricacions***/
//			Ordenfabricacion ordenfabricacion = new Ordenfabricacion(null, cabezapedido, producto, fechaingresoordenfabricacion, horaingresoordenfabricacion, cantidadproducto, null);
//			Set<Ordenfabricacion> ordenfabricacions = new HashSet<Ordenfabricacion>();
//			ordenfabricacions.add(ordenfabricacion);
//			
//			/***Estadoordenfabricacion***/			
//			Estadoordenfabricacion estadoordenfabricacion = new Estadoordenfabricacion(codigoestadoordenfabricacion);
//			
//			/***Lineaproduccion***/
//			Lineaproduccion lineaproduccion = new Lineaproduccion(codigolineaproduccion);
//			
//			/***Programarproduccion***/
//			Programarproduccion programarproduccion = new Programarproduccion(ordenfabricacion, estadoordenfabricacion, lineaproduccion, fechaprogramaproduccion, horaprogramaproduccion, codigoproducto, cantidadprogramada, cantidadfabricada, saldoporfabricar, null);
//			Assert.assertEquals(solicitudProductoService.save(cabezapedido, detallepedido, despachopedido, confirmacionpedido,  ordenfabricacions, programarproduccion), true);
			
		    SolicitudProductoVOString solicitudProductoVO = new SolicitudProductoVOString(
		    		"T01E01P01", "2", "10000", "dedicatoria", "comentario", "10-10-2015 12:12:12", "10-10-2015 12:12:12");
		
			Assert.assertNotNull(solicitudProductoService.create(solicitudProductoVO));
		
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}