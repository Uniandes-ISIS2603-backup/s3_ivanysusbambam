(function(ng){
    
    var mod = ng.module("clienteModule");
    
    mod.constant("clienteContext", "api/clientes");
    
    mod.controller("clienteEditarCtrl",["$scope", "$http", "clienteContext", "$rootScope", "$state", "dataTransfer", 
    
    function($scope, $http, clienteContext,$rootScope, $state, dataTransfer, $route){
                
        $scope.cliente = dataTransfer.get();
        $scope.nuevoNombre = $scope.cliente.nombre; 
        $scope.nuevaCedula = $scope.cliente.cedula;
        
        var address = clienteContext + "/" + $state.params.clienteId;
        
        
        $scope.editarCliente = function(){
            $http.put(address, $scope.cliente).then(function(response){
                
                $state.go("listCliente",{},{reload: true}); 
                
            });
                
            
        };
     
        $scope.cambioInfo= function(){
            $scope.cliente.nombre = $scope.nuevoNombre;
            $scope.cliente.cedula=$scope.nuevaCedula;
        
        };
        
        
    }
    
    ]);
    
})(window.angular);


