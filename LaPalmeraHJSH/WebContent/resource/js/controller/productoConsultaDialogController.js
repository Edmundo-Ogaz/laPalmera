define(["jquery", "service","bootstrap-dialog", "moment", "bootstrap-datetimepicker", "spin", "spin-jquery", "model", "page", "dialog"], 
		function($, service, bootstrapDialog, moment, bootstrapdatetimepicker, spin, spinjquery, model, page, dialog) {
 
	console.log("Function : solicitud Producto Controller");

	return {
		init : function() {
			
			getIngredientes = this.getIngredientes;
			getPrecio = this.getPrecio;
			
			var html = page.productoConsulta.get();
			dialog.modal(html,"Agregar Producto");
	 		
	 		jQuery("#productoConsulta #navgrid1").jqGrid({
				datatype: "local",
				jsonReader : { repeatitems: false },
				colNames:['Insumo', 'Cantidad', 'Unidad Medida', 'Stock Disponible', 'Unidad Medida'],
				colModel:[
				  		{name:'nombreinsumo', index:'nombreinsumo', key:true,  align:'left'},
				  		{name:'cantidadinsumo',index:'cantidadinsumo',         align:'right'},
				  		{name:'codigoUnidadMedida',index:'codigoUnidadMedida', align:'left'},
				  		{name:'stockDisponible',index:'stockDisponible',       align:'right'},
				  		{name:'unidadmedidaStock',index:'unidadmedidaStock',   align:'left'},
				  	],
			  	rowNum:10,
			  	rowList:[10,20,30],
			  	pager: '#pagernav',
			  	sortname: 'codigo',
			  	viewrecords: true,
			  	sortorder: "asc",
			  	caption:"Insumos",
			  	editurl:"clientArray",
			  	height:125,
			  	autowidth:true,			  	
	 		});
	 		
	 		jQuery("#productoConsulta #navgrid1").jqGrid('setGroupHeaders', {
	 			  useColSpanStyle: false, 
	 			  groupHeaders:[
	 				{startColumnName: 'nombreinsumo', numberOfColumns: 3, titleText: 'Ingredientes'},
	 				{startColumnName: 'stockDisponible', numberOfColumns: 2, titleText: 'Stock'}
	 			  ]	
	 			});
		 		
	 		$(window).on("resize", function () {
			    var newWidth = $("#productoConsulta #navgrid1").closest(".ui-jqgrid").parent().width();
			    $("#productoConsulta #navgrid1").jqGrid("setGridWidth", newWidth, true);
			    // without scrollbar
			    $("#productoConsulta #navgrid1").closest('.ui-jqgrid-bdiv').width($("#productoConsulta #navgrid1").closest('.ui-jqgrid-bdiv').width() + 1);
			});
		 		
	 		$("#productoConsulta #producto").change(function() {
	 			console.log("producto producto consulta dialog controller");
	 			
	 			var $producto = $("#productoConsulta #producto").val();
	 			var $cantidad = $("#productoConsulta #cantidad").val();
	 			
	 			var producto = service.producto.get($producto);
	 			if(producto instanceof Object) {
	 				$("#productoConsulta #unidadMedida").html(producto.unidadMedida.codigo);
	 			
		 			if($producto.trim() != "" && $cantidad.trim() != "") {
		 				$("#productoConsulta #navgrid1").jqGrid("clearGridData");
		 				getIngredientes($producto, $cantidad);
		 				getPrecio($producto, $cantidad);
		 			}
	 			}
	 		});
	 		
	 		$("#productoConsulta #cantidad").blur(function() {
	 			console.log("cantidad producto consulta dialog controller");
	 			var producto = $("#productoConsulta #producto").val();
	 			var cantidad = $("#productoConsulta #cantidad").val();
	 			if(producto.trim() != "" && cantidad.trim() != "") {
	 				$("#productoConsulta #navgrid1").jqGrid("clearGridData");
	 				getIngredientes(producto, cantidad);
	 				getPrecio(producto, cantidad)
	 			}
	 		});
		 		
	 		$("#productoConsulta #enviar").click(function() {
	 			console.log("enviar solicitud producto controller");		 			
	 			
	 			var productoCodigo = $("#productoConsulta #producto").val();
	 			var productoNombre = $("#productoConsulta #producto option:selected").text();
	 			var productoCantidad = $("#productoConsulta #cantidad").val();
	 			var productoPrecioTotal = $("#productoConsulta #precio").val();
	 			var observacion = $("#productoConsulta #observacion").val();
	 			
	 			var length = jQuery("#solicitudProducto #navgrid").jqGrid('getGridParam', 'records');
	 			
	 			var array = [];
	 			array.push({'id' : length + 1,
				            'productoCodigo' : productoCodigo,
				            'productoNombre' : productoNombre,
				            'cantidad' : productoCantidad,
				            'precio' : productoPrecioTotal,
				            'observacion' : observacion});
	 			jQuery("#solicitudProducto #navgrid").jqGrid('addRowData', 'id', array);
	 			//jQuery("#navgrid").trigger("reloadGrid");
	 			$("#dialog" ).dialog("close");
	 			
	 			var pedido = $('#state').data('pedido');
 				pedido.detallePedidos.push({"id" : null,
 									 "producto" : {"codigo": array[0].productoCodigo}, 
	 							   	 "cantidadproducto": array[0].cantidad,
	 							   	 "precioproducto" : array[0].precio,
 									 "observacion" : array[0].observacion,
 									 "active" : 1});
	 			pedido.preciototalpedido = pedido.preciototalpedido + parseInt(array[0].precio);
				
				$('#state').data('pedido',pedido);
	 			
	 			
	 		});
		 		
	 		$('#cargando').spin();
	 		
	 		setTimeout(function() {
	 			
	 			var producto = {"tipoProducto" : {"codigo" : "I"}};
		 		var resp = service.producto.getAllNotEqBy(producto);
		 		if(resp instanceof Array) {
		 			var productos = resp;
			 		var options = $("#productoConsulta #producto");
			 		options.append($("<option />").val("-1").text("SELECCIONE PRODUCTO"));
			 		$.each(productos, function() {
			 		    options.append($("<option />").val(this.codigo).text(this.nombre));
			 		});
		 		}
		 		
		 		$("#cargando").spin(false);
		 		
	 		}, 10);
		},
		getPrecio : function(codigoProducto, cantidad) {
			var producto = service.producto.get(codigoProducto);
			if(producto instanceof Object) {
				var precio = parseInt(producto.valorventa) * parseInt(cantidad);
				$("#productoConsulta #precio").val(precio);
				$("#productoConsulta #precioView").html(" " + precio);
			}
		},
		getIngredientes : function(producto, cantidad) {
 			var array = [];
 			var ingrediente = {'producto' : {'codigo' : producto}};
 			var resp = service.ingrediente.getAllEqBy(ingrediente);					  	
			if(resp instanceof Array) {
				var ingredientes = resp;
				if(ingredientes.length > 0) {
		 			for(var i=0;i<ingredientes.length;i++) {
						array.push({'nombreinsumo' : ingredientes[i].insumo.nombre, 
						            'cantidadinsumo' : parseInt(ingredientes[i].cantidadinsumo) * parseInt(cantidad), 
						            'codigoUnidadMedida' : ingredientes[i].unidadMedida.codigo, 
						            'stockDisponible' : ingredientes[i].insumo.stock.stockDisponible, 
						            'unidadmedidaStock' : ingredientes[i].insumo.stock.unidadMedida.codigo}); 
					}			
					//jQuery("#productoConsulta #navgrid1").jqGrid("clearGridData").jqGrid('addRowData', 'nombreinsumo', array);
		 			jQuery("#productoConsulta #navgrid1").jqGrid('addRowData', 'nombreinsumo', array);
				} else {
 					console.log('Sin ingredientes');
	 				bootstrapDialog.show({message: 'Sin ingredientes'});
 				}
			}
 		},
	};
});