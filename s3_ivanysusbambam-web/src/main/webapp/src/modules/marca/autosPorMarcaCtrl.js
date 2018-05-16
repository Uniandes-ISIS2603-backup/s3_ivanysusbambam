(function(ng){
    
   var mod = ng.module("marcaModule");
   
   mod.constant("marcaContext", "api/marcas");
   mod.controller("autosPorMarca", ["$scope", "$http", "marcaContext", "$state", "dataTransfer",
    function($scope, $http, marcaContext, $state, dataTransfer){
               
        if($state.params.Marcaid !== undefined && $state.params.MarcaId !==null){
            
            var address = marcaContext + "/"+$state.params.MarcaId;
            
            $http.get(address).then(function(response){
                $scope.automoviles = response.data.automoviles;
            });
        }
        
        $scope.subirInfoMarca = function(){
            dataTransfer.set($scope.marca);
        };
        
        
    }]);
            

            
    
})(window.angular);