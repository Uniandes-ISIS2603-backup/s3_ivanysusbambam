(function(ng){
    
    var mod = ng.module("marcaModule");
    
    mod.constant("marcaContext", "api/marcas");
    
    mod.controller("marcaEditarCtrl",["$scope", "$http", "marcaContext", "$rootScope", "$state", "dataTransfer", 
    
    function($scope, $http, marcaContext,$rootScope, $state, dataTransfer, $route){
        
        var address = marcaContext + "/" + $state.params.marcaId;
        
        $scope.nomOrg = $state.params.marcaName;
        
        var marca = {
            name: $state.params.marcaName,
            id: parseInt($state.params.marcaId)
        };
        
        
        $scope.cambioInfo= function(){
            
            marca.name = $scope.nuevoNombre;
        };
        
        $scope.editarMarca = function(){
            $scope.cambioInfo();
            
            $http.put(address, marca).then(function(response){
                
                $state.go("listMarca",{},{reload: true}); 
                
            });
                
            
        };
     
        
        
    }
    
    ]);
    
})(window.angular);