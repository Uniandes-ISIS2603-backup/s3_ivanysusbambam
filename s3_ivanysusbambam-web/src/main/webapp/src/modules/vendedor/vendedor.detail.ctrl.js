(function(ng){
    
   var mod = ng.module("vendedorModule");
   
   mod.constant("vendedorContext", "api/vendedores");
   mod.controller("vendedorDetailCtrl", ["$scope", "$http", "vendedorContext", "$state", "dataTransfer","$rootScope",
    function($scope, $http, vendedorContext, $state, dataTransfer,$rootScope){
               
        $http.get("api/clientes").then(function(response){
            $scope.listaClientes = response.data;
        });
         $http.get("api/automoviles").then(function(response){
            $scope.listaAutomoviles = response.data;
        });
        
        
        if($rootScope.currentUserId !== undefined && $rootScope.currentUserId !==null){
            var address = vendedorContext + "/"+$rootScope.currentUserId;
            
            $http.get(address).then(function(response){
                $scope.vendedor = response.data;
                $scope.pcRecords=$scope.vendedor.prospectosCompra;
                $scope.compras=$scope.vendedor.compras;
                $scope.compras=$scope.vendedor.ventas;
            });
        }
        
        
        $scope.subirInfoVendedor = function(){
            dataTransfer.set($scope.vendedor);
        };
         $scope.data={};
         $scope.comprarAuto = function(){
            
            
            $http.get("api/mediosDePago/"+$scope.medioDePago).then(function(response){
                $scope.data.medioDePago = response.data;
               
            });
            console.log("api/mediosDePago/"+$scope.medioDePago);
            
             $scope.data.automovil=$scope.automovil;
               $scope.data.vendedorEncargado=$scope.vendedor;
               $scope.data.cliente=$scope.cliente;
               $scope.data.puntoDeVenta=$scope.vendedor.puntoDeVenta;
               $scope.data.idVenta=$scope.automovil.id;
             console.log( $scope.data);
             
             $http.post("api/ventas", $scope.data).then(function(response){
              
             
              $state.go("perfilVendedor",{} ,{reload:true});
          
            });
           
        };
        
    }]);
            

            
    
})(window.angular);


