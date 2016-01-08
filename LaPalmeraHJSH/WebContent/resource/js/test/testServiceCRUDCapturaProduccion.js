/* global define, describe, it, should */
define(['service', 'moment'], function (service, moment) {
    'use strict';

    describe('service', function () {
    	it('should exist', function() {
            should.exist(service);
        });    	

    	describe('capturaProduccion', function () {
    		it("save expect capturaProduccion to be instanceof Object", function() {
    			
    			var codigoProgramaProduccion = '9-1-1';
    			var funcionarios = [];
	 			for(var i=0; i < 1; i++) {
	 				funcionarios.push({"rut" : '15331265-6'});
	 			}
	 			
    			var productoCodigo = 'T01E01D01';
    			var produccionNombre = 'Mil Delicias 20 Porciones';
    			
    			var bodegaCodigo = 'B01'
    			var fechaVencimiento = moment().locale('es').format('YYYY-MM-DD HH:mm:ss');
    			
    			var productoCantidad = 5;
    			var unidadMedidaCodigo = 'UND';
    			var ubicacionObservacion = 'prueba obs';
    			
    			var observacion = 'obs';
    			
    			var capturaProduccionToSave = {
	 					"programaProduccion": {"codigo" : codigoProgramaProduccion},
						 "fechaCapturaProduccion" : moment().locale('es').format('YYYY-MM-DD HH:mm:ss'),
						 //"horaCapturaProduccion" : moment().locale('es').format('YYYY-MM-DD HH:mm:ss'),
		 				 "funcionarios" : funcionarios,
		 				 "producto" : {"codigo" : productoCodigo,
		 					 		   "nombre" : produccionNombre,
							  		   "ubicacions" : [{"producto" : {"codigo" : productoCodigo},
						  	  			  			    "bodega" : {"codigo" : bodegaCodigo},
						  	  			  			    "fechaIngreso" :  moment().locale('es').format('YYYY-MM-DD HH:mm:ss'),
//						  	  			  				"horaIngreso" : moment().locale('es').format('YYYY-MM-DD HH:mm:ss'),
						  	  			  			    "fechaVencimiento" : fechaVencimiento,
								  			  			"cantidad": productoCantidad,
								  			  			"unidadMedida" : {"codigo": unidadMedidaCodigo},
								  			  			"observacion" : ubicacionObservacion,
								  			  			}]
							  		  },
				  		 "cantidadProduccion": productoCantidad,
				  		 "unidadMedida" : {"codigo": unidadMedidaCodigo},
				  		 "observacion": observacion,
					    };
    			
	    		var add = service.capturaProduccion.add(capturaProduccionToSave);
	    		expect(add).to.not.equal(false);
//	    		if(add.respuesta) {
//	 				var capturaProduccion = resp.capturaProduccion;
//	 				expect(capturaProduccion).to.be.object.equal(false);
//	    		}
    		});
    	});
    });
});