//The build will inline common dependencies into this file.

//For any third party dependencies, like jQuery, place them in the lib folder.

//Configure loading modules from the lib directory,
//except for 'app' ones, which are in a sibling
//directory.
requirejs.config({
    baseUrl: 'resource/js',
    paths: {
        'jquery': "vendor/jquery/jquery-1.11.1",
        'jquery-ui': "vendor/jquery/jquery-ui-1.10.3",
        'jquery-migrate': "vendor/jquery/jquery-migrate-1.2.1",
        'jqGrid-locale': "vendor/jqGrid/i18n/grid.locale-en",
        'jqGrid': "vendor/jqGrid/jquery.jqGrid.min-4.6.0",
        'maxlength': "vendor/maxlength/stjerneman/jquery.maxlength",
        //'moment': "vendor/moment/moment",
        'moment': "vendor/moment/moment-with-locales",
        'bootstrap': "vendor/bootstrap/bootstrap",
        'bootstrap-dialog': "vendor/bootstrap/dialog/bootstrap-dialog",
        'bootstrap-datetimepicker': "vendor/bootstrap/datetimepicker/bootstrap-datetimepicker",
        'router': "vendor/router/ramiel/routerIE8",
        'spin': "vendor/spin/fgnass/spin",
        'spin-jquery': "vendor/spin/fgnass/jquery.spin",
        'underscore': "vendor/underscore/underscore",
        //'underscore-min': "vendor/underscore/underscore-min",
        'placeholders': "vendor/placeholder/jamesallardice/placeholders",
        'es5shim': "vendor/es-shims/es5-shim",
        'loginController': "controller/loginController",
        'homeController': "controller/homeController",
        'menuController': "controller/menuController",
        'regionController': "controller/regionController",
        'ciudadController': "controller/ciudadController",
        'ubicacionController': "controller/ubicacionController",
        'ingredienteConsultaController': "controller/ingredienteConsultaController",
        'lineaProduccionConsultaController': "controller/lineaProduccionConsultaController",
        'ubicacionConsultaController': "controller/ubicacionConsultaController",
        'ubicacionDialogController': "controller/ubicacionDialogController",
        'stockConsultaController': "controller/stockConsultaController",
        'solicitudProductoController': "controller/solicitudProductoController",
        'solicitudProductoListaController': "controller/solicitudProductoListaController",
        'solicitudProductoClienteController': "controller/solicitudProductoClienteController",
        'productoConsultaDialogController': "controller/productoConsultaDialogController",
        'productoConsultaClienteDialogController': "controller/productoConsultaClienteDialogController",
        'ingresoInsumoController': "controller/ingresoInsumoController",
        'ingresoInsumoListaController': "controller/ingresoInsumoListaController",
        'entregaInsumoConsultaController': "controller/entregaInsumoConsultaController",
        'entregaInsumoDialogController': "controller/entregaInsumoDialogController",
        'devolucionInsumoConsultaController': "controller/devolucionInsumoConsultaController",
        'devolucionInsumoDialogController': "controller/devolucionInsumoDialogController",
        'capturaProduccionConsultaController': "controller/capturaProduccionConsultaController",
        'capturaProduccionDialogController': "controller/capturaProduccionDialogController",
        'pedidoConfirmaController': "controller/pedidoConfirmaController",
        'pedidoActualizaDialogController': "controller/pedidoActualizaDialogController",
        'pedidoConsultaController' : "controller/pedidoConsultaController",
        'pedidoConsultaDialogController': "controller/pedidoConsultaDialogController",
        'ordenFabricacionConsultaController' : "controller/ordenFabricacionConsultaController",
        'programaProduccionConsultaController' : "controller/programaProduccionConsultaController",
        'programaProduccionModificaDialogController' : "controller/programaProduccionModificaDialogController",
        'dispatcher': "dispatcher/dispatcher",
        'service': "service/service",
        'page': "service/page",
        'dialog': "dialog/dialog",
        'model': "service/model",
        'helper': "helper/helper",
        'enum': "enum/enum",
        'validar': "validar/validar",
        //'mocha': "vendor/mocha/mocha",
        //'chai': "vendor/chai/chai",
    },
    shim: {
    	'jquery-ui': ['jquery'],
    	'jqGrid-locale': ['jquery'],
    	'jqGrid': ['jquery', 'jqGrid-locale'],
    	'bootstrap': ['jquery', 'placeholders'],
    	'bootstrap-dialog': ['jquery', 'bootstrap'],
    	'bootstrap-datetimepicker': ['jquery', 'bootstrap', 'moment', 'es5shim'],
    	'loginController': ['jquery'],
    	'service': ['jquery', 'bootstrap-dialog'],
    	'dialog': ['jquery', 'jquery-ui'],
    	'stockConsultaController' : ['jquery', 'service', 'bootstrap-dialog']
    }
});