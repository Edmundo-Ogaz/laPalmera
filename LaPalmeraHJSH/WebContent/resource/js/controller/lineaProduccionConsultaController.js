define(["jquery", "service", "page", "bootstrap-dialog"], function($, service, page, bootstrapDialog) {
 
	console.log("Function : region controller");

	return {
		init : function() {
			
			var clear = this.clear;
			var getProductoLineas = this.getProductoLineas;
			
			$('#titulo').html('Consulta Linea Producción');
		 	//$('#page').load('lineaProduccionConsulta.html', function() {
		 		$('#page').html(page.lineaProduccionConsulta.get());
		 		
		 		setTimeout(function() {
		 			
		 			var stringLineaProduccions = "-1:SELECCIONE;";
			 		var resp = service.lineaProduccion.getAll();
			 		if(resp instanceof Array) {
			 			var lineaProduccions = resp;
				 		for(var i=0; i<lineaProduccions.length; i++) {
				 			stringLineaProduccions = stringLineaProduccions.concat(lineaProduccions[i].codigo + ":" + lineaProduccions[i].nombre + ";");
						}
			 		}
			 		stringLineaProduccions = stringLineaProduccions.substring(0, stringLineaProduccions.length - 1);
			 				 		
			 		jQuery("#navgrid").jqGrid({
						datatype: "local",
						jsonReader : { repeatitems: false },
						colNames:['Id', 'Linea Producción','Prioridad'],
						colModel:[
						        {name:'id', index:'id', key:true, hidden:true},	
						  		{name:'lineaProduccion', index:'lineaProduccion', width:90, editable:true, edittype:'select', editoptions:{readonly:false, value:stringLineaProduccions}},
						  		{name:'prioridad',index:'prioridad',            width:90, editable:true, editoptions:{readonly:false,size:25}},
						  	],
					  	rowNum:10,
					  	rowList:[10,20,30],
					  	pager: '#pagernav',
					  	sortname: 'insumo',
					  	viewrecords: true,
					  	sortorder: "asc",
					  	caption:"Linea Produccion",
					  	editurl:"clientArray",
					  	//editurl:"spring/regionGet",
					  	height:225,
					  	autowidth:true,		  	
			 		});

			 		$(window).on("resize", function () {
					    var newWidth = $("#navgrid").closest(".ui-jqgrid").parent().width();
					    $("#navgrid").jqGrid("setGridWidth", newWidth, true);
					    // without scrollbar
					    $("#navgrid").closest('.ui-jqgrid-bdiv').width($("#navgrid").closest('.ui-jqgrid-bdiv').width() + 1);
					});

			 		//.navGrid('#pagernav', {edit:false, add:false, del:false});
				  	jQuery("#navgrid").jqGrid('navGrid','#pagernav', {del:true,add:true,edit:true,search:false}, //options
			  		{			  			
			  			beforeSubmit : function (postdata, formid) {
			  				var productoLinea = {'id' : postdata.navgrid_id,
			  									'producto' : {'codigo' : $("#productoLinea #producto").val()},
			  									'lineaProduccion' : {'codigo' : postdata.lineaProduccion},
				  								'prioridad' : postdata.prioridad};
			  				var resp = service.productoLinea.update(productoLinea);
			  				if(resp instanceof Object) {
			  					var productoLinea = resp;
			  					var text = $('#'+formid[0].id+' #lineaProduccion option:selected').text();
			  					jQuery("#navgrid").jqGrid('setRowData', 
			  												productoLinea.id,
			  												{'id': productoLinea.id,
			  												'lineaProduccion': text, 
			  												'prioridad': postdata.prioridad});
			  					$(".ui-icon-closethick").trigger('click');
			  				}
			  				return [false, "No pudo actualizar producto linea"];
			  			},
			  			width: 500,
				  		height : 300,
					  	reloadAfterSubmit : false,
					  	bSubmit: "Submit",
					  	bCancel: "Cancel",
					  	closeAfterEdit : true,
		  		  	}, // edit options
		  		  	{
			  			beforeSubmit : function (postdata, formid) {
			  				var productoLinea = {'producto' : {'codigo' : $("#productoLinea #producto").val()},
			  								   'lineaProduccion' : {'codigo' : postdata.lineaProduccion},
			  								   'prioridad' : postdata.prioridad};
			  				var resp = service.productoLinea.add(productoLinea);
			  				if(resp instanceof Object) {
			  					var productoLinea = resp;
			  					var text = $('#'+formid[0].id+' #lineaProduccion option:selected').text();			  					
			  					jQuery("#navgrid").jqGrid('addRowData', 
			  												productoLinea.id,
			  												{'id':productoLinea.id, 
			  												 'lineaProduccion':text, 
			  												 'prioridad':postdata.prioridad},
			  											  'first');
			  					jQuery("#navgrid").jqGrid('setSelection', productoLinea.id, false);
			  					$(".ui-icon-closethick").trigger('click');
			  				}
			  				return [false, "No pudo grabar producto linea"];
			  			},
			  			width : 500,
			  	  	  	height : 200,
			  	  		reloadAfterSubmit : false,
			  	  		bSubmit : "Submit",
			  	  		bCancel : "Cancel",
			  	  		closeAfterAdd : true,
		  	  		}, // add options
		  		  	{
			  	  		beforeSubmit : function (rowid) {
			  	  			var data = jQuery("#navgrid").jqGrid('getRowData', rowid);				  				
					  	  	var productoLinea = {'id' : data.id};				  	  	
				  	  		var resp = service.productoLinea.del(productoLinea);
				  				if(resp instanceof Object) {
				  					jQuery("#navgrid").jqGrid('delRowData', rowid);
				  					$(".ui-icon-closethick").trigger('click');
				  				}
				  				return [false, "No pudo eliminar producto linea"];
				  			},
				  			reloadAfterSubmit:false,
			  	  			//url: "spring/regionPost"
			  	  		} // del options
				  	);
				  	
				  	$("#cargando").spin(false);
				  	
			  	}, 10);
			  	
			  	$("#producto").change(function() {
		 			console.log("producto productoLinea controller");		 			
		 			clear();		 			 			
		 			var $producto = $("#productoLinea #producto").val();		 			
		 			getProductoLineas($producto);
		 		});
			  	
			  	$('#cargando').spin();
			  	
			  	setTimeout(function() {
		 			
			  		var producto = {"tipoProducto" : {"codigo" : "I"}};
			 		var resp = service.producto.getAllNotEqBy(producto);
			 		if(resp instanceof Array) {
			 			var productos = resp;
				 		var $producto = $("#productoLinea #producto");
				 		$producto.append($("<option />").val("-1").text("SELECCIONE PRODUCTO"));
				 		$.each(productos, function() {
				 			$producto.append($("<option />").val(this.codigo).text(this.nombre));
				 		});
				  	}
			 		
			 		$("#cargando").spin(false);
			  	
			  	}, 10);
		 	//});
		},
		getProductoLineas : function(producto) {
			if(producto != "-1") {
				$('#cargando').spin();
			  	setTimeout(function() {
		 			var array = [];
		 			var productoLinea = {'producto' : {'codigo' : producto}};
		 			var resp = service.productoLinea.getAllEqBy(productoLinea); 	
					if(resp instanceof Array) {
						var produccionLineas = resp;
						if(produccionLineas.length > 0) {
							for(var i=0; i<produccionLineas.length; i++) {
								array.push({'id' : produccionLineas[i].id,
											'lineaProduccion' : produccionLineas[i].lineaProduccion.nombre,
								            'prioridad' : produccionLineas[i].prioridad});
							}
							jQuery("#navgrid").jqGrid("clearGridData").jqGrid('addRowData', 'id', array);
							jQuery("#navgrid").trigger("reloadGrid");						
						} else {
			 				console.log('Sin Linea Producción');
			 				bootstrapDialog.show({message: 'Sin Linea Producción'});
			 			}
					}
					
					$("#cargando").spin(false);
			  	}, 10);
			}
 		},
		clear : function() {
			jQuery("#navgrid").jqGrid("clearGridData");
		},
	};
});