(function(ng){
    
   var mod = ng.module("clienteModule");
    
   mod.constant("clienteContext","api/clientes");
    
   mod.controller("clienteGetAllCtrl",["$scope", "$http", "clienteContext", function($scope, $http, clienteContext){
      
           $http.get(clienteContext).then(function(response){
               $scope.clientes = response.data;
           });
           
   }]);
    
})(angular.view);


