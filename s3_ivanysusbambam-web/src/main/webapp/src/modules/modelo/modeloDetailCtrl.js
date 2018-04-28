(function(ng){
    
   var mod = ng.module("modeloModule");
   
   mod.constant("modeloContext", "api/modelos");
   mod.controller("modeloDetailCtrl", ["$scope", "$http", "modeloContext", "$state", "dataTransfer",
    function($scope, $http, modeloContext, $state, dataTransfer){
               
        if($state.params.id !== undefined && $state.params.id !==null){
            
            var address = modeloContext + "/"+$state.params.id;
            
            $http.get(address).then(function(response){
                $scope.modelo = response.data;
            });
        }
        
        $scope.subirInfoModelo = function(){
            console.log("subiendo info");
            dataTransfer.set($scope.modelo);
        };
        
    }]);
            

            
    
})(window.angular);