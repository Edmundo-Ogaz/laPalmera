/* global define, describe, it, should */
define(['page', 'loginController', 'homeController', 'ciudadController', 'regionController', 'ingredienteController', 
        'lineaProduccionConsultaController', 'ubicacionConsultaController', 'stockConsultaController', 'solicitudProductoController', 
        'solicitudProductoClienteController', 'ingresoInsumoController', 'capturaProduccionConsultaController', 'devolucionInsumoConsultaController',
        'entregaInsumoConsultaController', 'confirmaPedidoListaController'], 
		function (page, loginController, homeController, ciudadController, regionController, ingredienteController,
				lineaProduccionConsultaController, ubicacionConsultaController, stockConsultaController, solicitudProductoController, 
				solicitudProductoClienteController, ingresoInsumoController, capturaProduccionConsultaController, devolucionInsumoConsultaController,
				entregaInsumoConsultaController, confirmaPedidoListaController) {
    'use strict';

    describe('page', function () {
    	it('should exist', function() {
            should.exist(page);
        });
    	describe('Login', function () {
	        it("loging user and go to home page", function() {
	        	var resp = '';
	        	//load components
	        	$("#test").html(page.login.get());
	        	loginController.init();
	        	//listener components
	        	$('#button').on('click', function(e) {
	        		console.log("loging test");
	        		resp = e.result;
	            });
	        	//execute components
	        	$("#test #username").val("jochua");
	        	$("#test #password").val("jochua");       	
	        	$("#test #button").trigger("click");
	        	//test
	        	resp.should.equal('http://localhost:8081/LaPalmeraHJSH/test.html#/home.html');
			});	        
	        it("logout user", function() {
	        	var resp = '';
	        	//load components
	        	$("#test").html(page.home.get());
	        	homeController.init();
	        	//listener components
	        	$('#salir').on('click', function(e) {
	        		console.log("loguot test");
	        		resp = e.result;
	            });
	        	//execute components
	        	$("#test #salir").trigger("click");
	        	//test
	        	resp.should.equal('http://localhost:8081/LaPalmeraHJSH/test.html#/login.html');
			});
    	});
    	
    	describe('La Palmera', function () {
	        it("brand", function() {
	        	var resp = '';
	        	//load components
	        	$("#test").html(page.home.get());
	        	homeController.init();
	        	$('#menu #brand').on('click', function(e) {
	            	console.log("brand click event test");
	            	return this.href;
	            });
	        	//listener components
	        	$('#menu #brand').on('click', function(e) {
	        		console.log("brand listener event test");
	        		resp = e.result;
	            });
	        	//execute components
	        	$("#test #brand").click();
	        	//test
	        	resp.should.equal('http://localhost:8081/LaPalmeraHJSH/test.html#');
			});
    	});
//    	describe('Ciudad', function () {
//	        it("linck ciudad", function() {
//	        	setTimeout(function() {
//		        	window.location.href = $('#ciudad').attr('href');
//		        	window.location.href.should.equal('http://localhost:8081/LaPalmeraHJSH/test.html#/ciudad');
//	        	}, 10);
//			});
//	        it("page ciudad", function() {
//	        	setTimeout(function() {
//		        	$("#titulo").html().should.equal('Ciudad');
//	        	} ,10);
//			});
//    	});
    	describe('Ciudad', function () {
	        it("page ciudad", function() {
	        	ciudadController.init();
		        $("#titulo").html().should.equal('Ciudad');	        	
			});
    	});
//    	describe('Region', function () {
//	        it("region", function() {
//	        	setTimeout(function() {
//	        		window.location.href = $('#region').attr('href');
//	        		window.location.href.should.equal('http://localhost:8081/LaPalmeraHJSH/test.html#/region');
//	        	}, 10);
//			});
//	        it("page región", function() {
//	        	setTimeout(function() {
//		        	$("#titulo").html().should.equal('Región');
//	        	}, 10);
//			});
//    	});
    	describe('Region', function () {
	        it("page región", function() {
	        	regionController.init();
		        $("#titulo").html().should.equal('Región');
			});
    	});
//    	describe('Consulta Ingrediente', function () {
//	        it("link consulta ingrediente", function() {
//	        	setTimeout(function() {
//		        	window.location.href = $('#ingredienteConsulta').attr('href');
//		        	window.location.href.should.equal('http://localhost:8081/LaPalmeraHJSH/test.html#/ingredienteConsulta');
//	        	}, 10);
//			});
//	        it("page consulta ingrediente", function() {
//	        	setTimeout(function() {
//		        	$("#titulo").html().should.equal('Consulta Ingrediente');
//	        	}, 10);
//			});
//    	});
    	describe('Consulta Ingrediente', function () {
	        it("page consulta ingrediente", function() {
	        	ingredienteController.init();
		        $("#titulo").html().should.equal('Consulta Ingrediente');
			});
    	});
//    	describe('Consulta Linea Producción', function () {
//	        it("link consulta linea produccion", function() {
//	        	setTimeout(function() {
//		        	window.location.href = $('#lineaProduccionConsulta').attr('href');
//		        	window.location.href.should.equal('http://localhost:8081/LaPalmeraHJSH/test.html#/lineaProduccionConsulta');
//	        	}, 10);
//			});
//	        it("page consulta linea produccion", function() {
//	        	setTimeout(function() {
//		        	$("#titulo").html().should.equal('Consulta Linea Producción');
//	        	}, 10);
//			});
//    	});
    	describe('Consulta Linea Producción', function () {
	        it("page consulta linea produccion", function() {
	        	lineaProduccionConsultaController.init();
		        $("#titulo").html().should.equal('Consulta Linea Producción');
			});
    	});
//    	describe('Consulta Ubicación', function () {
//	        it("link consulta ubicacion", function() {
//	        	setTimeout(function() {
//		        	window.location.href = $('#ubicacionConsulta').attr('href');
//		        	window.location.href.should.equal('http://localhost:8081/LaPalmeraHJSH/test.html#/ubicacionConsulta');
//	        	}, 10);
//			});
//	        it("page consulta ubicacion", function() {
//	        	setTimeout(function() {
//		        	$("#titulo").html().should.equal('Consulta Ubicación');
//	        	}, 10);
//			});
//    	});
    	describe('Consulta Ubicación', function () {
	        it("page consulta ubicacion", function() {
	        	ubicacionConsultaController.init();
		        $("#titulo").html().should.equal('Consulta Ubicación');
			});
    	});
//    	describe('Consulta Stock', function () {
//	        it("link consulta stock", function() {
//	        	setTimeout(function() {
//		        	window.location.href = $('#stockConsulta').attr('href');
//		        	window.location.href.should.equal('http://localhost:8081/LaPalmeraHJSH/test.html#/stockConsulta');
//	        	}, 10);
//			});
//	        it("page consulta stock", function() {
//	        	setTimeout(function() {
//		        	$("#titulo").html().should.equal('Consulta Stock');
//	        	}, 10);
//			});
//    	});
    	describe('Consulta Stock', function () {
	        it("page consulta stock", function() {
	        	stockConsultaController.init();
		        $("#titulo").html().should.equal('Consulta Stock');
			});
    	});
//    	describe('Solicitud Producto', function () {
//	        it("link transaccion solicitud producto", function() {
//	        	setTimeout(function() {
//		        	window.location.href = $('#solicitudProducto').attr('href');
//		        	window.location.href.should.equal('http://localhost:8081/LaPalmeraHJSH/test.html#/solicitudProducto');
//	        	}, 10);
//			});
//	        it("page transaccion solicitud producto", function() {
//	        	setTimeout(function() {
//		        	$("#titulo").html().should.equal('Solicitud Producto');
//	        	}, 10);
//			});
//    	});
    	describe('Solicitud Producto', function () {
	        it("page transaccion solicitud producto", function() {
	        	solicitudProductoController.init();
		        $("#titulo").html().should.equal('Solicitud Producto');
			});
    	});
//    	describe('Solicitud Producto Cliente', function () {
//	        it("link transaccion solicitud producto cliente", function() {
//	        	setTimeout(function() {
//		        	window.location.href = $('#solicitudProductoCliente').attr('href');
//		        	window.location.href.should.equal('http://localhost:8081/LaPalmeraHJSH/test.html#/solicitudProductoCliente');
//	        	}, 10);
//			});
//	        it("page transaccion solicitud producto cliente", function() {
//	        	setTimeout(function() {
//		        	$("#titulo").html().should.equal('Solicitud Producto Cliente');
//	        	}, 10);
//			});
//    	});
    	describe('Solicitud Producto Cliente', function () {
	        it("page transaccion solicitud producto cliente", function() {
	        	solicitudProductoClienteController.init();
		        $("#titulo").html().should.equal('Solicitud Producto Cliente');
			});
    	});
//    	describe('Ingreso Insumo', function () {
//	        it("link transaccion ingreso insumo", function() {
//	        	setTimeout(function() {
//		        	window.location.href = $('#ingresoInsumo').attr('href');
//		        	window.location.href.should.equal('http://localhost:8081/LaPalmeraHJSH/test.html#/ingresoInsumo');
//	        	}, 10);
//			});
//	        it("page transaccion ingreso insumo", function() {
//	        	setTimeout(function() {
//		        	$("#titulo").html().should.equal('Ingreso Insumo');
//	        	}, 10);
//			});
//    	});
    	describe('Ingreso Insumo', function () {
	        it("page transaccion ingreso insumo", function() {
	        	ingresoInsumoController.init();
		        $("#titulo").html().should.equal('Ingreso Insumo');
			});
    	});
//    	describe('Captura Producción', function () {
//	        it("link transaccion captura producción", function() {
//	        	setTimeout(function() {
//		        	window.location.href = $('#capturaProduccion').attr('href');
//		        	window.location.href.should.equal('http://localhost:8081/LaPalmeraHJSH/test.html#/capturaProduccion');
//	        	}, 10);
//			});
//	        it("page transaccion captura producción", function() {
//	        	setTimeout(function() {
//		        	$("#titulo").html().should.equal('Captura Producción');
//	        	}, 10);
//			});
//    	});
    	describe('Captura Producción', function () {
	        it("page transaccion captura producción", function() {
	        	capturaProduccionConsultaController.init();
		        $("#titulo").html().should.equal('Captura Producción');
			});
    	});
//    	describe('Devolución Insumo', function () {
//	        it("link transaccion devolución insumo", function() {
//	        	setTimeout(function() {
//		        	window.location.href = $('#devolucionInsumo').attr('href');
//		        	window.location.href.should.equal('http://localhost:8081/LaPalmeraHJSH/test.html#/devolucionInsumo');
//	        	}, 10);
//			});
//	        it("page transaccion devolución insumo", function() {
//	        	setTimeout(function() {
//		        	$("#titulo").html().should.equal('Devolución Insumo');
//	        	}, 10);
//			});
//    	});
    	describe('Devolución Insumo', function () {
	        it("page transaccion devolución insumo", function() {
	        	devolucionInsumoConsultaController.init();
		        $("#titulo").html().should.equal('Devolución Insumo');
			});
    	});
//    	describe('Entrega Insumo', function () {
//	        it("link transaccion entrega insumo", function() {
//	        	setTimeout(function() {
//		        	window.location.href = $('#/entregaInsumo').attr('href');
//		        	window.location.href.should.equal('http://localhost:8081/LaPalmeraHJSH/test.html#/entregaInsumo');
//	        	}, 10);
//			});
//	        it("page transaccion entrega insumo", function() {
//	        	setTimeout(function() {
//		        	$("#titulo").html().should.equal('Entrega Insumo');
//	        	}, 10);
//			});
//    	});
    	describe('Entrega Insumo', function () {
	        it("page transaccion entrega insumo", function() {
	        	entregaInsumoConsultaController.init();
		        $("#titulo").html().should.equal('Entrega Insumo');
			});
    	});
    	describe('Confirma Pedido', function () {
	        it("page transaccion sub menú confirma pedido", function() {
	        	confirmaPedidoListaController.init();
		        $("#titulo").html().should.equal('Lista Confirmación Pedido');
			});
    	});  
    });
});