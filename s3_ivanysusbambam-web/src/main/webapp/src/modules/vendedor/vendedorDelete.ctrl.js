(function(ng){

    var mod = ng.module("vendedorModule");
    
    mod.constant("vendedorContext", "api/vendedores");
    
    mod.controller("vendedorListCtrl",["$scope","$http","vendedorContext","$state", function($scope, $http, vendedorContext,$state){
      
            $http.get(vendedorContext).then(function(response){
               $scope.vendedorRecords = response.data; 
            });
             $http.delete(vendedorContext + '/' + $state.params.id, {}).then(function (response) {
                    $state.go('listVendedor', {}, {reload: true});
                });
            
    }]);
    
})(window.angular);


