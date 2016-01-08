define(["jquery", "service","bootstrap-dialog", "spin", "spin-jquery", "page", "dialog", "moment"], 
		function($, service, bootstrapDialog, spin, spinJquery, page, dialog, moment) {
 
	console.log("Function : Captura Producción Controller");

	return {
		init : function(capturaProduccion) {
			
			var clear = this.clear;
			var requiredField = this.requiredField;
			
			var html = page.capturaProduccion.get();			
			dialog.modal(html,"Captura Producción");
			
			$('#datetimepicker').datetimepicker({
	 			inline: true,
                //sideBySide: true
	 			format : 'DD-MM-YYYY'
            });
	 		$("#datetimepicker").on("dp.change", function (e) {
	 			$('#fechaVencimiento').val(e.date.locale('es').format('YYYY-MM-DD HH:mm:ss'));
	            $('#fechaVencimientoView').val(e.date.locale('es').format('DD-MM-YYYY'));		            
	        });
			
	 		jQuery("#navgrid").jqGrid({
				datatype: "local",
				jsonReader : { repeatitems: false },
				colNames:['Rut', 'Nombre', 'Apellido Paterno', 'Apellido Materno'],
				colModel:[
				        {name:'rut', index:'rut', key:true, align:'left'},
				  		{name:'nombre', index:'nombre', align:'left'},
				  		{name:'apellidoPaterno', index:'apellidoPaterno', align:'left'},
				  		{name:'apellidoMaterno', index:'apellidoMaterno', align:'left'},
				  	],
			  	rowNum:10,
			  	rowList:[10,20,30],
			  	pager: '#pagernav',
			  	multiselect: true,
			  	sortname: 'funcionario',
			  	viewrecords: true,
			  	sortorder: "asc",
			  	caption:"Funcionario",
			  	editurl:"clientArray",
			  	autowidth:true,
			  	height:100,
	 		});
	 		
			$('#cargando').spin();
			
			$('#capturaProduccion #productoCodigo').val(capturaProduccion.producto.codigo);
			$('#capturaProduccion #productoNombre').html(capturaProduccion.producto.nombre);
	 		
			var unidadMedida = {"familia" : {"codigo" : capturaProduccion.producto.unidadMedida.familia.codigo}};
 			var unidadMedidas = service.unidadMedida.getAllEqBy(unidadMedida);
 			if(unidadMedidas instanceof Array) {
		 		var $unidadMedida = $("#unidadMedida");
		 		$unidadMedida.append($("<option />").val("-1").text("SELECCIONE UNIDAD MEDIDA"));
		 		$.each(unidadMedidas, function() {
		 			$unidadMedida.append($("<option />").val(this.codigo).text(this.nombre));
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
			var array = [];
			for(var i=0; i< funcionarios.length; i++) {
					
				array.push({'rut' : funcionarios[i].rut, 
							'nombre' : funcionarios[i].nombre,
							'apellidoPaterno' : funcionarios[i].apellidoPaterno,
							'apellidoMaterno' : funcionarios[i].apellidoMaterno,
			            });
			}
				
			jQuery("#navgrid").jqGrid('addRowData', 'rut', array);
			jQuery("#navgrid").trigger("reloadGrid");
			
			// without scrollbar
		    $("#navgrid").closest('.ui-jqgrid-bdiv').width($("#navgrid").closest('.ui-jqgrid-bdiv').width() + 1);
			
			$(window).on("resize", function () {
			    var newWidth = $("#navgrid").closest(".ui-jqgrid").parent().width();
			    $("#navgrid").jqGrid("setGridWidth", newWidth, true);
			    // without scrollbar
			    $("#navgrid").closest('.ui-jqgrid-bdiv').width($("#navgrid").closest('.ui-jqgrid-bdiv').width() + 1);
			});
	 		
	 		$("#add").click(function() {
	 			console.log("Captura Producción controller");
	 			if(requiredField()) {
	 				var programaProduccion = $('#state').data('programaProduccion');
		 			var codigoProgramaProduccion = $("#programaProduccion").val();
		 			var productoCodigo = $("#productoCodigo").val();
		 			var productoCantidad = $("#cantidad").val();
		 			var unidadMedidaCodigo = $("#unidadMedida").val();
		 			var bodegaCodigo = $("#bodega").val();
		 			var ubicacionObservacion = $("#ubicacionObservacion").val();
		 			var fechaVencimiento = $("#fechaVencimiento").val();
		 			var observacion = $("#observacion").val();
		 			var ids = jQuery("#navgrid").jqGrid('getGridParam','selarrrow');		 			
		 			var funcionarios = [];
		 			for(var i=0; i<ids.length; i++) {
		 				funcionarios.push({"rut" : ids[i]});
		 			}
		 			
		 			var capturaProduccionToSave = {
		 					 "programaProduccion": {"codigo" : codigoProgramaProduccion},
							 "fechaCapturaProduccion" : moment().locale('es').format('YYYY-MM-DD HH:mm:ss'),
							 "funcionarios" : funcionarios,
			 				 "producto" : {"codigo" : productoCodigo,
			 					 		   "nombre" : programaProduccion.producto.nombre,
								  		   "ubicacions" : [{"producto" : {"codigo" : productoCodigo},
							  	  			  			    "bodega" : {"codigo" : bodegaCodigo},
							  	  			  			    "fechaIngreso" :  moment().locale('es').format('YYYY-MM-DD HH:mm:ss'),
							  	  			  				"fechaVencimiento" : fechaVencimiento,
									  			  			"cantidad": productoCantidad,
									  			  			"unidadMedida" : {"codigo": unidadMedidaCodigo},
									  			  			"observacion" : ubicacionObservacion,
									  			  			}]
								  		  },
					  		 "cantidadProduccion": productoCantidad,
					  		 "unidadMedida" : {"codigo": unidadMedidaCodigo},
					  		 "observacion": observacion,
						    };
		 			
		 			var resp = service.capturaProduccion.add(capturaProduccionToSave);

		 			if(resp.respuesta) {
		 				var capturaProduccion = resp.capturaProduccion;
		 				var funcionario = "";
		 				for(var j=0; j < capturaProduccion.funcionarios.length; j++) {
		 					funcionario += capturaProduccion.funcionarios[j].nombre + " " +
			 								capturaProduccion.funcionarios[j].apellidoPaterno + " " + 
			 								capturaProduccion.funcionarios[j].apellidoMaterno + ", ";
		 				}
			 			jQuery("#navgrid2").jqGrid('addRowData', capturaProduccion.correlativoProduccion, 
									{'funcionario' : funcionario, 
					            	'producto' : capturaProduccion.producto.nombre, 
					            	'cantidad' : capturaProduccion.cantidadProduccion,
					            	'unidadMedida' : capturaProduccion.unidadMedida.codigo,
					            	'fechaCaptura' : moment(capturaProduccion.fechaCapturaProduccion).format("MM-DD-YYYY HH:mm"),				            	
					            	'observacion' : capturaProduccion.observacion,
						            },
				 				'first');
			 			jQuery("#navgrid2").jqGrid('setSelection', capturaProduccion.correlativoProduccion, false);
			 			
			 			$("#dialog" ).dialog("close");
			 			
		 			} else if(!resp.respuesta) {
		 				console.log(resp.detalle);
		 				bootstrapDialog.show({message: resp.detalle});
		 			} else {
		 				console.log('Problema al grabar captura produccón');
		 				bootstrapDialog.show({message: 'Problema al grabar captura produccón'});
		 			}
	 			}
	 		
	 		});
	 		$("#cancelar").click(function() {
	 			console.log("cerrar captura producción controller");
				$( '#dialog' ).dialog("close");
	 		});
	 		
	 		$("#cargando").spin(false);
		},
		clear : function() {
			jQuery("#navgrid").jqGrid("clearGridData")
		},
		requiredField : function() {
			var message = "";
			var codigoProgramaProduccion = $("#programaProduccion").val();
 			if(codigoProgramaProduccion.trim() == "")
 				message += ' Sin Programa Producción,';
			var producto = $("#productoCodigo").val();
			if(producto.trim() == "")
				message += ' Sin Producto,';
 			var cantidad = $("#cantidad").val();
 			if(cantidad.trim() == "")
 				message += ' Sin Cantidad,';
 			var unidadMedida = $("#unidadMedida").val();
 			if(unidadMedida.trim() == "-1")
 				message += ' Sin Unidad medida,';
 			var bodega = $("#bodega").val();
 			if(bodega.trim() == "-1")
 				message += ' Sin Bodega,';
 			
// 			var id = jQuery("#navgrid").jqGrid('getGridParam','selrow');
//			if(!id)
//				message += ' Sin Funcionario,';
 			
 			//multipled select
 			var ids = jQuery("#navgrid").jqGrid('getGridParam','selarrrow');
			if(ids.length == 0)
				message += ' Sin Funcionario,';
			
			if(message.length > 0) {
				bootstrapDialog.show({message: message});
				return false;
			} else { 
				return true;
			}				
		}
		
	};
});