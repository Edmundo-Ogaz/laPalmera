define(["jquery", "service","page", "bootstrap-dialog", "moment"], function($, service, page, bootstrapDialog, moment) {
 
	console.log("Function : ubicacion controller");

	return {
		init : function() {
			
			var clear = this.clear;
			var getUbicacions = this.getUbicacions;
			
			$('#titulo').html('Consulta Ubicación');
	 		$('#page').html(page.ubicacionConsulta.get());
	 		
	 		setTimeout(function() {
		 		
		 		var stringBodegas = "-1:SELECCIONE;";
		 		var resp = service.bodega.getAll();
		 		if(resp instanceof Array) {
		 			var bodegas = resp;			 		
			 		for(var i=0; i<bodegas.length; i++) {
			 			stringBodegas = stringBodegas.concat(bodegas[i].codigo + ":" + bodegas[i].nombre + ";");
					}
		 		}
		 		stringBodegas = stringBodegas.substring(0, stringBodegas.length - 1);
		 		
		 		var stringUnidadMedidas = "-1:SELECCIONE;";
		 		var unidadMedidas = service.unidadMedida.getAll();
		 		if(unidadMedidas instanceof Array) {
			 		for(var i=0; i<unidadMedidas.length; i++) {
			 			stringUnidadMedidas = stringUnidadMedidas.concat(unidadMedidas[i].codigo + ":" + unidadMedidas[i].nombre + ";");
					}
		 		}
		 		stringUnidadMedidas = stringUnidadMedidas.substring(0, stringUnidadMedidas.length - 1);
		 		
		 		jQuery("#navgrid").jqGrid({
					datatype: "local",
					jsonReader : { repeatitems: false },
					colNames:['Id', 'Bodega', 'Fecha Ingreso', 'Fecha Vencimiento','Cantidad', 'Unidad de Medida','Observación',],
					colModel:[
					        {name:'id', index:'id', key:true, hidden:true},						  		
					  		{name:'bodega',index:'bodega',            width:90, editable:true, edittype:'select', editoptions:{readonly:false, value:stringBodegas}},
					  		{name:'fechaIngreso',index:'fechaIngreso',            width:90, editable:true, editoptions:{readonly:false,size:25}},
					  		{name:'fechaVencimiento',index:'fechaVencimiento',            width:90, editable:true, editoptions:{readonly:false,size:25}},
					  		{name:'cantidad',index:'cantidad',            width:90, editable:true, editoptions:{readonly:false,size:25}},
					  		{name:'unidadMedida',index:'unidadMedida',            width:90, editable:true, edittype:'select', editoptions:{readonly:false, value:stringUnidadMedidas}},
					  		{name:'observacion',index:'observacion',            width:90, editable:true, editoptions:{readonly:false,size:25}},
					  	],
				  	rowNum:10,
				  	rowList:[10,20,30],
				  	pager: '#pagernav',
				  	sortname: 'Producto',
				  	viewrecords: true,
				  	sortorder: "asc",
				  	caption:"Ubicación",
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

		 		//.navGrid('#pagernav', {edit:false, add:false, del:false});
			  	jQuery("#navgrid").jqGrid('navGrid','#pagernav', {del:true,add:true,edit:true,search:false}, //options
			  		{			  			
				  		beforeShowForm : function (formid) {
			  		  		$("#fechaIngreso").val(moment().locale('es').format('YYYY-MM-DD HH:mm:ss'));
		                	$("#fechaVencimiento").val(moment().locale('es').format('YYYY-MM-DD HH:mm:ss'));
			  			},
			  			beforeSubmit : function (postdata, formid) {
			  				var ubicacion = {'id' : postdata.navgrid_id,
		  									'producto' : {'codigo' : $("#ubicacion #producto").val()},
		  									'bodega' : {'codigo' : postdata.bodega},
		  									'fechaIngreso' : postdata.fechaIngreso,
		  									'fechaVencimiento' : postdata.fechaVencimiento,
		  									'cantidad' : postdata.cantidad,
		  									'unidadMedida' : {'codigo' : postdata.unidadMedida},
		  									'observacion' : postdata.observacion};
			  				var resp = service.ubicacion.update(ubicacion);
			  				if(resp instanceof Object) {
			  					var ubicacion = resp;
			  					var bodegaText = $('#'+formid[0].id+' #bodega option:selected').text();				  					
			  					jQuery("#navgrid").jqGrid('setRowData', 
			  												ubicacion.id,
			  												{'id': ubicacion.id,
						  									'bodega' : bodegaText,
						  									'fechaIngreso' : moment(postdata.fechaIngreso).format("MM-DD-YYYY"),
						  									'fechaVencimiento' : moment(postdata.fechaVencimiento).format("MM-DD-YYYY"),
						  									'cantidad' : postdata.cantidad,
						  									'unidadMedida' : postdata.unidadMedida,
						  									'observacion' : postdata.observacion});
			  					$(".ui-icon-closethick").trigger('click');
			  				}
			  				return [false, "No pudo actualizar ubicación"];
			  			},
			  			width: 500,
			  			height : 350,
					  	reloadAfterSubmit : false,
					  	bSubmit: "Submit",
					  	bCancel: "Cancel",
					  	closeAfterEdit : true,
		  		  	}, // edit options
		  		  	{
			  		  	beforeShowForm : function (formid) {
			  		  		$("#fechaIngreso").val(moment().locale('es').format('YYYY-MM-DD HH:mm:ss'));
		                	$("#fechaVencimiento").val(moment().locale('es').format('YYYY-MM-DD HH:mm:ss'));
			  			},
			  			afterShowForm: function () {
			  			    var codigoProducto = $("#ubicacion #producto").val();
			  			    if(codigoProducto.trim() == "-1") {
			  			        $.jgrid.hideModal("#editmodnavgrid", {gbox: "#gbox_navgrid"});
			  			        bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
			  			        					title: "ERROR", 
			  			        					message: "Dede seleccionar un producto"});
			  			    }
			  			},
			  			beforeSubmit : function (postdata, formid) {
			  				var ubicacion = {'id' : null,
		  									'producto' : {'codigo' : $("#ubicacion #producto").val()},
		  									'bodega' : {'codigo' : postdata.bodega},
		  									'fechaIngreso' : postdata.fechaIngreso,
		  									'fechaVencimiento' : postdata.fechaVencimiento,
		  									'cantidad' : postdata.cantidad,
		  									'unidadMedida' : {'codigo' : postdata.unidadMedida},
		  									'observacion' : postdata.observacion};
			  				var resp = service.ubicacion.add(ubicacion);
			  				if(resp) {
			  					var ubicacion = resp;
			  					var bodegaText = $('#'+formid[0].id+' #bodega option:selected').text();				  					
			  					jQuery("#navgrid").jqGrid('addRowData', 
			  												ubicacion.id,
			  												{'id': ubicacion.id,
						  									'bodega' : bodegaText,
						  									'fechaIngreso' : moment(ubicacion.fechaIngreso).format("MM-DD-YYYY"),
						  									'fechaVencimiento' : moment(ubicacion.fechaVencimiento).format("MM-DD-YYYY"),
						  									'cantidad' : ubicacion.cantidad,
						  									'unidadMedida' : ubicacion.unidadMedida.codigo,
						  									'observacion' : ubicacion.observacion},
			  											'first');
			  					jQuery("#navgrid").jqGrid('setSelection', ubicacion.id, false);
			  					$(".ui-icon-closethick").trigger('click');
			  				}
			  				return [false, "No pudo grabar ubicación"];
			  			},
			  			width : 500,
			  	  	  	height : 350,
			  	  		reloadAfterSubmit : false,
			  	  		bSubmit : "Submit",
			  	  		bCancel : "Cancel",
			  	  		closeAfterAdd : true,
		  	  		}, // add options
		  		  	{
			  	  		beforeSubmit : function (rowid) {
			  	  			var data = jQuery("#navgrid").jqGrid('getRowData', rowid);				  				
					  	  	var ubicacion = {'id' : data.id};				  	  	
				  	  		var resp = service.ubicacion.del(ubicacion);
				  	  		if(resp) {
				  				jQuery("#navgrid").jqGrid('delRowData', rowid);
				  				$(".ui-icon-closethick").trigger('click');
				  			}
				  			return [false, "No pudo eliminar ubicación"];
				  		},
				  		reloadAfterSubmit:false,
			  	  	} // del options
			  	);
			  	
			  	$("#cargando").spin(false);
			  	
		  	}, 10);
		  	
		  	$("#producto").change(function() {
	 			console.log("producto ubicación controller");		 			
	 			clear();		 			 			
	 			var $producto = $("#ubicacion #producto").val();		 			
	 			getUbicacions($producto);
	 		});
		  	
		  	$('#cargando').spin();
		  	
		  	setTimeout(function() {
	 			
		  		var resp = service.producto.getAll();
		  		if(resp instanceof Array) {
		  			var productos = resp;
			 		var $producto = $("#ubicacion #producto");
			 		$producto.append($("<option />").val("-1").text("SELECCIONE PRODUCTO"));
			 		$.each(productos, function() {
			 			$producto.append($("<option />").val(this.codigo).text(this.nombre));
			 		});
		  		}
		 		
		 		$("#cargando").spin(false);
		  	
		  	}, 10);
		},
		getUbicacions : function(producto) {
			if(producto != "-1") {
				$('#cargando').spin();
			  	setTimeout(function() {
		 			var array = [];
		 			var ubicacion = {'producto' : {'codigo' : producto}};
		 			var resp = service.ubicacion.getAllEqBy(ubicacion);
		 			if(resp instanceof Array) {
		 				var ubicacions = resp;
						if(ubicacions.length > 0) {
			 				for(var i=0; i<ubicacions.length; i++) {
								array.push({'id' : ubicacions[i].id,
									  		'bodega' : ubicacions[i].bodega.nombre,
									  		'fechaIngreso' : moment(ubicacions[i].fechaIngreso).format("MM-DD-YYYY hh:mm"),
									  		'fechaVencimiento' : moment(ubicacions[i].fechaVencimiento).format("MM-DD-YYYY"),
									  		'cantidad' : ubicacions[i].cantidad,
									  		'unidadMedida' : ubicacions[i].unidadMedida.codigo,
									  		'observacion' : ubicacions[i].observacion
						  		});
							}
							jQuery("#navgrid").jqGrid("clearGridData").jqGrid('addRowData', 'id', array);
							jQuery("#navgrid").trigger("reloadGrid");
			 			} else {
			 				console.log('Sin Ingredientes');
			 				bootstrapDialog.show({message: 'Sin Ingredientes'});
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