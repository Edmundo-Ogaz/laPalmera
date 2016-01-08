define(["jquery", "service","bootstrap-dialog", "moment", "bootstrap-datetimepicker", "spin", "spin-jquery", 
        "page", "devolucionInsumoDialogController"], 
		function($, service, bootstrapDialog, moment, bootstrapdatetimepicker, spin, spinJquery, 
				page, devolucionInsumoDialogController) {
 
	console.log("Function : devolucion insumo Controller");

	return {
		init : function() {
			var clear = this.clear;
			var requiredField = this.requiredField;
			$('#titulo').html('Devolución Insumo');
		 	//$('#page').load('devolucionInsumoConsulta.html', {}, function(response, status, xhr) {
		 	$('#page').html(page.devolucionInsumoConsulta.get());
		 		jQuery("#navgrid2").jqGrid({
					datatype: "local",
					jsonReader : { repeatitems: false },
					colNames:['Id', 'Funcionario', 'Insumo', 'Cantidad', 'Unidad Medida', 'Fecha Devolución', 'Hora Devolución', 'Observación'],
					colModel:[
					        {name:'id', index:'id', 						key:true, hidden:true, },
					  		{name:'funcionario', index:'funcionario',       align:'left'},
					  		{name:'insumo',index:'insumo',           	    align:'left'},
					  		{name:'cantidad',index:'cantidad',              align:'right'},
					  		{name:'unidadMedida',index:'unidadMedida',      align:'left'},
					  		{name:'fechaDevolucion',index:'fechaEntrega',   align:'left'},
					  		{name:'horaDevolucion',index:'horaEntrega',     align:'left'},
					  		{name:'observacion',index:'observacion',        align:'left'},
					  	],
				  	rowNum:10,
				  	rowList:[10,20,30],
				  	pager: '#pagernav2',
				  	sortname: 'fechaDevolucion',
				  	viewrecords: true,
				  	sortorder: "asc",
				  	caption:"Devolución Insumos",
				  	editurl:"clientArray",
				  	autowidth:true,
				  	height:225,
		 		});
		 		
		 		$(window).on("resize", function () {
					    var newWidth = $("#navgrid2").closest(".ui-jqgrid").parent().width();
					    $("#navgrid2").jqGrid("setGridWidth", newWidth, true);
					    // without scrollbar
					    $("#navgrid2").closest('.ui-jqgrid-bdiv').width($("#navgrid2").closest('.ui-jqgrid-bdiv').width() + 1);
					});
		 		
	 			$("#ordenFabricacion").change(function() {
		 			console.log("orden fabricacion Devolución insumo controller");
		 			
		 			clear();
		 			
		 			$('#cargando').spin();
		 			
		 			setTimeout(function() {
		 			
			 			var codigoOrdenFabricacion = $('#ordenFabricacion').val();
			 			if(codigoOrdenFabricacion.trim() != "") {
			 			
			 				var ordenFabricacion = {"codigoOrdenFabricacion" : codigoOrdenFabricacion};
				 			ordenFabricacion = service.ordenFabricacion.get(ordenFabricacion);
				 			
				 			if(ordenFabricacion.codigoOrdenFabricacion == undefined) {
				 				console.log("No se pudo obtener orden fabricación!");
				 				bootstrapDialog.show({message: 'No se pudo obtener orden fabricación!'});
				 			} else {
		 					
			 					$('#fechaEntrega').html(ordenFabricacion.fechaIngresoOrdenFabricacion);
			 					$('#estadoOrdenFabricacion').html(ordenFabricacion.programarProduccion.estadoOrdenFabricacion.nombre);
			 					$('#producto').html(ordenFabricacion.producto.nombre);
			 					$('#lineaProduccion').html(ordenFabricacion.programarProduccion.lineaProduccion.nombre);
			 					$('#cantidadProgramada').html(ordenFabricacion.programarProduccion.cantidadprogramada);
			 					$('#cantidadFabricada').html(ordenFabricacion.programarProduccion.cantidadfabricada);
			 					$('#saldoPorFabricar').html(ordenFabricacion.programarProduccion.saldoporfabricar);
			 					
			 					//var ordenFabricacion = service.ordenFabricacion.get(codigoOrdenFabricacion);
			 					var array = [];
			 					for(var i=0; i< ordenFabricacion.devolucionInsumos.length; i++) {
			 						var funcionario = ordenFabricacion.devolucionInsumos[i].funcionario.nombre + " " + 
			 											ordenFabricacion.devolucionInsumos[i].funcionario.apellidopaterno + " " + 
			 											ordenFabricacion.devolucionInsumos[i].funcionario.apellidomaterno; + " "+
			 					
				 					array.push({'id' : ordenFabricacion.devolucionInsumos[i].correlativoDevolucionInsumo, 
				 								'funcionario' : funcionario, 
							            		'insumo' : ordenFabricacion.devolucionInsumos[i].detalleDevolucionInsumo.insumo.nombre, 
								            	'cantidad' : ordenFabricacion.devolucionInsumos[i].detalleDevolucionInsumo.cantidadDevolucionInsumo,
								            	'unidadMedida' : ordenFabricacion.devolucionInsumos[i].detalleDevolucionInsumo.codigoUnidadMedida,
								            	'fechaDevolucion' : ordenFabricacion.devolucionInsumos[i].fechaDevolucionInsumo,
								            	'horaDevolucion' : ordenFabricacion.devolucionInsumos[i].horaDevolucionInsumo,
								            	'observacion' : ordenFabricacion.devolucionInsumos[i].observacion,
								            });
								}
								
								jQuery("#navgrid2").jqGrid("clearGridData").jqGrid('addRowData', 'id', array);
								jQuery("#navgrid2").trigger("reloadGrid");
		 					
			 					// without scrollbar
			 				    $("#navgrid2").closest('.ui-jqgrid-bdiv').width($("#navgrid2").closest('.ui-jqgrid-bdiv').width() + 1);
				 			}
			 			}
			 			
			 			$("#cargando").spin(false);
			 			
		 			}, 10);
 					
		 		});
	 			
	 			$("#devolucionInsumo").click(function() {
		 			console.log("Devolución insumo controller");
		 			if(requiredField()) {
			 			var ordenFabricacion = $('#ordenFabricacion').val();		
			 			devolucionInsumoDialogController.init(ordenFabricacion);
		 			}		 			
		 		});
		 	//});
		},
		clear : function() {
			$('#fechaEntrega').html("");
			$('#estadoOrdenFabricacion').html("");
			$('#producto').html("");
			$('#lineaProduccion').html("");
			$('#cantidadProgramada').html("");
			$('#cantidadFabricada').html("");
			$('#saldoPorFabricar').html("");
			
			jQuery("#navgrid2").jqGrid("clearGridData")
		},
		requiredField : function() {
			var message = "";
			var codigoOrdenFabricacion = $("#ordenFabricacion").val();
 			if(codigoOrdenFabricacion.trim() == "")
 				message += ' Sin Orden Fabricación,';
			
			if(message.length > 0) {
				bootstrapDialog.show({message: message});
				return false;
			} else { 
				return true;
			}				
		}
	};
});