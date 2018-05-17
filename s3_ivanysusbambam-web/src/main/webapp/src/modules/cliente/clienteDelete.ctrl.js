(function(ng){ 
    
var mod = ng.module('clienteModule');
mod.constant("clienteContext", "api/clientes");
mod.controller("clienteDeleteCtrl", ["$scope", "$http", "clienteContext","$state",  function($scope, $http, clienteContext,$state){
        
        //$state.reload();
        $http.get(clienteContext).then(function(Response){
            $scope.clienteRecords = Response.data;
        });
        $http.delete("api/clientes/"+$state.params.id , {}).then(function (response) {
                    $state.go('adminAutos', {}, {reload: true});
                });
}]);


})(window.angular);