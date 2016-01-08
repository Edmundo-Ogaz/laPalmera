define(["jquery", "bootstrap-dialog", "moment"], function($, bootstrapDialog, moment) {
 	console.log("Function : servive");

 	$.validateObject = function(obj) {
	    var resp = true; 		
 		for(var attr in obj) {
	      console.log(attr + ' : ' + obj[attr]);
	      if(resp == false) {
	    	  break;
	      } else if(typeof obj[attr] === 'object') {
	    	  resp = $.validateObject(obj[attr]);
	      } else if(obj[attr] == undefined) {
	    	 return false;
	      }
	    }
 		return resp
	  };

	return {
		usuario : {
			login : function(usuario) {
					
				var resp = false;
					
				var data = "q="+JSON.stringify(usuario);
					
				$.ajax({
					async: false,
					type: "GET",
					url: "spring/usuario/login",
					data: data,
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
						console.log('login usuario');
						resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
											  title: status.toUpperCase(), 
											  message: request.responseText});
					}
				});
				
				return resp;
			},
			logout : function() {
				
				var resp = false;
					
				$.ajax({
					async: false,
					type: "GET",
					url: "spring/usuario/logout",
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
						console.log('logout usuario');	
						resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
				
				return resp;
			},			
		},
		region : {
			getAll : function() {
				var resp = [];
					
				$.ajax({
					async: false,
					type: "GET",
					url: "spring/region/getAll",
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
						console.log('getAll region json');
						resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
				
				return resp;
			},
//			search : function(username, password) {
//				var resp = [];
//					
//				$.ajax({
//					async: false,
//					type: "GET",
//					url: "spring/region/get?_search=true",
//					dataType:'json',
//					contentType: 'application/json',
//					success: function(data) {
//							console.log('search region json');
//							resp = data.rows;
//					},
//					error: function(request, status, error) {
//						console.log("request " +request);
//						console.log("status " + status);
//						console.log("error " + error);
//					}
//				});
//				
//				return resp;
//			},
			add : function(region) {
					
				var resp = false;
					
				var data = JSON.stringify(region);
					
				$.ajax({
					async: false,
					type: "POST",
					url: "spring/region/add",
					data: data,
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
						console.log('grabar region');
						resp = data;				
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
				
				return resp;
			},
			update : function(region) {
				
				var resp = false;
					
				var data = JSON.stringify(region);				
					
				$.ajax({
					async: false,
					type: "PUT",
					url: "spring/region/update",
					data: data,
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
						console.log('update region');
						resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
				
				return resp;
			},
			del : function(region) {
				
				var resp = false;
					
				var data = JSON.stringify(region);
					
				$.ajax({
					async: false,
					type: "DELETE",
					url: "spring/region/del",
					data: data,
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
						console.log('del region');
						resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
				
				return resp;
			}
		},
		ciudad : {
			getAll : function() {
				var resp = [];
					
				$.ajax({
					async: false,
					type: "GET",
					url: "spring/ciudad/getAll",
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
						console.log('update ciudad');
						resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
				
				return resp;
			},
//			search : function() {
//				var resp = [];
//					
//				$.ajax({
//					async: false,
//					type: "GET",
//					url: "spring/ciudad/get?_search=true",
//					dataType:'json',
//					contentType: 'application/json',
//					success: function(data) {
//						if (data.codigo == "1") {
//							console.log('_search ciudad');
//							resp = {'respuesta':true,'detalle':data.detalle};								
//						} else if (data.codigo == "0") {
//							console.log('Error ' + data.detalle);
//							resp = {'respuesta':false, 'detalle':'Error : ' + data.detalle};
//						} else {
//							console.log('Error : ' + 'No se pudo _search ciudad!');
//							resp = {'respuesta':false, 'detalle':'Error : ' + 'No se pudo _search ciudad!'};
//						}
//					},
//					error: function(request, status, error) {
//						console.log("request " +request);
//						console.log("status " + status);
//						console.log("error " + error);
//						resp = {'respuesta':false, 'detalle':status + ' ' + error};
//					}
//				});
//				
//				return resp;
//			},
			add : function(ciudad) {
					
				var resp = false;
					
				var data = JSON.stringify(ciudad);
					
				$.ajax({
					async: false,
					type: "POST",
					url: "spring/ciudad/add",
					data: data,
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
						console.log('add ciudad');
						resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
				
				return resp;
			},
			update : function(ciudad) {
				
				var resp = false;
					
				var data = JSON.stringify(ciudad);
					
				$.ajax({
					async: false,
					type: "PUT",
					url: "spring/ciudad/update",
					data: data,
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
						console.log('update ciudad');
						resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
				
				return resp;
			},
			del : function(ciudad) {
				
				var resp = false;
					
				var data = JSON.stringify(ciudad);
					
				$.ajax({
					async: false,
					type: "DELETE",
					url: "spring/ciudad/del",
					data: data,
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
						console.log('del ciudad');
						resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
				
				return resp;
			}
		},
		comuna : {
			getAll : function() {
				var resp = false;
					
				$.ajax({
					async: false,
					type: "GET",
					url: "spring/comuna/getAll",
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
							console.log('getAll comuna json');
							resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
				
				return resp;
			},
		},
		producto : {
			get : function(codigo) {
				var resp = false;
					
				$.ajax({
					async: false,
					type: "GET",
					url: "spring/producto/"+codigo,
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
							console.log('get producto json');
							resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
				
				return resp;
			},
//			getUbicacion : function(codigoProducto) {
//				var resp = [];
//					
//				$.ajax({
//					async: false,
//					type: "GET",
//					url: "spring/producto/getUbicacion?codigoProducto="+codigoProducto,
//					dataType:'json',
//					contentType: 'application/json',
//					success: function(data) {
//							console.log('get ubicacion producto json');
//							resp = data;
//					},
//					error: function(request, status, error) {
//						console.log("request " +request);
//						console.log("status " + status);
//						console.log("error " + error);
//					}
//				});
//				
//				return resp;
//			},
//			getStockUbicacion : function(codigoProducto) {
//				var resp = [];
//					
//				$.ajax({
//					async: false,
//					type: "GET",
//					url: "spring/producto/getStockUbicacion?codigoProducto="+codigoProducto,
//					dataType:'json',
//					contentType: 'application/json',
//					success: function(data) {
//							console.log('getStockUbicacion producto json');
//							resp = data;
//					},
//					error: function(request, status, error) {
//						console.log("request " +request);
//						console.log("status " + status);
//						console.log("error " + error);
//					}
//				});
//				
//				return resp;
//			},
			getAll : function() {
				var resp = false;
				
				$.ajax({
					async: false,
					type: "GET",
					url: "spring/producto/getAll",
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
						console.log('getAll producto');
						resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					},
				});
				
				return resp;
			},
//			getAllEqBy : function(producto) {
//				var resp = [];
//				
//				var data = "q="+JSON.stringify(producto);
//				
//				$.ajax({
//					async: false,
//					type: "GET",
//					url: "spring/producto/getAllEqBy",
//					data: data,
//					dataType:'json',
//					contentType: 'application/json',
//					success: function(data) {
//							console.log('getAllEqBy producto json');
//							resp = data;
//					},
//					error: function(request, status, error) {
//						console.log("request " +request);
//						console.log("status " + status);
//						console.log("error " + error);
//					},
//				});
//				
//				return resp;
//			},
			getAllNotEqBy : function(producto) {
				var resp = false;
				
				var data = "q="+JSON.stringify(producto);				
				
				$.ajax({
					async: false,
					type: "GET",
					url: "spring/producto/getAllNotEqBy",
					data: data,
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
						console.log('getAllNotEqBy producto');
						resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					},
				});
				
				return resp;
			},
			ingreso : function(producto) {
						
				var resp = false;
						
				var data = producto;
					
				$.ajax({
					async: false,
					type: "POST",
					url: "spring/producto/ingreso",
					data: JSON.stringify(data),
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
						resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
					
				return resp;
			},
		},
		bodega : {
			getAll : function() {
				var resp = false;
					
				$.ajax({
					async: false,
					type: "GET",
					url: "spring/bodega/getAll",
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
						console.log('getAll bodega');
						resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
				
				return resp;
			},			
		},
		unidadMedida : {
			getAll : function() {
				var resp = false;
					
				$.ajax({
					async: false,
					type: "GET",
					url: "spring/unidadMedida/getAll",
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
							console.log('getAll unidadMedida json');
							resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
				
				return resp;
			},
			getAllEqBy : function(unidadMedida) {
				var resp = false;
				
				var data = "q="+JSON.stringify(unidadMedida);
				
				$.ajax({
					async: false,
					type: "GET",
					url: "spring/unidadMedida/getAllEqBy",
					data : data,
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
							console.log('getAllEqBy unidadMedida json');
							resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
				
				return resp;
			}
		},
		ubicacion : {
			getAllEqBy : function(ubicacion) {
				var resp = false;
				
				var data = "state="+JSON.stringify(ubicacion);
					
				$.ajax({
					async: false,
					type: "GET",
					url: "spring/ubicacion/getAllEqBy",
					data: data,
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
						console.log('getAllEqBy ubicacion json');
						resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
				
				return resp;
			},
			add : function(ubicacion) {
				var resp = false;
					
				var data = JSON.stringify(ubicacion);
				
				$.ajax({
					async: false,
					type: "POST",
					url: "spring/ubicacion/add",
					data: data,
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
						console.log('add ubicacion json');
						resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
				
				return resp;
			},
			update : function(ubicacion) {
				var resp = false;
					
				var data = JSON.stringify(ubicacion);
				
				$.ajax({
					async: false,
					type: "PUT",
					url: "spring/ubicacion/update",
					data: data,
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
						console.log('update ubicacion json');
						resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
				
				return resp;
			},
			del : function(ubicacion) {
				var resp = false;
					
				var data = JSON.stringify(ubicacion);
				
				$.ajax({
					async: false,
					type: "DELETE",
					url: "spring/ubicacion/del",
					data: data,
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
						console.log('del ubicacion json');
						resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
				
				return resp;
			},
		},
		stock : {
			getAllEqBy : function(stock) {
				var resp = false;
				
				var data = "state="+JSON.stringify(stock);
					
				$.ajax({
					async: false,
					type: "GET",
					url: "spring/stock/getAllEqBy",
					data: data,
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
						console.log('getAllEqBy stock json');
						resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
				
				return resp;
			},
		},
		ingrediente : {
			getAllEqBy : function(ingrediente) {
				var resp = [];
					
				var data = "state="+JSON.stringify(ingrediente);
				
				$.ajax({
					async: false,
					type: "GET",
					url: "spring/ingrediente/getAllEqBy",
					data: data,
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
							console.log('getAllEqBy ingrediente json');
							resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
				
				return resp;
			},
			add : function(ingrediente) {
				var resp = false;
					
				var data = JSON.stringify(ingrediente);
				
				$.ajax({
					async: false,
					type: "POST",
					url: "spring/ingrediente/add",
					data: data,
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
						console.log('add ingrediente json');
						resp = data;						
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
				
				return resp;
			},
			update : function(ingrediente) {
				var resp = false;
					
				var data = JSON.stringify(ingrediente);
				
				$.ajax({
					async: false,
					type: "PUT",
					url: "spring/ingrediente/update",
					data: data,
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {					
						console.log('update ingrediente json');
						resp = data;						
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
				
				return resp;
			},
			del : function(ingrediente) {
				var resp = false;
					
				var data = JSON.stringify(ingrediente);
				
				$.ajax({
					async: false,
					type: "DELETE",
					url: "spring/ingrediente/del",
					data: data,
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
						console.log('del ingrediente json');
						resp = data;						
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
				
				return resp;
			},
		},
		productoLinea : {
			getAllEqBy : function(productoLinea) {
				var resp = false;
					
				var data = "state="+JSON.stringify(productoLinea);
				
				$.ajax({
					async: false,
					type: "GET",
					url: "spring/productoLinea/getAllEqBy",
					data: data,
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
						console.log('getAllEqBy productoLinea json');
						resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
				
				return resp;
			},
			add : function(productoLinea) {
				var resp = false;
					
				var data = JSON.stringify(productoLinea);
				
				$.ajax({
					async: false,
					type: "POST",
					url: "spring/productoLinea/add",
					data: data,
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
						console.log('add productoLinea json');
						resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
				
				return resp;
			},
			update : function(productoLinea) {
				var resp = false;
					
				var data = JSON.stringify(productoLinea);
				
				$.ajax({
					async: false,
					type: "PUT",
					url: "spring/productoLinea/update",
					data: data,
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
						console.log('update productoLinea json');
						resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
				
				return resp;
			},
			del : function(productoLinea) {
				var resp = false;
					
				var data = JSON.stringify(productoLinea);
				
				$.ajax({
					async: false,
					type: "DELETE",
					url: "spring/productoLinea/del",
					data: data,
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
						console.log('del productoLinea json');
						resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
				
				return resp;
			},
		},
		lineaProduccion : {
			
			getAll : function() {
				
				var resp = false;
					
				$.ajax({
					async: false,
					type: "GET",
					url: "spring/lineaProduccion/getAll",
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
						console.log('getAll lineaProduccion json');
						resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
				
				return resp;
			}
		},
//		cabezaPedido : {
//			
//			get : function(numeroPedido) {
//				
//				var resp = false;
//					
//				$.ajax({
//					async: false,
//					type: "GET",
//					url: "spring/cabezaPedido/"+numeroPedido,
//					dataType:'json',
//					contentType: 'application/json',
//					success: function(data) {
//						console.log('get cabeza pedido json');
//						resp = data;
//					},
//					error: function(request, status, error) {
//						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
//							  title: status.toUpperCase(), 
//							  message: request.responseText});
//					}
//				});
//				
//				return resp;
//			}
//		},
		pedido : {
			
			get : function(numeroPedido) {
				
				var resp = false;
					
				$.ajax({
					async: false,
					type: "GET",
					url: "spring/pedido/"+numeroPedido,
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
						console.log('get pedido json');
						resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
				
				return resp;
			},
			getAll : function() {
				
				var resp = false;
				
				$.ajax({
					async: false,
					type: "GET",
					url: "spring/pedido/getAll",
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
						console.log('getAll pedido json');
						resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
				
				return resp;
			},
			getAllEqBy : function(pedido) {
				
				var resp = false;
				
				var data = "q="+JSON.stringify(pedido);
					
				$.ajax({
					async: false,
					type: "GET",
					url: "spring/pedido/getAllEqBy",
					data: data,
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
						console.log('getAllEqBy pedido json');
						resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
				
				return resp;
			},
			save : function(pedido) {
				
				var resp = false;
					
				var data = pedido;				
				$.ajax({
					async: false,
					type: "POST",
					url: "spring/pedido/save",
					data: JSON.stringify(data),
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
						console.log('pedido add');
						resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
				
				return resp;
			},
		},
		/*ingresoInsumo : {
			
			add : function(codigoProducto, codigoBodega, fechaVencimiento, cantidadProducto, codigoUnidadMedida, observacion) {

				
				var resp = false;
					
				var data = ({"codigoProducto": codigoProducto,
							 "codigoBodega": codigoBodega,
							 "fechaVencimiento": fechaVencimiento,
							 "cantidadProducto": cantidadProducto,
							 "codigoUnidadMedida": codigoUnidadMedida,
							 "observacion": observacion,
						    });
				
				$.ajax({
					async: false,
					type: "POST",
					url: "spring/ingresoInsumo/add",
					data: JSON.stringify(data),
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
						if (data.respuesta == "SUCCESS") {
							resp = {'respuesta':true,'producto':data.detalle};
							console.log('Ingreso Insumo add');
						} else {
							resp = {'respuesta':false};
						}
					},
					error: function(request, status, error) {
						console.log("request " +request);
						console.log("status " + status);
						console.log("error " + error);
						resp = false;
					}
				});
				
				return resp;
			},*/
		ingresoInsumo : {
				
			add : function(producto) {
					
				var resp = false;
						
				var data = producto;
					
				$.ajax({
					async: false,
					type: "POST",
					url: "spring/ingresoInsumo/add",
					data: JSON.stringify(data),
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
						resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
					
				return resp;
			},
		},
		ordenFabricacion : {
			get : function(ordenFabricacion) {
				var resp = false;
				
				$.ajax({
					async: false,
					type: "GET",
					url: "spring/ordenFabricacion/"+ordenFabricacion,
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
							console.log('get orden fabricacion json');
							resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
				
				return resp;
			},
			getAllEqBy : function(ordenFabricacion) {
				var resp = false;
				
				var data = "q="+JSON.stringify(ordenFabricacion);
				
				$.ajax({
					async: false,
					type: "GET",
					url: "spring/ordenFabricacion/getAllEqBy",
					data: data,
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
							console.log('getAllEqBy orden fabricacion json');
							resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
				
				return resp;
			},
			save : function(ordenFabricacion) {
				var resp = false;
				
				var data = ordenFabricacion;
				
				$.ajax({
					async: false,
					type: "POST",
					url: "spring/ordenFabricacion/save",
					data: data,
					data: JSON.stringify(data),
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
							console.log('save orden fabricación json');
							resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
				
				return resp;
			},
		},
		programaProduccion : {
			get : function(programaProduccion) {
				var resp = false;
				
				$.ajax({
					async: false,
					type: "GET",
					url: "spring/programaProduccion/"+programaProduccion,
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
							console.log('get Programa Producción json');
							resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
				
				return resp;
			},
		},
		funcionario : {
			getAll : function() {
				var resp = [];
					
				$.ajax({
					async: false,
					type: "GET",
					url: "spring/funcionario/getAll",
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
							console.log('getAll funcionario json');
							resp = data;
					},
					error: function(request, status, error) {
						console.log("request " +request);
						console.log("status " + status);
						console.log("error " + error);
					}
				});
				
				return resp;
			},
		},
		entregaInsumo : {
			getAllEqBy : function(entregaInsumo) {
				var resp = [];
				
				data = "q="+JSON.stringify(entregaInsumo);
				
				$.ajax({
					async: false,
					type: "GET",
					url: "spring/entregaInsumo/getAllEqBy",
					data: data,
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
							console.log('getByOrdenFabricacion entrega Insumo json');
							resp = data;
					},
					error: function(request, status, error) {
						console.log("request " +request);
						console.log("status " + status);
						console.log("error " + error);
					}
				});
				
				return resp;
			},
			add : function(ordenFabricacion, funcionario, detalleEntregaInsumo, observacion) {
				var resp = [];
					
				var data = ({"ordenFabricacion": ordenFabricacion,
					 "funcionario": funcionario,
					 "detalleEntregaInsumo" : detalleEntregaInsumo,
					 "observacion": observacion,
				    });
				
				$.ajax({
					async: false,
					type: "POST",
					url: "spring/entregaInsumo/add",
					data: JSON.stringify(data),
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
							if (data.respuesta == "SUCCESS") {
								resp = {'respuesta':true,'entregaInsumo':data.detalle};
								console.log('Entrega Insumo add');
							} else {
								resp = {'respuesta':false};
							}
					},
					error: function(request, status, error) {
						console.log("request " +request);
						console.log("status " + status);
						console.log("error " + error);
					}
				});
				
				return resp;
			},
		},
		devolucionInsumo : {
			add : function(devolucionInsumo) {
				var resp = [];

				var data = devolucionInsumo;
				
				$.ajax({
					async: false,
					type: "POST",
					url: "spring/devolucionInsumo/add",
					data: JSON.stringify(data),
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
							if (data.respuesta == "SUCCESS") {
								resp = {'respuesta':true,'devolucionInsumo':data.detalle};
								console.log('Devolución Insumo add');
							} else {
								resp = {'respuesta':false};
							}
					},
					error: function(request, status, error) {
						console.log("request " +request);
						console.log("status " + status);
						console.log("error " + error);
					}
				});
				
				return resp;
			},
		},
		capturaProduccion : {
			getAllEqBy : function(capturaProduccion) {

				if(!$.validateObject(capturaProduccion)) {
					console.log('Error : ' + 'campo undefined!');
					return {'respuesta':false, 'detalle':'Error : ' + 'campo undefined!'};					
				}

				var resp = [];

				var data = "q="+JSON.stringify(capturaProduccion);
				
				$.ajax({
					async: false,
					type: "GET",
					url: "spring/capturaProduccion/getAllEqBy",
					data: data,
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
						if (data.codigo == "1") {
							console.log('getAllEqBy Captura Producción');	
							resp = {'respuesta':true,'detalle':data.detalle};								
						} else if (data.codigo == "0") {
							console.log('Error ' + data.detalle);
							resp = {'respuesta':false, 'detalle':'Error : ' + data.detalle};
						} else {
							console.log('Error : ' + 'No se pudo obtener captura producción!');
							resp = {'respuesta':false, 'detalle':'Error : ' + 'No se pudo obtener captura producción!'};
						}
					},
					error: function(request, status, error) {
						console.log("request " +request);
						console.log("status " + status);
						console.log("error " + error);
						resp = {'respuesta':false, 'detalle':status + ' : ' + error};
					}
				});
				
				return resp;
			},
			add : function(capturaProduccion) {

//				if(!$.validateObject(capturaProduccion)) {
//					console.log('Error : ' + 'campo undefined!');
//					return {'respuesta':false, 'detalle':'Error : ' + 'campo undefined!'};					
//				}

				var resp = [];

				var data = capturaProduccion;
				
				$.ajax({
					async: false,
					type: "POST",
					url: "spring/capturaProduccion/add",
					data: JSON.stringify(data),
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
						if (data.codigo == "1") {
							console.log('Captura Producción add');	
							resp = {'respuesta':true,'capturaProduccion':data.detalle};								
						} else if (data.codigo == "0") {
							console.log('Error ' + data.detalle);
							resp = {'respuesta':false, 'detalle':'Error : ' + data.detalle};
						} else {
							console.log('Error : ' + 'No se pudo grabar captura producción!');
							resp = {'respuesta':false, 'detalle':'Error : ' + 'No se pudo grabar captura producción!'};
						}
					},
					error: function(request, status, error) {
						console.log("request " +request);
						console.log("status " + status);
						console.log("error " + error);
						resp = {'respuesta':false, 'detalle':error + status};
					}
				});
				
				return resp;
			},
		},
		cliente : {
			
			get : function(rut) {
				
				var resp = false;
					
				$.ajax({
					async: false,
					type: "GET",
					url: "spring/cliente/"+rut,
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
						console.log('get cliente json');
						resp = data;
					},
					error: function(request, status, error) {
						if(request.status != 200) {
							bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER,
								  title: status.toUpperCase(),
								  message: request.responseText});
						}
					}
				});
				
				return resp;
			},
		},
		entrega : {
			getAll : function() {
				var resp = false;
					
				$.ajax({
					async: false,
					type: "GET",
					url: "spring/entrega/getAll",
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
							console.log('getAll entrega json');
							resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
				
				return resp;
			},
		},
		estadoPedido : {
			getAll : function() {
				var resp = false;
					
				$.ajax({
					async: false,
					type: "GET",
					url: "spring/estadoPedido/getAll",
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
							console.log('getAll estadoPedido json');
							resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
				
				return resp;
			},
		},
		estadoOrdenFabricacion : {
			getAll : function() {
				var resp = false;
					
				$.ajax({
					async: false,
					type: "GET",
					url: "spring/estadoOrdenFabricacion/getAll",
					dataType:'json',
					contentType: 'application/json',
					success: function(data) {
							console.log('getAll estadoOrdenFabricacion json');
							resp = data;
					},
					error: function(request, status, error) {
						bootstrapDialog.show({type: bootstrapDialog.TYPE_DANGER, 
							  title: status.toUpperCase(), 
							  message: request.responseText});
					}
				});
				
				return resp;
			},
		},
	};
});