

function validarLista() {

	var check = $("input[type='checkbox']:checked").length;

	if(check == ""){
		alert('Debe seleccionar un registro.');
    	return false;
    } else {
        return true;
	}		    
}

$(document).ready(function() {
    $('#example').dataTable();
} );

