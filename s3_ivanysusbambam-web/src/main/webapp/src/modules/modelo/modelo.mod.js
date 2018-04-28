(function (ng) {

    var mod = ng.module("modeloModule", ['ui.router']);



    mod.config(["$stateProvider", "$urlRouterProvider", function ($stateProvider, $urlRouterProvider) {
        var basePath = "src/modules/modelo/";
        
        $stateProvider.state("listModelo", {

                url: "/modelos/lista",
                views:{
                    mainView:{
                templateUrl: basePath + "modelo.list.html",
                controller: "modeloListCtrl",
                controllerAs: "ctrl"}}
            })
            .state('modeloDetail', {
                url: '/:ModeloId/detail',
                parent: "listModelo",
                params: {
                    ModeloId: null
                },
                views: {
                    modelDetailView: {
                        templateUrl: basePath + "modelo.detail.html",
                        controller: "modeloDetailCtrl",
                        controllerAs: "ctrl"

                    }
                }

            })
            .state('crearModelo', {
                url: '/modelo/crear',
                views: {
                    mainView: {
                        templateUrl: basePath + "modelo.crear.html",
                        controller: "modeloCrearCtrl",
                        controllerAs: "ctrl"
                    }
                }
            })
            .state('editarModelo', {
                url: '/:ModeloId/editar',
                parent: "listModelo",
                params: {
                    ModeloId: null
                },
                views: {
                    mainView: {
                        templateUrl: basePath + "modelo.editar.html",
                        controller: "modeloEditarCtrl",
                        controllerAs: "ctrl"
                    }
                }
            });
        }]);
})(window.angular);