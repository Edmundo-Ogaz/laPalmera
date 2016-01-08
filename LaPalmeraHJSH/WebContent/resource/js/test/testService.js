/* global define, describe, it, should */
define(['service', 'moment'], function (service, moment) {
    'use strict';

    describe('service', function () {
    	it('should exist', function() {
            should.exist(service);
        });
    	
    	describe('usuario', function () {
	        it("login should equal true", function() {
	        	var usuario = {"username" : "administrador", "password" : "jochua"};				
	        	var resp = service.usuario.login(usuario);
				var login = resp;
	        	login.should.equal(true);
			});
	        it("logout should equal true", function() {
	        	var resp = service.usuario.logout();
				var logout = resp;
				logout.should.equal(true);
			});
    	});
    	
    	describe('región', function () {
	        it("getAll expect región to be array", function() {
				var resp = service.region.getAll();
				var regions = resp;
    			expect(regions).to.be.instanceof(Array);
			});
//	        it("add region should expect to not equal false", function() {
//				var region = {"codigo" : "2", "nombre" : "2"};
//	        	var add = service.region.add(region);
//	        	expect(add).to.not.equal(false);
//			});
//	        it("update región expect to not equal false", function() {
//				var region = {"codigo" : "2", "nombre" : "22"};
//	        	var update = service.region.update(region);
//	        	expect(update).to.not.equal(false);				
//			});
//	        it("delete región expect to not equal false", function() {
//				var region = {"codigo" : "2"};
//	        	var del = service.region.del(region);
//	        	expect(del).to.not.equal(false);				
//			});
    	});
    	
    	describe('ciudad', function () {
	        it("getAll expect ciudad to have length above 0", function() {
				var resp = service.ciudad.getAll();
				var ciudads = resp;
    			expect(ciudads).to.be.instanceof(Array);
			});
//	        it("add ciudad expect to not equal false", function() {
//				var ciudad = {"codigo" : "2", "nombre" : "2", "region" : {"codigo" : "R01"}};
//	        	var add = service.ciudad.add(ciudad);
//	        	expect(add).to.not.equal(false);			
//			});
//	        it("update ciudad expect to not equal false", function() {
//				var ciudad = {"codigo" : "2", "nombre" : "22", "region" : {"codigo" : "R01"}};
//	        	var update = service.ciudad.update(ciudad);
//	        	expect(update).to.not.equal(false);				
//			});
//	        it("delete ciudad expect to not equal false", function() {
//				var ciudad = {"codigo" : "2"};
//	        	var del = service.ciudad.del(ciudad);
//	        	expect(del).to.not.equal(false);				
//			});
    	});
    	
    	describe('comuna', function () {
	        it("getAll expect comuna to have length above 0", function() {
				var resp = service.comuna.getAll();
				var comunas = resp;
    			expect(comunas).to.be.instanceof(Array);
			});
    	});
    	
    	describe('producto', function () {
    		it("get expect productos to be instanceof Object", function() {
				var resp = service.producto.get("I01C01C01");
				var producto = resp;
				expect(producto).to.be.instanceof(Object);
			});
    		it("getAll expect productos to be instanceof Array", function() {
				var resp = service.producto.getAll();
				var productos = resp;
				expect(productos).to.be.instanceof(Array);
			});
	        it("getAllNotEqBy expect productos to be instanceof Array", function() {
	        	var producto = {};
				var resp = service.producto.getAllNotEqBy(producto);
				var productos = resp;
				expect(productos).to.be.instanceof(Array);
			});	        
    	});
    	
    	describe('bodega', function () {
	        it("getAll expect bodegas to be instanceof Array", function() {
				var resp = service.bodega.getAll();
				var bodegas = resp;
				expect(bodegas).to.be.instanceof(Array);
			});	        
    	});
    	
    	describe('unidadMedida', function () {
    		it("getAll expect unidadMedidas to be instanceof Array", function() {
    			var resp = service.unidadMedida.getAll();
    			var unidadMedidas = resp;
    			expect(unidadMedidas).to.be.instanceof(Array);
    		});
    		it("getAllEqBy expect unidadMedidas to be instanceof Array", function() {
    			var unidadMedida = {};
    			var resp = service.unidadMedida.getAllEqBy(unidadMedida);
    			var unidadMedidas = resp;
    			expect(unidadMedidas).to.be.instanceof(Array);
    		});	
    	});
    	
    	describe('ubicacion', function () {
    		it("getAllEqBy expect ubicacions to be instanceof Array", function() {
    			var unidadMedida = {};
    			var resp = service.ubicacion.getAllEqBy(unidadMedida);
    			var ubicacions = resp;
    			expect(ubicacions).to.be.instanceof(Array);
    		});
//    		var add = null;
//	        it("add ubicacion expect to not equal false", function() {
//	        	var ubicacion = {'id' : null,
//								'producto' : {'codigo' : "T01E01D01"},
//								'bodega' : {'codigo' : "B01"},
//								'fechaIngreso' : moment().locale('es').format('YYYY-MM-DD HH:mm:ss'),
//								'horaIngreso' : moment().locale('es').format('YYYY-MM-DD HH:mm:ss'),
//								'fechaVencimiento' : moment().locale('es').format('YYYY-MM-DD HH:mm:ss'),
//								'cantidad' : 1,
//								'unidadMedida' : {'codigo' : "UND"},
//								'observacion' : "test"};
//	        	add = service.ubicacion.add(ubicacion);
//	        	expect(add).to.not.equal(false);
//			});
//	        it("update ubicacion expect to not equal false", function() {
//	        	var ubicacion = {'id' : add.id,
//						'producto' : {'codigo' : "T01E01D01"},
//						'bodega' : {'codigo' : "B01"},
//						'fechaIngreso' : moment().locale('es').format('YYYY-MM-DD HH:mm:ss'),
//						'horaIngreso' : moment().locale('es').format('YYYY-MM-DD HH:mm:ss'),
//						'fechaVencimiento' : moment().locale('es').format('YYYY-MM-DD HH:mm:ss'),
//						'cantidad' : 1,
//						'unidadMedida' : {'codigo' : "UND"},
//						'observacion' : "test"};
//	        	var update = service.ubicacion.update(ubicacion);
//	        	expect(update).to.not.equal(false);
//			});
//	        it("delete ubicacion expect to not equal false", function() {
//	        	var ubicacion = {'id' : add.id};
//	        	var del = service.ubicacion.del(ubicacion);
//	        	expect(del).to.not.equal(false);		
//			});
    	});
    	
    	describe('stock', function () {
    		it("getAllEqBy expect stocks to be instanceof Array", function() {
    			var stock = {};
    			var resp = service.stock.getAllEqBy(stock);
    			var stocks = resp;
    			expect(stocks).to.be.instanceof(Array);
    		});
    	});
    	
    	describe('ingrediente', function () {
    		it("getAllEqBy expect ingredientes to be instanceof Array", function() {
    			var ingrediente = {"producto" : {"codigo" : "T01E01D01"}};
    			var resp = service.ingrediente.getAllEqBy(ingrediente);
    			var ingredientes = resp;
    			expect(ingredientes).to.be.instanceof(Array);
    		});
//    		var add = null;
//	        it("add ingrediente expect to not equal false", function() {
//	        	var ingrediente = {'id' : null,
//	        					   'producto' : {'codigo' : "T01E01D01"},
//								   'insumo' : {'codigo' : "T01E01D01"},
//								   'carga':  1,
//								   'cantidadinsumo' : 1,
//								   'unidadMedida' : {'codigo' : "LTS"}
//								  };
//	        	add = service.ingrediente.add(ingrediente);
//	        	expect(add).to.not.equal(false);
//			});
//	        it("update ingrediente expect to not equal false", function() {
//	        	var ingrediente = {'id' : add.id,
//								   'producto' : {'codigo' : "T01E01D01"},
//								   'insumo' : {'codigo' : "T01E01D01"},
//								   'carga':  2,
//								   'cantidadinsumo' : 2,
//								   'unidadMedida' : {'codigo' : "LTS"}
//								  };
//	        	var update = service.ingrediente.update(ingrediente);
//	        	expect(update).to.not.equal(false);
//			});
//	        it("delete ingrediente expect to not equal false", function() {
//	        	var ingrediente = {'id' : add.id};
//	        	var del = service.ingrediente.del(ingrediente);
//	        	expect(del).to.not.equal(false);		
//			});
    	});
    	
    	describe('productoLinea', function () {
    		it("getAllEqBy expect productoLineas to be instanceof Array", function() {
    			var productoLinea = {};
    			var resp = service.productoLinea.getAllEqBy(productoLinea);
    			var productoLineas = resp;
    			expect(productoLineas).to.be.instanceof(Array);
    		});
//    		var add = null;
//	        it("add productoLinea expect to not equal false", function() {
//	        	var productoLinea = {'id' : null,
//									'producto' : {'codigo' : "T01E01D01"},
//									'lineaProduccion' : {'codigo' : "M03"},
//									'prioridad' : 3};
//	        	add = service.productoLinea.add(productoLinea);
//	        	expect(add).to.not.equal(false);
//			});
//	        it("update productoLinea expect to not equal false", function() {
//	        	var productoLinea = {'id' : add.id,
//									'producto' : {'codigo' : "T01E01D01"},
//									'lineaProduccion' : {'codigo' : "M03"},
//									'prioridad' : 4};
//	        	var update = service.productoLinea.update(productoLinea);
//	        	expect(update).to.not.equal(false);
//			});
//	        it("delete productoLinea expect to not equal false", function() {
//	        	var productoLinea = {'id' : add.id};
//	        	var del = service.productoLinea.del(productoLinea);
//	        	expect(del).to.not.equal(false);		
//			});
    	});
    	
    	describe('lineaProduccion', function () {
    		it("getAllEqBy expect lineaProduccion to be instanceof Array", function() {
    			var resp = service.lineaProduccion.getAll();
    			var lineaProduccions = resp;
    			expect(lineaProduccions).to.be.instanceof(Array);
    		});
    	});
    	
    	describe('pedido', function () {
    		it("get expect pedido to be instanceof Object", function() {
    			var resp = service.pedido.get("64");
    			var cabezaPedidos = resp;
    			expect(cabezaPedidos).to.be.instanceof(Object);
    		});
    	});
    	
    	describe('pedido ingresado', function () {
    		it("getAllEbBy expect pedido to be instanceof Array", function() {
    			var pedido = {estadoPedido : {codigo : 'I'}};
    			var resp = service.pedido.getAllEqBy(pedido);
    			var cabezaPedidos = resp;
    			expect(cabezaPedidos).to.be.instanceof(Array);
    		});
    	});
    	
    	describe('pedido confirmado', function () {
    		it("getAllEbBy expect pedido to be instanceof Array", function() {
    			var pedido = {estadoPedido : {codigo : 'C'}};
    			var resp = service.pedido.getAllEqBy(pedido);
    			var cabezaPedidos = resp;
    			expect(cabezaPedidos).to.be.instanceof(Array);
    		});
    	});
    	
    	describe('pedido Rechazado', function () {
    		it("getAllEbBy expect pedido to be instanceof Array", function() {
    			var pedido = {estadoPedido : {codigo : 'R'}};
    			var resp = service.pedido.getAllEqBy(pedido);
    			var cabezaPedidos = resp;
    			expect(cabezaPedidos).to.be.instanceof(Array);
    		});
    	});
    	
    	describe('pedido getAllEqBy', function () {
    		it("getAllEbBy expect pedido to be instanceof Array", function() {
    			var pedido = {numeroPedido : 73, cliente : {rut : '90145895'}, estadoPedido : {codigo : 'R'}};
    			var resp = service.pedido.getAllEqBy(pedido);
    			var cabezaPedidos = resp;
    			expect(cabezaPedidos).to.be.instanceof(Array);
    		});
    	});
    	
    	describe('funcionario', function () {
	        it("expect return true", function() {
				var funcionario = service.funcionario.getAll();
				expect(funcionario.length).to.be.above(0);
			});
    	});
    	
    	describe('cliente', function () {
    		it("get expect cliente to be instanceof Object", function() {
    			var resp = service.cliente.get("90145895");
    			var cliente = resp;
    			expect(cliente).to.be.instanceof(Object);
    		});
    	});
    	
    	describe('entrega', function () {
    		it("get expect entrega to be instanceof Array", function() {
    			var resp = service.entrega.getAll();
    			var entrega = resp;
    			expect(entrega).to.be.instanceof(Array);
    		});
    	});
    	
    	describe('estadoPedido', function () {
    		it("get expect estadoPedido to be instanceof Array", function() {
    			var resp = service.estadoPedido.getAll();
    			var estadoPedido = resp;
    			expect(estadoPedido).to.be.instanceof(Array);
    		});
    	});
    	
    	describe('estadoOrdenFabricacion', function () {
    		it("get expect estadoOrdenFabricacion to be instanceof Array", function() {
    			var resp = service.estadoOrdenFabricacion.getAll();
    			var estadoOrdenFabricacion = resp;
    			expect(estadoOrdenFabricacion).to.be.instanceof(Array);
    		});
    	});
    	
    	describe('ordenFabricacion', function () {
    		it("get expect ordenFabricacion to be instanceof Object", function() {
    			var resp = service.ordenFabricacion.get('12-1');
    			var ordenFabricacion = resp;
    			expect(ordenFabricacion).to.be.instanceof(Object);
    		});
    		it("getAllEqBy expect ordenFabricacion to be instanceof Array", function() {
    			var ordenFabricacion = {codigoOrdenFabricacion : '12-1'};
    			var resp = service.ordenFabricacion.getAllEqBy(ordenFabricacion);
    			var ordenFabricacion = resp;
    			expect(ordenFabricacion).to.be.instanceof(Array);
    		});
    	});
    	
//    	describe('ordenFabricacion', function () {
//    		
//    	});
    });
});