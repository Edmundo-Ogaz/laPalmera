define(["jquery", "service","bootstrap-dialog", "moment", "bootstrap-datetimepicker", "spin", "spin-jquery", "page", 
        "entregaInsumoDialogController"], 
		function($, service, bootstrapDialog, moment, bootstrapdatetimepicker, spin, spinJquery, page, 
				entregaInsumoDialogController) {
 
	console.log("Function : entrega insumo Controller");

	return {
		init : function() {
			var clear = this.clear;
			var requiredField = this.requiredField;
			$('#titulo').html('Entrega Insumo');
		 	//$('#page').load('entregaInsumoConsulta.html', {}, function(response, status, xhr) {
		 	$('#page').html(page.entregaInsumoConsulta.get());
		 		jQuery("#navgrid2").jqGrid({
					datatype: "local",
					jsonReader : { repeatitems: false },
					colNames:['Id', 'Funcionario', 'Insumo', 'Cantidad', 'Unidad Medida', 'Fecha Entrega', 'Hora Entrega', 'Observación'],
					colModel:[
					        {name:'id', index:'id', key:true, hidden:true, align:'left' },
					  		{name:'funcionario', index:'funcionario', align:'left'},
					  		{name:'insumo',index:'insumo',           			align:'right'},
					  		{name:'cantidad',index:'cantidad',            		align:'left'},
					  		{name:'unidadMedida',index:'unidadMedida',          align:'right'},
					  		{name:'fechaEntrega',index:'fechaEntrega',          align:'left'},
					  		{name:'horaEntrega',index:'horaEntrega',            align:'left'},
					  		{name:'observacion',index:'observacion',            align:'left'},
					  	],
				  	rowNum:10,
				  	rowList:[10,20,30],
				  	pager: '#pagernav2',
				  	sortname: 'fechaEntrega',
				  	viewrecords: true,
				  	sortorder: "asc",
				  	caption:"Entrega Insumos",
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
		 			console.log("orden fabricacion entrega insumo controller");
		 			
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
			 					
			 					var array = [];
			 					for(var i=0; i< ordenFabricacion.entregaInsumos.length; i++) {
			 						var funcionario = ordenFabricacion.entregaInsumos[i].funcionario.nombre + 
			 											ordenFabricacion.entregaInsumos[i].funcionario.apellidopaterno + 
			 											ordenFabricacion.entregaInsumos[i].funcionario.apellidomaterno;
			 					
				 					array.push({'id' : ordenFabricacion.entregaInsumos[i].correlativoEntregaInsumo, 
				 								'funcionario' : funcionario, 
							            		'insumo' : ordenFabricacion.entregaInsumos[i].detalleEntregaInsumo.insumo.nombre, 
								            	'cantidad' : ordenFabricacion.entregaInsumos[i].detalleEntregaInsumo.cantidadentregainsumo,
								            	'unidadMedida' : ordenFabricacion.entregaInsumos[i].detalleEntregaInsumo.codigounidadmedida,
								            	'fechaEntrega' : ordenFabricacion.entregaInsumos[i].fechaentregainsumo,
								            	'horaEntrega' : ordenFabricacion.entregaInsumos[i].horaEntregaInsumo,
								            	'observacion' : ordenFabricacion.entregaInsumos[i].observacion,
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
	 			
	 			$("#agregarInsumo").click(function() {
		 			console.log("agregar insumo controller");
		 			if(requiredField()) {
			 			entregaInsumoDialogController.init();
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