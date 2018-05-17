(function(ng){
    
    var mod = ng.module("compraModule");
    
    mod.constant("compraContext", "api/compras");
    
    mod.controller("compraCrearCtrl", ["$scope", "$http", "compraContext", "$state",
    function($scope, $http, compraContext, $state){
        
        $scope.data={};
       
        
     
        
         $scope.crearCompra = function(){
             
             
            
             $http.get("api/clientes/"+$scope.clienteId).then(function(response){
            $scope.data.cliente = response.data;
            
        });
           
     $http.get("api/puntosDeVenta/"+$scope.puntoDeVentaId).then(function(response){
            $scope.data.puntoDeVenta = response.data;
        });
           
     $http.get("api/vendedores/"+$scope.vendedorId).then(function(response){
            $scope.data.vendedorEncargado = response.data;
        });
     
   
            $http.post(compraContext, $scope.data).then(function(response){
              
              $scope.data.compra=response.data;
              $state.go("AdminCompraGetAll",{} ,{reload:true});
          
            });
        };
        
    }]);
    
})(window.angular);