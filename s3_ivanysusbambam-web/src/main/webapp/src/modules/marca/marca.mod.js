(function (ng) {

    var mod = ng.module("marcaModule", ['ui.router']);



    mod.config(["$stateProvider", "$urlRouterProvider", function ($stateProvider, $urlRouterProvider) {
        var basePath = "src/modules/marca/";
        
        $stateProvider.state("listMarca", {

                url: "/marcas/lista",
                params:{
              requireLogin: false  
            },
                views:{
                    mainView:{
                templateUrl: basePath + "marca.list.html",
                controller: "marcaListCtrl",
                controllerAs: "ctrl"}}
            })
            .state('marcaDetail', {
                url: '/:MarcaId/detail',
                parent: "listMarca",
                params: {
                    MarcaId: null,
                    requireLogin:false
                },
                views: {
                    marcaDetailView: {
                        templateUrl: basePath + "marca.detail.html",
                        controller: "marcaDetailCtrl",
                        controllerAs: "ctrl"

                    }
                }

            })
            .state('crearMarca', {
                url: '/marca/crear',
            params:{
              requireLogin: true  
            },
                views: {
                    mainView: {
                        templateUrl: basePath + "marca.crear.html",
                        controller: "marcaCrearCtrl",
                        controllerAs: "ctrl"
                    }
                }
            })
            .state('editarMarca', {
                url: '/:marcaId/editar',
                parent: "listMarca",
                params: {
                    marcaId: null,
                    requireLogin:true
                },
                views: {
                    mainView: {
                        templateUrl: basePath + "marca.editar.html",
                        controller: "marcaEditarCtrl",
                        controllerAs: "ctrl"
                    }
                }
            });
        }]);
})(window.angular);
