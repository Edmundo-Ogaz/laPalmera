/* global define */
define([
        //'testLink',
        //'testPage',
        //'testService',
        //'testReportes'
        //'testServiceCRUDSolicitudProducto'
        //'testServiceCRUDSolicitudProductoCliente'
        //'testServiceCRUDOrdenFabricacion',
        'testServiceCRUDCapturaProduccion',
        ], function () {
    'use strict';

    window.console = window.console || function() {};
    window.notrack = true;
    window.mocha.run();
});