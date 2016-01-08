/* global define, describe, it, should */
define(['service', 'moment'], function (service, moment) {
    'use strict';

    describe('service', function () {
    	it('should exist', function() {
            should.exist(service);
        });
    	
//    	describe('ordenFabbricacion', function () {
//		it("save expect ordenFabricacion to be instanceof Object", function() {
//			
//			var clienteTipoCliente = "S01";
// 			var clienteRut = "90124578";
//			var clienteDv = "6";
//			var clienteNombre = "La Palmera";
//			var clienteDireccion = "R02C01C01";
//			var clienteComuna = "R02C01C01";	    			
//			var clienteTelefono = "11245799";
//			var clienteCelular = "45895536";
//			var clienteEmail = "laPalmera@gmail.com";
//			
//			var productoCodigo = "T01E01D01";
//			var cantidad = 1;
//			var precio = 1000;
//			var observacion = "test observacion producto1";
//			
//			var productoCodigo2 = "T01E01P01";
//			var cantidad2 = 2;
//			var precio2 = 2000;
//			var observacion2 = "test observacion producto2";
//			
//			var total = 3000;
//			
//			var date = moment().locale('es').format('YYYY-MM-DD HH:mm:ss');
//			
//			var pedido = {"cliente" : {"rut" : clienteRut, 
//										"dv" : clienteDv,
//										"nombre" : clienteNombre,
//										"comuna": {"codigo" : clienteComuna},
//										"tipoCliente" : {"codigo" : clienteTipoCliente},
//										"direccion" : clienteDireccion,
//										"telefono" : clienteTelefono,
//										"celular" : clienteCelular,
//										"email" : clienteEmail},
//		    			"detallePedidos" : [{"producto" : {"codigo": productoCodigo},
//											 "cantidadproducto": cantidad,
//											 "precioproducto" : precio,
//											 "observacion" : observacion},
//											{"producto" : {"codigo": productoCodigo2},
//											 "cantidadproducto": cantidad2,
//											 "precioproducto" : precio2,
//											 "observacion" : observacion2}],
//		    			"fechapedido": date,
//		    			"preciototalpedido": total,
//		    			"observacionpedido" : "test observacion",
//		    			"estadoPedido" : {"codigo" : "C"},
//		    			"despachoPedido" : {"nombrecliente" : "Este campo no va",
//		    								"lugarEntrega" : {"codigo" : "1"},
//		    								//"direcciondespacho" : "Venta",
//		    								"fechaentregadespacho" : date},
//		    			"confirmacionPedido" : {"nombrecliente" : "Este campo no va",
//		    									"apellidocliente" : "Este campo no va",
//		    									"direccioncliente" : "Este campo no va",
//		    									"fecha" : date},
//		    			"ordenFabricacions" : [{"programaProduccions" : [{
//		    																"fechaprogramaproduccion" : date,		
//		    																"cantidadprogramada" : cantidad,
//		    																"cantidadfabricada" : 0,
//		    																"saldoporfabricar" : cantidad,
//		    																"producto" : {"codigo" : productoCodigo},			    															  
//		    															}],
//		    									"producto" : {"codigo" : productoCodigo},
//		    									"cantidadProducto" : cantidad,
//		    									"fechaIngresoOrdenFabricacion" : date,
//		    									"estadoOrdenFabricacion" : "A",
//		    									},
//		    									{"programaProduccions" : [{
//		    																"fechaprogramaproduccion" : date,
//		    																"producto" : {"codigo" : productoCodigo2},					
//		    																"cantidadprogramada" : cantidad2,
//		    																"cantidadfabricada" : 0,
//		    																"saldoporfabricar" : cantidad2,			    															
//		    															}],
//		    									"producto" : {"codigo" : productoCodigo2},
//		    									"cantidadProducto" : cantidad2,
//		    									"fechaIngresoOrdenFabricacion" : date,
//		    									"estadoOrdenFabricacion" : "A",
//		    									}],
//						};
//			
//    		var add = service.pedido.save(pedido);
//    		expect(add).to.not.equal(false);
//		});
//	});
    	
    	describe('ordenFabricacion', function () {
    		it("update expect ordenFabricacion to be instanceof Object", function() {
    			
    			var ordenFabricacion = service.ordenFabricacion.get("12-1");
    			var programaProduccionLength = ordenFabricacion.programaProduccions.length;
    			
    			var cantidad = 10;
    			var lineaProduccionCodigo = 'M01';
    			var lineaProduccionNombre = 'Mesón 1';
				
				var programaProduccion = {"codigo" : ordenFabricacion.codigoOrdenFabricacion + '-' + (programaProduccionLength + 1), 									 	 							   	 
	 							   	 "fechaprogramaproduccion" : moment().locale('es').format('YYYY-MM-DD HH:mm:ss'),
	 							   	 "ordenFabricacion" : {"codigoOrdenFabricacion": ordenFabricacion.codigoOrdenFabricacion},
 									 "producto" : {"codigo" : ordenFabricacion.producto.codigo, "nombre" : ordenFabricacion.producto.nombre},
 									 "lineaProduccion": {'codigo' : lineaProduccionCodigo, "nombre" : lineaProduccionNombre},
 									 "cantidadprogramada" : cantidad,
 									 "cantidadfabricada" : 0,
 									 "saldoporfabricar" : cantidad,
 									 "active" : 1};
		 			
	 			ordenFabricacion.programaProduccions.push(programaProduccion);
    			
	    		var add = service.ordenFabricacion.save(ordenFabricacion);
	    		expect(add).to.not.equal(false);
    		});
    	});
    });
});