(function(ng) {
    var mod = ng.module("puntoVentaModule");
    mod.constant("puntoVentaContext", "api/puntosDeVenta");
    mod.controller("puntoVentaUsuarioCtrl",
        ["$scope", "$http", "puntoVentaContext",
        function($scope, $http, puntoVentaContext){
            
            $http.get(puntoVentaContext).then(function(response){
                $scope.puntosDeVentaBack = response.data;
            });
            
            $scope.data = {};
            $scope.crearCalificacionTienda = function(){
               $http.post("api/calificacionesTienda", $scope.data).then(function(response){
                  $state.go("puntosDeVentaMapa", {}, {reload: true}); 
               });  
            };  
        }
    ]);
})(window.angular);