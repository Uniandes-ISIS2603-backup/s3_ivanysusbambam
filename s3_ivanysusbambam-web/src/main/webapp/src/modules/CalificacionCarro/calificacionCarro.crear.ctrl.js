(function(ng){
    var mod = ng.module("calificacionCarroModule");
    mod.constant("calificacionCarroContext", "api/calificacionesCarro");
    mod.controller("calificacionCarroCrearCtrl", ["$scope", "$http",
        "calificacionCarroContext","$rootScope","$state", 
        function($scope, $http, calificacionCarroContext, $rootScope, $state){
                     
          
            $scope.info = {};
            
            
            $scope.crearCalificacionCarro = function(){
                
                $scope.info.puntoDeVenta=$state.params.venta;
                $scope.info.comentario=$scope.comentario;
                 $scope.info.puntaje=$scope.puntaje;
                $http.post(calificacionCarroContext, $scope.info).then(function(response){
                  $state.go("buscarAuto", {}, {reload: true}); 
               });  
            };                   
    }]);
    
})(window.angular);


