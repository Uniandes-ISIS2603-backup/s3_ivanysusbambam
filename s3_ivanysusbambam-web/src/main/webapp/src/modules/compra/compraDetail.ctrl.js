(function(ng){

    var mod = ng.module("compraModule");
    
    mod.constant("compraContext", "api/compras");
    
    mod.controller("compraDetailCtrl",["$scope","$http","compraContext", function($scope, $http, compraContext){
      
            $http.get("data/compra.json").then(function(response){
               $scope.compras = response.data; 
            });
            
    }]);
    
})(window.angular);


