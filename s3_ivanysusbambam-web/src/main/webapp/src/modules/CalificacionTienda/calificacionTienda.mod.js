(function (ng) {

    var mod = ng.module("calificacionTiendaModule", ["ui.router"]);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/CalificacionTienda/';

            $urlRouterProvider.otherwise('/CalificacionTienda');

            $stateProvider.state('adminCalificacionesTiendaGetAll', {
                    url: '/calificacionesTienda/principal',
                    abstract: false,
                    params: {
                        requireLogin: true
                    },
                    views: {
                        'mainView': {
                            templateUrl: basePath + 'calificacionesTienda.list.html',
                            controller: 'calificacionesTiendaCtrl',
                            controllerAs: 'ctrl'
                        }
                    }
                })
                .state('calificacionTiendaDetail', {
                    url: '/{calificacionTiendaId: int}/detail',
                    parent: 'adminCalificacionesTiendaGetAll',
                    params: {
                        calificacionTiendaId: null,
                        requireLogin: true
                    },
                    views: {
                        ctDetailView: {
                            templateUrl: basePath + 'calificacionTienda.detail.html',
                            controller: 'calificacionTiendaDetailCtrl',
                            controllerAs: 'ctrl'
                        }
                    }
                })
                .state('calificacionTiendaBackDetail', {
                    url: '/{calificacionTiendaBackId: int}/detail',
                    parent: 'adminCalificacionesTiendaGetAll',
                    params: {
                        calificacionTiendaBackId: null,
                        requireLogin: true
                    },
                    views: {
                        ctBackDetailView: {
                            templateUrl: basePath + 'calificacionTienda.back.detail.html',
                            controller: 'calificacionTiendaDetailBackCtrl',
                            controllerAs: 'ctrl'
                        }
                    }
                }).state('ctCrear', {
                    url: '/calificacionTienda/principal/crear',
                    params: {
                        requireLogin: true,
                        puntoDeVenta:null
                    },
                    views: {
                        mainView: {
                            templateUrl: basePath + 'calificacionTienda.crear.html',
                            controller: 'calificacionTiendaCrearCtrl',
                            controllerAs: 'ctrl'
                        }
                    }
                });
        }
    ]);
})(window.angular);
