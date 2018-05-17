(function(ng){

    var mod = ng.module("ventaModule");
    
    mod.constant("ventaContext", "api/ventas");
    
    mod.controller("ventaDeleteCtrl",["$scope","$http","ventaContext","$state,", function($scope, $http, ventaContext,$state){
      
            $http.get(ventaContext).then(function(response){
               $scope.ventas = response.data; 
            });
            $http.delete(ventaContext + '/' + $state.params.idVenta, {}).then(function (response) {
                    $state.go('adminVentaGetAll', {}, {reload: true});
                });
    }]);
    
})(window.angular);
