define(["jquery", "service"], function($, service) {
 
	console.log("Function : region controller");

	return {
		init : function() {
			
			$('#titulo').html('Regi&oacute;n');
		 	$('#page').load('region.html', function() {
		 		jQuery("#navgrid").jqGrid({
					datatype: "local",
					jsonReader : { repeatitems: false },
					colNames:['C&oacute;digo','Nombre'],
					colModel:[
					  		{name:'codigo', index:'codigo', key:true, width:55, editable:true, editoptions:{readonly:false,size:10}},
					  		{name:'nombre',index:'nombre',            width:90, editable:true, editoptions:{readonly:false,size:25}}
					  	],
				  	rowNum:10,
				  	rowList:[10,20,30],
				  	pager: '#pagernav',
				  	sortname: 'codigo',
				  	viewrecords: true,
				  	sortorder: "asc",
				  	caption:"Regiones",
				  	editurl:"clientArray",
				  	height:225,
				  	autowidth:true,			  	
		 		});
		 		
		 		$(window).on("resize", function () {
				    var newWidth = $("#navgrid").closest(".ui-jqgrid").parent().width();
				    $("#navgrid").jqGrid("setGridWidth", newWidth, true);
				    // without scrollbar
				    $("#navgrid").closest('.ui-jqgrid-bdiv').width($("#navgrid").closest('.ui-jqgrid-bdiv').width() + 1);
				});

			  	jQuery("#navgrid").jqGrid('navGrid','#pagernav', {del:true,add:true,edit:true,search:true}, //options
			  		{
			  			beforeShowForm : function (formid) {
			  				$("#codigo", formid).attr("readonly","readonly");
			  			},
			  			beforeSubmit : function (postdata, formid) {
			  				var region = ({"codigo": postdata.codigo, "nombre": postdata.nombre});
			  				var resp = service.region.update(region);
			  				if(resp instanceof Object) {
			  					jQuery("#navgrid").jqGrid('setRowData', 
			  							postdata.navgrid_id,
			  							{'codigo':postdata.codigo, 'nombre':postdata.nombre});				  				
			  					$(".ui-icon-closethick").trigger('click');
			  				}
			  				return [false, "Problemas al actualizar región"];
			  			},
				  		height : 300,
					  	reloadAfterSubmit : false,
					  	bSubmit: "Submit",
					  	bCancel: "Cancel",
					  	closeAfterEdit : true,
					  	url: "spring/regionPost",
		  		  	}, // edit options
		  		  	{
			  		  	beforeShowForm : function (formid) {
			  				$("#codigo", formid).removeAttr("readonly");
			  			},
			  			beforeSubmit : function (postdata, formid) {
			  				var region = ({"codigo": postdata.codigo, "nombre": postdata.nombre});
			  				var resp = service.region.add(region);
			  				if(resp instanceof Object) {
			  					jQuery("#navgrid").jqGrid('addRowData', 
			  												postdata.codigo,
			  												{'codigo':postdata.codigo, 'nombre':postdata.nombre},
			  												'first');
			  					jQuery("#navgrid").jqGrid('setSelection', postdata.codigo, false);
			  					$(".ui-icon-closethick").trigger('click');
							}
			  				return [false, "No pudo grabar región"];
			  			},
			  	  	  	height : 300,
			  	  		reloadAfterSubmit : false,
			  	  		bSubmit : "Submit",
			  	  		bCancel : "Cancel",
			  	  		closeAfterAdd : true,
			  	  		url: "spring/regionPost",
		  	  		}, // add options
		  		  	{
			  	  		beforeSubmit : function (rowid) {
			  	  		var data = jQuery("#navgrid").jqGrid('getRowData', rowid);
			  	  	    var region = ({"codigo": data.codigo});
			  				var resp = service.region.del(region);
			  				if(resp instanceof Object) {
			  					jQuery("#navgrid").jqGrid('delRowData', rowid);
			  					$(".ui-icon-closethick").trigger('click');
			  				}
			  				return [false, "No pudo eliminar región"];
			  			},
			  			reloadAfterSubmit:false,
		  	  			url: "spring/regionPost"
		  	  		}, // del options
		  		  	{
		  	  			sopt:['eq', 'ne', 'bw', 'bn', 'ew', 'en', 'cn', 'nc', 'nu', 'nn' 
		  	  	  		//, 'in','ni'
		    	  	  	],
		    	  	  	multipleSearch:true,
		    	  	  	multipleGroup:true,
		    	  	  	showQuery:true,
		 	  		 } // search options
			  	);
			  	
				var resp = service.region.getAll();
				if(resp instanceof Array) {
					var regions = resp;
					for(var i=0;i<regions.length;i++) {
						jQuery("#navgrid").jqGrid('addRowData', regions[i].codigo, regions[i]);
					}
					jQuery("#navgrid").trigger("reloadGrid");
				}
		 	});
		}
	};
});