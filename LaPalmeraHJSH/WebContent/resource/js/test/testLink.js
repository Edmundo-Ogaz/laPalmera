/* global define, describe, it, should */
define(['page', 'loginController', 'homeController', 'ciudadController', 'regionController', 'ingredienteController', 
        'lineaProduccionConsultaController', 'ubicacionConsultaController', 'stockConsultaController', 'solicitudProductoController', 
        'solicitudProductoClienteController', 'ingresoInsumoController', 'capturaProduccionConsultaController', 'devolucionInsumoConsultaController',
        'entregaInsumoConsultaController'], 
		function (page, loginController, homeController, ciudadController, regionController, ingredienteController,
				lineaProduccionConsultaController, ubicacionConsultaController, stockConsultaController, solicitudProductoController, 
				solicitudProductoClienteController, ingresoInsumoController, capturaProduccionConsultaController, devolucionInsumoConsultaController,
				entregaInsumoConsultaController) {
    'use strict';

    describe('link', function () {
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
	        	resp.should.equal('http://localhost:8081/LaPalmeraHJSH/home.html');
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
	        	resp.should.equal('http://localhost:8081/LaPalmeraHJSH/login.html');
			});
    	});
    	
    	describe('La Palmera', function () {
	        it("link brand", function() {
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
    	describe('Mantenedor Ciudad', function () {
	        it("linck mantenedor ciudad", function() {
	        	setTimeout(function() {
		        	window.location.href = $('#ciudad').attr('href');
		        	window.location.href.should.equal('http://localhost:8081/LaPalmeraHJSH/test.html#/ciudad');
	        	}, 10);
			});
    	});
    	describe('Mantenedor Region', function () {
	        it("link mantenedor región", function() {
	        	setTimeout(function() {
	        		window.location.href = $('#region').attr('href');
	        		window.location.href.should.equal('http://localhost:8081/LaPalmeraHJSH/test.html#/region');
	        	}, 10);
			});
    	});
    	describe('Consulta Ingrediente', function () {
	        it("link consulta ingrediente", function() {
	        	setTimeout(function() {
		        	window.location.href = $('#ingredienteConsulta').attr('href');
		        	window.location.href.should.equal('http://localhost:8081/LaPalmeraHJSH/test.html#/ingredienteConsulta');
	        	}, 10);
			});
    	});
    	describe('Consulta Linea Producción', function () {
	        it("link consulta linea produccion", function() {
	        	setTimeout(function() {
		        	window.location.href = $('#lineaProduccionConsulta').attr('href');
		        	window.location.href.should.equal('http://localhost:8081/LaPalmeraHJSH/test.html#/lineaProduccionConsulta');
	        	}, 10);
			});
    	});
    	describe('Consulta Ubicación', function () {
	        it("link consulta ubicacion", function() {
	        	setTimeout(function() {
		        	window.location.href = $('#ubicacionConsulta').attr('href');
		        	window.location.href.should.equal('http://localhost:8081/LaPalmeraHJSH/test.html#/ubicacionConsulta');
	        	}, 10);
			});
    	});
    	describe('Consulta Stock', function () {
	        it("link consulta stock", function() {
	        	setTimeout(function() {
		        	window.location.href = $('#stockConsulta').attr('href');
		        	window.location.href.should.equal('http://localhost:8081/LaPalmeraHJSH/test.html#/stockConsulta');
	        	}, 10);
			});
    	});
    	describe('Solicitud Producto', function () {
	        it("link transaccion solicitud producto", function() {
	        	setTimeout(function() {
		        	window.location.href = $('#solicitudProducto').attr('href');
		        	window.location.href.should.equal('http://localhost:8081/LaPalmeraHJSH/test.html#/solicitudProducto');
	        	}, 10);
			});
    	});
    	describe('Solicitud Producto Cliente', function () {
	        it("link transaccion solicitud producto cliente", function() {
	        	setTimeout(function() {
		        	window.location.href = $('#solicitudProductoCliente').attr('href');
		        	window.location.href.should.equal('http://localhost:8081/LaPalmeraHJSH/test.html#/solicitudProductoCliente');
	        	}, 10);
			});
    	});
    	describe('Ingreso Insumo', function () {
	        it("link transaccion ingreso insumo", function() {
	        	setTimeout(function() {
		        	window.location.href = $('#ingresoInsumo').attr('href');
		        	window.location.href.should.equal('http://localhost:8081/LaPalmeraHJSH/test.html#/ingresoInsumo');
	        	}, 10);
			});
    	});
    	describe('Captura Producción', function () {
	        it("link transaccion captura producción", function() {
	        	setTimeout(function() {
		        	window.location.href = $('#capturaProduccion').attr('href');
		        	window.location.href.should.equal('http://localhost:8081/LaPalmeraHJSH/test.html#/capturaProduccion');
	        	}, 10);
			});
    	});
    	describe('Devolución Insumo', function () {
	        it("link transaccion devolución insumo", function() {
	        	setTimeout(function() {
		        	window.location.href = $('#devolucionInsumo').attr('href');
		        	window.location.href.should.equal('http://localhost:8081/LaPalmeraHJSH/test.html#/devolucionInsumo');
	        	}, 10);
			});
    	});
    	describe('Entrega Insumo', function () {
	        it("link transaccion entrega insumo", function() {
	        	setTimeout(function() {
		        	window.location.href = $('#entregaInsumo').attr('href');
		        	window.location.href.should.equal('http://localhost:8081/LaPalmeraHJSH/test.html#/entregaInsumo');
	        	}, 10);
			});
    	});
    	describe('Confirmación Pedido', function () {
	        it("link transaccion sub menú pedido Confirmación Pedido", function() {
	        	setTimeout(function() {
		        	window.location.href = $('#confirmaPedidoLista').attr('href');
		        	window.location.href.should.equal('http://localhost:8081/LaPalmeraHJSH/test.html#/confirmaPedidoLista');
	        	}, 10);
			});
    	});
    });
});