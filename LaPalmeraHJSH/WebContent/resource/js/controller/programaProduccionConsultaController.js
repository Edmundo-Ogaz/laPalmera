define(["jquery", "jqGrid", "bootstrap-dialog", "moment", "bootstrap-datetimepicker", "spin", "spin-jquery", "underscore", 
        "service", "page", "programaProduccionModificaDialogController"], 
		function($, jqGrid, bootstrapDialog, moment, bootstrapdatetimepicker, spin, spinjquery, underscore, 
				service, page, programaProduccionModificaDialogController) {
 
	console.log("Function : consultar orden fabricación controller");

	return {
		init : function() {
			
			$('#titulo').html('Programar Programa Producción');
	 		$('#page').html(page.programaProduccionConsulta.get());
 		
	 		jQuery("#navgrid").jqGrid({
				datatype: "local",
				jsonReader : { repeatitems: false },
				colNames:['Programa Producción', 'Fecha', 'Producto', 'Linea Producción', 'Cantidad Programada', 'Cantidad Fabricada', 'Saldo por Fabricar'],
				colModel:[
				  		{name:'programaProduccion', index:'programaProduccion', key:true,  align:'left'},
				  		{name:'fecha',index:'fecha',         align:'left'},
				  		{name:'producto',index:'producto', align:'right'},
				  		{name:'lineaProduccion',index:'lineaProduccion',       align:'right'},
				  		{name:'cantidadProgramada',index:'cantidadProgramada',   align:'left'},
				  		{name:'cantidadFabricada',index:'cantidadFabricada',   align:'left'},
				  		{name:'saldoPorFabricar',index:'saldoPorFabricar',   align:'left'},
				  	],
			  	rowNum:10,
			  	rowList:[10,20,30],
			  	pager: '#programaProduccionsPagernav',
			  	sortname: 'programaProduccion',
			  	viewrecords: true,
			  	sortorder: "asc",
			  	caption:"Programa Producción",
			  	editurl:"clientArray",
			  	height:225,
			  	autowidth:true,
			  	ondblClickRow: function (rowId, iRow,iCol) {
			  		var ordenFabricacion = $('#state').data('ordenFabricacion');
					var programaProduccions = underscore.where(ordenFabricacion.programaProduccions, {codigo : rowId});
					//var programaProduccion = jQuery('#navgrid').jqGrid ('getRowData', rowId);
					programaProduccions[0].ordenFabricacion = ordenFabricacion.codigoOrdenFabricacion;
					programaProduccionModificaDialogController.init(programaProduccions[0]);
					
					//LISTENER TO DIALOG EVENT CLICK ENVIAR
			 		$('#dialog #programaProduccionModifica #programaProduccionNew #enviar').on('click', function(e) {
			    		var programaProduccionSave = e.result;
			    		var ordenFabricacion = $('#state').data('ordenFabricacion');
			    		if(ordenFabricacion instanceof Object) {
			    			//ACTUALIZAR GRID
			    			var array = [];
							for(var j=0; j< ordenFabricacion.programaProduccions.length; j++) {
								array.push({'programaProduccion' : ordenFabricacion.programaProduccions[j].codigo, 
											'fecha' : moment(ordenFabricacion.programaProduccions[j].fechaprogramaproduccion).format("MM-DD-YYYY"), 
						            		'producto' : ordenFabricacion.programaProduccions[j].producto.nombre,
							            	'lineaProduccion' : ordenFabricacion.programaProduccions[j].lineaProduccion.nombre,
							            	'cantidadProgramada' : ordenFabricacion.programaProduccions[j].cantidadprogramada,
							            	'cantidadFabricada' : ordenFabricacion.programaProduccions[j].cantidadfabricada,
							            	'saldoPorFabricar' : ordenFabricacion.programaProduccions[j].saldoporfabricar,
						        });
							}
							
							jQuery("#page #programaProduccionConsulta #ordenFabricacion #programaProduccions #navgrid").jqGrid("clearGridData").jqGrid('addRowData', 'programaProduccion', array);
							jQuery("#page #programaProduccionConsulta #ordenFabricacion #programaProduccions #navgrid").trigger("reloadGrid");			
							
							jQuery('#page #programaProduccionConsulta #ordenFabricacion #programaProduccions #navgrid').jqGrid('setSelection', programaProduccionSave.codigo);							
			    		}
			        });
		        }
	 		});
		 		
	 		$(window).on("resize", function () {
			    var newWidth = $("#navgrid").closest(".ui-jqgrid").parent().width();
			    $("#navgrid").jqGrid("setGridWidth", newWidth, true);
			    // without scrollbar
			    $("#navgrid").closest('.ui-jqgrid-bdiv').width($("#navgrid").closest('.ui-jqgrid-bdiv').width() + 1);
			});
	 		
	 		//BUSCAR PEDIDO"
	 		$("#programaProduccionConsulta #consulta #ordenFabricacion").change(function() {
	 			console.log("Buscar Orden Fabricación");
	 			
	 			$('#cargando').spin();
	 			
	 			var codigoOrdenFabricacion = $("#programaProduccionConsulta #consulta #ordenFabricacion").val();
	 			
	 			var resp = service.ordenFabricacion.get(codigoOrdenFabricacion);
	 							 			
	 			if(resp instanceof Object) {
	 				var ordenFabricacion = resp;
	 				$('#state').data('ordenFabricacion',ordenFabricacion);
			 		
	 				$("#programaProduccionConsulta #ordenFabricacion #codigoOrdenFabricacion").html(ordenFabricacion.codigoOrdenFabricacion);
	 				$("#programaProduccionConsulta #ordenFabricacion #fechaIngresoView").html(ordenFabricacion.fechaIngresoOrdenFabricacion);
	 				$("#programaProduccionConsulta #ordenFabricacion #fechaIngreso").html(ordenFabricacion.fechaIngresoOrdenFabricacion);
	 				$("#programaProduccionConsulta #ordenFabricacion #numeroPedido").html(ordenFabricacion.cabezaPedido.numeroPedido);
	 				$("#programaProduccionConsulta #ordenFabricacion #producto").html(ordenFabricacion.producto.nombre);
	 				$("#programaProduccionConsulta #ordenFabricacion #cantidad").html(ordenFabricacion.cantidadProducto);
	 				$("#programaProduccionConsulta #ordenFabricacion #estado").html(ordenFabricacion.estadoOrdenFabricacion.nombre);
			
	 				var array = [];
					for(var i=0; i< ordenFabricacion.programaProduccions.length; i++) {					
						array.push({'programaProduccion' : ordenFabricacion.programaProduccions[i].codigo, 
									'fecha' : moment(ordenFabricacion.programaProduccions[i].fechaprogramaproduccion).format("MM-DD-YYYY"), 
				            		'producto' : ordenFabricacion.programaProduccions[i].producto.nombre,
					            	'lineaProduccion' : ordenFabricacion.programaProduccions[i].lineaProduccion.nombre,
					            	'cantidadProgramada' : ordenFabricacion.programaProduccions[i].cantidadprogramada,
					            	'cantidadFabricada' : ordenFabricacion.programaProduccions[i].cantidadfabricada,
					            	'saldoPorFabricar' : ordenFabricacion.programaProduccions[i].saldoporfabricar,
				        });
					}
					jQuery("#navgrid").jqGrid("clearGridData").jqGrid('addRowData', 'id', array);
					jQuery("#navgrid").trigger("reloadGrid");
	 			} else {
	 				console.log("No existen orden de fabricación!");
	 				bootstrapDialog.show({message: 'No existen orden de fabricación para consultar!'});
	 			}
	 			
	 			$("#cargando").spin(false);
	 		});
		},		
	};
});