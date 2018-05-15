(function(ng){
    
    var mod = ng.module("compraModule");
    mod.constant("compraContext", "api/compras");
    mod.controller("compraDetailCtrl", ["$scope", "$http", "compraContext", "$state", "dataTransfer", 
    function($scope, $http, compraContext, $state, dataTransfer){
        if($state.params.idCompra !== undefined && $state.params.idCompra !==null){
            var address = compraContext + "/"+$state.params.idCompra;
            
            $http.get(address).then(function(response){
                $scope.compra = response.data;
            });
        }
        
        $scope.subirInfoCompra = function(){
            dataTransfer.set($scope.compra);
        };
      
        
    }]);
    
})(window.angular);


