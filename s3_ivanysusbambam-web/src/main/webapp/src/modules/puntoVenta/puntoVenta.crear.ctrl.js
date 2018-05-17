(function(ng){
    var mod = ng.module("puntoVentaModule");
    mod.constant("puntoVentaContext", "api/puntosDeVenta");
    mod.controller("puntoVentaCrearCtrl", ["$scope", "$http",
        "puntoVentaContext","$rootScope","$state", 
        function($scope, $http, puntoVentaContext, $rootScope, $state){
                        
            $scope.info = {};
            $scope.crearPuntoVenta = function(){
               $http.post(puntoVentaContext, $scope.info).then(function(response){
                  $state.go("puntosDeVentaMapa", {}, {reload: true}); 
               });  
            };                   
    }]);
    
})(window.angular);


