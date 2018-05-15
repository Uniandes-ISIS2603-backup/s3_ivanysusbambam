(function(ng){
    var mod = ng.module("calificacionTiendaModule");
    mod.constant("calificacionTiendaContext", "api/calificacionesTienda");
    mod.controller("calificacionTiendaCrearCtrl", ["$scope", "$http",
        "calificacionTiendaContext","$rootScope","$state", 
        function($scope, $http, calificacionTiendaContext, $rootScope, $state){
                        
            $scope.info = {};
            $scope.crearCalificacionTienda = function(){
               $http.post(calificacionTiendaContext, $scope.info).then(function(response){
                  $state.go("adminCalificacionesTiendaGetAll", {}, {reload: true}); 
               });  
            };                   
    }]);
    
})(window.angular);


