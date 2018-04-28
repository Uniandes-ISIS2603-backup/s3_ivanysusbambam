(function(ng){
    
    var mod = ng.module("clienteModule");
    
    mod.constant("clienteContext", "api/clientes");
    
    mod.controller("clienteEditarPerfilCtrl",["$scope", "$http", "clienteContext", "$rootScope", "$state", "dataTransfer", 
    
    function($scope, $http, clienteContext,$rootScope, $state, dataTransfer, $route){
        
        //$rootScope.edit = true;
        
        console.log($state);
        console.log($state.params);
        console.log($state.params.clienteId);
        
        
        $scope.cliente = dataTransfer.get();
        $scope.nuevoNombre = $scope.cliente.nombre;    
        
        var address = clienteContext + "/" + $state.params.clienteId;
        
        
        $scope.editarCliente = function(){
            console.log($scope.cliente.nombre);
            $http.put(address, $scope.cliente).then(function(response){
                
                $state.go("perfilCliente",{clienteId: $scope.cliente.cedula},{reload: true}); 
                
            });
                
            
        };
     
        $scope.cambioInfo= function(){
            $scope.cliente.nombre = $scope.nuevoNombre;
        
        };
        
        
    }
    
    ]);
    
})(window.angular);





