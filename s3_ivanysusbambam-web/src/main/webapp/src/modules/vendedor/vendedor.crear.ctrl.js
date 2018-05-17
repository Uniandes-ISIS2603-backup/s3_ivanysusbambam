(function(ng){
    
    var mod = ng.module("vendedorModule");
    
    mod.constant("vendedorContext", "api/vendedores");
    
    mod.controller("vendedorCrearCtrl", ["$scope", "$http", "vendedorContext","$rootScope","$state", function($scope, $http, vendedorContext, $rootScope, $state){
            
            $scope.data = {};
            $scope.puntosVenta = [];
             
             ;
           
            
            $scope.crearVendedor = function(){
                
                
            $http.get("api/puntosDeVenta/"+$scope.data.puntoDeVentaId).then(function(response){
          
                $scope.data.puntoDeVenta = response.data;
            
        });
                
                //Carnet cualquiera que será reemplazado por el autogenerado
               $scope.data.carnetVendedor = Number.MAX_SAFE_INTEGER;
               $http.post(vendedorContext, $scope.data).then(function(response){
                  $state.go("listVendedor",{}, {reload: true}); 
               });  
            };
            
            
    }]);
    
})(window.angular);


