(function(ng){
    
    var mod = ng.module("calificacionCarroModule", ["ui.router"]);
    
    mod.config(['$stateProvider','$urlRouterProvider', function($stateProvider, $urlRouterProvider){
        var basePath = 'src/modules/CalificacionCarro/';
        
        $urlRouterProvider.otherwise('/CalificacionCarro');
        
        $stateProvider.state('adminCalificacionesCarroGetAll', {
           url: '/calificacionesCarro/principal',
           abstract: false,
           views: {
               'mainView': {
                   templateUrl: basePath + 'calificacionesCarro.list.html',
                   controller: 'calificacionesCarroCtrl',
                   controllerAs: 'ctrl'
               }
           }
        }).state('calificacionCarroDetail',{
            url: '/{calificacionCarroId: int}/detail',
            parent: 'adminCalificacionesCarroGetAll',
            params: {calificacionCarroId: null},
            views: {
                'ccDetailView': {
                    templateUrl: basePath + 'calificacionCarro.detail.html',
                    controller: 'calificacionCarroDetailCtrl',
                    controllerAs: 'ctrl'
                }               
            }
        }).state('calificacionCarroBackDetail',{
            url: '/{calificacionCarroBackId: int}/detail',
            parent: 'adminCalificacionesCarroGetAll',
            params: {calificacionCarroBackId: null},
            views: {
                ccBackDetailView: {
                    templateUrl: basePath + 'calificacionCarro.back.detail.html',
                    controller: 'calificacionCarroDetailBackCtrl',
                    controllerAs: 'ctrl'
                }               
            }
        }).state('ccCrear',{
                url: '/calificacionCarro/principal/crear',
                parent: 'adminCalificacionesCarroGetAll',
                views: {
                   mainCrearView: {
                       templateUrl: basePath + 'calificacionCarro.crear.html',
                       controller: 'calificacionCarroCrearCtrl',
                       controllerAs: 'ctrl'
                    }
                }
            });
        }
    ]);    
})(window.angular);


