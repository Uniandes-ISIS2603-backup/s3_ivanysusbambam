(function (ng) {

    var mod = ng.module("modeloModule", ['ui.router']);



    mod.config(["$stateProvider", "$urlRouterProvider", function ($stateProvider, $urlRouterProvider) {
        var basePath = "src/modules/modelo/";
        
         $urlRouterProvider.otherwise("/modelo");
        

        $stateProvider.state("listModelo", {

                url: "/modelos/lista",
                params: {
                    requireLogin: false
                },
                views: {
                    mainView: {
                        templateUrl: basePath + "modelo.list.html",
                        controller: "modeloListCtrl",
                        controllerAs: "ctrl"
                    }
                }
            }).state("eliminarModelo", {

                url: "/modelos/lista",
                params: {
                    requireLogin: false,
                    idModelo:null
                    
                },
                views: {
                    mainView: {
                        templateUrl: basePath + "modelo.list.html",
                        controller: "modeloListCtrl",
                        controllerAs: "ctrl"
                    }
                }
            })
            .state('modeloDetail', {
                url: '/:ModeloId/detail',
                parent: "listModelo",
                params: {
                    ModeloId: null,
                    requireLogin: false
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
                params: {
                    requireLogin: true
                },
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
                params: {
                    ModeloId: null,
                    requireLogin: true
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
