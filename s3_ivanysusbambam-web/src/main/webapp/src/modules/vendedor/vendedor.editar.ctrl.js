(function(ng){
    
    var mod = ng.module("vendedorModule");
    mod.constant("vendedorContext", "api/vendedores");
    
    mod.controller("vendedorEditarCtrl", ["$scope", "$http", "vendedorContext", "$state", "dataTransfer", 
    function ($scope, $http, vendedorContext, $state, dataTransfer){
     
        $scope.vendedor = dataTransfer.get();
        
        $scope.puntosVenta = [];
            
        $http.get("api/puntosDeVenta").then(function(response){
               
            $scope.puntosVenta = response.data;
                
        });
        
        var address = vendedorContext + "/" + $state.params.vendedorId;
        
        $scope.nuevoNombre = $scope.vendedor.nombre;
        
        $scope.editarVendedor = function(){
            $http.put(address, $scope.vendedor).then(function(response){
                
                $state.go("listVendedor",{},{reload: true});
                
            });
        };
        
        $scope.cambioInfo = function(){
           
          $scope.vendedor.nombre = $scope.nuevoNombre;
          $scope.vendedor.puntoDeVenta = $scope.nuevoPv;
          
        };
        
    }]);
})(window.angular);

