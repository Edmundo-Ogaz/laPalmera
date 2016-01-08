define([], function() {
 	console.log("Function : model");
 	
	return {
		producto : {
			codigo : null,
			nombre : null,
			unidadMedida : null,
			otraCaracteristica : null,
			familia : null,
			subFamilia : null,
			stockcriticoproducto : null,
			valorcosto : null,
			valorventa : null,
			preparacion : null,
			tipoProducto : null,
			fotoproducto : null,
			observacion : null,
			stock : null,			
			setTipoProducto : function(tipoProducto) {
				this.tipoProducto = tipoProducto;
				return this.get();
			},
			get : function() {
				return {"codigo" : this.codigo,
						"nombre" : this.nombre,
						"unidadMedida" : this.unidadMedida,
						"otraCaracteristica" : this.otraCaracteristica,
						"familia" : this.familia,
						"subFamilia" : this.subFamilia,
						"stockcriticoproducto" : this.stockcriticoproducto,
						"valorcosto" : this.valorcosto,
						"valorventa" : this.valorventa,
						"preparacion" : this.preparacion,
						"tipoProducto" : this.tipoProducto,
						"fotoproducto" : this.fotoproducto,
						"observacion" : this.observacion,
						"stock" : this.stock};
			}
		},
		tipoProducto : {
			codigo : null,
			nombre : null,
			setCodigo : function(codigo) {
				this.codigo = codigo;
				return this.get();
			},
			get : function() {
				return {"codigo" : this.codigo, "nombre" : this.nombre};
			}
		}
	};
});