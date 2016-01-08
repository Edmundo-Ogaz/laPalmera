define(["jquery", "service","bootstrap-dialog", "moment"], function($, service, bootstrapDialog, moment) {
 
	console.log("Function : solicitud Producto Lista Controller");

	return {
		init : function(codigoProducto, idUbicacion) {
			
			$('#titulo').html('Listado Ingreso Insumo');
		 	$('#page').load('ingresoInsumoLista.html', function() {				
		 				 		
		 		jQuery("#navgrid").jqGrid({
					datatype: "local",
					jsonReader : { repeatitems: false },
					colNames:['Bodega', 'Ubicación', 'Fecha Ingreso', 'Fecha Vencimiento', 'Cantidad', 'Unidad Medida'],
					colModel:[
						    {name:'bodega',           index:'OrdenFabricación',    align:'left', key:true},
							{name:'ubicacion',        index:'Producto',            align:'left'},
							{name:'fechaIngreso',     index:'LineaProducción',     align:'left'},
							{name:'fechaVencimiento', index:'CantidadFabricada',   align:'right'},
							{name:'cantidad',         index:'CantidadporFabricar', align:'right'},
							{name:'unidadMedida',     index:'Estado',              align:'left'},
					  	],
				  	rowNum:10,
				  	rowList:[10,20,30],
				  	pager: '#pagernav',
				  	gridview: true,
				  	autoencode: true,				  	
				  	sortname: 'bodega',
				  	viewrecords: true,
				  	sortorder: "asc",
				  	caption:"Insumos",
				  	editurl:"clientArray",
				  	autowidth:true,
				  	height:'auto',
		 		});
		 		
		 		jQuery("#navgrid").jqGrid('setGroupHeaders', {
		 			  useColSpanStyle: false, 
		 			  groupHeaders:[
		 				{startColumnName: 'bodega', numberOfColumns: 7, titleText: 'Ubicación'}		 				
		 			  ]	
		 			});
		 		
		 		//var producto = service.producto.getStockUbicacion(codigoProducto);
		 		var producto = service.producto.get(codigoProducto);
		 		
		 		$("#producto").html(producto.nombre);
		 		$("#stockDisponible").html(producto.stock.stockDisponible);
		 		$("#unidadMedida").html(producto.stock.codigoUnidadMedida);
			  	
		 		var setSelection = "";
			  	var array = [];				  	
				for(var i=0; i< producto.ubicacions.length;i++) {
					
					jQuery("#navgrid").jqGrid('addRowData', i, 
											{'bodega' : producto.ubicacions[i].bodega.nombre, 
							            	'ubicacion' : producto.ubicacions[i].observacion, 
							            	'fechaIngreso' : moment(producto.ubicacions[i].fechaIngreso).format("MM-DD-YYYY HH:mm"),
							            	'fechaVencimiento' : moment(producto.ubicacions[i].fechaVencimiento).format("MM-DD-YYYY"),
							            	'cantidad' : producto.ubicacions[i].cantidad,
							            	'unidadMedida' : producto.ubicacions[i].codigoUnidadMedida,
							            });
					
					if(idUbicacion == producto.ubicacions[i].id)
						setSelection = i;
				}
				
				jQuery("#navgrid").jqGrid('setSelection', setSelection, false);
				
				// without scrollbar
			    $("#navgrid").closest('.ui-jqgrid-bdiv').width($("#navgrid").closest('.ui-jqgrid-bdiv').width() + 1);
				
				$(window).on("resize", function () {
				    var newWidth = $("#navgrid").closest(".ui-jqgrid").parent().width();
				    $("#navgrid").jqGrid("setGridWidth", newWidth, true);
				    // without scrollbar
				    $("#navgrid").closest('.ui-jqgrid-bdiv').width($("#navgrid").closest('.ui-jqgrid-bdiv').width() + 1);
				});
		 						
				$("#nuevaInsumo").click(function() {
		 			console.log("nueva ingreso insumo");
		 			window.location.hash = '#/ingresoInsumo';
		 		});
		 	});
		}
	};
});