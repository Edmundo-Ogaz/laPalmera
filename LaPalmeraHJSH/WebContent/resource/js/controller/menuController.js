define(["jquery", "bootstrap-dialog", "service", "page", "ciudadController"], 
		function($, bootstrapDialog, service, page, ciudadController) {
 
	console.log("Function : menu controller");

	return {
		
		init : function() {
			
			var logout = this.logout;
			
			$('#menu').html(page.menu.get());
			 
			$('#menu #salir').on('click', function(e) {
            	console.log("salir menu controller");
            	var resp = logout();
            	return resp;
            });
		},
		logout : function() {
			var forward = '';
			var resp = service.usuario.logout();			
			if(resp) {
				forward = window.location.href.substring(0,  window.location.href.lastIndexOf("/")) + "/login.html";
			} else {
				bootstrapDialog.show({message: 'Problemas al salir del aplicativo!'});
			}
			
			return forward;
		}
	};
});