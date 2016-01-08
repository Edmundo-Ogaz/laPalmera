package cl.obam.pasteleria.lapalmera.test;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cl.obam.pasteleria.lapalmera.exception.BusinessException;
import cl.obam.pasteleria.lapalmera.exception.DAOException;
import cl.obam.pasteleria.lapalmera.model.Detalleentregainsumo;
import cl.obam.pasteleria.lapalmera.model.Entregainsumo;
import cl.obam.pasteleria.lapalmera.model.Funcionario;
import cl.obam.pasteleria.lapalmera.model.Ordenfabricacion;
import cl.obam.pasteleria.lapalmera.model.Producto;
import cl.obam.pasteleria.lapalmera.model.Stock;
import cl.obam.pasteleria.lapalmera.model.Ubicacion;
import cl.obam.pasteleria.lapalmera.service.EntregaInsumoService;
import cl.obam.pasteleria.lapalmera.service.FuncionarioService;
import cl.obam.pasteleria.lapalmera.service.StockService;
import cl.obam.pasteleria.lapalmera.service.UbicacionService;
import cl.obam.pasteleria.lapalmera.util.Mapper;
import cl.obam.pasteleria.lapalmera.view.EntregaInsumoVO;
import cl.obam.pasteleria.lapalmera.view.UbicacionVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/applicationContext.xml" })

public class EntregaInsumoSeviceTest {
	
	@Autowired
	private EntregaInsumoService entregaInsumoService;
	
	@Autowired
	private UbicacionService ubicacionService;
	
	@Autowired
	private StockService stockService;
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Test
	@Ignore
	public void getAll() {
		
		try {
			Assert.assertNotNull(entregaInsumoService.getAll());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void getAllEqBy() {
		
		try {
			Entregainsumo entregaInsumo = new Entregainsumo();
			Assert.assertNotNull(entregaInsumoService.getAllEqBy(entregaInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllNotEqBy() {
		
		try {
			Entregainsumo entregaInsumo = new Entregainsumo();
			Assert.assertNotNull(entregaInsumoService.getAllNotEqBy(entregaInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
					
	@Test
	@Ignore
	public void getAllBeginWithBy() {
		
		try {
			Entregainsumo entregaInsumo = new Entregainsumo();
			Assert.assertNotNull(entregaInsumoService.getAllBeginWithBy(entregaInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllNotBeginWithBy() {
		
		try {
			Entregainsumo entregaInsumo = new Entregainsumo();
			Assert.assertNotNull(entregaInsumoService.getAllNotBeginWithBy(entregaInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllEndWithBy() {
		
		try {
			Entregainsumo entregaInsumo = new Entregainsumo();
			Assert.assertNotNull(entregaInsumoService.getAllEndWithBy(entregaInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllNotEndWithBy() {
		
		List<Entregainsumo> list = null;
		try {
			Entregainsumo entregaInsumo = new Entregainsumo();
			Assert.assertNotNull(entregaInsumoService.getAllNotEndWithBy(entregaInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllContainBy() {
		
		try {
			Entregainsumo entregaInsumo = new Entregainsumo();
			Assert.assertNotNull(entregaInsumoService.getAllContainBy(entregaInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllNotContainBy() {
		
		try {
			Entregainsumo entregaInsumo = new Entregainsumo();
			Assert.assertNotNull(entregaInsumoService.getAllNotContainBy(entregaInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllIsNullBy() {
		
		try {
			Entregainsumo entregaInsumo = new Entregainsumo();
			Assert.assertNotNull(entregaInsumoService.getAllIsNullBy(entregaInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Test
	@Ignore
	public void getAllNotIsNullBy() {
		
		try {
			Entregainsumo entregaInsumo = new Entregainsumo();
			Assert.assertNotNull(entregaInsumoService.getAllNotIsNullBy(entregaInsumo));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	
	@Test
	//@Ignore
	public void save() {
		
		try {
			String codigoOrdenFabricacion = "9-1";
			String rutfuncionario = "15331265-6";
			String codigoInsumo = "I01C01L01";
			int cantidad = 2;
			String codigoUnidadMedida = "LTS";
			String observacion = "test";
			List<UbicacionVO> ubicacionsVO = new LinkedList<UbicacionVO>();
			ubicacionsVO.add(new UbicacionVO(15, null, null, null, null, null, null, null, null, null));
			
			/***Ordenfabricacion***/
			Ordenfabricacion ordenFabricacion = new Ordenfabricacion(codigoOrdenFabricacion);
			
			/***Funcionario***/
			Funcionario funcionario = funcionarioService.get(rutfuncionario);
//			Funcionario funcionario = new Funcionario();
//			funcionario.setRutfuncionario(rutfuncionario);
									
			/***Entregainsumo***/
			Entregainsumo entregaInsumo = new Entregainsumo(ordenFabricacion, funcionario, new Date(), new Date(), observacion, null);
			
			/***Producto***/
			Producto producto = new Producto();
			producto.setCodigoproducto(codigoInsumo);
			
			/***Ubicacion***/
			Set<Ubicacion> ubicacions = new HashSet<Ubicacion>();
			Ubicacion ubicacion = null;
			for(UbicacionVO ubicacionVO : ubicacionsVO) {
				ubicacion = ubicacionService.get(ubicacionVO.getId());
				Float cantidadUbicacion = ubicacion.getCantidad();
				if(cantidad > cantidadUbicacion) {
					throw new BusinessException("Cantidad mayor a ubicación elegida");
				} else {
					ubicacion.setCantidad(cantidadUbicacion - cantidad);
					ubicacions.add(ubicacion);
				}
			}
			producto.setUbicacions(ubicacions);
			
			/***Stock***/
			Stock stock = stockService.get(codigoInsumo);
			float stockDisponible = stock.getStockdisponible();
			if(cantidad > stockDisponible) {
				throw new BusinessException("Cantidad mayor a stock disponible");
			} else {
				stock.setStockdisponible(stockDisponible - cantidad);
			}			
			producto.setStock(stock);
			
			/***Detalleentregainsumo***/
			Detalleentregainsumo detalleEntregaInsumo = new Detalleentregainsumo(entregaInsumo, producto, cantidad, codigoUnidadMedida);
						
			entregaInsumo.setDetalleentregainsumo(detalleEntregaInsumo);
			
			//entregaInsumoService.save(entregaInsumo);
			Assert.assertEquals(entregaInsumoService.save(entregaInsumo), true);
			
			Assert.assertEquals(entregaInsumoService.delete(entregaInsumo.getCorrelativoentregainsumo()), true);
			
			EntregaInsumoVO entregaInsumoVO = Mapper.from(entregaInsumo);
			
			Assert.assertNotNull(entregaInsumo.getCorrelativoentregainsumo());
			Assert.assertNotNull(entregaInsumo.getFuncionario().getNombre());
			Assert.assertNotNull(entregaInsumo.getFuncionario().getApellidopaterno());
			Assert.assertNotNull(entregaInsumo.getFuncionario().getApellidomaterno());
			Assert.assertNotNull(entregaInsumo.getDetalleentregainsumo().getCantidadentregainsumo());
			Assert.assertNotNull(entregaInsumo.getDetalleentregainsumo().getUnidadmedida());
			Assert.assertNotNull(entregaInsumo.getFechaentregainsumo());
			Assert.assertNotNull(entregaInsumo.getHoraentregainsumo());
			Assert.assertNotNull(entregaInsumo.getObservacion());
			
			
			
			//Assert.assertNotNull(entregaInsumoService.get(Integer.toString(entregaInsumo.getCorrelativoentregainsumo())));
			//entregaInsumo.setObservacion("zz");
			//Assert.assertEquals(entregaInsumoService.update(entregaInsumo), true);			
			
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test
	@Ignore
	public void update() {
		
		try {
			Entregainsumo entregaInsumo = new Entregainsumo();
			entregaInsumo.setCorrelativoentregainsumo(1);
			entregaInsumo.setObservacion("zz");
			Assert.assertEquals(entregaInsumoService.update(entregaInsumo), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void delete() {
		
		try {
			int id = 1;
			Assert.assertEquals(entregaInsumoService.delete(id), true);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    	

}
