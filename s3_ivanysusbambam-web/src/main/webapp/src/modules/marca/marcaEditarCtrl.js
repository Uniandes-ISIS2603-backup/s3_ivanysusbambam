(function(ng){
    
    var mod = ng.module("marcaModule");
    
    mod.constant("marcaContext", "api/marcas");
    
    mod.controller("marcaEditarCtrl",["$scope", "$http", "marcaContext", "$rootScope", "$state", "dataTransfer", 
    
    function($scope, $http, marcaContext,$rootScope, $state, dataTransfer, $route){
        
        //$rootScope.edit = true;
        $scope.marca = dataTransfer.get();
        $scope.nuevoNombre = $scope.marca.nombre;    
        
        var address = marcaContext + "/" + $state.params.marcaId;
        
        
        $scope.editarMarca = function(){
            console.log($scope.marca.nombre);
            $http.put(address, $scope.marca).then(function(response){
                
                $state.go("listMarca",{},{reload: true}); 
                
            });
                
            
        };
     
        $scope.cambioInfo= function(){
            $scope.marca.nombre = $scope.nuevoNombre;
        };
        
        
    }
    
    ]);
    
})(window.angular);