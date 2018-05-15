(function(ng){
    
    var mod = ng.module("medioDePagoModule");

    mod.constant("medioDePagoContext", "api/mediosDePago");
    mod.controller("medioDePagoDetailCtrl", ["$scope", "$http", "medioDePagoContext", "$state", "dataTransfer", 
    function($scope, $http, medioDePagoContext, $state, dataTransfer){
         
        if($state.params.numero !== undefined && $state.params.numero !==null){
            var address = medioDePagoContext + "/"+$state.params.numero;
            
            $http.get(address).then(function(response){
               
                $scope.mdp = response.data;
            });
        }
        
        $scope.subirInfoCompra = function(){
            dataTransfer.set($scope.compra);
        };
      
        
    }]);
    
})(window.angular);


