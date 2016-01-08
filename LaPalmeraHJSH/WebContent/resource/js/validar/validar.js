define(["jquery", "bootstrap-dialog"], function($, bootstrapDialog) {
 	console.log("Function : validar");

	return {
		numero : {
			soloNumero : function(obj) {
				obj.value = (obj.value + '').replace(/[^0-9]/g, '');
			},
		},
		length : {
			max : function(obj, max) {
				obj.attr('maxlength',max);			
			}
		}
	};
});