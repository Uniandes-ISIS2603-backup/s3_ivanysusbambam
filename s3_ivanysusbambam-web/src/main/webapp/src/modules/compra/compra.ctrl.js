(function(ng){

    var mod = ng.module("compraModule");
    
    mod.constant("compraContext", "api/compras");
    
    mod.controller("compraGetAllCtrl",["$scope","$http","compraContext", function($scope, $http, compraContext){
      
            $http.get("data/compra.json").then(function(response){
               $scope.compras = response.data; 
            });
            
    }]);
    
})(window.angular);


