(function (ng) {

    var mod = ng.module("ventaModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

            var basePath = 'src/modules/venta/';

            $urlRouterProvider.otherwise("/venta/getall");

            $stateProvider.state('adminVentaGetAll', {
                url: '/venta/getall',
                views: {

                    'mainView': {
                        templateUrl: basePath + "venta.list.html",
                        controller: 'ventaGetAllCtrl',
                        controllerAs: "ctrl"
                    }
                }
            }
            );
        }]);


})(window.angular);

