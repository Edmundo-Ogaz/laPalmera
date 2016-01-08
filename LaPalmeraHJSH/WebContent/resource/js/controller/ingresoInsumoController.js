define(["jquery", "bootstrap-dialog", "moment", "bootstrap-datetimepicker", "spin", "spin-jquery", "maxlength", 
        "service", "page", "validar"], 
		function($, bootstrapDialog, moment, bootstrapdatetimepicker, spin, spinJquery, maxlength,
				service, page, validar) {
 
	console.log("Function : ingreso insumo Controller");

	return {
		init : function() {
			
			$('#titulo').html('Ingreso Insumo');
	 		$('#page').html(page.ingresoInsumo.get());
	 		
	 		$('#fechaVencimiento').val(moment().locale('es').format('YYYY-MM-DD HH:mm:ss'));
            $('#fechaVencimientoView').val(moment().locale('es').format('LLLL'));		            
	 		
	 		//CALENDAR
	 		$('#datetimepicker').datetimepicker({
	 			inline: true,
                sideBySide: true
            });	 		
	 		$("#datetimepicker").on("dp.change", function (e) {
	 			$('#fechaVencimiento').val(e.date.locale('es').format('YYYY-MM-DD HH:mm:ss'));
	            $('#fechaVencimientoView').val(e.date.locale('es').format('LLLL'));
	        });
	 		
	 		//CANTIDAD
	 		$("#cantidad").maxlength({maxCharacters: 6, status: false});
	 		$("#cantidad").keyup(function() {
				validar.numero.soloNumero(this);
			});
	 		
	 		//ENVIAR EVENT CLICK
	 		$("#enviar").click(function() {
	 			console.log("enviar ingreso insumo controller");
	 			
	 			var codigoProducto = $("#insumo").val();
	 			var codigoBodega = $("#bodega").val();
	 			var fechaVencimiento = $("#fechaVencimiento").val();
	 			var cantidadProducto = $("#cantidad").val();
	 			var codigoUnidadMedida = $("#unidadMedida").val();
	 			var observacion = $("#observacion").val();
	 			
	 			var date = moment().locale('es').format('YYYY-MM-DD HH:mm:ss');
	 			
	 			var insumo = {"codigo" : codigoProducto,
	 							"ubicacions" : [{"unidadMedida" : {"codigo" : codigoUnidadMedida}, 
	 											"producto" : {"codigo" : codigoProducto}, 
	 											"bodega" : {"codigo" : codigoBodega},
	 											"fechaIngreso" : date,
	 											"fechaVencimiento" : fechaVencimiento,
	 											"cantidad" : cantidadProducto,
	 											"observacion" : observacion}],
	 							"stock" : {"producto" : {"codigo" : codigoProducto}}
	 						};
	 			
//	 			var resp = service.ingresoInsumo.add(codigoProducto, codigoBodega, fechaVencimiento, 
//	 												 cantidadProducto, codigoUnidadMedida, observacion);
	 			
	 			//var resp = service.ingresoInsumo.add(insumo);
	 			var resp = service.producto.ingreso(insumo);
	 			
	 			if(resp instanceof Object) {
	 				var producto = resp;
	 				var codigoProducto = producto.codigo;
	 				var idUbicacion = producto.ubicacions[0].id;
	 				
	 				window.location.hash = '#/ingresoInsumoLista?codigoProducto='+codigoProducto+
	 														    '&idUbicacion='+idUbicacion;
	 			}
	 		
	 		});
	 		
	 		//INSUMO EVENT CHANGE
	 		$("#insumo").change(function() {
	 			$('#cargando').spin();
	 			
	 			setTimeout(function() {
		 			var insumoCodigo = $("#insumo").val();
		 			var insumo = service.producto.get(insumoCodigo);
		 			var unidadMedida = {'familia' : {'codigo' : insumo.unidadMedida.familia.codigo}};
		 			var unidadMedidas = service.unidadMedida.getAllEqBy(unidadMedida);
			 		if(unidadMedidas instanceof Array) {
				 		var unidadMedida = $("#unidadMedida");
				 		unidadMedida.html($("<option />").val("-1").text("SELECCIONE UNIDAD MEDIDA"));
				 		$.each(unidadMedidas, function() {
				 			unidadMedida.append($("<option />").val(this.codigo).text(this.nombre));
				 		});
			 		}
			 		$("#cargando").spin(false);
	 			}, 10);
	 		
	 		});
	 		
	 		// LOAD DATA
	 		$('#cargando').spin();
	 		
			setTimeout(function() {
				var insumo = {"tipoProducto" : {"codigo" : "T"}};
 				var resp = service.producto.getAllNotEqBy(insumo);
 				if(resp instanceof Array) {
 					var insumos = resp;
			 		var $insumo = $("#insumo");
			 		$insumo.append($("<option />").val("-1").text("SELECCIONE INSUMO"));
			 		$.each(insumos, function() {
			 			$insumo.append($("<option />").val(this.codigo).text(this.nombre));
			 		});
 				}
			
		 		var resp = service.bodega.getAll();
		 		if(resp instanceof Array) {
			 		var bodegas = resp;
		 			var $bodega = $("#bodega");
			 		$bodega.append($("<option />").val("-1").text("SELECCIONE BODEGA"));
			 		$.each(bodegas, function() {
			 			$bodega.append($("<option />").val(this.codigo).text(this.nombre));
			 		});
 				}
	 		
		 		$("#cargando").spin(false);
	 		
			}, 10);
		},
	};
});