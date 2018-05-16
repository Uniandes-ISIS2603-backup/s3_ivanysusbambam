/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


(function(ng){
    
   var mod = ng.module("compraModule");
   
   mod.constant("automovilContext", "api/automoviles");
   mod.controller("comprarCtrl", ["$scope","$rootScope","$http", "automovilContext", "$state", 
    function($scope,$rootScope, $http, automovilContext, $state){
            
        $scope.data = {};
        
        if($state.params.idAuto !== undefined && $state.params.idAuto !==null){
            var address = automovilContext + "/"+$state.params.idAuto;
            
            $http.get(address).then(function(response){
                $scope.automovil = response.data;
                $scope.data.automovil=response.data;
                $scope.data.puntoDeVenta=$scope.automovil.puntoDeVenta;
                $scope.data.idVenta=$scope.automovil.id;
            });
        }
        
        if($state.params.clienteId !== undefined && $state.params.clienteId !==null){
            var address2 = "api/clientes" + "/"+$state.params.clienteId;
            
           
            $http.get(address2).then(function(response){
                $scope.elCliente = response.data;
                $scope.data.cliente=response.data;
                
                
            });
            
         
            
        }
        $scope.crearVenta = function(){
               $http.post("api/ventas", $scope.data).then(function(){
                  $state.go("adminVentaGetAll", {reload: true}); 
               });  
            };
        
    }]);
            

            
    
})(window.angular);