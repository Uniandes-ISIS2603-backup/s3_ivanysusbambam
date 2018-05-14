(function (ng) {

    var mod = ng.module("medioDePagoModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

        var basePath = 'src/modules/medioDePago/';



        $stateProvider.state('AdminMedioDePagoGetAll', {
            url: '/medioDePago/getall',
            params: {
                requireLogin: true
            },
            views: {

                'mainView': {
                    templateUrl: basePath + "medioDePago.list.html",
                    controller: 'medioDePagoGetAllCtrl',
                    controllerAs: "ctrl"
                }
            }
        }).state('medioDePagoDetail', {

            url: "/{numero: int}/detail",
            parent: "AdminMedioDePagoGetAll",
            params: {
                numero: null,
                requireLogin: true
            },
            views: {
                'medioDePagoDetailView': {
                    templateUrl: basePath + "medioDePago.detail.html",
                    controller: "medioDePagoDetailCtrl",
                    controllerAs: "ctrl"
                }
            }


        }).state('medioCreate', {

            url: "/create",
            parent: "AdminMedioDePagoGetAll",
            params: {
                requireLogin: true
            },
            views: {
                medioDePagoDetailView: {
                    templateUrl: basePath + "medioDePago.crear.html",
                    controller: "medioDePagoCrearCtrl",
                    controllerAs: "ctrl"

                }
            }


        }).state('medioDePagoDelete', {

            url: "/{numero: int}/detail",
            parent: "AdminMedioDePagoGetAll",
            params: {
                numero: null,
                requireLogin: true
            },
            views: {
                'medioDePagoDetailView': {
                    templateUrl: basePath + "medioDePago.detele.html",
                    controller: "medioDePagoDeleteCtrl",
                    controllerAs: "ctrl"
                }
            }


        });
        }]);


})(window.angular);
