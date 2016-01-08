define(['enum'], function(ENUM) {
 	console.log("Function : helper");
 	
	return {
		UnidadMedida : {
			conversion : function(codigoUnidadMedidaBase, codigoUnidadMediaNew, cantidad) {			
				
				if(codigoUnidadMedidaBase != codigoUnidadMediaNew) {
					if(ENUM.UnidadMedida.LITRO.codigo == codigoUnidadMediaNew)
						cantidad = cantidad * ENUM.UnidadMedida.LITRO.conversion;
					if(ENUM.UnidadMedida.CENTRIMETRO_CUBICOS.codigo == codigoUnidadMediaNew)
						cantidad = cantidad * ENUM.UnidadMedida.CENTRIMETRO_CUBICOS.conversion;
				}
				
				return cantidad;
			}
		}
	};
});