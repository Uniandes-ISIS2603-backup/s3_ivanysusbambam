(function(ng){
    
    var mod = ng.module("vendedorModule");
    mod.constant("vendedorContext", "api/vendedores");
    
    mod.controller("vendedorEditarCtrl", ["$scope", "$http", "vendedorContext", "$state", "dataTransfer", 
    function ($scope, $http, vendedorContext, $state, dataTransfer){
     
        $scope.vendedor = dataTransfer.get();
        
        var address = vendedorContext + "/" + $state.params.vendedorId;
        
        $scope.nuevoNombre = $scope.vendedor.nombre;
        
        if($scope.vendedor.puntoDeVenta !== undefined &&
                $scope.vendedor.puntoDeVenta !== null){
            $scope.idPV = $scope.vendedor.puntoDeVenta.id;
        }
        $scope.editarVendedor = function(){
            $http.put(address, $scope.vendedor).then(function(response){
                
                $state.go("listVendedor",{},{reload: true});
                
            });
        };
        
        $scope.cambioInfo = function(){
         
          console.log($scope.nuevoNombre);  
            
          $scope.vendedor.nombre = $scope.nuevoNombre;
         
          console.log($scope.idPV);
          
          $http.get("api/puntosDeVenta/"+$scope.idPV).then(function(response){
                    
                    console.log("THEN");
                    
                    var pvDDto = response.data;
                    var pc = {
                        name: pvDDto.name,
                        id: pvDDto.id,
                        direccion: pvDDto.direccion,
                        telefono: pvDDto.telefono  
                    };
                    console.log("PC DONE");
                    console.log(pc);
                    $scope.vendedor.puntoDeVenta = pc;
                    console.log(vendedor);
                });  
          
        };
        
    }]);
})(window.angular);

