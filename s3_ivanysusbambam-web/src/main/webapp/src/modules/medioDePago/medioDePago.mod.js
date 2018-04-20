(function (ng) {

    var mod = ng.module("medioDePagoModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

            var basePath = 'src/modules/medioDePago/';

           

            $stateProvider.state('AdminMedioDePagoGetAll', {
                url: '/medioDePago/getall',
                views: {

                    'mainView': {
                        templateUrl: basePath + "medioDePago.list.html",
                        controller: 'medioDePagoGetAllCtrl',
                        controllerAs: "ctrl"
                    }
                }
            }
            );
        }]);


})(window.angular);

