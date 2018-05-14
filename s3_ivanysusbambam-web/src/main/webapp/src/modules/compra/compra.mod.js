(function (ng) {

    var mod = ng.module("compraModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

            var basePath = 'src/modules/compra/';

            $urlRouterProvider.otherwise("/compra/getall");

            $stateProvider.state('AdminCompraGetAll', {
                url: '/compra/getall',
                params:{
              requireLogin: true  
            },
                views: {
                    
                    'mainView': {
                        templateUrl: basePath + "compra.list.html",
                        controller: 'compraGetAllCtrl',
                        controllerAs: "ctrl"
                    }

                }
            }
            ).state('compraDetail', {

                url: "/{idCompra: int}/detail",
                parent: "AdminCompraGetAll",
                params: {
                    idCompra: null,
                    requireLogin:true
                },
                views: {
                    'compraDetailView': {
                        templateUrl: basePath + "compra.detail.html",
                        controller: "compraDetailCtrl",
                        controllerAs: "ctrl"
                    }
                }


            }
            ).state('compraCreate', {

                url: "/create",
                parent: "AdminCompraGetAll",
                params: {
                    idCompra: null,
                    requireLogin:true
                },
                views: {
                    'compraDetailView': {
                        templateUrl: basePath + "compra.crear.html",
                        controller: "compraCrearCtrl",
                        controllerAs: "ctrl"
                    }
                }


            }
            ).state('compraDelete', {

                url: "/{idCompra: int}/detail",
                parent: "AdminCompraGetAll",
                params: {
                    idCompra: null,
                    requireLogin:true
                },
                views: {
                    'compraDetailView': {
                        templateUrl: basePath + "compra.delete.html",
                        controller: "compraDeleteCtrl",
                        controllerAs: "ctrl"
                    }
                }


            }).state('comprarAuto',{
            
                url: "/comprar/{idAuto: int}/",
                params:{
                      requireLogin: true,
                      idAuto: null
                    },    
                views: {
                        mainView: {
                            templateUrl: basePath + "comprar.html",
                            controller: "automovilGetAllCtrl",
                            controllerAs: "ctrl"
                        },
                    }
            
            });
        }]);


})(window.angular);

