define(["jquery", "bootstrap-dialog", "moment", "bootstrap-datetimepicker", "spin", "spin-jquery", 
        "service", "page", "productoConsultaDialogController"], 
		function($, bootstrapDialog, moment, bootstrapdatetimepicker, spin, spinjquery, 
				service, page, productoConsultaDialogController) {
 
	console.log("Function : solicitud Producto Controller");

	return {
		init : function() {
			
			$('#titulo').html('Solicitud Producto');
	 		$('#page').html(page.solicitudProducto.get());
 		
	 		jQuery("#solicitudProducto #navgrid").jqGrid({
				datatype: "local",
				jsonReader : { repeatitems: false },
				colNames:['N°', 'Producto Código', 'Producto', 'Cantidad', 'Precio', 'Observación'],
				colModel:[
				  		{name:'id', index:'id', key:true,  align:'left'},
				  		{name:'productoCodigo',index:'productoCodigo',         hidden:true},
				  		{name:'productoNombre',index:'productoNombre',         align:'left'},
				  		{name:'cantidad',index:'cantidad', align:'right'},
				  		{name:'precio',index:'precio',       align:'right'},
				  		{name:'observacion',index:'observacion',   align:'left'},
				  	],
			  	rowNum:10,
			  	rowList:[10,20,30],
			  	pager: '#pagernav',
			  	sortname: 'codigo',
			  	viewrecords: true,
			  	sortorder: "asc",
			  	caption:"Productos",
			  	editurl:"clientArray",
			  	height:125,
			  	autowidth:true,			  	
	 		});
	 		
	 		$(window).on("resize", function () {
			    var newWidth = $("#solicitudProducto #navgrid").closest(".ui-jqgrid").parent().width();
			    $("#solicitudProducto #navgrid").jqGrid("setGridWidth", newWidth, true);
			    // without scrollbar
			    $("#solicitudProducto #navgrid").closest('.ui-jqgrid-bdiv').width($("#solicitudProducto #navgrid").closest('.ui-jqgrid-bdiv').width() + 1);
			});
	 		
	 		$('#solicitudProducto #datetimepicker').datetimepicker({
	 			inline: true,
                sideBySide: true
            });
	 		$("#solicitudProducto #datetimepicker").on("dp.change", function (e) {
	 			$('#solicitudProducto #fecha').val(e.date.locale('es').format('YYYY-MM-DD HH:mm:ss'));
	            $('#solicitudProducto #fechaView').val(e.date.locale('es').format('LLLL'));		            
	        });
	 		
	 		$('#solicitudProducto #fecha').val(moment().locale('es').format('YYYY-MM-DD HH:mm:ss'));
            $('#solicitudProducto #fechaView').val(moment().locale('es').format('LLLL'));
	 		
            //ENVIAR
	 		$("#solicitudProducto #enviar").click(function() {
	 			console.log("enviar solicitud producto controller");
	 			
	 			var date = moment().locale('es').format('YYYY-MM-DD HH:mm:ss');
	 			
	 			var pedidoEstadoConfirmacion = "C"; 
	 			var ordenFabricacionEstadoAprobado = "A";

	 			var pedidoObservacion = $("#observacion").val();
	 			
				var precioTotal = 0;
	 			var detallePedidos = [];
	 			var ordenFabricacions = [];
	 			
	 			var productos = jQuery("#solicitudProducto #navgrid").jqGrid('getGridParam', 'data');
	 			
	 			for(var i=0; i < productos.length; i++) {
	 				detallePedidos.push({"producto" : {"codigo": productos[i].productoCodigo},
			 							"cantidadproducto": productos[i].cantidad,
			 							"precioproducto" : productos[i].precio,
			 							"observacion" : productos[i].observacion,
			 							"active" : 1});
	 			
	 				ordenFabricacions.push({"programaProduccions" : [{
	 																"fechaprogramaproduccion" : date,
	 																"producto" : {"codigo" : productos[i].productoCodigo},
	 																"cantidadprogramada" : productos[i].cantidad,
																	"cantidadfabricada" : 0,
																	"saldoporfabricar" : productos[i].cantidad,																	
																	}],
											"producto" : {"codigo" : productos[i].productoCodigo},
											"cantidadProducto" : productos[i].cantidad,
											"fechaIngresoOrdenFabricacion" : date,
											"estadoOrdenFabricacion" : ordenFabricacionEstadoAprobado,
											});
	 			
		 			precioTotal = precioTotal +  parseInt(productos[i].precio);
	 			}		 			

	 			var despachoDireccion = "Venta";
	 			var despachoFechaEntrega = $("#fecha").val();
	 			
	 			var pedido = $('#state').data('pedido');
	 			
	 			pedido.detallePedidos  = detallePedidos;
	 			pedido.fechapedido = date,
	 			pedido.preciototalpedido = precioTotal,
	 			pedido.observacionpedido = pedidoObservacion,
	 			pedido.estadoPedido = {"codigo" : pedidoEstadoConfirmacion};
	 			pedido.despachoPedido = {"nombrecliente" : "Este campo no va",
	 									 "lugarEntrega" : {"codigo" : despachoDireccion},
									     "fechaentregadespacho" : despachoFechaEntrega},
				pedido.confirmacionPedido = {"nombrecliente" : "Este campo no va",
											"apellidocliente" : "Este campo no va",
											"direccioncliente" : "Este campo no va",
											"fecha" : date};
	 			pedido.ordenFabricacions = ordenFabricacions;

	 			var resp = service.pedido.save(pedido);
	 			
	 			if(resp instanceof Object) {
	 				var pedido = resp;
	 				window.location.hash = '#/solicitudProductoLista?numeroPedido='+pedido.numeroPedido;
	 			}
	 		});

	 		//AGREGAR PRODUCTO"
	 		$("#solicitudProducto #productoAgregar").click(function() {
	 			console.log("dialog Producto Consulta controller");		
		 		productoConsultaDialogController.init();
	 		});

			//ELIMINAR PRODUCTO"
	 		$("#solicitudProducto #productoEliminar").click(function() {
	 			console.log("Eliminar Producto Solicitud Producto controller");		
	 			var rowid = jQuery("#solicitudProducto #navgrid").jqGrid('getGridParam','selrow');
				if(!rowid) {
					bootstrapDialog.show({message: 'No ha seleccionado producto!'});
				} else {
					jQuery("#solicitudProducto #navgrid").jqGrid('delRowData', rowid);
					var allRowsInGrid = jQuery("#solicitudProducto #navgrid").jqGrid('getGridParam', 'data');
					var array = [];
					for(var i=0; i<allRowsInGrid.length; i++) {
						array.push({'id' : i + 1,
						            'productoCodigo' : allRowsInGrid[i].productoCodigo,
						            'productoNombre' : allRowsInGrid[i].productoNombre,
						            'cantidad' : allRowsInGrid[i].cantidad,
						            'precio' : allRowsInGrid[i].precio,
						            'observacion' : allRowsInGrid[i].observacion});
					}
					jQuery("#solicitudProducto #navgrid").jqGrid("clearGridData").jqGrid('addRowData', 'nombreinsumo', array);
				}
	 		});
	 		
	 		var clienteTipoCliente = "S01";
 			var clienteRut = "90124578";
			var clienteDv = "6";
			var clienteNombre = "La Palmera";
			var clienteDireccion = "R02C01C01";
			var clienteComuna = "R02C01C01";	    			
			var clienteTelefono = "11245799";
			var clienteCelular = "45895536";
			var clienteEmail = "laPalmera@gmail.com";			

	 		var pedido  =  {"cliente" : {"rut" : clienteRut, 
										"dv" : clienteDv,
										"nombre" : clienteNombre,
										"comuna": {"codigo" : clienteComuna},
										"tipoCliente" : {"codigo" : clienteTipoCliente},
										"direccion" : clienteDireccion,
										"telefono" : clienteTelefono,
										"celular" : clienteCelular,
										"email" : clienteEmail},
							"detallePedidos" : [],
							"fechapedido": null,
							"preciototalpedido": null,
							"observacionpedido" : null,
							"estadoPedido" : {"codigo" : null},
							"despachoPedido" : {"nombrecliente" : "Este campo no va",
												"direcciondespacho" : null,
												"fechaentregadespacho" : null},
							"confirmacionPedido" : {"nombrecliente" : "Este campo no va",
													"apellidocliente" : "Este campo no va",
													"direccioncliente" : "Este campo no va",
													"fecha" : null},
							"ordenFabricacions" : []
	 		};
	 		
	 		$('#state').data('pedido',pedido);
		}		
	};
});