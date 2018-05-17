(function(ng){
    
    var mod = ng.module("compraModule");
    mod.constant("compraContext", "api/compras");
    mod.controller("compraDeleteCtrl", ["$scope", "$http", "compraContext", "$state", "dataTransfer", 
    
      function ($scope, $http, compraContext, $state) {
            var idCompra = $state.params.idCompra;
            $http.get(compraContext).then(function(response){
               $scope.compras = response.data; 
            });
            
           
                $http.delete(compraContext + '/' + idCompra, {}).then(function (response) {
                    $state.go('AdminCompraGetAll', {}, {reload: true});
                });
            
        }
        
    ]);
    
})(window.angular);


