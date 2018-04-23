(function(ng){
    
    var mod = ng.module("vendedorModule");
    
    mod.constant("vendedorContext", "api/vendedores");
    
    mod.controller("vendedorCrearCtrl", ["$scope", "$http", "vendedorContext","$rootScope","$state", function($scope, $http, vendedorContext, $rootScope, $state){
            
            //$rootScope.edit = false;
            
            $scope.data = {};
            $scope.idPv = null;
            
            
            $scope.buscarPV = function(){
              $http.get("api/puntosDeVenta/"+$scope.idPV).then(function(response){
                    var pvDDto = response.data;
                    var pc = {
                        name: pvDDto.name,
                        id: pvDDto.id,
                        direccion: pvDDto.direccion,
                        telefono: pvDDto.telefono  
                    };
                    $scope.data.puntoDeVenta = pc;
                });  
            };
            
            $scope.crearVendedor = function(){
                
                //Carnet cualquiera que será reemplazado por el autogenerado
               $scope.data.carnetVendedor = Number.MAX_SAFE_INTEGER;
               $http.post(vendedorContext, $scope.data).then(function(response){
                  $state.go("listVendedor",{}, {reload: true}); 
               });  
            };
            
            
    }]);
    
})(window.angular);


