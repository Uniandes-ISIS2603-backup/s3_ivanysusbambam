(function (ng) {

    var mod = ng.module("quejaReclamoModule", ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

            var basePath = 'src/modules/quejaReclamo/';

            $urlRouterProvider.otherwise("/quejaReclamo/getall");

            $stateProvider.state('adminQuejaReclamoGetAll', {
                url: '/quejaReclamo/getall',
                views: {

                    'mainView': {
                        templateUrl: basePath + "quejaReclamo.list.html",
                        controller: 'quejaReclamoGetAllCtrl',
                        controllerAs: "ctrl"
                    }
                }
            }).state("quejaReclamoDetail",{
                    url: "/{quejaReclamoId:int}/detail",
                    parent:"adminQuejaReclamoGetAll",
                    params: {
                        quejaReclamoId:null
                    },
                    views: {
                        quejaReclamoDetailView: {
                            templateUrl: basePath + "quejaReclamo.detail.html",
                            controller:"quejaReclamoDetailCtrl",
                            controllerAs:"ctrl"
                        }
                    }}).state("crearQuejaReclamo",{
                url: "/quejaReclamo/crear",

                views:{
                    mainView:{
                        templateUrl: basePath + "quejaReclamo.crear.html",
                        controller: "quejaReclamoCrearCtrl",
                        controllerAs: "ctrl"
                    }
                }});
        }]);


})(window.angular);

