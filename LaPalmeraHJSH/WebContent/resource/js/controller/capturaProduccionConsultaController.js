define(["jquery", "service","bootstrap-dialog", "moment", "bootstrap-datetimepicker", "spin", "spin-jquery", "page",
        "capturaProduccionDialogController"], 
		function($, service, bootstrapDialog, moment, bootstrapdatetimepicker, spin, spinJquery, page, 
				capturaProduccionDialogController) {
 
	console.log("Function : Captura producción Controller");

	return {
		init : function() {
			var clear = this.clear;
			var requiredField = this.requiredField;
			$('#titulo').html('Captura Producción');		
			$('#page').html(page.capturaProduccionConsulta.get());
		 		
			jQuery("#navgrid2").jqGrid({
				datatype: "local",
				jsonReader : { repeatitems: false },
				colNames:['Id', 'Funcionario', 'Producto', 'Cantidad', 'Unidad Medida', 'Fecha Captura', 'Observación'],
				colModel:[
				        {name:'id', index:'id', 						key:true, hidden:true, },
				  		{name:'funcionario', index:'funcionario',       align:'left'},
				  		{name:'producto',index:'producto',           	    align:'left'},
				  		{name:'cantidad',index:'cantidad',              align:'right'},
				  		{name:'unidadMedida',index:'unidadMedida',      align:'left'},
				  		{name:'fechaCaptura',index:'fechaCaptura',   align:'left'},
				  		{name:'observacion',index:'observacion',        align:'left'},
				  	],
			  	rowNum:10,
			  	rowList:[10,20,30],
			  	pager: '#pagernav2',
			  	sortname: 'fechaCaptura',
			  	viewrecords: true,
			  	sortorder: "asc",
			  	caption:"Captura Producción",
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
		 		
		 		$("#consulta #programaProduccion").change(function() {
		 			console.log("programa producción Captura Producción controller");
		 			
		 			clear();		 			
		 			
		 			var codigoProgramaProduccion = $('#consulta #programaProduccion').val();
		 			if(codigoProgramaProduccion.trim() != "") {
				 			
		 				setTimeout(function() {
		 					$('#cargando').spin();
				 			
					 		setTimeout(function() {
					 				
				 				var resp = service.programaProduccion.get(codigoProgramaProduccion);
					 							 			
					 			if(resp instanceof Object) {
					 				var programaProduccion =  resp;				 				
					 				$('#state').data('programaProduccion',programaProduccion);
				 					
					 				$('#fechaEntrega').html(programaProduccion.ordenFabricacion.cabezaPedido.despachoPedido.fechaentregadespacho);
				 					$('#estadoOrdenFabricacion').html(programaProduccion.ordenFabricacion.estadoOrdenFabricacion.nombre);
				 					$('#consulta #productoCodigo').val(programaProduccion.producto.codigo);
				 					$('#consulta #productoNombre').html(programaProduccion.producto.nombre);
				 					$('#lineaProduccion').html(programaProduccion.lineaProduccion.nombre);
				 					
				 					$('#cantidadProgramada').html(programaProduccion.cantidadprogramada);			 					
				 					$('#cantidadFabricada').html(programaProduccion.cantidadfabricada);
				 					$('#saldoPorFabricar').html(programaProduccion.saldoporfabricar);
				 					
				 					var array = [];
				 					if(programaProduccion.capturaProduccions.length > 0) {
					 					for(var i=0; i< programaProduccion.capturaProduccions.length; i++) {
					 						var funcionario = "";
							 				for(var j=0; j < programaProduccion.capturaProduccions[i].funcionarios.length; j++) {
							 					funcionario += programaProduccion.capturaProduccions[i].funcionarios[j].nombre + " " +
							 					programaProduccion.capturaProduccions[i].funcionarios[j].apellidoPaterno + " " + 
							 					programaProduccion.capturaProduccions[i].funcionarios[j].apellidoMaterno + ", ";
							 				}
					 					
						 					array.push({'id' : programaProduccion.capturaProduccions[i].correlativoProduccion, 
						 								'funcionario' : funcionario, 
									            		'producto' : programaProduccion.capturaProduccions[i].producto.nombre, 
										            	'cantidad' : programaProduccion.capturaProduccions[i].cantidadProduccion,
										            	'unidadMedida' : programaProduccion.capturaProduccions[i].producto.unidadMedida.codigo,
										            	'fechaCaptura' : moment(programaProduccion.capturaProduccions[i].fechaCapturaProduccion).format("MM-DD-YYYY HH:mm"),
										            	'observacion' : programaProduccion.capturaProduccions[i].observacion,
										            });
										}
				 					} else {
				 						console.log("No existen capturas de producción para este programa de producción!")
				 						bootstrapDialog.show({message: "No existen capturas de producción para este programa de producción!"});
				 					}
									
									jQuery("#navgrid2").jqGrid("clearGridData").jqGrid('addRowData', 'id', array);
									jQuery("#navgrid2").trigger("reloadGrid");
			 					
				 					// without scrollbar
				 				    $("#navgrid2").closest('.ui-jqgrid-bdiv').width($("#navgrid2").closest('.ui-jqgrid-bdiv').width() + 1);
					 		
					 			}
					 			
					 			$("#cargando").spin(false);
					 			
				 			}, 10);
		 				}, 10);				 		
			 		}			 			
 					
		 		});
	 			
	 			$("#consulta #capturaProduccion").click(function() {
		 			console.log("Captura Producción controller");
		 			if(requiredField()) {
		 				
		 				var programaProduccion = $('#state').data('programaProduccion');
		 				
			 			var programaProduccionCodigo = $('#programaProduccion').val();
			 			var productoCodigo = $('#consulta #productoCodigo').val();
			 			var productoNombre = $('#consulta #productoNombre').html();			 			
			 			var familiaUnidadMedida = programaProduccion.producto.unidadMedida.familia.codigo;
			 			var capturaProduccion = {"programaProduccion" : {"codigoProgramaProduccion" : programaProduccionCodigo},
			 									 "producto" : {"codigo" : productoCodigo,
				 											   "nombre" : productoNombre,
				 											   "unidadMedida" : {"familia" : {"codigo" : familiaUnidadMedida}}
			 											      }
			 							        };			 			
			 			capturaProduccionDialogController.init(capturaProduccion);
		 			}		 			
		 		});
		 	//});
		},
		clear : function() {
			$('#fechaEntrega').html("");
			$('#estadoOrdenFabricacion').html("");
			$('#consulta #productoCodigo').html("");
			$('#consulta #productoNombre').html("");
			$('#lineaProduccion').html("");
			$('#cantidadProgramada').html("");
			$('#cantidadFabricada').html("");
			$('#saldoPorFabricar').html("");
			
			jQuery("#navgrid2").jqGrid("clearGridData");
		},
		requiredField : function() {
			var message = "";
			var codigoProgramaProduccion = $("#programaProduccion").val();
 			if(codigoProgramaProduccion.trim() == "")
 				message += ' Sin Programa Producción,';
			
			if(message.length > 0) {
				bootstrapDialog.show({message: message});
				return false;
			} else { 
				return true;
			}				
		}
	};
});