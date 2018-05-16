(function(ng){
    
    var mod = ng.module("compraModule");
    
    mod.constant("compraContext", "api/compras");
    
    mod.controller("compraCrearCtrl", ["$scope", "$http", "compraContext", "$state",
    function($scope, $http, compraContext, $state){
        
        $scope.data={};
       
        
     
        
         $scope.crearCompra = function(){
             
             console.log("api/clientes/"+$scope.clienteId);
            
             $http.get("api/clientes/"+$scope.clienteId).then(function(response){
            $scope.data.cliente = response.data;
            
           
            
        });
           
     $http.get("api/puntosDeVenta/"+$scope.puntoDeVentaId).then(function(response){
            $scope.data.puntoDeVenta = response.data;
        });
           
     $http.get("api/vendedores/"+$scope.vendedorId).then(function(response){
            $scope.data.vendedorEncargado = response.data;
        });
      console.log($scope.data);
   
            $http.post(compraContext, $scope.data).then(function(response){
                
                console.log(response.data);
                
                $state.go("crearAutomovil({cliente: $scope.data.cliente, puntoDeVenta:$scope.data.puntoDeVenta, compra: response.data})",{} ,{reload:true});
            });
        };
        
    }]);
    
})(window.angular);