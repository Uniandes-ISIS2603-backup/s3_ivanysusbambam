(function(ng){
    
    var mod = ng.module("calificacionTiendaModule", ["ui.router"]);
    
    mod.config(['$stateProvider','$urlRouterProvider', function($stateProvider, $urlRouterProvider){
        var basePath = 'src/modules/CalificacionTienda/';
        
        $urlRouterProvider.otherwise('/CalificacionTienda');
        
        $stateProvider.state('adminCalificacionesTiendaGetAll', {
           url: '/calificacionesTienda/principal',
           abstract: false,
           views: {
               'mainView': {
                   templateUrl: basePath + 'calificacionesTienda.list.html',
                   controller: 'calificacionesTiendaCtrl',
                   controllerAs: 'ctrl'
               }
           }
        }).state('calificacionTiendaDetail',{
            url: '/{calificacionTiendaId: int}/detail',
            parent: 'adminCalificacionesTiendaGetAll',
            params: {calificacionTiendaId: null},
            views: {
                ctDetailView: {
                    templateUrl: basePath + 'calificacionTienda.detail.html',
                    controller: 'calificacionTiendaDetailCtrl',
                    controllerAs: 'ctrl'
                }               
            }
        }).state('calificacionTiendaBackDetail',{
            url: '/{calificacionTiendaBackId: int}/detail',
            parent: 'adminCalificacionesTiendaGetAll',
            params: {calificacionTiendaBackId: null},
            views: {
                ctBackDetailView: {
                    templateUrl: basePath + 'calificacionTienda.back.detail.html',
                    controller: 'calificacionTiendaDetailBackCtrl',
                    controllerAs: 'ctrl'
                }               
            }
        }).state('ctCrear',{
                url: '/calificacionTienda/principal/crear',
                parent: 'adminCalificacionesTiendaGetAll',
                views: {
                   mainCrearView: {
                       templateUrl: basePath + 'calificacionTienda.crear.html',
                       controller: 'calificacionCarroTiendaCtrl',
                       controllerAs: 'ctrl'
                    }
                }
            });
        }
    ]);    
})(window.angular);


