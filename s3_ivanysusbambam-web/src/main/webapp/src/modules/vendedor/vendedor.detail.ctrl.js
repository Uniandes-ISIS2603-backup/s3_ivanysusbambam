(function(ng){
    
   var mod = ng.module("vendedorModule");
   
   mod.constant("vendedorContext", "api/vendedores");
   mod.controller("vendedorDetailCtrl", ["$scope", "$http", "vendedorContext", "$state", "dataTransfer",
    function($scope, $http, vendedorContext, $state, dataTransfer){
               
        if($state.params.vendedorId !== undefined && $state.params.vendedorId !==null){
            var address = vendedorContext + "/"+$state.params.vendedorId;
            
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
        
    }]);
            

            
    
})(window.angular);


