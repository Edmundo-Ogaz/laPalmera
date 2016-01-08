define(["jquery", "jqGrid", "bootstrap-dialog", "moment", "bootstrap-datetimepicker", "spin", "spin-jquery", "underscore", 
        "service", "page", "pedidoConsultaDialogController"], 
		function($, jqGrid, bootstrapDialog, moment, bootstrapdatetimepicker, spin, spinjquery, underscore, 
				service, page, pedidoConsultaDialogController) {
 
	console.log("Function : confirmar pedido controller");

	return {
		init : function() {
			
			$('#titulo').html('Consulta Pedido');
	 		$('#page').html(page.pedidoConsulta.get());
 		
	 		jQuery("#pedidoNavgrid").jqGrid({
				datatype: "local",
				jsonReader : { repeatitems: false },
				colNames:['N° Pedido', 'Nombre Cliente', 'Fecha Pedido', 'Precio Total', 'Fecha Confirmación', 'Observación'],
				colModel:[
				  		{name:'id', index:'id', key:true,  align:'left'},
				  		{name:'nombre',index:'nombre',         hidden:true},
				  		{name:'fechaPedido',index:'fechaPedido',         align:'left'},
				  		{name:'precioTotal',index:'precioTotal', align:'right'},
				  		{name:'fechaConfirmacion',index:'fechaConfirmacion',       align:'right'},
				  		{name:'observacion',index:'observacion',   align:'left'},
				  	],
			  	rowNum:10,
			  	rowList:[10,20,30],
			  	pager: '#pedidoPagernav',
			  	sortname: 'codigo',
			  	viewrecords: true,
			  	sortorder: "asc",
			  	caption:"Pedidos",
			  	editurl:"clientArray",
			  	height:225,
			  	autowidth:true,
			  	ondblClickRow: function (rowid, iRow,iCol) {
			  		var pedidos = $('#state').data('pedidos');
					var pedido = underscore.where(pedidos, {numeroPedido : parseInt(rowid)});
					pedidoConsultaDialogController.init(pedido[0]);
		        }
	 		});
		 		
	 		$(window).on("resize", function () {
			    var newWidth = $("#pedidoNavgrid").closest(".ui-jqgrid").parent().width();
			    $("#pedidoNavgrid").jqGrid("setGridWidth", newWidth, true);
			    // without scrollbar
			    $("#pedidoNavgrid").closest('.ui-jqgrid-bdiv').width($("#pedidoNavgrid").closest('.ui-jqgrid-bdiv').width() + 1);
			});
	 		
	 		$('#consultaPedidoLista #buscar #datetimepickerInicio').datetimepicker({
	 			format: 'LLLL'
            });
	 		$("#consultaPedidoLista #buscar #datetimepickerInicio").on("dp.change", function (e) {
	 			$('#consultaPedidoLista #buscar #fechaInicio').val(e.date.locale('es').format('YYYY-MM-DD HH:mm'));		            
	        });
            
            $('#consultaPedidoLista #buscar #datetimepickerTermino').datetimepicker({
            	format: 'LLLL'
            });
	 		$("#consultaPedidoLista #buscar #datetimepickerTermino").on("dp.change", function (e) {
	 			$('#consultaPedidoLista #buscar #fechaTermino').val(e.date.locale('es').format('YYYY-MM-DD HH:mm'));	            
	        });
	 		
	 		//BUSCAR PEDIDO"
	 		$("#consultaPedidoLista #buscar #buscarPedido").click(function() {
	 			console.log("Buscar Pedido controller");
	 			
	 			$('#cargando').spin();
	 			
	 			var numeroPedido = $("#consultaPedidoLista #buscar #numeroPedido").val();
	 			var rutCliente = $("#consultaPedidoLista #buscar #rut").val();
	 			var fechaInicio = $("#consultaPedidoLista #buscar #fechaInicio").val();
	 			var fechaTermino = $("#consultaPedidoLista #buscar #fechaTermino").val();
	 			var estadoPedido = $("#consultaPedidoLista #buscar #estadoPedido").val();
	 			
	 			var pedido = {"numeroPedido" : numeroPedido,
	 						  "cliente" : {"rut" : rutCliente},
	 						  "estadoPedido" : estadoPedido != '-1' ? estadoPedido : "",
	 						  "fechaInicio" : fechaInicio,
	 						  "fechaTermino" : fechaTermino};
	 			
	 			var resp = service.pedido.getAllEqBy(pedido);
	 							 			
	 			if(resp instanceof Array) {
	 				var pedidos = resp;
		 			if(pedidos != undefined || pedidos.length != 0) {
		 				$('#state').data('pedidos',pedidos);
				 		var array = [];
						for(var i=0; i< pedidos.length; i++) {					
							array.push({'id' : pedidos[i].numeroPedido, 
										'nombre' : pedidos[i].nombreCliente, 
					            		'fechaPedido' : moment(pedidos[i].fechapedido).format("MM-DD-YYYY"),
						            	'precioTotal' : pedidos[i].preciototalpedido,
						            	'fechaConfirmacion' : pedidos[i].confirmacionPedido != null ? moment(pedidos[i].confirmacionPedido.fecha).format("MM-DD-YYYY") : "",
						            	'observacion' : pedidos[i].observacionpedido,
					        });				  		
						}
						jQuery("#pedidoNavgrid").jqGrid("clearGridData").jqGrid('addRowData', 'id', array);
						jQuery("#pedidoNavgrid").trigger("reloadGrid");
		 			} else if(pedidos == undefined || pedidos.length == 0) {
		 				console.log("No existen pedido para consultar!");
		 				bootstrapDialog.show({message: 'No existen pedido para consultar!'});
		 			}
		 		}
	 			
	 			$("#cargando").spin(false);
	 		});
	 		
	 		$('#cargando').spin();
	 		
	 		setTimeout(function() {
	 			
		 		var resp = service.estadoPedido.getAll();
		 		if(resp instanceof Array) {
		 			var estadoPedidos = resp;
			 		var options = $("#consultaPedidoLista #buscar #estadoPedido");
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