define(["jquery", "service","bootstrap-dialog", "moment", "bootstrap-datetimepicker", "spin", "spin-jquery", "model", "page", "dialog"], 
		function($, service, bootstrapDialog, moment, bootstrapdatetimepicker, spin, spinjquery, model, page, dialog) {
 
	console.log("Function : solicitud Producto Controller");

	return {
		init : function() {
			
			getPrecio = this.getPrecio;
			
			var html = page.productoConsulta.get();
			dialog.modal(html,"Agregar Producto");
		 		
	 		$("#productoConsulta #producto").change(function() {
	 			console.log("producto producto consulta dialog controller");
	 			
	 			var $producto = $("#productoConsulta #producto").val();
	 			var $cantidad = $("#productoConsulta #cantidad").val();
	 			
	 			var producto = service.producto.get($producto);
	 			if(producto instanceof Object) {
	 				$("#productoConsulta #unidadMedida").html(producto.unidadMedida.codigo);
	 			
		 			if($producto.trim() != "" && $cantidad.trim() != "") {
		 				getPrecio($producto, $cantidad);
		 			}
	 			}
	 		});
	 		
	 		$("#productoConsulta #cantidad").blur(function() {
	 			console.log("cantidad producto consulta dialog controller");
	 			var producto = $("#productoConsulta #producto").val();
	 			var cantidad = $("#productoConsulta #cantidad").val();
	 			if(producto.trim() != "" && cantidad.trim() != "") {
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
	 			
	 			var length = jQuery("#solicitudProductoCliente #navgrid").jqGrid('getGridParam', 'records');
	 			
	 			var array = [];
	 			array.push({'id' : length + 1,
				            'productoCodigo' : productoCodigo,
				            'productoNombre' : productoNombre,
				            'cantidad' : productoCantidad,
				            'precio' : productoPrecioTotal,
				            'observacion' : observacion});
	 			jQuery("#solicitudProductoCliente #navgrid").jqGrid('addRowData', 'id', array);
	 			//jQuery("#navgrid").trigger("reloadGrid");
	 			$("#dialog" ).dialog("close");
	 			
	 			
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
	};
});