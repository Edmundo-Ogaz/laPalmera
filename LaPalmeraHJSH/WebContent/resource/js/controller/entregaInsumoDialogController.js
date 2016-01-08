define(["jquery", "service","bootstrap-dialog", "spin", "spin-jquery", "page", "dialog", "moment"], 
		function($, service, bootstrapDialog, spin, spinJquery, page, dialog, moment) {
 
	console.log("Function : buscar insumo Controller");

	return {
		init : function() {
			
			var clear = this.clear;
			var requiredField = this.requiredField;
			
			var html = page.entregaInsumo.get();			
			dialog.modal(html,"Entrega Insumo");
			
			$('#cargando').spin();
			
			var producto = {"tipoProducto" : {"codigo" : "T"}}; 
			var resp = service.producto.getAllNotEqBy(producto);
			if(resp instanceof Array) {
				var insumos = resp;
				var $insumo = $("#insumo");			
				$insumo.append($("<option />").val("-1").text("SELECCIONE INSUMO"));
		 		$.each(insumos, function() {
		 			$insumo.append($("<option />").val(this.codigo).text(this.nombre));
		 		});
			}
	 			 		
	 		jQuery("#navgrid").jqGrid({
				datatype: "local",
				jsonReader : { repeatitems: false },
				colNames:['Bodega', 'Ubicación', 'Fecha Vencimiento',  'Cantidad', 'Unidad Medida'],
				colModel:[
				  		{name:'bodega', index:'funcionario', key:true, align:'left'},
				  		{name:'ubicacion',index:'insumo',           			align:'right'},
				  		{name:'fechaVencimiento',index:'cantidad',            		align:'left'},
				  		{name:'cantidad',index:'fechaEntrega',          align:'left'},
				  		{name:'unidadMedida',index:'horaEntrega',            align:'left'},
				  	],
			  	rowNum:10,
			  	rowList:[10,20,30],
			  	pager: '#pagernav',
			  	multiselect: false,
			  	sortname: 'fechaVencimiento',
			  	viewrecords: true,
			  	sortorder: "asc",
			  	caption:"Ubicación",
			  	editurl:"clientArray",
			  	autowidth:true,
			  	//height:'auto',
			  	height:100,
	 		});
	 		
	 		var funcionarios = service.funcionario.getAll();
	 		var $funcionario = $("#funcionario");
	 		$funcionario.append($("<option />").val("-1").text("SELECCIONE FUNCIONARIO"));
	 		$.each(funcionarios, function() {
	 			$funcionario.append($("<option />").val(this.rut).text(this.nombre));
	 		});
	 		
	 		$insumo.change(function() {
	 			clear();
	 			
	 			var codigoInsumo = $("#insumo").val();
	 			var insumo = service.producto.get(codigoInsumo);
	 			if(insumo instanceof Object) {
	 				var ubicacions = insumo.ubicacions;	 			
		 			for(var i=0; i< ubicacions.length;i++) {
						jQuery("#navgrid").jqGrid('addRowData', ubicacions[i].id,
												{'bodega' : ubicacions[i].bodega.nombre,
								            	'ubicacion' : ubicacions[i].observacion,
								            	'fechaVencimiento' : moment(ubicacions[i].fechaVencimiento).format("MM-DD-YYYY"),
								            	'cantidad' : ubicacions[i].cantidad,
								            	'unidadMedida' : ubicacions[i].codigoUnidadMedida,
								            });
					}
	 			
		 			var unidadMedida = {"familia" : {"codigo" : insumo.unidadMedida.familia.codigo}};
		 			var unidadMedidas = service.unidadMedida.getAllEqBy(unidadMedida);
		 			if(unidadMedidas instanceof Array) {
				 		var $unidadMedida = $("#unidadMedida");
				 		$unidadMedida.append($("<option />").val("-1").text("SELECCIONE UNIDAD MEDIDA"));
				 		$.each(unidadMedidas, function() {
				 			$unidadMedida.append($("<option />").val(this.codigo).text(this.nombre));
				 		});
		 			}
	 			}
	 			
	 		});
	 		
	 		$("#add").click(function() {
	 			console.log("agregar insumo controller");
	 			if(requiredField()) {
		 			var codigoOrdenFabricacion = $("#ordenFabricacion").val();
		 			var insumo = $("#insumo").val();
		 			var cantidad = $("#cantidad").val();
		 			var unidadMedida = $("#unidadMedida").val();
		 			var rutfuncionario = $("#funcionario").val();
		 			var observacion = $("#observacion").val();
		 			
		 			var id = jQuery("#navgrid").jqGrid('getGridParam','selrow');		 			
		 			var ubicacions = [{"id" : id}];
		 			
		 			//Multipled select
		 			//var ids = jQuery("#navgrid").jqGrid('getGridParam','selarrrow');		 			
		 			//var ubicacions = [];
		 			//for(var i=0; i<ids.length; i++) {
		 			//	ubicacions.push({"id" : ids[i]});
		 			//}
		 			
		 			var ordenFabricacion = {"codigoOrdenFabricacion" : codigoOrdenFabricacion};
		 			
		 			var funcionario = {"rut" : rutfuncionario};
		 			
		 			var detalleEntregaInsumo = {"cantidadentregainsumo" : cantidad, 
		 										"unidadMedida" : {"codigo" : unidadMedida},
		 										"insumo" : {"codigo" : insumo,
		 						 					        "ubicacions" : ubicacions}
		 										};
		 			
		 			var resp = service.entregaInsumo.add(ordenFabricacion, funcionario, detalleEntregaInsumo, observacion);
		 			if(resp.respuesta) {
		 				var entregaInsumo = resp.entregaInsumo;		 			
			 			var funcionario = entregaInsumo.funcionario.nombre + 
											entregaInsumo.funcionario.apellidopaterno + 
											entregaInsumo.funcionario.apellidomaterno;
			 			jQuery("#navgrid2").jqGrid('addRowData', entregaInsumo.correlativoEntregaInsumo, 
									{'funcionario' : funcionario, 
					            	'insumo' : entregaInsumo.detalleEntregaInsumo.insumo.nombre, 
					            	'cantidad' : entregaInsumo.detalleEntregaInsumo.cantidadentregainsumo,
					            	'unidadMedida' : entregaInsumo.detalleEntregaInsumo.codigounidadmedida,
					            	'fechaEntrega' : moment(entregaInsumo.fechaentregainsumo).format("MM-DD-YYYY"),
					            	'horaEntrega' : moment(entregaInsumo.horaEntregaInsumo).format("HH:mm"),					            	
					            	'observacion' : entregaInsumo.observacion,
						            },
				 				'first');
			 			jQuery("#navgrid2").jqGrid('setSelection', entregaInsumo.correlativoEntregaInsumo, false);
		
		 			} else {
		 				console.log("Problemas al grabar entrega insumo!");
		 				bootstrapDialog.show({message: 'Problemas al grabar entrega insumo!'});
		 			}
	 			}
	 		
	 		});
	 		
	 		$("#cancelar").click(function() {
	 			console.log("agregar insumo controller");
				$( '#dialog' ).dialog("close");
	 		});
	 		
	 		$("#cargando").spin(false);
		},
		clear : function() {
			$("#unidadMedida").html("");
			jQuery("#navgrid").jqGrid("clearGridData");
		},
		requiredField : function() {
			var message = "";
			var codigoOrdenFabricacion = $("#ordenFabricacion").val();
 			if(codigoOrdenFabricacion.trim() == "")
 				message += ' Sin Orden Fabricación,';
			var insumo = $("#insumo").val();
			if(insumo.trim() == "-1")
				message += ' Sin Insumo,';
 			var cantidad = $("#cantidad").val();
 			if(cantidad.trim() == "")
 				message += ' Sin Cantidad,';
 			var unidadMedida = $("#unidadMedida").val();
 			if(unidadMedida.trim() == "-1")
 				message += ' Sin Unidad medida,';
 			var rutfuncionario = $("#funcionario").val();
 			if(rutfuncionario.trim() == "-1")
 				message += ' Sin Rut,';
 			
 			var id = jQuery("#navgrid").jqGrid('getGridParam','selrow');
			if(!id)
				message += ' Sin Ubicación,';
 			
 			//multipled select
 			//var ids = jQuery("#navgrid").jqGrid('getGridParam','selarrrow');
			//if(ids.length == 0)
			//	message += ' Sin Ubicación,';
			
			if(message.length > 0) {
				bootstrapDialog.show({message: message});
				return false;
			} else { 
				return true;
			}				
		}
		
	};
});