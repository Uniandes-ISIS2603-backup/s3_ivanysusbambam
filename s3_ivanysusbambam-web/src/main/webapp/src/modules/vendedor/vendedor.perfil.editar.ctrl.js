(function(ng){
    
    var mod = ng.module("vendedorModule");
    mod.constant("vendedorContext", "api/vendedores");
    
    mod.controller("vendedorEditarPerfilCtrl", ["$scope", "$http", "vendedorContext", "$state", "dataTransfer", 
    function ($scope, $http, vendedorContext, $state, dataTransfer){
     
        $scope.vendedor = dataTransfer.get();
        
        var address = vendedorContext + "/" + $state.params.vendedorId;
        
        $scope.nuevoNombre = $scope.vendedor.nombre;
        
        $scope.editarVendedor = function(){
            $http.put(address, $scope.vendedor).then(function(response){
                
                $state.go("perfilVendedor",{vendedorId: $scope.vendedor.carnetVendedor},{reload: true});
                
            });
        };
        
        $scope.cambioInfo = function(){
         
          console.log($scope.nuevoNombre);  
          console.log($scope.vendedor.puntoDeVenta);
            
          $scope.vendedor.nombre = $scope.nuevoNombre;
          
          
        };
        
    }]);
})(window.angular);




