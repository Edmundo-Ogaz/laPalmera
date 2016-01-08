define(["jquery", "jqGrid", "bootstrap-dialog", "moment", "spin", "spin-jquery", "underscore", "enum",
        "service", "page", "pedidoActualizaDialogController"], 
		function($, jqGrid, bootstrapDialog, moment, spin, spinjquery, underscore, ENUM,
				service, page, pedidoActualizaDialogController) {
 
	console.log("Function : confirmar pedido controller");

	return {
		init : function() {
			
			$('#titulo').html('Confirma Pedido');
	 		$('#page').html(page.pedidoConfirma.get());
 		
	 		jQuery("#navgrid").jqGrid({
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
			    pager: '#pedidoConfirmaPagernav',
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
					pedidoActualizaDialogController.init(pedido);
					
					//LISTENER TO DIALOG EVENT CLICK ENVIAR
			 		$('#dialog #solicitudProductoCliente #enviar').on('click', function(e) {
			    		var pedidoSave = e.result;
			    		if(pedidoSave instanceof Object) {
			    			//ACTUALIZAR GRID			 						
		    				if(pedidoSave.estadoPedido.codigo == ENUM.estadoPedido.INGRESADO.codigo) {
		    					jQuery("#page #navgrid").jqGrid('setRowData', pedidoSave.numeroPedido,
			 							   {'id' : pedidoSave.numeroPedido,
 											'nombre' : pedidoSave.nombreCliente,
	 					            		'fechaPedido' : moment(pedidoSave.fechapedido).format("MM-DD-YYYY"),
	 						            	'precioTotal' : pedidoSave.preciototalpedido,
	 						            	'fechaConfirmacion' : pedidoSave.confirmacionPedido != null ? moment(pedidoSave.confirmacionPedido.fecha).format("MM-DD-YYYY") : "",
	 						            	'observacion' : pedidoSave.observacionpedido,
			 							   });
		    				} else {
		    					jQuery("#page #navgrid").jqGrid('delRowData', pedidoSave.numeroPedido);
		    				}
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
	 		
	 		//LOAD DATA
	 		$('#cargando').spin();
	 		
	 		var pedido = {"estadoPedido" : {"codigo" : "I"}};
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
					jQuery("#navgrid").jqGrid("clearGridData").jqGrid('addRowData', 'id', array);
					jQuery("#navgrid").trigger("reloadGrid");
	 			} else if(pedidos == undefined || pedidos.length == 0) {
	 				console.log("No existen pedido para confirmar!");
	 				bootstrapDialog.show({message: 'No existen pedido para confirmar!'});
	 			}
	 		}
 			
 			$("#cargando").spin(false);
		},		
	};
});