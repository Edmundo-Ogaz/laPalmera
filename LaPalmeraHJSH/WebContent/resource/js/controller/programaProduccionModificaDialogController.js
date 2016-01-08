define(["jquery", "service","bootstrap-dialog", "moment", "bootstrap-datetimepicker", "spin", "spin-jquery", "model", "page", "dialog"], 
		function($, service, bootstrapDialog, moment, bootstrapdatetimepicker, spin, spinjquery, model, page, dialog) {
 
	console.log("Function : programa producción modifica dialog Controller");

	return {
		init : function(programaProduccion) {
			
			var fill = this.fill;
			
			var html = page.programaProduccionModifica.get();
			dialog.modal(html,"Modifica Programa Producción");
	 		
	 		jQuery("#dialog #programaProduccionModifica #programaProduccion #navgrid").jqGrid({
				datatype: "local",
				jsonReader : { repeatitems: false },
				colNames:['Programa Produción', 'Fecha', 'Orden Fabricación', 'Producto', 'Línea Producción', 'Cantidad Programada', 'Cantidad Fabricada', 'Saldo por Fabricar'],
				colModel:[
				  		{name:'programaProduccion', index:'programaProduccion', key:true,  align:'left'},
				  		{name:'fecha',index:'fecha',         align:'right'},
				  		{name:'ordenFabricacion',index:'ordenFabricacion', align:'left'},
				  		{name:'producto',index:'producto',       align:'right'},
				  		{name:'lineaProduccion',index:'lineaProduccion',   align:'left'},
				  		{name:'cantidadProgramada',index:'cantidadProgramada',   align:'left'},
				  		{name:'cantidadFabricada',index:'cantidadFabricada',   align:'left'},
				  		{name:'saldoPorFabricar',index:'saldoPorFabricar',   align:'left'},
				  	],
			  	rowNum:10,
			  	rowList:[10,20,30],
			  	pager: jQuery('#dialog #programaProduccionModifica #programaProduccion #pagernav'),
			  	sortname: 'programaProduccion',
			  	viewrecords: true,
			  	sortorder: "asc",
			  	caption:"Programa Producción",
			  	editurl:"clientArray",
			  	height:125,
			  	autowidth:true,			  	
	 		});
		 		
	 		$(window).on("resize", function () {
			    var newWidth = $("#programaProduccionModifica #programaProduccion #navgrid").closest(".ui-jqgrid").parent().width();
			    $("#programaProduccionModifica #programaProduccion #navgrid").jqGrid("setGridWidth", newWidth, true);
			    // without scrollbar
			    $("#programaProduccionModifica #programaProduccion #navgrid").closest('.ui-jqgrid-bdiv').width($("#programaProduccionModifica #programaProduccion #navgrid").closest('.ui-jqgrid-bdiv').width() + 1);
			});
		 		
	 		$("#programaProduccionModifica #programaProduccionNew #enviar").click(function() {
	 			console.log("enviar nuevo programa producción controller");		 			
	 			 			
	 			var lineaProduccionCodigo = $("#programaProduccionModifica #programaProduccionNew #lineaProduccion").val();
	 			var lineaProduccionNombre = $("#programaProduccionModifica #programaProduccionNew #lineaProduccion option:selected").text();
	 			var cantidad = $("#programaProduccionModifica #programaProduccionNew #cantidad").val();
	 			var programaProduccions = $('#programaProduccionModifica #programaProduccion #navgrid').jqGrid('getGridParam','data');
	 			
	 			var ordenFabricacion = jQuery.extend(true, {}, $('#state').data('ordenFabricacion'));
	 			var programaProduccionLength = ordenFabricacion.programaProduccions.length;
	 			
	 			try {
		 			for(var i=0; i<programaProduccionLength; i++) {
		 				if(ordenFabricacion.programaProduccions[i].codigo ==  programaProduccions[0].programaProduccion) {
		 					var saldoPorFabricar = ordenFabricacion.programaProduccions[i].saldoporfabricar - cantidad;
		 					if(saldoPorFabricar < 0) {
		 						throw "Nueva cantidad programada mayor a saldo por fabricar!";
		 					}
		 					var cantidadProgramada = saldoPorFabricar + ordenFabricacion.programaProduccions[i].cantidadfabricada;
		 					
		 					ordenFabricacion.programaProduccions[i].cantidadprogramada = cantidadProgramada;
		 					ordenFabricacion.programaProduccions[i].saldoporfabricar = saldoPorFabricar;
		 					
		 					break;
		 				}
		 			}
		 			
		 			var programaProduccion = {"codigo" : ordenFabricacion.codigoOrdenFabricacion + '-' + (programaProduccionLength + 1), 									 	 							   	 
			 							   	 "fechaprogramaproduccion" : moment().locale('es').format('YYYY-MM-DD HH:mm:ss'),
			 							   	 "ordenFabricacion" : {"codigoOrdenFabricacion": ordenFabricacion.codigoOrdenFabricacion},
		 									 "producto" : {"codigo" : ordenFabricacion.producto.codigo, "nombre" : ordenFabricacion.producto.nombre},
		 									 "lineaProduccion": {'codigo' : lineaProduccionCodigo, "nombre" : lineaProduccionNombre},
		 									 "cantidadprogramada" : cantidad,
		 									 "cantidadfabricada" : 0,
		 									 "saldoporfabricar" : cantidad,
		 									 "active" : 1};
		 			
		 			ordenFabricacion.programaProduccions.push(programaProduccion);
				
					var resp = service.ordenFabricacion.save(ordenFabricacion);
		 			
		 			if(resp instanceof Object) {
		 				bootstrapDialog.show({message: 'Programa Producción grabada!'});
		 				$('#state').data('ordenFabricacion',ordenFabricacion);
		 				$('#state').removeData('programaProduccion');
		 				$("#dialog" ).dialog("close");		 				
		 				resp = programaProduccion;
		 			}
		 			
		 			return resp;	            	
	 			}
            	catch(err) {
            		bootstrapDialog.show({message: err});
            	}
            	
	 		});
		 		
	 		$('#cargando').spin();
	 		
	 		setTimeout(function() {
	 			
		 		var resp = service.lineaProduccion.getAll();
		 		if(resp instanceof Array) {
		 			var lineaProduccions = resp;
			 		var options = $("#programaProduccionModifica #programaProduccionNew #lineaProduccion");
			 		options.append($("<option />").val("-1").text("SELECCIONE LINEA PRODUCCION"));
			 		$.each(lineaProduccions, function() {
			 		    options.append($("<option />").val(this.codigo).text(this.nombre));
			 		});
		 		}
		 		
		 		$("#programaProduccionModifica #programaProduccionNew #unidadMedida").html(programaProduccion.producto.unidadMedida.codigo);
		 		
		 		fill(programaProduccion);
		 		
		 		$("#cargando").spin(false);
		 		
	 		}, 10);
		},
		fill : function(programaProduccion) {

 			var array = []; 				
 				array.push({'programaProduccion' : programaProduccion.codigo, 
					'fecha' : moment(programaProduccion.fechaprogramaproduccion).format("MM-DD-YYYY"),
					'ordenFabricacion' : programaProduccion.ordenFabricacion,
            		'producto' : programaProduccion.producto.nombre,
	            	'lineaProduccion' : programaProduccion.lineaProduccion.nombre,
	            	'cantidadProgramada' : programaProduccion.cantidadprogramada,
	            	'cantidadFabricada' : programaProduccion.cantidadfabricada,
	            	'saldoPorFabricar' : programaProduccion.saldoporfabricar,
 				});
 			
 			jQuery("#programaProduccionModifica #programaProduccion #navgrid").jqGrid('addRowData', 'id', array); 			
 			
 			$('#state').data('programaProduccion',programaProduccion);
 			
		},
	};
});