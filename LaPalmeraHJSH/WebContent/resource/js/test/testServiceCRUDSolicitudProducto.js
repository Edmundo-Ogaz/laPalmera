/* global define, describe, it, should */
define(['service', 'moment'], function (service, moment) {
    'use strict';

    describe('service', function () {
    	it('should exist', function() {
            should.exist(service);
        });    	
    	describe('solicitudProducto', function () {
    		it("save expect solicitudProducto to be instanceof Object", function() {
    			
    			var clienteTipoCliente = "S01";
	 			var clienteRut = "90124578";
    			var clienteDv = "6";
    			var clienteNombre = "La Palmera";
    			var clienteDireccion = "R02C01C01";
    			var clienteComuna = "R02C01C01";	    			
    			var clienteTelefono = "11245799";
    			var clienteCelular = "45895536";
    			var clienteEmail = "laPalmera@gmail.com";
    			
    			var productoCodigo = "T01E01D01";
    			var cantidad = 1;
    			var precio = 1000;
    			var observacion = "test observacion producto1";
    			
    			var productoCodigo2 = "T01E01P01";
    			var cantidad2 = 2;
    			var precio2 = 2000;
    			var observacion2 = "test observacion producto2";
    			
    			var total = 3000;
    			
    			var date = moment().locale('es').format('YYYY-MM-DD HH:mm:ss');
    			
    			var pedido = {"cliente" : {"rut" : clienteRut, 
											"dv" : clienteDv,
											"nombre" : clienteNombre,
											"comuna": {"codigo" : clienteComuna},
											"tipoCliente" : {"codigo" : clienteTipoCliente},
											"direccion" : clienteDireccion,
											"telefono" : clienteTelefono,
											"celular" : clienteCelular,
											"email" : clienteEmail},
			    			"detallePedidos" : [{"producto" : {"codigo": productoCodigo},
												 "cantidadproducto": cantidad,
												 "precioproducto" : precio,
												 "observacion" : observacion},
												{"producto" : {"codigo": productoCodigo2},
												 "cantidadproducto": cantidad2,
												 "precioproducto" : precio2,
												 "observacion" : observacion2}],
			    			"fechapedido": date,
			    			"preciototalpedido": total,
			    			"observacionpedido" : "test observacion",
			    			"estadoPedido" : {"codigo" : "C"},
			    			"despachoPedido" : {"nombrecliente" : "Este campo no va",
			    								"lugarEntrega" : {"codigo" : "1"},
			    								//"direcciondespacho" : "Venta",
			    								"fechaentregadespacho" : date},
			    			"confirmacionPedido" : {"nombrecliente" : "Este campo no va",
			    									"apellidocliente" : "Este campo no va",
			    									"direccioncliente" : "Este campo no va",
			    									"fecha" : date},
			    			"ordenFabricacions" : [{"programaProduccions" : [{
			    																"fechaprogramaproduccion" : date,		
			    																"cantidadprogramada" : cantidad,
			    																"cantidadfabricada" : 0,
			    																"saldoporfabricar" : cantidad,
			    																"producto" : {"codigo" : productoCodigo},			    															  
			    															}],
			    									"producto" : {"codigo" : productoCodigo},
			    									"cantidadProducto" : cantidad,
			    									"fechaIngresoOrdenFabricacion" : date,
			    									"estadoOrdenFabricacion" : "A",
			    									},
			    									{"programaProduccions" : [{
			    																"fechaprogramaproduccion" : date,
			    																"producto" : {"codigo" : productoCodigo2},					
			    																"cantidadprogramada" : cantidad2,
			    																"cantidadfabricada" : 0,
			    																"saldoporfabricar" : cantidad2,			    															
			    															}],
			    									"producto" : {"codigo" : productoCodigo2},
			    									"cantidadProducto" : cantidad2,
			    									"fechaIngresoOrdenFabricacion" : date,
			    									"estadoOrdenFabricacion" : "A",
			    									}],
							};
    			
	    		var add = service.pedido.save(pedido);
	    		expect(add).to.not.equal(false);
    		});
    	});
    	
//    	describe('solicitudProductoCliente', function () {
//    		it("add expect solicitudProductoCliente to be instanceof Object", function() {
//    			var productoCodigo = "T01E01D01";
//    			var productoCodigo2 = "T01E01P01";
//    			var cantidad = 1;
//    			var precio = 1000;
//    			var date = moment().locale('es').format('YYYY-MM-DD HH:mm:ss');
//    			var pedido = {"nombreCliente" : "Pastelería La Palmera",
//						    			"detallePedidos" : [{"producto" : {"codigo": productoCodigo}, 
//															"cantidadproducto": cantidad,
//															"precioproducto" : precio},
//															{"producto" : {"codigo": productoCodigo2}, 
//																"cantidadproducto": cantidad,
//																"precioproducto" : precio}],
//						    			"fechapedido": date,
//						    			"horapedido": date,
//						    			"preciototalpedido": precio,
//						    			"observacionpedido" : "test observacion",
//						    			"estadoPedido" : {"codigo" : "I"},
//						    			"despachoPedido" : {"nombrecliente" : "Pastelería La Palmera",
//    														"lugarEntrega" : {"codigo" : 1},
//						    								//"direcciondespacho" : "Venta",
//						    								"fechaentregadespacho" : date,
//						    								"horaentregadestacho" : date},
//						    			"confirmacionPedido" : {"nombrecliente" : "Pastelería La Palmera",
//						    									"apellidocliente" : "Pastelería La Palmera",
//						    									"direccioncliente" : "Ventas",
//						    									"telefonocliente" : 268898,
//						    									"fecha" : date,
//						    									"hora" : date},
//    									};
//    			
//	    		var add = service.pedido.save(pedido);
//	    		expect(add).to.not.equal(false);
//    		});
//    	});
    	
//    	describe('solicitudProductoCliente', function () {
//    		it("update expect solicitudProductoCliente to be instanceof Object", function() {
//    			var productoCodigo = "T01E01D01";
//    			var cantidad = 1;
//    			var precio = 1000;
//    			
//    			var productoCodigo2 = "T01E01P01";
//    			var cantidad2 = 2;
//    			var precio2 = 2000;
//    			
//    			var total = 3000;
//    			
//    			var date = moment().locale('es').format('YYYY-MM-DD HH:mm:ss');
//    			
//    			var pedido = {"nombreCliente" : "Pastelería La Palmera",
//						    			"detallePedidos" : [{"producto" : {"codigo": productoCodigo},
//															 "cantidadproducto": cantidad,
//															 "precioproducto" : precio},
//															{"producto" : {"codigo": productoCodigo2},
//															 "cantidadproducto": cantidad2,
//															 "precioproducto" : precio2}],
//						    			"fechapedido": date,
//						    			"horapedido": date,
//						    			"preciototalpedido": total,
//						    			"dedicatoriaPedido" : "test dedicatoria",
//						    			"observacionpedido" : "test observacion",
//						    			"estadoPedido" : {"codigo" : "C"},
//						    			"despachoPedido" : {"nombrecliente" : "Pastelería La Palmera",
//						    								"direcciondespacho" : "Venta",
//						    								"fechaentregadespacho" : date,
//						    								"horaentregadestacho" : date},
//						    			"confirmacionPedido" : {"nombrecliente" : "Pastelería La Palmera",
//						    									"apellidocliente" : "Pastelería La Palmera",
//						    									"direccioncliente" : "Ventas",
//						    									"telefonocliente" : 268898,
//						    									"fecha" : date,
//						    									"hora" : date},
//						    			"ordenFabricacions" : [{"programarProduccion" : {"estadoOrdenFabricacion" : "A",
//						    															"cantidadprogramada" : cantidad,
//						    															"cantidadfabricada" : 0,
//						    															"saldoporfabricar" : cantidad,
//						    															"producto" : {"codigo" : productoCodigo},
//						    															"fechaprogramaproduccion" : date,
//						    											    			"horaprogramaproduccion" : date,
//						    															},
//						    									"producto" : {"codigo" : productoCodigo},
//						    									"cantidadProducto" : cantidad,
//						    									"fechaIngresoOrdenFabricacion" : date,
//						    									"horaIngresoOrdenFabricacion" : date,
//						    									},
//						    									{"programarProduccion" : {"estadoOrdenFabricacion" : "A",
//						    															"cantidadprogramada" : cantidad2,
//						    															"cantidadfabricada" : 0,
//						    															"saldoporfabricar" : cantidad2,
//						    															"producto" : {"codigo" : productoCodigo2},
//						    															"fechaprogramaproduccion" : date,
//						    											    			"horaprogramaproduccion" : date,
//						    															},
//						    									"producto" : {"codigo" : productoCodigo2},
//						    									"cantidadProducto" : cantidad2,
//						    									"fechaIngresoOrdenFabricacion" : date,
//						    									"horaIngresoOrdenFabricacion" : date,
//						    									}],
//    									};
//    			
//	    		var add = service.pedido.save(pedido);
//	    		expect(add).to.not.equal(false);
//    		});
//    	});
    });
});