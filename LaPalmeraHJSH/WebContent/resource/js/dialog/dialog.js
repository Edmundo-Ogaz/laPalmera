define(["jquery"], function($) {
 	console.log("Function : dialog");
	return {
		modal : function(text,titulo) {
			if (titulo==undefined){
				titulo = "...";
			}
			$('#dialog').html(text);
			$("#dialog").dialog({
				autoOpen: false,
				height: "auto",
				width: 810,
				modal: true,
				resizable:true,
				closeOnEscape:false,
				title: titulo,
				position: "top",
				open: function (event, ui) {
					$('#dialog').css('overflow', 'hidden'); //this line does the actual hiding
				},
			});
			$("#dialog" ).dialog("open");
		},
		modalWidth : function(text,titulo, width) {
			if (titulo==undefined){
				titulo = "...";
			}
			$('#dialog').html(text);
			$("#dialog").dialog({
				autoOpen: false,
				height: "auto",
				width: width,
				modal: true,
				resizable:true,
				closeOnEscape:false,
				title: titulo,
				position: "top",
				open: function (event, ui) {
					$('#dialog').css('overflow', 'hidden'); //this line does the actual hiding
				},
			});
			$("#dialog" ).dialog("open");
		}
	}
});