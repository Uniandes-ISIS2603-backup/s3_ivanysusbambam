(function(ng){

    var mod = ng.module("ventaModule");
    
    mod.constant("ventaContext", "api/ventas");
    
    mod.controller("ventaGetAllCtrl",["$scope","$http","ventaContext", function($scope, $http, ventaContext){
      
            $http.get("data/ventas.json").then(function(response){
               $scope.ventas = response.data; 
            });
            
    }]);
    
})(window.angular);
