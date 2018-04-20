(function(ng){

    var mod = ng.module("medioDePagoModule");
    
    mod.constant("medioDePagoContext", "api/medioDePago");
    
    mod.controller("medioDePagoGetAllCtrl",["$scope","$http","compraContext", function($scope, $http, compraContext){
      
            $http.get("data/compra.json").then(function(response){
               $scope.compras = response.data; 
            });
            
    }]);
    
})(window.angular);


