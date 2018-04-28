(function(ng){
    var mod = ng.module("calificacionCarroModule", ["ui.router"]);
    
    mod.config([ '$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
            var basePath = 'src/modules/CalificacionCarro/';
            
            $urlRouterProvider.otherwise("/CalificacionCarro");
            $stateProvider.state('adminCalificacionesCarroGetAll', {
                url: '/calificacionCarro/list',
                abstract: false,
                views:{
                    'mainView':{
                        templateUrl: basePath + 'calificacionCarro.list.html',
                        controller: 'calificacionCarroSenseiCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('calificacionCarroDetail',{
                url: '/{calificacionCarroId: int}/detail',
                parent: 'adminCalificacionesCarroGetAll',
                param: {calificacionCarroId: null},
                views:{
                    'ccDetailView':{
                        templeateUrl: basePath + 'calificacionCarroDetail.html',
                        controller: 'calificacionCarroDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
    }]);
})(window.angular);


