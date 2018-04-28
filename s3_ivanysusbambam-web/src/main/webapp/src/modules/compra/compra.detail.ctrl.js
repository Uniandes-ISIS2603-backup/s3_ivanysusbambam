(function(ng){
    
    var mod = ng.module("compraModule");
    console.log("hola");
    mod.constant("compraContext", "api/compras");
    mod.controller("compraDetailCtrl", ["$scope", "$http", "compraContext", "$state", "dataTransfer", 
    function($scope, $http, compraContext, $state, dataTransfer){
          console.log("salu2");
          console.log($state.params.idCompra);
        if($state.params.idCompra !== undefined && $state.params.idCompra !==null){
            var address = compraContext + "/"+$state.params.idCompra;
            console.log($state.params.idCompra);
            
            $http.get(address).then(function(response){
                console.log(response.data);
                $scope.compra = response.data;
            });
        }
        
        $scope.subirInfoCompra = function(){
            console.log("subiendo info");
            dataTransfer.set($scope.compra);
        };
      
        
    }]);
    
})(window.angular);


