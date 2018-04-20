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
            );
        }]);


})(window.angular);

