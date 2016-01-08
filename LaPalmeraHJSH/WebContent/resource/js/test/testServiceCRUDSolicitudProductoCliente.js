/* global define, describe, it, should */
define(['service', 'moment'], function (service, moment) {
    'use strict';

    describe('service', function () {
    	it('should exist', function() {
            should.exist(service);
        });
    	
    	/*describe('solicitudProductoCliente', function () {
    		it("add expect solicitudProductoCliente to be instanceof Object", function() {
    			
    			var clienteRut = "90124578";
    			var clienteDv = "6";
    			var clienteNombre = "La Palmera";
    			var clienteComuna = "R02C01C01";
    			var clienteTipoCliente = "S01";
    			var clienteDireccion = "R02C01C01";
    			var clienteTelefono = "11245799";
    			var clienteCelular = "45895536";
    					
    			var productoCodigo = "T01E01D01";
    			var productoCodigo2 = "T01E01P01";
    			var cantidad = 1;
    			var precio = 1000;
    			var date = moment().locale('es').format('YYYY-MM-DD HH:mm:ss');
    			var pedido = {"cliente" : {"rut" : clienteRut,
    										"dv" : clienteDv,
    										"nombre" : clienteNombre,
    										"comuna": {"codigo" : clienteComuna},
    										"tipoCliente" : {"codigo" : clienteTipoCliente},
    										"direccion" : clienteDireccion,
    										"telefono" : clienteTelefono,
    										"celular" : clienteCelular},
    							"detallePedidos" : [{"producto" : {"codigo": productoCodigo}, 
													"cantidadproducto": cantidad,
													"precioproducto" : precio,
													"observacion" : "test observación",
													"active" : 1},
													{"producto" : {"codigo": productoCodigo2}, 
													 "cantidadproducto": cantidad,
													 "precioproducto" : precio,
													 "observacion" : "test observación",
													 "active" : 1}],
						    	"fechapedido": date,
						    	"preciototalpedido": precio,
						    	"observacionpedido" : "test observacion",
						    	"estadoPedido" : {"codigo" : "I"},
						    	"despachoPedido" : {"nombrecliente" : "Pastelería La Palmera",
						    						"lugarEntrega" : {"codigo" : 1},
						    						"fechaentregadespacho" : date},
						    	"confirmacionPedido" : {"nombrecliente" : "Pastelería La Palmera",
						    							"apellidocliente" : "Pastelería La Palmera",
						    							"direccioncliente" : "Ventas",
						    							"fecha" : date},
    						};
    			
	    		var add = service.pedido.save(pedido);
	    		expect(add).to.not.equal(false);
    		});
    	});*/
    	
    	describe('solicitudProductoCliente', function () {
    		it("update expect solicitudProductoCliente to be instanceof Object", function() {
    			
    			var pedido = service.pedido.get('89');
    			var date = moment().locale('es').format('YYYY-MM-DD HH:mm:ss');
    			pedido.estadoPedido.codigo = "C";
    			
    			var detallePedidos = [];
    			for(var i = 0; i < pedido.detallePedidos.length; i++) {
    				pedido.detallePedidos[i].active = "0";
    				detallePedidos.push(pedido.detallePedidos[i]);    				
    			}
    			var productoCodigo3 = "T01E01D01";
    			var cantidad3 = 1;
    			var precio3 = 1000;
    			detallePedidos.push({"producto" : {"codigo": productoCodigo3}, 
									 "cantidadproducto": cantidad3,
									 "precioproducto" : precio3,
									 "observacion" : "test observación3",
									 "active" : 1});
    			pedido.detallePedidos = detallePedidos;
    			
    			var ordenFabricacions = [];
    			for(var i = 0; i < pedido.detallePedidos.length; i++) {
    				ordenFabricacions.push({"programaProduccions" : [{
    																 "codigo" : pedido.numeroPedido + "-" + i + "-" + i,
																	 "cantidadprogramada" : pedido.detallePedidos[i].cantidadproducto,
																	 "cantidadfabricada" : 0,
																	 "saldoporfabricar" : pedido.detallePedidos[i].cantidadproducto,
																	 "producto" : {"codigo" : pedido.detallePedidos[i].producto.codigo},
																	 "fechaprogramaproduccion" : date,
																    }],
											"codigoOrdenFabricacion" : pedido.numeroPedido + "-" + i ,
											"producto" : {"codigo" : pedido.detallePedidos[i].producto.codigo},
											"cantidadProducto" : pedido.detallePedidos[i].cantidadproducto,
											"fechaIngresoOrdenFabricacion" : date,
											"estadoOrdenFabricacion" : "A",
									});

    			}
    			
    			pedido.ordenFabricacions = ordenFabricacions;
    			
	    		var add = service.pedido.save(pedido);
	    		expect(add).to.not.equal(false);
    		});
    	});
    	
    });
});