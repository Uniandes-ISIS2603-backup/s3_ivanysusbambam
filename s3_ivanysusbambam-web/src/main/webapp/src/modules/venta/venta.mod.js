(function (ng) {

    var mod = ng.module("ventaModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

        var basePath = 'src/modules/venta/';

        $urlRouterProvider.otherwise("/venta/getall");

        $stateProvider.state('adminVentaGetAll', {
            url: '/venta/getall',
            views: {
                params: {
                    requireLogin: true
                },
                'mainView': {
                    templateUrl: basePath + "venta.list.html",
                    controller: 'ventaGetAllCtrl',
                    controllerAs: "ctrl"
                }
            }
        }).state("ventaDetail", {
            url: "/{ventaId: int}/detail ",
            parent: "adminVentaGetAll",
            params: {
                ventaId: null,
                requireLogin: true
            },
            views: {
                'ventaDetailView': {
                    templateUrl: basePath + "venta.detail.html",
                    controller: "ventaDetailCtrl",
                    controllerAs: "ctrl"
                }
            }
        }).state("crearVenta", {
            url: "/venta/crear",
            params: {
                requireLogin: true
            },
            views: {
                mainView: {
                    templateUrl: basePath + "venta.crear.html",
                    controller: "ventaCrearCtrl",
                    controllerAs: "ctrl"
                }
            }
        });
        }]);


})(window.angular);
