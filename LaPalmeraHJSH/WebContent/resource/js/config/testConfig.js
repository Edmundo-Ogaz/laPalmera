'use strict';

require.config({
    baseUrl: 'resource/js',
    deps: ['runner'],
    paths: {
    	testLink: 'test/testLink',
    	testPage: 'test/testPage',
    	testService: 'test/testService',
    	testReportes: 'test/testReportes',
    	testServiceCRUDSolicitudProducto: 'test/testServiceCRUDSolicitudProducto',
    	testServiceCRUDSolicitudProductoCliente: 'test/testServiceCRUDSolicitudProductoCliente',
    	testServiceCRUDOrdenFabricacion: 'test/testServiceCRUDOrdenFabricacion',
    	testServiceCRUDCapturaProduccion: 'test/testServiceCRUDCapturaProduccion',
        runner: 'test/testRunner',
        commonConfig: 'config/commonConfig'
    },
    shim: {
        runner: ['commonConfig']
    }
});