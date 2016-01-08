define(["jquery", "jqGrid", "bootstrap-dialog", "moment", "bootstrap-datetimepicker", "spin", "spin-jquery", "dialog",
        "service", "page", "helper", "enum", "productoConsultaClienteDialogController"], 
		function($, jqGrid, bootstrapDialog, moment, bootstrapdatetimepicker, spin, spinjquery, dialog,
				service, page, helper, ENUM, productoConsultaClienteDialogController) {
 
	console.log("Function : Pedido Confirma Dialog Controller");
	
	var GRID = '#dialog #solicitudProductoCliente #navgrid1';
	var GRID_FOOTER = '#dialog #solicitudProductoCliente #pagernav';
	return {
		init : function(pedido) {
			
			fill = this.fill;
			
			var html = page.solicitudProductoCliente.get();
			dialog.modalWidth(html,"Pedido", 1024);
		 		
			jQuery(GRID).jqGrid({
				datatype: "local",
				jsonReader : { repeatitems: false },
				colNames:['N°', 'Id', 'Producto Código', 'Producto', 'Cantidad', 'Precio', 'Observación'],
				colModel:[
				        {name:'nro', index:'nro', key:true,  			align:'left'},
				  		{name:'id', index:'id', 						hidden:true},
				  		{name:'productoCodigo',index:'productoCodigo',  hidden:true},
				  		{name:'productoNombre',index:'productoNombre',  align:'left'},
				  		{name:'cantidad',index:'cantidad', 				align:'right'},
				  		{name:'precio',index:'precio',       			align:'right'},
				  		{name:'observacion',index:'observacion',   		align:'left'},
				  	],
			  	rowNum:10,
			  	rowList:[10,20,30],
			  	//pager: jQuery(GRID_FOOTER),
			  	pager: $('#dialog #solicitudProductoCliente #pagernav'),
			  	sortname: 'codigo',
			  	viewrecords: true,
			  	sortorder: "asc",
			  	caption:"Productos",
			  	editurl:"clientArray",
			  	height:125,
			  	autowidth:true,			  	
	 		});
	 		
	 		$(window).on("resize", function () {
			    var newWidth = $(GRID).closest(".ui-jqgrid").parent().width();
			    $(GRID).jqGrid("setGridWidth", newWidth, true);
			    // without scrollbar
			    $(GRID).closest('.ui-jqgrid-bdiv').width($(GRID).closest('.ui-jqgrid-bdiv').width() + 1);
			});
	 		
	 		//EVENT CALENDAR
	 		$("#solicitudProductoCliente #despacho #datetimepicker").on("dp.change", function (e) {
	 			$('#solicitudProductoCliente #despacho #fecha').val(e.date.locale('es').format('YYYY-MM-DD HH:mm:ss'));		            
	        });            
	 		$("#solicitudProductoCliente #confirmar #datetimepicker").on("dp.change", function (e) {
	 			$('#solicitudProductoCliente #confirmar #fecha').val(e.date.locale('es').format('YYYY-MM-DD HH:mm:ss'));	            
	        });
	 		
	 		//HABILITAR DESABILITAR COMPONENTES
	 		$("#solicitudProductoCliente #estado").show();	 		
	 		
	 		//GRABAR PEDIDO
	 		$("#solicitudProductoCliente #enviar").click(function() {
	 			console.log("enviar solicitud producto cliente controller");
	 			
	 			var date = moment().locale('es').format('YYYY-MM-DD HH:mm:ss');
	 			
	 			var clienteTipoCliente = $("#solicitudProductoCliente #cliente #tipoCliente").val();
	 			var clienteRut = $("#solicitudProductoCliente #cliente #rut").val();
	 			var clienteDv = $("#solicitudProductoCliente #cliente #dv").val();
	 			var clienteNombre = $("#solicitudProductoCliente #cliente #nombre").val();
	 			var clienteDireccion = $("#solicitudProductoCliente #cliente #direccion").val();
	 			var clienteComuna = $("#solicitudProductoCliente #cliente #comuna").val();
	 			var clienteTelefono = $("#solicitudProductoCliente #cliente #telefono").val();
	 			var clienteCelular = $("#solicitudProductoCliente #cliente #celular").val();
	 			var clienteEmail = $("#solicitudProductoCliente #cliente #email").val();
	 			
	 			var pedidoEstado = $('input:radio[name=estadoConfirmacion]:checked').val();
	 			
	 			var pedidoObservacion = $("#solicitudProductoCliente #observacion").val();
	 			
	 			var ordenFabricacionEstadoAprobado = "A";
	 			
	 			var precioTotal = 0;
	 			var detallePedidos = [];
	 			var ordenFabricacions = [];
	 			
	 			var pedido = $('#state').data('pedido');
	 			for(var i=0; i < pedido.detallePedidos.length; i++) {
	 				detallePedidos.push({"id" : pedido.detallePedidos[i].id,
	 									 "producto" : {"codigo": pedido.detallePedidos[i].producto.codigo}, 
		 							   	 "cantidadproducto": pedido.detallePedidos[i].cantidadproducto,
		 							   	 "precioproducto" : pedido.detallePedidos[i].precioproducto,
	 									 "observacion" : pedido.detallePedidos[i].observacion,
	 									 "active" : pedido.detallePedidos[i].active});
	 				
	 				if(pedidoEstado == ENUM.estadoPedido.CONFIRMADO.codigo) {
		 				ordenFabricacions.push({"programaProduccions" : [{
		 																"codigo" : pedido.numeroPedido + "-" + (i + 1) + "-1",
																		"cantidadprogramada" : pedido.detallePedidos[i].cantidadproducto,
																		"cantidadfabricada" : 0,
																		"saldoporfabricar" : pedido.detallePedidos[i].cantidadproducto,
																		"producto" : {"codigo" : pedido.detallePedidos[i].producto.codigo},
																		"fechaprogramaproduccion" : date,
																		}],
												"codigoOrdenFabricacion" : pedido.numeroPedido + "-" + (i + 1),
												"producto" : {"codigo" : pedido.detallePedidos[i].producto.codigo},
												"cantidadProducto" : pedido.detallePedidos[i].cantidadproducto,
												"fechaIngresoOrdenFabricacion" : date,
												"estadoOrdenFabricacion" : ordenFabricacionEstadoAprobado,
												});
	 				}
		 			precioTotal = precioTotal +  parseInt(pedido.detallePedidos[i].precioproducto);
	 			}
	 			
	 			var despachoDireccion = $("#solicitudProductoCliente #despacho #lugarEntrega").val();
	 			var despachoFecha = $("#solicitudProductoCliente #despacho #fecha").val();
	 			
	 			var confirmacionFecha = $("#solicitudProductoCliente #confirmar #fecha").val();
	 			
	 			pedido.cliente.rut = clienteRut;
	 			pedido.cliente.dv = clienteDv;
	 			pedido.cliente.nombre = clienteNombre;
	 			pedido.cliente.comuna = {"codigo" : clienteComuna};
	 			pedido.cliente.tipoCliente = {"codigo" : clienteTipoCliente};
	 			pedido.cliente.direccion = clienteDireccion;
	 			pedido.cliente.telefono = clienteTelefono;
	 			pedido.cliente.celular = clienteCelular;
	 			pedido.cliente.email = clienteEmail;
	 			pedido.detallePedidos = detallePedidos;
	 			pedido.fechapedido = date;
	 			pedido.preciototalpedido = precioTotal;
	 			pedido.observacionpedido = pedidoObservacion;
	 			pedido.estadoPedido = {"codigo" : pedidoEstado};
	 			pedido.despachoPedido = {"nombrecliente" : "Este campo no va",
	 								"lugarEntrega" : {"codigo" : despachoDireccion},
									"fechaentregadespacho" : despachoFecha};
				pedido.confirmacionPedido = {"nombrecliente" : "Este campo no va",
										"apellidocliente" : "Este campo no va",
										"direccioncliente" : "Este campo no va",
										"fecha" : confirmacionFecha};
				pedido.ordenFabricacions = ordenFabricacions;

	 			var resp = service.pedido.save(pedido);
	 			
	 			if(resp instanceof Object) {
	 				bootstrapDialog.show({message: 'Pedido grabado!'});
	 				$('#state').removeData('pedido');
	 				$("#dialog" ).dialog("close");
	 			}	 			
	 			
            	return resp;
	 		});
	 		
	 		//AGREGAR PRODUCTO"
	 		$("#solicitudProductoCliente #productoAgregar").click(function() {
	 			console.log("dialog Producto Consulta controller");		
		 		productoConsultaDialogController.init();
	 		});
	 		 
	 		//ELIMINAR PRODUCTO"
	 		$("#solicitudProductoCliente #productoEliminar").click(function() {
	 			console.log("Eliminar Producto Solicitud Producto Cliente controller");		
	 			var rowid = jQuery(GRID).jqGrid('getGridParam','selrow');
				if(!rowid) {
					bootstrapDialog.show({message: 'No ha seleccionado producto!'});
				} else {
					jQuery(GRID).jqGrid('delRowData', rowid);
					var allRowsInGrid = jQuery(GRID).jqGrid('getGridParam', 'data');
					var array = [];
					for(var i=0; i<allRowsInGrid.length; i++) {
						array.push({'nro' : i + 1,
									'id' : allRowsInGrid[i].id,
						            'productoCodigo' : allRowsInGrid[i].productoCodigo,
						            'productoNombre' : allRowsInGrid[i].productoNombre,
						            'cantidad' : allRowsInGrid[i].cantidad,
						            'precio' : allRowsInGrid[i].precio,
						            'observacion' : allRowsInGrid[i].observacion});
					}
					jQuery(GRID).jqGrid("clearGridData").jqGrid('addRowData', 'nombreinsumo', array);
					
					var pedido = $('#state').data('pedido');
					for(var i = 0; i < pedido.detallePedidos.length; i++) {
						if(pedido.detallePedidos[i].id = rowid) {
							pedido.detallePedidos[i].active = "0";
						}
					}
					$('#state').data('pedido',pedido);
				}
	 		});
	 		
	 		$('#cargando').spin();
	 		
	 		setTimeout(function() {
	 			
		 		var resp = service.comuna.getAll();
		 		if(resp instanceof Array) {
		 			var comunas = resp;
			 		var options = $("#solicitudProductoCliente #cliente #comuna");
			 		options.append($("<option />").val("-1").text("SELECCIONE COMUNA"));
			 		$.each(comunas, function() {
			 		    options.append($("<option />").val(this.codigo).text(this.nombre));
			 		});
		 		}
		 		
		 		var resp = service.entrega.getAll();
		 		if(resp instanceof Array) {
		 			var entregas = resp;
			 		var options = $("#solicitudProductoCliente #despacho #lugarEntrega");
			 		options.append($("<option />").val("-1").text("SELECCIONE LUGAR ENTREGA"));
			 		$.each(entregas, function() {
			 		    options.append($("<option />").val(this.codigo).text(this.descripcion));
			 		});
		 		}
		 		
		 		fill(pedido[0]);
		 		
		 		$("#cargando").spin(false);
		 		
	 		}, 10);
		},
		fill : function(pedido) {
			
			$("#solicitudProductoCliente #cliente #tipoCliente").val(pedido.cliente.tipoCliente.codigo);
 			$("#solicitudProductoCliente #cliente #rut").val(pedido.cliente.rut);
 			$("#solicitudProductoCliente #cliente #dv").val(pedido.cliente.dv);
 			$("#solicitudProductoCliente #cliente #nombre").val(pedido.cliente.nombre);
 			$("#solicitudProductoCliente #cliente #direccion").val(pedido.cliente.direccion);
 			$("#solicitudProductoCliente #cliente #comuna").val(pedido.cliente.comuna.codigo);
 			$("#solicitudProductoCliente #cliente #telefono").val(pedido.cliente.telefono);
 			$("#solicitudProductoCliente #cliente #celular").val(pedido.cliente.celular);
 			$("#solicitudProductoCliente #cliente #email").val(pedido.cliente.email);
 			
 			$("#solicitudProductoCliente #observacion").val(pedido.observacionpedido);
 			
 			var message = '';
 			var array = [];
 			for(var i = 0; i < pedido.detallePedidos.length; i++) {
 				//CONSULTAR INGREDIENTE
 				var producto = {'producto' : {'codigo' : pedido.detallePedidos[i].producto.codigo},
 								'carga' : pedido.detallePedidos[i].cantidadproducto};
 				var ingredientes = service.ingrediente.getAllEqBy(producto);
				
				if(ingredientes.length > 0) {
					for(var j=0; j < ingredientes.length; j++) {
						var insumo = service.producto.get(ingredientes[j].insumo.codigo);
						if(insumo.stock instanceof Object) {
							var cantidad = helper.UnidadMedida.conversion(insumo.stock.unidadMedida.codigo, 
														   ingredientes[j].unidadMedida.codigo,
														   ingredientes[j].cantidadinsumo);
							var stockDisponible = insumo.stock.stockDisponible - cantidad;
							if(insumo.stockcriticoproducto > stockDisponible) {
								message = message + 'Ingrediente ' + insumo.nombre + ' en stock critico ';
							}
						
						} else {
							message = message + 'Ingrediente ' + insumo.nombre + ' sin stock ';
						}						
					}
				} else {
					message = 'Sin ingredientes';
 				}
 				
 				array.push({'nro' : i + 1,
 						'id' : pedido.detallePedidos[i].id,
			            'productoCodigo' : pedido.detallePedidos[i].producto.codigo,
			            'productoNombre' : pedido.detallePedidos[i].producto.nombre,
			            'cantidad' : pedido.detallePedidos[i].cantidadproducto,
			            'precio' : pedido.detallePedidos[i].precioproducto,
			            'observacion' : pedido.detallePedidos[i].observacion});
 			}
 			
 			if(message != "") {
				console.log(message);
 				bootstrapDialog.show({message: message});
			}
 			
 			jQuery(GRID).jqGrid('addRowData', 'id', array);
 			
 			$("#solicitudProductoCliente #despacho #lugarEntrega").val(pedido.despachoPedido.lugarEntrega.codigo);
 			$('#solicitudProductoCliente #despacho #datetimepicker').datetimepicker({
	 			format: 'LLLL',
	 			defaultDate: pedido.despachoPedido.fechaentregadespacho,
            });
 			
 			$('#solicitudProductoCliente #confirmar #datetimepicker').datetimepicker({
	 			format: 'LLLL',
	 			defaultDate: pedido.confirmacionPedido.fecha,
            });
 			
 			var pedidoEstado = pedido.estadoPedido.codigo;
 			if(pedidoEstado == 'I') {$("#solicitudProductoCliente #estado #ingresado").prop("checked", true);}
 			if(pedidoEstado == 'C') {$("#solicitudProductoCliente #estado #confirmado").prop("checked", true);}
 			if(pedidoEstado == 'R') {$("#solicitudProductoCliente #estado #rechazado").prop("checked", true);}
 			
 			
 			$('#state').data('pedido',pedido);
 			
		},
	};
});