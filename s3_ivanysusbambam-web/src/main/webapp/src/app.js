(function (ng) {
    var app = angular.module('mainApp', [
        // External dependencies
        'ui.router',
       //'ui.bootstrap',
       
        // Internal modules dependencies   
        
        // Modulo de los automoviles,
        'automovilModule',

        // Modulo de las compras 
        "compraModule",
        "medioDePagoModule",
        'ventaModule',
       'quejaReclamoModule',

        
        
        //Módulo del cliente
        'clienteModule',
        //Modulo del vendedor
        'vendedorModule'/*,
        //Módulo del prospecto de compra
        'pcModule',
        //Modulo de las quejas/reclamos
        ,
        
        // Modulo de las ventas,
        'ventaModule'
*/
    ]);
    // Resuelve problemas de las promesas
    app.config(['$qProvider', function ($qProvider) {
            $qProvider.errorOnUnhandledRejections(false);
        }]);
    
    //Servicio para transferencia de datos entre templates.
    //adaptado de: 
    //https://stackoverflow.com/questions/22408790/angularjs-passing-data-between-pages
    app.service("dataTransfer", function() {
        var savedData = {};
        this.set = function(data) {
            savedData = data;
        };
        this.get= function() {
            return savedData;
        };
    });
    
})(window.angular);

