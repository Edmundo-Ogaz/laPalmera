define(["jquery", "jqGrid", "bootstrap-dialog", "moment", "bootstrap-datetimepicker", "spin", "spin-jquery", "dialog",
        "service", "page", "helper", "enum", "productoConsultaClienteDialogController"], 
		function($, jqGrid, bootstrapDialog, moment, bootstrapdatetimepicker, spin, spinjquery, dialog,
				service, page, helper, ENUM, productoConsultaClienteDialogController) {
 
	console.log("Function : Pedido Dialog Controller");
	
	var page = '#page #solicitudProductoCliente';
	var dialog = '#dialog #solicitudProductoCliente';
	var grid = '#navgrid';
	var gridFooter = '#pagernav';
	var client = 'cliente';
	var despacho = 'despacho';
	var confirma = 'confirmar';
	
	return {
		init : function(pedido) {
			
			fill = this.fill;
			
			var html = page.solicitudProductoCliente.get();
			dialog.modalWidth(html,"Pedido", 1024);
		 		
			jQuery("#solicitudProductoCliente #navgrid").jqGrid({
				datatype: "local",
				jsonReader : { repeatitems: false },
				colNames:['N°', 'Id', 'Producto Código', 'Producto', 'Cantidad', 'Precio', 'Observación'],
				colModel:[
				        {name:'nro', index:'nro', key:true,  			align:'left'},
				  		{name:'id', index:'id', 						hidden:true},
				  		{name:'productoCodigo',index:'productoCodigo',  hidden:true},
				  		{name:'productoNombre',index:'productoNombre',  align:'left'},
				  		{name:'cantidad',index:'cantidad', 				align:'right'},
				  		{name:'precio',index:'precio',       			align:'right'},
				  		{name:'observacion',index:'observacion',   		align:'left'},
				  	],
			  	rowNum:10,
			  	rowList:[10,20,30],
			  	pager: '#pagernav',
			  	sortname: 'codigo',
			  	viewrecords: true,
			  	sortorder: "asc",
			  	caption:"Productos",
			  	editurl:"clientArray",
			  	height:125,
			  	autowidth:true,			  	
	 		});
	 		
	 		$(window).on("resize", function () {
			    var newWidth = $("#navgrid").closest(".ui-jqgrid").parent().width();
			    $("#solicitudProductoCliente #navgrid").jqGrid("setGridWidth", newWidth, true);
			    // without scrollbar
			    $("#solicitudProductoCliente #navgrid").closest('.ui-jqgrid-bdiv').width($("#solicitudProductoCliente #navgrid").closest('.ui-jqgrid-bdiv').width() + 1);
			});
	 		
	 		//EVENT CHANGE FECHA
	 		$("#solicitudProductoCliente #despacho #datetimepicker").on("dp.change", function (e) {
	 			$('#solicitudProductoCliente #despacho #fecha').val(e.date.locale('es').format('YYYY-MM-DD HH:mm:ss'));		            
	        });            
	 		$("#solicitudProductoCliente #confirmar #datetimepicker").on("dp.change", function (e) {
	 			$('#solicitudProductoCliente #confirmar #fecha').val(e.date.locale('es').format('YYYY-MM-DD HH:mm:ss'));	            
	        });
	 		
	 		//HABILITAR DESABILITAR COMPONENTES
	 		$("#solicitudProductoCliente #estado").show();	 		
	 		$("#solicitudProductoCliente #productoAgregar").hide();
	 		$("#solicitudProductoCliente #productoEliminar").hide();	 		
	 		$("#solicitudProductoCliente #enviar").hide();	 		
	 		
	 		$('#cargando').spin();
	 		
	 		setTimeout(function() {
	 			
		 		var resp = service.comuna.getAll();
		 		if(resp instanceof Array) {
		 			var comunas = resp;
			 		var options = $("#solicitudProductoCliente #cliente #comuna");
			 		options.append($("<option />").val("-1").text("SELECCIONE COMUNA"));
			 		$.each(comunas, function() {
			 		    options.append($("<option />").val(this.codigo).text(this.nombre));
			 		});
		 		}
		 		
		 		var resp = service.entrega.getAll();
		 		if(resp instanceof Array) {
		 			var entregas = resp;
			 		var options = $("#solicitudProductoCliente #despacho #lugarEntrega");
			 		options.append($("<option />").val("-1").text("SELECCIONE LUGAR ENTREGA"));
			 		$.each(entregas, function() {
			 		    options.append($("<option />").val(this.codigo).text(this.descripcion));
			 		});
		 		}
		 		
		 		fill(pedido);
		 		
		 		$("#cargando").spin(false);
		 		
	 		}, 10);
		},
		fill : function(pedido) {
			
			$("#solicitudProductoCliente #cliente #tipoCliente").val(pedido.cliente.tipoCliente.codigo);
 			$("#solicitudProductoCliente #cliente #rut").val(pedido.cliente.rut);
 			$("#solicitudProductoCliente #cliente #dv").val(pedido.cliente.dv);
 			$("#solicitudProductoCliente #cliente #nombre").val(pedido.cliente.nombre);
 			$("#solicitudProductoCliente #cliente #direccion").val(pedido.cliente.direccion);
 			$("#solicitudProductoCliente #cliente #comuna").val(pedido.cliente.comuna.codigo);
 			$("#solicitudProductoCliente #cliente #telefono").val(pedido.cliente.telefono);
 			$("#solicitudProductoCliente #cliente #celular").val(pedido.cliente.celular);
 			$("#solicitudProductoCliente #cliente #email").val(pedido.cliente.email);
 			
 			$("#solicitudProductoCliente #despacho #lugarEntrega").val(pedido.despachoPedido.lugarEntrega.codigo);
 			$('#solicitudProductoCliente #despacho #datetimepicker').datetimepicker({
	 			format: 'LLLL',
	 			defaultDate: pedido.despachoPedido.fechaentregadespacho,
            });
 			
 			$('#solicitudProductoCliente #confirmar #datetimepicker').datetimepicker({
	 			format: 'LLLL',
	 			defaultDate: pedido.confirmacionPedido.fecha,
            });
 			
 			var array = [];
 			for(var i = 0; i < pedido.detallePedidos.length; i++) {
 				
 				array.push({'nro' : i + 1,
 						'id' : pedido.detallePedidos[i].id,
			            'productoCodigo' : pedido.detallePedidos[i].producto.codigo,
			            'productoNombre' : pedido.detallePedidos[i].producto.nombre,
			            'cantidad' : pedido.detallePedidos[i].cantidadproducto,
			            'precio' : pedido.detallePedidos[i].precioproducto,
			            'observacion' : pedido.detallePedidos[i].observacion});
 			}
 			
 			jQuery("#solicitudProductoCliente #navgrid").jqGrid('addRowData', 'id', array);
 			
 			var pedidoEstado = pedido.estadoPedido.codigo;
 			if(pedidoEstado == 'I') {$("#solicitudProductoCliente #estado #ingresado").prop("checked", true);}
 			if(pedidoEstado == 'C') {$("#solicitudProductoCliente #estado #confirmado").prop("checked", true);}
 			if(pedidoEstado == 'R') {$("#solicitudProductoCliente #estado #rechazado").prop("checked", true);}
 			
 			$("#solicitudProductoCliente #observacion").val(pedido.observacionpedido);
 			
 			$('#state').data('pedido',pedido);
 			
		},
	};
});