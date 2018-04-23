(function(ng){
    
   var mod = ng.module("vendedorModule");
   
   mod.constant("vendedorContext", "api/vendedores");
   mod.controller("vendedorDetailCtrl", ["$scope", "$http", "vendedorContext", "$state", "dataTransfer",
    function($scope, $http, vendedorContext, $state, dataTransfer){
               
        if($state.params.vendedorId !== undefined && $state.params.vendedorId !==null){
            var address = vendedorContext + "/"+$state.params.vendedorId;
            
            console.log("Encviando get vendedor");
            $http.get(address).then(function(response){
                $scope.vendedor = response.data;
            });
        }
        
        $scope.subirInfoVendedor = function(){
            console.log("subiendo info");
            dataTransfer.set($scope.vendedor);
        };
        
    }]);
            

            
    
})(window.angular);


