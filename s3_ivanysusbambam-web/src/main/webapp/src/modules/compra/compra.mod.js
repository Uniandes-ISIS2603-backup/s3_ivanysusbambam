(function (ng) {

    var mod = ng.module("compraModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

            var basePath = 'src/modules/compra/';

            $urlRouterProvider.otherwise("/compra/getall");

            $stateProvider.state('AdminCompraGetAll', {
                url: '/compra/getall',
                views: {

                    'mainView': {
                        templateUrl: basePath + "compra.list.html",
                        controller: 'compraGetAllCtrl',
                        controllerAs: "ctrl"
                    }
                    
                }
            }
            ).state('compraDetail', {
           
               url: "/{compraId: int}/detail",
               parent: "AdminCompraGetAll",
               params: {
                   compraId: null
               },
               views: {
                   'compraDetailView': {
                       templateUrl: basePath+"compra.detail.html",
                       controller: "compraDetailCtrl",
                       controllerAs: "ctrl"
                   }
               }
               
                
        });
        }]);


})(window.angular);

