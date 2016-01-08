define(["jquery", "service","bootstrap-dialog", "spin", "spin-jquery", "page", "dialog", "moment"], 
		function($, service, bootstrapDialog, spin, spinJquery, page, dialog, moment) {
 
	console.log("Function : buscar insumo Controller");

	return {
		init : function(_ordenFabricacion) {
			
			var clear = this.clear;
			var requiredField = this.requiredField;
			
			var html = page.devolucionInsumo.get();
			var width = 880;
			dialog.modalWidth(html,"Devolución Insumo", width);
			
			$('#datetimepicker').datetimepicker({
	 			inline: true,
                sideBySide: true
            });
	 		$("#datetimepicker").on("dp.change", function (e) {
	 			$('#fechaVencimiento').val(e.date.locale('es').format('YYYY-MM-DD HH:mm:ss'));
	            $('#fechaVencimientoView').val(e.date.locale('es').format('LLLL'));		            
	        });
			
			$('#cargando').spin();
			
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
		
	 		var unidadMedidas = service.unidadMedida.getAll();
	 		if(unidadMedidas instanceof Array) {
		 		var unidadMedida = $("#unidadMedida");
		 		unidadMedida.append($("<option />").val("-1").text("SELECCIONE UNIDAD MEDIDA"));
		 		$.each(unidadMedidas, function() {
		 			unidadMedida.append($("<option />").val(this.codigo).text(this.nombre));
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
	 		
	 		var funcionarios = service.funcionario.getAll();
	 		var $funcionario = $("#funcionario");
	 		$funcionario.append($("<option />").val("-1").text("SELECCIONE FUNCIONARIO"));
	 		$.each(funcionarios, function() {
	 			$funcionario.append($("<option />").val(this.rut).text(this.nombre));
	 		});
	 		
	 		$("#add").click(function() {
	 			console.log("devolucion insumo controller");
	 			if(requiredField()) {
	 				var codigoOrdenFabricacion = $("#ordenFabricacion").val();
		 			var insumo = $("#insumo").val();
		 			var cantidad = $("#cantidad").val();
		 			var unidadMedida = $("#unidadMedida").val();
		 			var codigoBodega = $("#bodega").val();
		 			var fechaVencimiento = $("#fechaVencimiento").val();
		 			var rutfuncionario = $("#funcionario").val();
		 			var observacion = $("#observacion").val();
		 			
		 			var devolucionInsumo = {"ordenFabricacion": {"codigoOrdenFabricacion" : codigoOrdenFabricacion},
								"funcionario": {"rut" : rutfuncionario},
								"detalleDevolucionInsumo" : {"cantidadDevolucionInsumo" : cantidad, 
														  "codigoUnidadMedida" : unidadMedida,
														  "insumo" : {"codigo" : insumo,
															  		  "ubicacions" : [{"codigoProducto" : insumo,
															  			  			   "bodega" : {"codigo" : codigoBodega},
															  			  			   "fechaVencimiento" : fechaVencimiento
															  			  			   }]
														  			  }
														  },
								 "observacion": observacion,
							    };
		 			
		 			var resp = service.devolucionInsumo.add(devolucionInsumo);
		 			if(resp.respuesta) {
		 				devolucionInsumo = resp.devolucionInsumo;		 			
			 			var funcionario = devolucionInsumo.funcionario.nombre + " "  +
			 								devolucionInsumo.funcionario.apellidopaterno + " " +
			 								devolucionInsumo.funcionario.apellidomaterno;
			 			jQuery("#navgrid2").jqGrid('addRowData', devolucionInsumo.correlativoDevolucionInsumo, 
									{'id' : devolucionInsumo.correlativoDevolucionInsumo, 
			 						'funcionario' : funcionario, 
					            	'insumo' : devolucionInsumo.detalleDevolucionInsumo.insumo.nombre, 
					            	'cantidad' : devolucionInsumo.detalleDevolucionInsumo.cantidadDevolucionInsumo,
					            	'unidadMedida' : devolucionInsumo.detalleDevolucionInsumo.codigoUnidadMedida,
					            	'fechaDevolucion' : moment(devolucionInsumo.fechaDevolucioninsumo).format("MM-DD-YYYY"),
					            	'horaDevolucion' : moment(devolucionInsumo.horaDevolucionInsumo).format("HH:mm"),					            	
					            	'observacion' : devolucionInsumo.observacion,
						            },
				 				'first');
			 			jQuery("#navgrid2").jqGrid('setSelection', devolucionInsumo.correlativoDevolucionInsumo, false);
		
		 			} else {
		 				console.log("Problemas al grabar devolución insumo!");
		 				bootstrapDialog.show({message: 'Problemas al grabar devolución insumo!'});
		 			}
	 			}
	 		
	 		});
	 		$("#cancelar").click(function() {
	 			console.log("devolución insumo controller");
				$( '#dialog' ).dialog("close");
	 		});
	 		
	 		$("#cargando").spin(false);
		},
		requiredField : function() {
			var message = "";
			var codigoOrdenFabricacion = $("#ordenFabricacion").val();
 			if(codigoOrdenFabricacion.trim() == "")
 				message += ' Sin Orden Fabricación,';
			var insumo = $("#insumo").val();
			if(insumo.trim() == "-1")
				message += ' Sin Insumo,';
 			var cantidad = $("#cantidad").val();
 			if(cantidad.trim() == "")
 				message += ' Sin Cantidad,';
 			var unidadMedida = $("#unidadMedida").val();
 			if(unidadMedida.trim() == "-1")
 				message += ' Sin Unidad medida,';
 			var bodega = $("#bodega").val();
 			if(bodega.trim() == "-1")
 				message += ' Sin Bodega,';
 			var fechaVencimiento = $("#fechaVencimiento").val();
 			if(fechaVencimiento.trim() == "")
 				message += ' Sin Fecha Vencimiento,';
 			var rutfuncionario = $("#funcionario").val();
 			if(rutfuncionario.trim() == "-1")
 				message += ' Sin Rut,';
 			var observacion = $("#observacion").val();
 			if(observacion.trim() == "-1")
 				message += ' Sin Ubicación,';
			
			if(message.length > 0) {
				bootstrapDialog.show({message: message});
				return false;
			} else { 
				return true;
			}				
		}
		
	};
});