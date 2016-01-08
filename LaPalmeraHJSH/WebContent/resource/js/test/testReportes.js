/* global define, describe, it, should */
define(['service', 'moment'], function (service, moment) {
    'use strict';

    describe('service', function () {
    	it('should exist', function() {
            should.exist(service);
        });
    	
    	describe('ordenFabricacion', function () {
	        it("getAllEqBy expect ordenFabricacion to be instanceof Array", function() {
	        	
	        	var ordenFabricacion = {"codigoOrdenFabricacion" : "12-1",
									    "programaProduccions" : [{"lineaProduccion" : {"codigo" : "M01"}}],
									    "estadoOrdenFabricacion" : "I",
									    "fechaInicio" : "01-01-215",
									    "fechaTermino" : "30-12-2015"};
	        	
	        	var resp = service.ordenFabricacion.getAllEqBy(ordenFabricacion);
	        	expect(resp).to.be.instanceof(Array);
			});
    	});
    });
});