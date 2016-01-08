define(["jquery", "jqGrid", "bootstrap-dialog", "moment", "bootstrap-datetimepicker", "spin", "spin-jquery", 
        "service", "page", "productoConsultaClienteDialogController"], 
		function($, jqGrid, bootstrapDialog, moment, bootstrapdatetimepicker, spin, spinjquery, 
				service, page, productoConsultaClienteDialogController) {
 
	console.log("Function : solicitud Producto Controller");

	return {
		init : function() {
			
			$('#titulo').html('Solicitud Producto Cliente');
	 		$('#page').html(page.solicitudProductoCliente.get());
 		
	 		jQuery("#solicitudProductoCliente #navgrid").jqGrid({
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
			    var newWidth = $("#navgrid").closest(".ui-jqgrid").parent().width();
			    $("#solicitudProductoCliente #navgrid").jqGrid("setGridWidth", newWidth, true);
			    // without scrollbar
			    $("#solicitudProductoCliente #navgrid").closest('.ui-jqgrid-bdiv').width($("#solicitudProductoCliente #navgrid").closest('.ui-jqgrid-bdiv').width() + 1);
			});
	 		
	 		$('#solicitudProductoCliente #despacho #datetimepicker').datetimepicker({
	 			format: 'LLLL'
            });
	 		$("#solicitudProductoCliente #despacho #datetimepicker").on("dp.change", function (e) {
	 			$('#solicitudProductoCliente #despacho #fecha').val(e.date.locale('es').format('YYYY-MM-DD HH:mm:ss'));		            
	        });
            
            $('#solicitudProductoCliente #confirmar #datetimepicker').datetimepicker({
            	format: 'LLLL'
            });
	 		$("#solicitudProductoCliente #confirmar #datetimepicker").on("dp.change", function (e) {
	 			$('#solicitudProductoCliente #confirmar #fecha').val(e.date.locale('es').format('YYYY-MM-DD HH:mm:ss'));	            
	        });
	 		
	 		$("#solicitudProductoCliente #cliente #rut").on("change", function (e) {
	 			var clienteTipoCliente = null;
	 			var clienteRut = null;
	 			var clienteDv = null;
	 			var clienteNombre = null;
	 			var clienteDireccion = null;
	 			var clienteComuna = null;
	 			var clienteTelefono = null;
	 			var clienteCelular = null;
	 			var clienteEmail = null;
	 			
	 			var cliente = service.cliente.get(e.target.value);
	 			if(cliente instanceof Object) {
	 				clienteTipoCliente = cliente.tipoCliente.codigo;
	 				clienteRut = cliente.rut;
		 			clienteDv = cliente.dv;
		 			clienteNombre = cliente.nombre;
		 			clienteDireccion = cliente.direccion;
		 			clienteComuna = cliente.comuna.codigo;
		 			clienteTelefono = cliente.telefono;
		 			clienteCelular = cliente.celular;
		 			clienteEmail = cliente.email;
	 			} else {
	 				clienteTipoCliente = 'P01';
	 				clienteRut = e.target.value;
	 				clienteComuna = '-1';
	 			}
	 			$("#solicitudProductoCliente #cliente #tipoCliente").val(clienteTipoCliente);
	 			$("#solicitudProductoCliente #cliente #rut").val(clienteRut);
	 			$("#solicitudProductoCliente #cliente #dv").val(clienteDv);
	 			$("#solicitudProductoCliente #cliente #nombre").val(clienteNombre);
	 			$("#solicitudProductoCliente #cliente #direccion").val(clienteDireccion);
	 			$("#solicitudProductoCliente #cliente #comuna").val(clienteComuna);
	 			$("#solicitudProductoCliente #cliente #telefono").val(clienteTelefono);
	 			$("#solicitudProductoCliente #cliente #celular").val(clienteCelular);
	 			$("#solicitudProductoCliente #cliente #email").val(clienteEmail);
	        });
	 		
	 		//ENVIAR
	 		$("#solicitudProductoCliente #enviar").click(function() {
	 			console.log("enviar solicitud producto cliente controller");		 			
	 			
	 			var clienteTipoCliente = $("#solicitudProductoCliente #cliente #tipoCliente").val();
	 			var clienteRut = $("#solicitudProductoCliente #cliente #rut").val();
	 			var clienteDv = $("#solicitudProductoCliente #cliente #dv").val();
	 			var clienteNombre = $("#solicitudProductoCliente #cliente #nombre").val();
	 			var clienteDireccion = $("#solicitudProductoCliente #cliente #direccion").val();
	 			var clienteComuna = $("#solicitudProductoCliente #cliente #comuna").val();
	 			var clienteTelefono = $("#solicitudProductoCliente #cliente #telefono").val();
	 			var clienteCelular = $("#solicitudProductoCliente #cliente #celular").val();
	 			var clienteEmail = $("#solicitudProductoCliente #cliente #email").val();
	 			
	 			var pedidoEstadoIngreso = "I";
	 			var pedidoObservacion = $("#solicitudProductoCliente #observacion").val();
	 			
	 			var precioTotal = 0;
	 			var detallePedidos = [];
	 			var productos = jQuery("#solicitudProductoCliente #navgrid").jqGrid('getGridParam', 'data');
	 			for(var i=0; i < productos.length; i++) {
	 				detallePedidos.push({"producto" : {"codigo": productos[i].productoCodigo}, 
		 							"cantidadproducto": productos[i].cantidad,
		 							"precioproducto" : productos[i].precio,
		 							"observacion" : productos[i].observacion,
		 							"active" : 1});
		 			precioTotal = precioTotal +  parseInt(productos[i].precio);
	 			}
	 			
	 			var despachoDireccion = $("#solicitudProductoCliente #despacho #lugarEntrega").val();
	 			var despachoFecha = $("#solicitudProductoCliente #despacho #fecha").val();
	 			
	 			var confirmacionFecha = $("#solicitudProductoCliente #confirmar #fecha").val();
	 			
	 			var date = moment().locale('es').format('YYYY-MM-DD HH:mm:ss');
	 			
	 			var pedido = $('#state').data('pedido');
	 			
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
	 			pedido.estadoPedido = {"codigo" : pedidoEstadoIngreso};
	 			pedido.despachoPedido = {"nombrecliente" : "Este campo no va",
	 								"lugarEntrega" : {"codigo" : despachoDireccion},
									"fechaentregadespacho" : despachoFecha};
				pedido.confirmacionPedido = {"nombrecliente" : "Este campo no va",
										"apellidocliente" : "Este campo no va",
										"direccioncliente" : "Este campo no va",
										"fecha" : confirmacionFecha};

	 			var resp = service.pedido.save(pedido);
	 			
	 			if(resp instanceof Object) {
	 				var pedido = resp;
	 				window.location.hash = '#/solicitudProductoLista?numeroPedido='+pedido.numeroPedido;
	 			}
	 		});
	 		
	 		//AGREGAR PRODUCTO"
	 		$("#solicitudProductoCliente #productoAgregar").click(function() {
	 			console.log("dialog Producto Consulta controller");		
		 		productoConsultaClienteDialogController.init();
	 		});
	 		 
	 		//ELIMINAR PRODUCTO"
	 		$("#solicitudProductoCliente #productoEliminar").click(function() {
	 			console.log("Eliminar Producto Solicitud Producto Cliente controller");		
	 			var rowid = jQuery("#solicitudProductoCliente #navgrid").jqGrid('getGridParam','selrow');
				if(!rowid) {
					bootstrapDialog.show({message: 'No ha seleccionado producto!'});
				} else {
					jQuery("#solicitudProductoCliente #navgrid").jqGrid('delRowData', rowid);
					var allRowsInGrid = jQuery("#solicitudProductoCliente #navgrid").jqGrid('getGridParam', 'data');
					var array = [];
					for(var i=0; i<allRowsInGrid.length; i++) {
						array.push({'id' : i + 1,
						            'productoCodigo' : allRowsInGrid[i].productoCodigo,
						            'productoNombre' : allRowsInGrid[i].productoNombre,
						            'cantidad' : allRowsInGrid[i].cantidad,
						            'precio' : allRowsInGrid[i].precio,
						            'observacion' : allRowsInGrid[i].observacion});
					}
					jQuery("#solicitudProductoCliente #navgrid").jqGrid("clearGridData").jqGrid('addRowData', 'nombreinsumo', array);
				}
	 		});
	 		
	 		//LOADING
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
		 		
		 		$("#cargando").spin(false);
		 		
	 		}, 10);

	 		var pedido  =  {"cliente" : {"rut" : null, 
										"dv" : null,
										"nombre" : null,
										"comuna": {"codigo" : null},
										"tipoCliente" : {"codigo" : null},
										"direccion" : null,
										"telefono" : null,
										"celular" : null,
										"email" : null},
							"detallePedidos" : [],
							"fechapedido": null,
							"preciototalpedido": null,
							"observacionpedido" : null,
							"estadoPedido" : null,
							"despachoPedido" : null,
							"confirmacionPedido" : null,
							"ordenFabricacions" : null
	 		};
	 		
	 		$('#state').data('pedido',pedido);
		},		
	};
});