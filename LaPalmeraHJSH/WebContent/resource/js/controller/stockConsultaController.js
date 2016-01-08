define(["jquery", "service", "page", "bootstrap-dialog"], function($, service, page, bootstrapDialog) {
 
	console.log("Function : Stock Consulta controller");

	return {
		init : function() {
			
			var getStocks = this.getStocks;
			
			$('#titulo').html('Consulta Stock');
	 		$('#page').html(page.stockConsulta.get());
	 		
	 		setTimeout(function() {
		 		
		 		jQuery("#navgrid").jqGrid({
					datatype: "local",
					jsonReader : { repeatitems: false },
					colNames:['Id', 'Stock Disponible', 'Stock Comprometido', 'Unidad de Medida'],
					colModel:[
					        {name:'id', index:'id', key:true, hidden:true},						  		
					  		{name:'stockDisponible',index:'stockDisponible',            width:90},
					  		{name:'stockComprometido',index:'stockComprometido',            width:90},
					  		{name:'unidadMedida',index:'unidadMedida',            width:90},
					  	],
				  	rowNum:10,
				  	rowList:[10,20,30],
				  	pager: '#pagernav',
				  	sortname: 'id',
				  	viewrecords: true,
				  	sortorder: "asc",
				  	caption:"Stock",
				  	editurl:"clientArray",
				  	height:225,
				  	autowidth:true,		  	
		 		});

		 		$(window).on("resize", function () {
				    var newWidth = $("#navgrid").closest(".ui-jqgrid").parent().width();
				    $("#navgrid").jqGrid("setGridWidth", newWidth, true);
				    // without scrollbar
				    $("#navgrid").closest('.ui-jqgrid-bdiv').width($("#navgrid").closest('.ui-jqgrid-bdiv').width() + 1);
				});

			  	$("#cargando").spin(false);
			  	
		  	}, 10);
		  	
		  	$("#producto").change(function() {
	 			console.log("producto stock controller");		 			
	 			jQuery("#navgrid").jqGrid("clearGridData");
	 			var $producto = $("#stock #producto").val();		 			
	 			getStocks($producto);
	 		});
		  	
		  	$('#cargando').spin();
		  	
		  	setTimeout(function() {
	 			
		  		var resp = service.producto.getAll();
		  		if(resp instanceof Array) {
		  			var productos = resp;
			 		var $producto = $("#stock #producto");
			 		$producto.append($("<option />").val("-1").text("SELECCIONE PRODUCTO"));
			 		$.each(productos, function() {
			 			$producto.append($("<option />").val(this.codigo).text(this.nombre));
			 		});
		  		}
		 		
		 		$("#cargando").spin(false);
		  	
		  	}, 10);
		},
		getStocks : function(producto) {
			if(producto != '-1') {
				$('#cargando').spin();
			  	setTimeout(function() {
		 			var array = [];
		 			var stock = {'producto' : {'codigo' : producto}};
		 			var resp = service.stock.getAllEqBy(stock);
		 			if(resp instanceof Array) {
		 				var stocks = resp;
		 				if(stocks.length > 0) {
							for(var i=0; i<stocks.length; i++) {
								array.push({'id' : stocks[i].id,
									  		'stockDisponible' : stocks[i].stockDisponible,
									  		'stockComprometido' : stocks[i].stockComprometido,
									  		'unidadMedida' : stocks[i].unidadMedida.codigo,
						  		});
							}
							jQuery("#navgrid").jqGrid("clearGridData").jqGrid('addRowData', 'id', array);
							jQuery("#navgrid").trigger("reloadGrid");
		 				} else {
		 					console.log('Sin stock');
			 				bootstrapDialog.show({message: 'Sin stock'});
		 				}
		 			}
		 			
					$("#cargando").spin(false);
			  	
			  	}, 10);
			}
 		},
	};
});