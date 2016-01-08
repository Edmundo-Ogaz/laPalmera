define(["jquery", "jqGrid", "service","page", "bootstrap-dialog"], function($, jqGrid, service, page, bootstrapDialog) {
 
	console.log("Function : ciudad controller");

	return {
		init : function() {
			var stringRegion = "-1:SELECCIONE;";
			var resp = service.region.getAll();
			if(resp instanceof Array) {
				var regions = resp;
				for(var i=0; i<regions.length; i++) {
					stringRegion = stringRegion.concat(regions[i].codigo + ":" + regions[i].nombre + ";");
				}
			}			
			stringRegion = stringRegion.substring(0, stringRegion.length - 1);
			$('#titulo').html('Ciudad');
			$('#page').html(page.ciudad.get());
		 	
			//$('#page').load('ciudad.html', function() {
			
		 		jQuery("#navgrid").jqGrid({
					datatype: "local",
					jsonReader : { repeatitems: false },
					colNames:['C&oacute;digo','Nombre', 'Regi&oacute;n'],
					colModel:[
					  		{name:'codigo', index:'codigo', key:true, width:55, editable:true, editoptions:{readonly:false, size:10}},
					  		{name:'nombre',index:'nombre',            width:90, editable:true, editoptions:{readonly:false, size:25}},
					  		{name:'region',index:'region',            width:90, editable:true, edittype:'select', editoptions:{readonly:false, value:stringRegion}}
					  	],
				  	rowNum:10,
				  	rowList:[10,20,30],
				  	pager: '#pagernav',
				  	sortname: 'codigo',
				  	viewrecords: true,
				  	sortorder: "asc",
				  	caption:"Ciudades",
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
		 		
				  	//.navGrid('#pagernav', {edit:false, add:false, del:false});
			  	jQuery("#navgrid").jqGrid('navGrid','#pagernav', {del:true,add:true,edit:true,search:true}, //options
			  		{
			  			beforeShowForm : function (formid) {
			  				$("#codigo", formid).attr("readonly","readonly");
			  			},
			  			beforeSubmit : function (postdata, formid) {
			  				var ciudad = {"codigo": postdata.codigo, "nombre": postdata.nombre, "region": {"codigo" : postdata.region}};
			  				var resp = service.ciudad.update(ciudad);
			  				if(resp instanceof Object) {
			  					jQuery("#navgrid").jqGrid('setRowData', 
			  							postdata.navgrid_id,
			  							{'codigo':postdata.codigo, 'nombre':postdata.nombre, 'region':postdata.region});				  				
			  					$(".ui-icon-closethick").trigger('click');
			  				}
			  				return [false, "no pudo update ciudad"];
			  			},
				  		height : 300,
					  	reloadAfterSubmit : false,
					  	bSubmit: "Submit",
					  	bCancel: "Cancel",
					  	closeAfterEdit : true,
					  	url: "spring/ciudadPost",
		  		  	}, // edit options
		  		  	{
			  		  	beforeShowForm : function (formid) {
			  				$("#codigo", formid).removeAttr("readonly");
			  			},
			  			beforeSubmit : function (postdata, formid) {
			  				var ciudad = {"codigo": postdata.codigo, "nombre": postdata.nombre, "region": {"codigo" : postdata.region}};
			  				var resp = service.ciudad.add(ciudad);
			  				if(resp instanceof Object) {
			  					jQuery("#navgrid").jqGrid('addRowData', 
			  												postdata.codigo,
			  												{'codigo':postdata.codigo, 'nombre':postdata.nombre, 'region':postdata.region},
			  												'first');
			  					jQuery("#navgrid").jqGrid('setSelection', postdata.codigo, false);
			  					$(".ui-icon-closethick").trigger('click');
			  				}
			  				return [false, "No pudo grabar ciudad"];
			  			},
			  	  	  	height : 300,
			  	  		reloadAfterSubmit : false,
			  	  		bSubmit : "Submit",
			  	  		bCancel : "Cancel",
			  	  		closeAfterAdd : true,
			  	  		url: "spring/ciudadPost",
		  	  		}, // add options
		  		  	{
			  	  		beforeSubmit : function (rowid) {
			  	  		var data = jQuery("#navgrid").jqGrid('getRowData', rowid);
			  	  		var ciudad = {"codigo": data.codigo};
			  				var resp = service.ciudad.del(ciudad);
			  				if(resp instanceof Object) {
			  					jQuery("#navgrid").jqGrid('delRowData', rowid);
			  					$(".ui-icon-closethick").trigger('click');
			  				}
			  				return [false, "No pudo delete Ciudad"];
			  			},
			  			reloadAfterSubmit:false,
		  	  			url: "spring/ciudadPost"
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
			  	
			  	//jQuery("#navgrid").jqGrid('filterToolbar', {stringResult: true, searchOnEnter: false});
			  	
				var resp = service.ciudad.getAll();
				if(resp instanceof Array) {
					var ciudads = resp;
					var array = [];
					for(var i=0; i<ciudads.length; i++) {
						array.push({'codigo' : ciudads[i].codigo, 
									'nombre' : ciudads[i].nombre, 
									'region' : ciudads[i].region.codigo,
			            });
					}
					jQuery("#navgrid").jqGrid('addRowData', "codigo", array);
					jQuery("#navgrid").trigger("reloadGrid");
			 	}
		 	//});
		}
	};
});