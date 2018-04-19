(function (ng) {
    var app = angular.module('mainApp', [
        // External dependencies
        'ui.router',
       'ui.bootstrap',
       
        // Internal modules dependencies   
        'adminModule'
        /*
        //Módulo del cliente
        'clienteModule',
        //Modulo del vendedor
        'vendedorModule',
        //Módulo del prospecto de compra
        'pcModule',
        //Modulo de las quejas/reclamos
        'quejaReclamoModule',
        // Modulo de los automoviles,
        'automovilModule',
        // Modulo de las ventas,
        'ventaModule'
*/
    ]);
    // Resuelve problemas de las promesas
    app.config(['$qProvider', function ($qProvider) {
            $qProvider.errorOnUnhandledRejections(false);
        }]);
})(window.angular);

