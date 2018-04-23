(function(ng){
    
    var mod = ng.module("clienteModule");
    
    mod.constant("clienteContext", "api/clientes");
    
    mod.controller("clienteCrearCtrl", ["$scope", "$http", "clienteContext","$rootScope","$state", function($scope, $http, clienteContext, $rootScope, $state){
            
            //$rootScope.edit = false;
            
            $scope.data = {};
            
            
            $scope.crearCliente = function(){
               $http.post(clienteContext, $scope.data).then(function(response){
                  $state.go("listCliente", {reload: true}); 
               });  
            };
            
            7
    }]);
    
})(window.angular);
