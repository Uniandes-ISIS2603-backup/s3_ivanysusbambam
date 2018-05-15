(function(ng){
    
   var mod = ng.module("marcaModule");
   
   mod.constant("marcaContext", "api/marcas");
   mod.controller("marcaDetailCtrl", ["$scope", "$http", "marcaContext", "$state", "dataTransfer",
    function($scope, $http, marcaContext, $state, dataTransfer){
               
        if($state.params.Marcaid !== undefined && $state.params.MarcaId !==null){
            
            var address = marcaContext + "/"+$state.params.MarcaId;
            
            $http.get(address).then(function(response){
                $scope.marca = response.data;
            });
        }
        
        $scope.subirInfoMarca = function(){
            dataTransfer.set($scope.marca);
        };
        
    }]);
            

            
    
})(window.angular);