define(["jquery", "service","bootstrap-dialog", "moment"], function($, service, bootstrapDialog, moment) {
 
	console.log("Function : solicitud Producto Lista Controller");

	return {
		init : function(numeroPedido) {
			
			$('#titulo').html('Lista Solicitud Producto');
		 	$('#page').load('solicitudProductoLista.html', function() {				
		 				 		
		 		jQuery("#navgrid").jqGrid({
					datatype: "local",
					jsonReader : { repeatitems: false },
					colNames:['Orden Fabricación', 'Producto', 'Linea Producción', 'Cantidad Programada', 'Cantidad Fabricada', 'Cantidad por Fabricar', 'Estado'],
					colModel:[
						    {name:'OrdenFabricación',   index:'OrdenFabricación', key:true,     align:'left'},
							{name:'Producto',           index:'Producto',                       align:'left'},
							{name:'LineaProducción',    index:'LineaProducción',                align:'left'},
							{name:'CantidadProgramada', index:'CantidadProgramada',             align:'right'},
							{name:'CantidadFabricada',  index:'CantidadFabricada',              align:'right'},
							{name:'SaldoPorFabricar',	index:'SaldoPorFabricar',            	align:'right'},
							{name:'Estado',             index:'Estado',                         align:'left'},
					  	],
				  	rowNum:10,
				  	rowList:[10,20,30],
				  	pager: '#pagernav',
				  	gridview: true,
				  	autoencode: true,
				  	
				  	sortname: 'OrdenFabricación',
				  	viewrecords: true,
				  	sortorder: "asc",
				  	caption:"Orden Fabricación",
				  	editurl:"clientArray",
				  	autowidth:true,
				  	height:100,
		 		});
			  	
			  	var pedido = service.pedido.get(numeroPedido);
		 		
		 		$("#numeroPedido").html(pedido.numeroPedido);
		 		$("#nombreCliente").html(pedido.cliente.nombre);
		 		$("#fecha").html(pedido.despachoPedido.fechaentregadespacho);
			  	
			  	var array = [];
			  	if(pedido.ordenFabricacions instanceof Array) {
					for(var i=0; i<pedido.ordenFabricacions.length; i++) {
						array.push({'OrdenFabricación' : pedido.ordenFabricacions[i].codigoOrdenFabricacion, 
						            'Producto' : pedido.ordenFabricacions[i].producto.nombre, 
						            'LineaProducción' : pedido.ordenFabricacions[i].programarProduccion.lineaProduccion.nombre, 
						            'CantidadProgramada' : pedido.ordenFabricacions[i].programarProduccion.cantidadprogramada, 
						            'CantidadFabricada' : pedido.ordenFabricacions[i].programarProduccion.cantidadfabricada,
						            'SaldoPorFabricar' : pedido.ordenFabricacions[i].programarProduccion.saldoporfabricar,
						            'Estado' : pedido.ordenFabricacions[i].programarProduccion.estadoOrdenFabricacion.nombre}); 
					}
			  	}
			  	
		 		/*var ordenFabricacion = {"cabezaPedido" : {"numeroPedido" : numeroPedido}};
		 		ordenFabricacions = service.ordenFabricacion.getAllEqBy(ordenFabricacion);
		 		
		 		$("#numeroPedido").html(ordenFabricacions[0].cabezaPedido.numeroPedido);
		 		$("#nombreCliente").html(ordenFabricacions[0].cabezaPedido.nombreCliente);
		 		$("#fecha").html(ordenFabricacions[0].cabezaPedido.despachoPedido.fechaentregadespacho);
		 		$("#hora").html(ordenFabricacions[0].cabezaPedido.despachoPedido.horaentregadestacho);
		 		var array = [];				  	
				for(var i=0;i<ordenFabricacions.length;i++) {		 		
			 					  				  	
					array.push({'OrdenFabricación' : ordenFabricacions[i].codigoOrdenFabricacion, 
					            'Producto' : ordenFabricacions[i].producto.nombre, 
					            'LineaProducción' : ordenFabricacions[i].programarProduccion.lineaProduccion.nombre, 
					            'CantidadProgramada' : ordenFabricacions[i].programarProduccion.cantidadprogramada, 
					            'CantidadFabricada' : ordenFabricacions[i].programarProduccion.cantidadfabricada,
					            'SaldoPorFabricar' : ordenFabricacions[i].programarProduccion.saldoporfabricar,
					            'Estado' : ordenFabricacions[i].programarProduccion.estadoOrdenFabricacion.nombre}); 
				}*/
				
				jQuery("#navgrid").jqGrid("clearGridData").jqGrid('addRowData', 'nombreinsumo', array);
				// without scrollbar
			    $("#navgrid").closest('.ui-jqgrid-bdiv').width($("#navgrid").closest('.ui-jqgrid-bdiv').width() + 1);
				
				$(window).on("resize", function () {
				    var newWidth = $("#navgrid").closest(".ui-jqgrid").parent().width();
				    $("#navgrid").jqGrid("setGridWidth", newWidth, true);
				    // without scrollbar
				    $("#navgrid").closest('.ui-jqgrid-bdiv').width($("#navgrid").closest('.ui-jqgrid-bdiv').width() + 1);
				});
				
				$("#nuevaSolicitud").click(function() {
		 			console.log("nueva solicitud producto");
		 			window.location.hash = '#/solicitudProducto';
		 		});
		 	});
		}
	};
});