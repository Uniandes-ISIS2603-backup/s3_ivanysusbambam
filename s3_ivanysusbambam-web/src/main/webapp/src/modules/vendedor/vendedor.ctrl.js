(function(ng){

    var mod = ng.module("vendedorModule");
    
    mod.constant("vendedorContext", "api/vendedores");
    
    mod.controller("vendedorListCtrl",["$scope","$http","vendedorContext", function($scope, $http, vendedorContext){
      
            $http.get(vendedorContext).then(function(response){
               $scope.vendedorRecords = response.data; 
            });
            
    }]);
    
})(window.angular);


