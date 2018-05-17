(function(ng) {
    var mod = ng.module("puntoVentaModule");
    mod.constant("puntoVentaContext", "api/puntosDeVenta");
    mod.controller("puntoVentaUsuarioCtrl",
        ["$scope","$rootScope","$state", "$http", "puntoVentaContext",
        function($scope,$rootScope,$state, $http, puntoVentaContext){
            
            $http.get(puntoVentaContext).then(function(response){
                $scope.puntosDeVentaBack = response.data;
            });
            $rootScope.comentar = false;
            $scope.quiereComentar = function(){
              $rootScope.comentar=true;  
            };
            $scope.data = {};
            $scope.crearCalificacionTienda = function(){
               $http.post("api/calificacionesTienda", $scope.data).then(function(response){
                  $state.go("puntosDeVentaMapa", {}, {reload: true}); 
               });  
            };  
        }
    ]);
})(window.angular);