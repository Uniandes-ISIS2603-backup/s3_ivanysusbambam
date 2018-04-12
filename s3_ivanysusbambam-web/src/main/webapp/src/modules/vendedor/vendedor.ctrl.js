(function(ng){

    var mod = ng.module("vendedorModule");
    
    mod.constant("vendedorContext", "api/vendedores");
    
    mod.controller("vendedorGetAll",["$scope","$http","vendedorContext", function($scope, $http, vendedorContext){
      
            $http.get(vendedorContext).then(function(response){
               $scope.vendedores = response.data; 
            });
            
    }]);
    
})(angular.view);


