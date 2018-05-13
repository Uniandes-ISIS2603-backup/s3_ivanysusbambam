(function(ng){
    
    var mod = ng.module("vendedorModule");
    
    mod.constant("vendedorContext", "api/vendedores");
    
    mod.controller("vendedorCrearCtrl", ["$scope", "$http", "vendedorContext","$rootScope","$state", function($scope, $http, vendedorContext, $rootScope, $state){
            
            $scope.data = {};
            $scope.puntosVenta = [];
            
            $http.get("api/puntosDeVenta").then(function(response){
               
                $scope.puntosVenta = response.data;
                
            });
            
            $scope.crearVendedor = function(){
                
                //Carnet cualquiera que será reemplazado por el autogenerado
               $scope.data.carnetVendedor = Number.MAX_SAFE_INTEGER;
               $http.post(vendedorContext, $scope.data).then(function(response){
                  $state.go("listVendedor",{}, {reload: true}); 
               });  
            };
            
            
    }]);
    
})(window.angular);


