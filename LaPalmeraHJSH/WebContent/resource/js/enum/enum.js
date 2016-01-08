define([], function() {
 	console.log("Function : Enum");
 	
	return {
		UnidadMedida : {
			LITRO : { codigo : 'LTS', conversion : 10000, descripcion : 'Litros'},
			CENTRIMETRO_CUBICOS : {codigo : 'CM3', conversion : 0.001, descripcion : 'Centimetro Cubico'}
		},
		estadoPedido : {
			INGRESADO : {codigo : 'I', descripcion : 'Ingresado'},
			CONFIRMADO : {codigo : 'C', descripcion : 'Confirmado'},
			RECHAZADO : {codigo : 'R', descripcion : 'Rechazado'}
		}
	};
});