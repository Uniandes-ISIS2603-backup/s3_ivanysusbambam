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
        }).state("vender", {
            url: "/comprar/{idAuto: int}/",
            params: {
                requireLogin: true,
                idAuto: null,
                clienteId:null
            },
            views: {
                mainView: {
                    templateUrl: basePath + "vender.html",
                    controller: "venderCtrl",
                    controllerAs: "ctrl"
                }
            }
        });
        }]);


})(window.angular);
