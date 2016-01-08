define(["jquery", "service","page", "bootstrap-dialog"], function($, service, page, bootstrapDialog) {
 
	console.log("Function : ingrediente controller");

	return {
		init : function() {
			
			var getIngredientes = this.getIngredientes;
			
			$('#titulo').html('Consulta Ingrediente');
	 		$('#page').html(page.ingredienteConsulta.get());
	 		
	 		setTimeout(function() {
	 			
	 			var stringInsumos = "-1:SELECCIONE;";				
				var producto = {"tipoProducto" : {"codigo" : "T"}};
		 		var resp = service.producto.getAllNotEqBy(producto);
		 		if(resp instanceof Array) {
		 			var insumos = resp;
			 		for(var i=0; i<insumos.length; i++) {
			 			stringInsumos = stringInsumos.concat(insumos[i].codigo + ":" + insumos[i].nombre + ";");
					}		
		 		}
		 		stringInsumos = stringInsumos.substring(0, stringInsumos.length - 1);
		 		
		 		var stringUnidadMedida = "-1:SELECCIONE;";				
		 		var unidadMedidas = service.unidadMedida.getAll();
		 		if(unidadMedidas instanceof Array) {
			 		for(var i=0; i<unidadMedidas.length; i++) {
			 			stringUnidadMedida = stringUnidadMedida.concat(unidadMedidas[i].codigo + ":" + unidadMedidas[i].nombre + ";");
					}
		 		}
			 	stringUnidadMedida = stringUnidadMedida.substring(0, stringUnidadMedida.length - 1);
		 		
			 	jQuery("#navgrid").jqGrid({
					datatype: "local",
					jsonReader : { repeatitems: false },
					colNames:['Id', 'Insumo','Cantidad', 'Unidad Medida'],
					colModel:[
					        {name:'id', index:'id', key:true, hidden:false},	
					  		{name:'insumo', index:'insumo', width:90, editable:true, edittype:'select', editoptions:{readonly:false, value:stringInsumos}},
					  		{name:'cantidad',index:'cantidad',            width:90, editable:true, editoptions:{readonly:false,size:25}},
					  		{name:'unidadMedida', index:'unidadMedida', width:90, editable:true, edittype:'select', editoptions:{readonly:false, value:stringUnidadMedida}},
					  	],
				  	rowNum:10,
				  	rowList:[10,20,30],
				  	pager: '#pagernav',
				  	sortname: 'insumo',
				  	viewrecords: true,
				  	sortorder: "asc",
				  	caption:"Ingredientes",
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

			  	jQuery("#navgrid").jqGrid('navGrid','#pagernav', {del:true,add:true,edit:true,search:false}, //options
		  		{			  			
		  			beforeSubmit : function (postdata, formid) {
		  				var ingrediente = {'id' : postdata.navgrid_id,
		  									'producto' : {'codigo' : $("#ingrediente #producto").val()},
		  									'insumo' : {'codigo' : postdata.insumo},
		  									'carga':  $("#ingrediente #cantidad").val(),
			  								'cantidadinsumo' : postdata.cantidad,
		  									'unidadMedida' : {'codigo' : postdata.unidadMedida}
		  									};
		  				var resp = service.ingrediente.update(ingrediente);
		  				if(resp instanceof Object) {
		  					var text = $('#'+formid[0].id+' #insumo option:selected').text();
		  					
		  					jQuery("#navgrid").jqGrid('setRowData', 
		  												ingrediente.id,
		  												{'id': ingrediente.id,
		  												'insumo': text, 
		  												'cantidad': postdata.cantidad, 
		  												'unidadMedida': postdata.unidadMedida});
		  					$(".ui-icon-closethick").trigger('click');
		  				}
		  				return [false, "No pudo actualizar ingrediente"];
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
		  				var ingrediente = {'producto' : {'codigo' : $("#ingrediente #producto").val()},
		  								   'insumo' : {'codigo' : postdata.insumo},
		  								   'carga':  $("#ingrediente #cantidad").val(),
		  								   'cantidadinsumo' : postdata.cantidad,
		  								   'unidadMedida' : {'codigo' : postdata.unidadMedida}
		  								  };
		  				var resp = service.ingrediente.add(ingrediente);
		  				if(resp instanceof Object) {
		  					var ingrediente = resp;
		  					var text = $('#'+formid[0].id+' #insumo option:selected').text();			  					
		  					jQuery("#navgrid").jqGrid('addRowData', 
		  												ingrediente.id,
		  												{'id':ingrediente.id, 
		  												 'insumo':text, 
		  												 'cantidad':postdata.cantidad, 
		  												 'unidadMedida':postdata.unidadMedida},
		  											  'first');
		  					jQuery("#navgrid").jqGrid('setSelection', ingrediente.id, false);
		  					$(".ui-icon-closethick").trigger('click');
		  				}
		  				return [false, "No pudo grabar ingrediente"];
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
			  				
				  	  	var ingrediente = {'id' : data.id};
			  	  	
			  	  		var resp = service.ingrediente.del(ingrediente);
			  				if(resp instanceof Object) {
			  					jQuery("#navgrid").jqGrid('delRowData', rowid);
			  					$(".ui-icon-closethick").trigger('click');
			  				}
			  				return [false, "No pudo eliminar Ingrediente"];
			  			},
			  			reloadAfterSubmit:false,
		  	  		} // del options
			  	);
			  	
			  	$("#cargando").spin(false);
			  	
		  	}, 10);
		  	
		  	$("#producto").change(function() {
	 			console.log("producto ingrediente controller");		 			
	 			jQuery("#navgrid").jqGrid("clearGridData");
	 			var $producto = $("#ingrediente #producto").val();
	 			var $cantidad = $("#ingrediente #cantidad").val();		 			
	 			if($cantidad.trim() == "") {
	 				$cantidad = 1;
	 				$("#cantidad").val($cantidad);
	 			}		 			
	 			getIngredientes($producto, $cantidad);
	 		});
		  	
		  	$("#cantidad").blur(function() {
	 			console.log("cantidad ingrediente controller");
	 			jQuery("#navgrid").jqGrid("clearGridData");
	 			var $producto = $("#ingrediente #producto").val();
	 			var $cantidad = $("#ingrediente #cantidad").val();
	 			if($producto.trim() != "-1" && $cantidad.trim() != "") {
	 				getIngredientes($producto, $cantidad);
	 			}
	 		});
		  	
		  	$('#cargando').spin();
		  	
		  	setTimeout(function() {
	 			
		  		var producto = {"tipoProducto" : {"codigo" : "I"}};
		 		var resp = service.producto.getAllNotEqBy(producto);
		 		if(resp instanceof Array) {
		 			var productos = resp;
		 			var $producto = $("#producto");
			 		$producto.append($("<option />").val("-1").text("SELECCIONE PRODUCTO"));
			 		$.each(productos, function() {
			 			$producto.append($("<option />").val(this.codigo).text(this.nombre));
			 		});
			  	}
		 		
		 		$("#cargando").spin(false);
		  	
		  	}, 10);
		},
		getIngredientes : function(producto, cantidad) {
			
			$('#cargando').spin();		  	
		  	setTimeout(function() {	 			
	 			var array = [];
	 			var ingrediente = {'producto' : {'codigo' : producto},
	 							   'carga' : cantidad};
	 			var resp = service.ingrediente.getAllEqBy(ingrediente);
	 			if(resp instanceof Array) {
	 				var ingredientes = resp;
	 				if(ingredientes.length > 0) {
						for(var i=0; i<ingredientes.length; i++) {
							array.push({'id' : ingredientes[i].id, 
										'insumo' : ingredientes[i].insumo.nombre, 
							            'cantidad' : parseInt(ingredientes[i].cantidadinsumo) * parseInt(cantidad), 
							            'unidadMedida' : ingredientes[i].unidadMedida.codigo}); 
						}				
						jQuery("#navgrid").jqGrid("clearGridData").jqGrid('addRowData', 'id', array);
	 				} else {
	 					console.log('Sin ingredientes');
		 				bootstrapDialog.show({message: 'Sin ingredientes'});
	 				}
	 			}
	 			
				$("#cargando").spin(false);			  	
		  	}, 10);			
 		},
	};
});