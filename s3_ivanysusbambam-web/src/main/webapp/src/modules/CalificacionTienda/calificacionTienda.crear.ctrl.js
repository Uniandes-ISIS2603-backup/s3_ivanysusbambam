(function(ng){
    var mod = ng.module("calificacionTiendaModule");
    mod.constant("calificacionTiendaContext", "api/calificacionesTienda");
    mod.controller("calificacionTiendaCrearCtrl", ["$scope", "$http",
        "calificacionTiendaContext","$rootScope","$state", 
        function($scope, $http, calificacionTiendaContext, $rootScope, $state){
                        
            $scope.info = {};
            $scope.crearCalificacionTienda = function(){
                $scope.info.venta=$state.params.venta;
                $scope.info.comentario=$scope.comentario;
                 $scope.info.puntaje=$scope.puntaje;
               $http.post(calificacionTiendaContext, $scope.info).then(function(response){
                  $state.go("buscarAuto", {}, {reload: true}); 
               });  
            };                   
    }]);
    
})(window.angular);


