(function(ng){ 
    
var mod = ng.module('clienteModule');
mod.constant("clienteContext", "api/clientes");
mod.controller("clienteListCtrl", ["$scope", "$http", "clienteContext",  function($scope, $http, clienteContext){
        
        //$state.reload();
        $http.get(clienteContext).then(function(Response){
            $scope.clienteRecords = Response.data;
        });
}]);


})(window.angular);