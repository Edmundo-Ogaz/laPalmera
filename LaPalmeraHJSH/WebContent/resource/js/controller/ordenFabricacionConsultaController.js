define(["jquery", "jqGrid", "bootstrap-dialog", "moment", "bootstrap-datetimepicker", "spin", "spin-jquery", "underscore", 
        "service", "page", "pedidoConsultaDialogController"], 
		function($, jqGrid, bootstrapDialog, moment, bootstrapdatetimepicker, spin, spinjquery, underscore, 
				service, page, pedidoConsultaDialogController) {
 
	console.log("Function : consultar orden fabricación controller");

	return {
		init : function() {
			
			$('#titulo').html('Consulta Orden Fabricación');
	 		$('#page').html(page.ordenFabricacionConsulta.get());
 		
	 		jQuery("#navgrid").jqGrid({
				datatype: "local",
				jsonReader : { repeatitems: false },
				colNames:['Orden Fabricación', 'Número Pedido', 'Fecha Entrega', 'Producto', 'Estado OrdenFabricación'],
				colModel:[
				  		{name:'ordenFabricacion', index:'ordenFabricacion', key:true,  align:'left'},
				  		{name:'numeroPedido',index:'numeroPedido',         hidden:true},
				  		{name:'fechaEntrega',index:'fechaEntrega',         align:'left'},
				  		{name:'producto',index:'producto', align:'left'},
				  		{name:'estadoOrdenFabricacion',index:'estadoOrdenFabricacion',   align:'left'},
				  	],
			  	rowNum:10,
			  	rowList:[10,20,30],
			  	pager: '#pagernav',
			  	sortname: 'ordenFabricacion',
			  	viewrecords: true,
			  	sortorder: "asc",
			  	caption:"Orden de Fabricación",
			  	editurl:"clientArray",
			  	height:225,
			  	autowidth:true,
			  	ondblClickRow: function (rowid, iRow,iCol) {
			  		//var pedidos = $('#state').data('pedidos');
					//var pedido = underscore.where(pedidos, {numeroPedido : parseInt(rowid)});
					//pedidoConsultaDialogController.init(pedido);
		        }
	 		});
		 		
	 		$(window).on("resize", function () {
			    var newWidth = $("#navgrid").closest(".ui-jqgrid").parent().width();
			    $("#navgrid").jqGrid("setGridWidth", newWidth, true);
			    // without scrollbar
			    $("#navgrid").closest('.ui-jqgrid-bdiv').width($("#navgrid").closest('.ui-jqgrid-bdiv').width() + 1);
			});
	 		
	 		$('#ordenFabricacionConsulta #buscar #datetimepickerInicio').datetimepicker({
	 			format: 'LLLL'
            });
	 		$("#ordenFabricacionConsulta #buscar #datetimepickerInicio").on("dp.change", function (e) {
	 			$('#ordenFabricacionConsulta #buscar #fechaInicio').val(e.date.locale('es').format('YYYY-MM-DD HH:mm'));		            
	        });
            
            $('#ordenFabricacionConsulta #buscar #datetimepickerTermino').datetimepicker({
            	format: 'LLLL'
            });
	 		$("#ordenFabricacionConsulta #buscar #datetimepickerTermino").on("dp.change", function (e) {
	 			$('#ordenFabricacionConsulta #buscar #fechaTermino').val(e.date.locale('es').format('YYYY-MM-DD HH:mm'));	            
	        });
	 		
	 		//BUSCAR PEDIDO"
	 		$("#ordenFabricacionConsulta #buscar #buscarPedido").click(function() {
	 			console.log("Buscar Pedido controller");
	 			
	 			$('#cargando').spin();
	 			
	 			setTimeout(function() {
	 			
		 			var codigoOrdenFabricacion = $("#ordenFabricacionConsulta #buscar #ordenFabricacion").val();
		 			var fechaInicio = $("#ordenFabricacionConsulta #buscar #fechaInicio").val();
		 			var fechaTermino = $("#ordenFabricacionConsulta #buscar #fechaTermino").val();
		 			var estadoOrdenFabricacion = $("#ordenFabricacionConsulta #buscar #estadoOrdenFabricacion").val();
		 			
		 			var ordenFabricacion = {"codigoOrdenFabricacion" : codigoOrdenFabricacion,	 									
				 						    "estadoOrdenFabricacion" : estadoOrdenFabricacion != '-1' ? estadoOrdenFabricacion : "",
				 						    "fechaInicio" : fechaInicio,
				 						    "fechaTermino" : fechaTermino};
		 			
		 			var resp = service.ordenFabricacion.getAllEqBy(ordenFabricacion);
		 							 			
		 			if(resp instanceof Array) {
		 				var ordenFabricacions = resp;
			 			if(ordenFabricacions.length > 0) {
			 				$('#state').data('ordenFabricacions',ordenFabricacions);
					 		var array = [];
							for(var i=0; i< ordenFabricacions.length; i++) {					
								array.push({'ordenFabricacion' : ordenFabricacions[i].codigoOrdenFabricacion, 
											'numeroPedido' : ordenFabricacions[i].cabezaPedido.numeroPedido, 
						            		'fechaEntrega' : moment(ordenFabricacions[i].cabezaPedido.despachoPedido.fechaentregadespacho).format("MM-DD-YYYY"),
							            	'producto' : ordenFabricacions[i].producto.nombre,
							            	'estadoOrdenFabricacion' : ordenFabricacions[i].estadoOrdenFabricacion.nombre,
						        });
							}
							jQuery("#navgrid").jqGrid("clearGridData").jqGrid('addRowData', 'ordenFabricacion', array);
							jQuery("#navgrid").trigger("reloadGrid");
			 			} else if(ordenFabricacions == undefined || ordenFabricacions.length == 0) {
			 				console.log("No existen orden fabricación para consultar!");
			 				bootstrapDialog.show({message: 'No existen orden fabricación para consultar!'});
			 			}
			 		}
		 			
		 			$("#cargando").spin(false);
		 			
	 			}, 10);
	 		});
	 		
	 		$('#cargando').spin();
	 		
	 		setTimeout(function() {
		 		
		 		var resp = service.estadoOrdenFabricacion.getAll();
		 		if(resp instanceof Array) {
		 			var estadoPedidos = resp;
			 		var options = $("#ordenFabricacionConsulta #buscar #estadoOrdenFabricacion");
			 		options.append($("<option />").val("-1").text("SELECCIONE ESTADO PEDIDO"));
			 		$.each(estadoPedidos, function() {
			 		    options.append($("<option />").val(this.codigo).text(this.nombre));
			 		});
		 		}
		 		
		 		$("#cargando").spin(false);
		 		
	 		}, 10);
		},		
	};
});