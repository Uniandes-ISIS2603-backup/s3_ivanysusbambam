(function(ng){
    
   var mod = ng.module("clienteModule");
   
   mod.constant("clienteContext", "api/clientes");
   mod.controller("clienteDetailCtrl", ["$scope", "$http", "clienteContext", "$state", "dataTransfer",
    function($scope, $http, clienteContext, $state, dataTransfer){
               
        if($state.params.clienteId !== undefined && $state.params.clienteId !==null){
            var address = clienteContext + "/"+$state.params.clienteId;
            
            $http.get(address).then(function(response){
                $scope.cliente = response.data;
            });
        }
        
        $scope.subirInfoCliente = function(){
            console.log("subiendo info");
            dataTransfer.set($scope.cliente);
        };
        
    }]);
            

            
    
})(window.angular);